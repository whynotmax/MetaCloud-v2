package dev.mzcy.cloud.api.service;

import dev.mzcy.cloud.api.group.CloudGroup;

import java.util.concurrent.CompletableFuture;

public interface CloudService {

    String getName();

    String getGroupName();

    CloudGroup getGroup();

    CompletableFuture<CloudGroup> getGroupAsync();

    void shutdown();



}
