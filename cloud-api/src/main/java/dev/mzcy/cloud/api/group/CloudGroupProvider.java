package dev.mzcy.cloud.api.group;

import dev.mzcy.cloud.api.group.type.GroupType;

import java.util.concurrent.CompletableFuture;

public interface CloudGroupProvider {

    CloudGroup getGroupByName(String name);

    CompletableFuture<CloudGroup> getGroupByNameAsync(String name);

    CloudGroup[] getAllGroups();

    CompletableFuture<CloudGroup[]> getAllGroupsAsync();

    CloudGroup[] getGroupsByType(GroupType type);

    CompletableFuture<CloudGroup[]> getGroupsByTypeAsync(GroupType type);

    void createGroup();

    void deleteGroup(CloudGroup group);

}
