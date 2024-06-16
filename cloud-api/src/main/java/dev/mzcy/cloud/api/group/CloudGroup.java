package dev.mzcy.cloud.api.group;

import dev.mzcy.cloud.api.group.template.GroupTemplate;
import dev.mzcy.cloud.api.group.type.GroupType;

public interface CloudGroup {

    String getName();

    int getMinimumOnlineInstances();
    int getMaximumOnlineInstances();

    GroupType getType();

    GroupTemplate getTemplate();

}
