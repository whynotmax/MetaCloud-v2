package dev.mzcy.cloud.node.netty;

import io.netty5.bootstrap.ServerBootstrap;
import io.netty5.channel.EventLoopGroup;
import io.netty5.channel.MultithreadEventLoopGroup;
import io.netty5.channel.epoll.Epoll;
import io.netty5.channel.epoll.EpollHandler;
import io.netty5.channel.epoll.EpollServerSocketChannel;
import io.netty5.channel.nio.NioHandler;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.concurrent.Future;

@Getter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class NettyServer {

    EventLoopGroup bossGroup = new MultithreadEventLoopGroup(Epoll.isAvailable() ? EpollHandler.newFactory() : NioHandler.newFactory());
    EventLoopGroup workerGroup = new MultithreadEventLoopGroup(Epoll.isAvailable() ? EpollHandler.newFactory() : NioHandler.newFactory());

    public NettyServer() {
        new ServerBootstrap()
                .channelFactory(EpollServerSocketChannel::new)
                .group(bossGroup, workerGroup)
                .childHandler(new NettyNetworkServerInitializer())
                .bind("0.0.0.0", 7787)
                .addListener(future -> {

                });
    }

    public void close() {
        this.bossGroup.shutdownGracefully();
        this.workerGroup.shutdownGracefully();
    }

}
