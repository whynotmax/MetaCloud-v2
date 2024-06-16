package dev.mzcy.cloud.api.group;

import dev.mzcy.cloud.api.group.type.GroupType;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface CloudGroupProvider {

    Optional<CloudGroup> getGroupByName(String name);

    CompletableFuture<CloudGroup> getGroupByNameAsync(String name);

    Optional<CloudGroup[]> getAllGroups();

    CompletableFuture<CloudGroup[]> getAllGroupsAsync();

    Optional<CloudGroup[]> getGroupsByType(GroupType type);

    CompletableFuture<CloudGroup[]> getGroupsByTypeAsync(GroupType type);

    void createGroup(CloudGroup group);

    void deleteGroup(CloudGroup group);

}
