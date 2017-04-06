package com.mark;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mark on 17-4-6.
 */
@Configuration
public class ServerConfiguration {

    @Bean(name = "echoServer")
    public EchoServer provideEchoServer() {
        return new EchoServer();
    }
}
