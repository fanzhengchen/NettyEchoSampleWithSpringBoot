package com.mark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyEchoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NettyEchoApplication.class, args);
        EchoServer server = new EchoServer();
        server.run(8007);
    }
}
