package dev.mzcy.cloud.node.netty;

import io.netty5.channel.Channel;
import io.netty5.channel.ChannelHandlerContext;
import io.netty5.channel.SimpleChannelInboundHandler;

public final class NettyNetworkHandler extends SimpleChannelInboundHandler<Channel> {
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, Channel channel) throws Exception {
        channel.pipeline().addLast("network_handler", new NettyNetworkHandler());
    }
}
