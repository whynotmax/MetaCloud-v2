package dev.mzcy.cloud.node;

import dev.mzcy.cloud.api.CloudAPI;
import dev.mzcy.cloud.api.group.CloudGroupProvider;
import dev.mzcy.cloud.api.service.CloudServiceProvider;
import dev.mzcy.cloud.node.command.CommandProvider;
import dev.mzcy.cloud.node.group.CloudGroupProviderImpl;
import dev.mzcy.cloud.node.netty.NettyServer;
import dev.mzcy.cloud.node.services.CloudServiceProviderImpl;
import dev.mzcy.cloud.node.terminal.Jline3Terminal;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class CloudInstance extends CloudAPI {

    @Getter
    static CloudInstance instance;

    Jline3Terminal terminal;
    CommandProvider commandProvider;
    CloudGroupProvider groupProvider;
    CloudServiceProvider serviceProvider;
    NettyServer nettyServer;

    public CloudInstance() {

        instance = this;

        this.terminal = new Jline3Terminal();
        this.commandProvider = new CommandProvider();

        this.groupProvider = new CloudGroupProviderImpl();
        this.serviceProvider = new CloudServiceProviderImpl();

        this.nettyServer = new NettyServer();

        Runtime.getRuntime().addShutdownHook(new Thread(CloudInstanceShutdownHandler::run));
    }

}
