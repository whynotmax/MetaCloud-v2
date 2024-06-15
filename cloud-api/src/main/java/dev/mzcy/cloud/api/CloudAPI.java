package dev.mzcy.cloud.api;

import dev.mzcy.cloud.api.group.CloudGroup;
import dev.mzcy.cloud.api.group.CloudGroupProvider;
import dev.mzcy.cloud.api.service.CloudService;
import dev.mzcy.cloud.api.service.CloudServiceProvider;
import lombok.Getter;

@Getter
public abstract class CloudAPI {

    @Getter
    private static CloudAPI instance;

    public CloudAPI() {
        instance = this;
    }

    public abstract CloudGroupProvider getGroupProvider();

    public abstract CloudServiceProvider getServiceProvider();

}
