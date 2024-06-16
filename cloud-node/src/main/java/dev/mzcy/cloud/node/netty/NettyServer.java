package dev.mzcy.cloud.node.netty;

import io.netty5.bootstrap.ServerBootstrap;
import io.netty5.channel.EventLoopGroup;
import io.netty5.channel.MultithreadEventLoopGroup;
import io.netty5.channel.epoll.EpollHandler;
import io.netty5.channel.epoll.EpollServerSocketChannel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class NettyServer {

    EventLoopGroup bossGroup = new MultithreadEventLoopGroup(EpollHandler.newFactory());
    EventLoopGroup workerGroup = new MultithreadEventLoopGroup(EpollHandler.newFactory());


    public NettyServer() {
        new ServerBootstrap()
                .channelFactory(EpollServerSocketChannel::new)
                .group(bossGroup, workerGroup)
                .bind("0.0.0.0", 7787)
                .addListener(future -> {
                    System.out.println("Netty server started on port 7787.");
                }).;
    }

    public void close() {
        this.bossGroup.shutdownGracefully();
        this.workerGroup.shutdownGracefully();
    }

}
