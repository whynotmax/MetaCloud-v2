package dev.mzcy.cloud.node.command;

import dev.mzcy.cloud.node.command.impl.ShutdownCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class CommandProvider {

    private Map<String, Command> commands = new ConcurrentHashMap<>();

    public CommandProvider() {
        this.registerCommand("shutdown", new ShutdownCommand());
    }

    public void registerCommand(String name, Command command) {
        commands.put(name, command);
    }

    public void call(String[] args) {
        var arguments = new ArrayList<>(Arrays.stream(args).toList());
        var command = arguments.remove(0);

        if (commands.containsKey(command)) {
            commands.get(command).execute(arguments.toArray(new String[0]));
        }
    }

}
