package dev.mzcy.cloud.api.group.template;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface CloudGroupTemplateProvider {

    Optional<GroupTemplate> getGroupTemplateByName(String name);

    CompletableFuture<GroupTemplate> getGroupTemplateByNameAsync(String name);

    Optional<GroupTemplate[]> getAllGroupTemplates();

    CompletableFuture<GroupTemplate[]> getAllGroupTemplatesAsync();

    void createGroupTemplate(GroupTemplate group);

    void deleteGroupTemplate(GroupTemplate group);

}
