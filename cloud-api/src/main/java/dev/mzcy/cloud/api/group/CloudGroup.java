package dev.mzcy.cloud.api.group;

import dev.mzcy.cloud.api.group.type.GroupType;

public interface CloudGroup {

    String name();

    int minimumOnlineInstances();
    int maximumOnlineInstances();

    GroupType type();

}
