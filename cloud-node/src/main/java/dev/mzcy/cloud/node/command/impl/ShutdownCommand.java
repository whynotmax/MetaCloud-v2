package dev.mzcy.cloud.node.command.impl;

import dev.mzcy.cloud.node.command.Command;

public final class ShutdownCommand implements Command {

    @Override
    public void execute(String[] args) {

        System.exit(0);

    }

}
