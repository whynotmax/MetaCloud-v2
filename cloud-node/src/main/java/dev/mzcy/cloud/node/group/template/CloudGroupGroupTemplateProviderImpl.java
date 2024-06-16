package dev.mzcy.cloud.node.group.template;

import dev.mzcy.cloud.api.group.template.CloudGroupTemplateProvider;
import dev.mzcy.cloud.api.group.template.GroupTemplate;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class CloudGroupGroupTemplateProviderImpl implements CloudGroupTemplateProvider {

    Map<String, GroupTemplate> templatePool = new ConcurrentHashMap<>();

    @Override
    public Optional<GroupTemplate> getGroupTemplateByName(String name) {
        return Optional.ofNullable(templatePool.get(name));
    }

    @Override
    public CompletableFuture<GroupTemplate> getGroupTemplateByNameAsync(String name) {
        return CompletableFuture.completedFuture(templatePool.get(name));
    }

    @Override
    public Optional<GroupTemplate[]> getAllGroupTemplates() {
        return Optional.of(templatePool.values().toArray(new GroupTemplate[0]));
    }

    @Override
    public CompletableFuture<GroupTemplate[]> getAllGroupTemplatesAsync() {
        return CompletableFuture.completedFuture(templatePool.values().toArray(new GroupTemplate[0]));
    }

    @Override
    public void createGroupTemplate(GroupTemplate group) {
        templatePool.put(group.getName(), group);
    }

    @Override
    public void deleteGroupTemplate(GroupTemplate group) {
        templatePool.remove(group.getName());
        //TODO: set all groups with this template to default template
    }
}
