package dev.mzcy.cloud.node.group;

import dev.mzcy.cloud.api.group.CloudGroup;
import dev.mzcy.cloud.api.group.CloudGroupProvider;
import dev.mzcy.cloud.api.group.type.GroupType;
import lombok.experimental.FieldDefaults;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public final class CloudGroupProviderImpl implements CloudGroupProvider {

    Map<String, CloudGroup> groupPool = new ConcurrentHashMap<>();

    @Override
    public CloudGroup getGroupByName(String name) {
        return groupPool.get(name);
    }

    @Override
    public CompletableFuture<CloudGroup> getGroupByNameAsync(String name) {
        return CompletableFuture.completedFuture(groupPool.get(name));
    }

    @Override
    public CloudGroup[] getAllGroups() {
        return groupPool.values().toArray(new CloudGroup[0]);
    }

    @Override
    public CompletableFuture<CloudGroup[]> getAllGroupsAsync() {
        return CompletableFuture.completedFuture(groupPool.values().toArray(new CloudGroup[0]));
    }

    @Override
    public CloudGroup[] getGroupsByType(GroupType type) {
        return groupPool.values().stream().filter(group -> group.getType().equals(type)).toArray(CloudGroup[]::new);
    }

    @Override
    public CompletableFuture<CloudGroup[]> getGroupsByTypeAsync(GroupType type) {
        return CompletableFuture.completedFuture(groupPool.values().stream().filter(group -> group.getType().equals(type)).toArray(CloudGroup[]::new));
    }

    @Override
    public void createGroup(CloudGroup group) {
        groupPool.put(group.getName(), group);
    }

    @Override
    public void deleteGroup(CloudGroup group) {
        groupPool.remove(group.getName());
    }
}
