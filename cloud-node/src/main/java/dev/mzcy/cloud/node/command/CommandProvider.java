package dev.mzcy.cloud.node.command;

import dev.mzcy.cloud.node.command.impl.GroupCommand;
import dev.mzcy.cloud.node.command.impl.ShutdownCommand;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public final class CommandProvider {

    Map<String, Command> commands = new ConcurrentHashMap<>();

    public CommandProvider() {
        this.registerCommand("shutdown", new ShutdownCommand(), "stop", "exit", "quit", "end", "terminate");
        this.registerCommand("group", new GroupCommand(), "g", "groups");
    }

    public void registerCommand(String name, Command command, String... aliases) {
        commands.put(name, command);
        for (var alias : aliases) {
            commands.put(alias, command);
        }
    }

    public void call(String[] args) {
        var arguments = new ArrayList<>(Arrays.stream(args).toList());
        var command = arguments.remove(0);

        if (commands.containsKey(command)) {
            commands.get(command).execute(arguments.toArray(new String[0]));
        }
    }

}
