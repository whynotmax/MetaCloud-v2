package dev.mzcy.cloud.api.service;

import java.util.concurrent.CompletableFuture;

public interface CloudServiceProvider {

    CloudService getServiceByName(String name);

    CompletableFuture<CloudService> getServiceByNameAsync(String name);

    CloudService[] getAllServices();

    CompletableFuture<CloudService[]> getAllServicesAsync();

    void registerService(CloudService cloudService);

    void unregisterService(CloudService cloudService);

}
