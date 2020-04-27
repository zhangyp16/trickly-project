package com.trickly.dataway.config;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.util.ClassUtils;

import java.util.Properties;

@Configuration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class JschConfiguration implements InitializingBean, DisposableBean {

    @Value("${jsch.proxy.host}")
    private String proxyHost;
    @Value("${jsch.proxy.port}")
    private String proxyPort;
    @Value("${jsch.proxy.user}")
    private String proxyUser;
    @Value("${jsch.dest.host}")
    private String destHost;
    @Value("${jsch.dest.port}")
    private String destPort;
    @Value("${jsch.local.port}")
    private String localPort;
    @Value("${jsch.proxy.prvkey}")
    private String prvkey;
    @Value("${ssh.proxy.enable}")
    private int sshProxyEnable;


    private Session session;


    @Override
    public void afterPropertiesSet() throws Exception {
        if (sshProxyEnable == 0){
            return;
        }

        JSch jsch = new JSch();
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        jsch.addIdentity(path.concat(prvkey));
        session = jsch.getSession(proxyUser, proxyHost, Integer.valueOf(proxyPort));
        // session.setPassword(jschProperties.getProxyPassword());
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);

        log.info("Jsch_AutoConfiguration connect to:::host:" + proxyHost + ", port : " + proxyPort + ", user: " + proxyUser);

        session.connect();
        // 打印SSH服务器版本信息
        log.info("Jsch_AutoConfiguration:::" + session.getServerVersion());

        int assinged_port = session.setPortForwardingL(Integer.valueOf(localPort), destHost, Integer.valueOf(destPort));
        log.info("Jsch_AutoConfiguration:::localhost:" + assinged_port + " -> " + destHost + ":" + destPort);
    }

    @Override
    public void destroy() throws Exception {
        if (session != null) {
            session.disconnect();
        }
        log.info("Jsch_AutoConfiguration::: destory connection");
    }
}