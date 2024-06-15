package dev.mzcy.cloud.node.services;

import dev.mzcy.cloud.api.CloudAPI;
import dev.mzcy.cloud.api.group.CloudGroup;
import dev.mzcy.cloud.api.service.CloudService;
import dev.mzcy.cloud.node.group.CloudGroupProviderImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.CompletableFuture;

@Getter
@AllArgsConstructor
public final class CloudServiceImpl implements CloudService {

    private final String name;
    private final String groupName;
    private final CloudGroup group;

    private Process process;

    @Override
    public CompletableFuture<CloudGroup> getGroupAsync() {
        return CompletableFuture.completedFuture(group);
    }

    @Override
    public void shutdown() {
        //todo
    }
}
