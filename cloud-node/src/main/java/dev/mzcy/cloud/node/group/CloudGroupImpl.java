package dev.mzcy.cloud.node.group;

import dev.mzcy.cloud.api.group.CloudGroup;
import dev.mzcy.cloud.api.group.template.GroupTemplate;
import dev.mzcy.cloud.api.group.type.GroupType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public final class CloudGroupImpl implements CloudGroup {

    String name;
    int minimumOnlineInstances;
    int maximumOnlineInstances;
    GroupType type;
    GroupTemplate template;


}
