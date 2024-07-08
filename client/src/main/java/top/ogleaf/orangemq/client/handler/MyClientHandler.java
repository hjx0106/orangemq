package top.ogleaf.orangemq.client.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class MyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        new Thread(() -> {
            while (true) {
                try {
                    ctx.writeAndFlush(Unpooled.copiedBuffer("喂喂，听到请回答", CharsetUtil.UTF_8));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //打印接收到的消息
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("收到服务端"+ctx.channel().remoteAddress()+"的消息:"+byteBuf.toString(CharsetUtil.UTF_8));
    }
}
