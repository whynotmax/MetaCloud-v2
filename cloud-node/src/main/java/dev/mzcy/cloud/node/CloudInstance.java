package dev.mzcy.cloud.node;

import dev.mzcy.cloud.api.CloudAPI;
import dev.mzcy.cloud.api.group.CloudGroupProvider;
import dev.mzcy.cloud.api.service.CloudServiceProvider;
import dev.mzcy.cloud.node.group.CloudGroupProviderImpl;
import dev.mzcy.cloud.node.services.CloudServiceProviderImpl;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class CloudInstance extends CloudAPI {

    CloudGroupProvider groupProvider;
    CloudServiceProvider serviceProvider;

    public CloudInstance() {
        this.groupProvider = new CloudGroupProviderImpl();
        this.serviceProvider = new CloudServiceProviderImpl();
    }
}
