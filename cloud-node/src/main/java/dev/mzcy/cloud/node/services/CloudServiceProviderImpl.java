package dev.mzcy.cloud.node.services;

import dev.mzcy.cloud.api.group.CloudGroup;
import dev.mzcy.cloud.api.group.CloudGroupProvider;
import dev.mzcy.cloud.api.group.type.GroupType;
import dev.mzcy.cloud.api.service.CloudService;
import dev.mzcy.cloud.api.service.CloudServiceProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public final class CloudServiceProviderImpl implements CloudServiceProvider {

    private final Map<String, CloudService> servicePool = new ConcurrentHashMap<>();

    @Override
    public CloudService getServiceByName(String name) {
        return this.servicePool.get(name);
    }

    @Override
    public CompletableFuture<CloudService> getServiceByNameAsync(String name) {
        return CompletableFuture.completedFuture(this.servicePool.get(name));
    }

    @Override
    public CloudService[] getAllServices() {
        return this.servicePool.values().toArray(new CloudService[0]);
    }

    @Override
    public CompletableFuture<CloudService[]> getAllServicesAsync() {
        return CompletableFuture.completedFuture(this.servicePool.values().toArray(new CloudService[0]));
    }

    @Override
    public void registerService(CloudService cloudService) {
        this.servicePool.put(cloudService.getName(), cloudService);
    }

    @Override
    public void unregisterService(CloudService cloudService) {
        this.servicePool.remove(cloudService.getName());
    }
}
