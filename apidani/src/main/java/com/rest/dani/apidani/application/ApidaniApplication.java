package com.rest.dani.apidani.application;

import com.rest.dani.apidani.controllers.HelloController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication(scanBasePackages = {"com.rest.dani.apidani"})
@EntityScan("com.rest.dani.apidani.VO")
@EnableJpaRepositories("com.rest.dani.apidani.repositories")
public class ApidaniApplication {
    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(ApidaniApplication.class);
        ConfigurableApplicationContext context =  app.run(args);
        Environment env = context.getEnvironment();
        String protocol = "http";

        LOG.info("\n-------------------------------------------------------\n\t" +
                "Application '{}' is running! Access URLs:\n\t" +
                "Local: \t\t{}://localhost:{}\n\t" + "External: \t{}:{}{}\n\t" +
                "Profile(s): \t{}\n-------------------------------------------------------",
                env.getProperty("spring.application.name"), protocol, env.getProperty("server.port"), protocol,
                InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"), env.getActiveProfiles()

        );
    }

}
