package com.mark;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.apache.catalina.Pipeline;


/**
 * Created by mark on 17-4-6.
 */
public class EchoInitializer extends ChannelInitializer<SocketChannel> {
    private static final StringEncoder ENCODER = new StringEncoder();
    private static final StringDecoder DECODER = new StringDecoder();
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        pipeline.addLast(DECODER);
        pipeline.addLast(ENCODER);
        pipeline.addLast(new EchoInboundHandler());

    }
}
