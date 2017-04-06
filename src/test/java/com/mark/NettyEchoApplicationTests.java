package com.mark;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.net.Socket;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NettyEchoApplicationTests {

    @Test
    public void testSocketConnection() throws Exception {

        Socket socket = new Socket("127.0.0.1", 8007);

        OutputStream outputStream = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(outputStream);

        writer.print("socket data from client");
        writer.flush();

        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
        inputStream.close();
        writer.close();
        outputStream.close();
        socket.close();

    }

}
