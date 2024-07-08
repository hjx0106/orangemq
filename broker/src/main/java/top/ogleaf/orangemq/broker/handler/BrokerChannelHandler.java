package top.ogleaf.orangemq.broker.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class BrokerChannelHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // TODO 获取从客户端接收的信息
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("收到客户端"+ctx.channel().remoteAddress()+"消息:" + byteBuf.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // TODO 将数据发送给客户端
        ctx.writeAndFlush(Unpooled.copiedBuffer("服务端已经收到消息", CharsetUtil.UTF_8));
    }
}
