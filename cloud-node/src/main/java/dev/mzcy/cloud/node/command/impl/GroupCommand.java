package dev.mzcy.cloud.node.command.impl;

import dev.mzcy.cloud.api.CloudAPI;
import dev.mzcy.cloud.api.group.type.GroupType;
import dev.mzcy.cloud.node.CloudInstance;
import dev.mzcy.cloud.node.command.Command;
import dev.mzcy.cloud.node.group.CloudGroupImpl;
import dev.mzcy.cloud.node.group.template.CloudGroupTemplateImpl;

public final class GroupCommand implements Command {

    //create <name> <type> <template-to-use>
    //delete <name>

    @Override
    public void execute(String[] args) {

        var terminal = CloudInstance.getInstance().getTerminal();

        if (args.length == 4 && args[0].equalsIgnoreCase("create")) {
            var name = args[1];
            var type = args[2];
            var template = args[3];

            if (CloudAPI.getInstance().getGroupProvider().getGroupByName(name).isPresent()) {
                terminal.write("&2Group already exists.");
                return;
            }

            if (CloudAPI.getInstance().getTemplateProvider().getGroupTemplateByName(template).isEmpty()) {
                terminal.write("&2Group template not found.");
                return;
            }

            CloudAPI.getInstance().getGroupProvider().createGroup(new CloudGroupImpl(name, 1, 1, GroupType.valueOf(type.toUpperCase()), new CloudGroupTemplateImpl(template, "storage/templates/" + template)));
            terminal.write("&0Group created.");

            return;
        }

        if (args.length == 2 && args[0].equalsIgnoreCase("delete")) {
            var name = args[1];
            if (CloudAPI.getInstance().getGroupProvider().getGroupByName(name).isPresent()) {
                var group = CloudAPI.getInstance().getGroupProvider().getGroupByName(name).get();
                CloudAPI.getInstance().getGroupProvider().deleteGroup(group);
                terminal.write("&0Group deleted.");
                return;
            }
            terminal.write("&2Group not found.");
            return;
        }

    }
}
