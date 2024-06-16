package dev.mzcy.cloud.node.group.template;

import dev.mzcy.cloud.api.group.template.GroupTemplate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public final class CloudGroupTemplateImpl implements GroupTemplate {

    String name;
    String storagePath;

}
