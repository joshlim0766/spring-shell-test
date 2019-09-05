package josh0766.cli.command;

import josh0766.cli.node.CliNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.shell.CommandRegistry;
import org.springframework.shell.MethodTarget;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Order(value = 1)
public class CommandRegistryHelper {

    private static class ActualCommandRegistry implements CommandRegistry {
        private Map<String, MethodTarget> commands = new Hashtable<>();

        @Override
        public Map<String, MethodTarget> listCommands() {
            return commands;
        }
    }

    private CommandRegistry commandRegistry;

    private ActualCommandRegistry actualCommandRegistry = new ActualCommandRegistry();

    @Autowired
    public void setCommandRegistry (CommandRegistry commandRegistry) {
        this.commandRegistry = commandRegistry;

        this.commandRegistry.listCommands().entrySet().stream().forEach(entry -> {
            String commandName = entry.getKey();
            MethodTarget methodTarget = entry.getValue();

            actualCommandRegistry.listCommands().put(commandName, methodTarget);
        });
    }

    public void reconstructCommandRegistry (CliNode cliNode) {
        Map<String, MethodTarget> registeredCommands = commandRegistry.listCommands();

        List<String> disabledCommands = registeredCommands.entrySet().stream().
                filter(entry -> !cliNode.hasCommand(entry.getKey())).
                map(entry -> entry.getKey()).
                collect(Collectors.toList());

        disabledCommands.stream().forEach(commandName -> registeredCommands.remove(commandName));

        actualCommandRegistry.listCommands().entrySet().stream().forEach(entry -> {
            String commandName = entry.getKey();
            MethodTarget methodTarget = entry.getValue();

            if (cliNode.hasCommand(commandName)) {
                registeredCommands.put(commandName, methodTarget);
            }
        });
    }

    public List<String> getCurrentCommandNames () {
        List<String> commandNames = new ArrayList<>();

        commandRegistry.listCommands().entrySet().stream().forEach(entry -> {
            commandNames.add(entry.getKey());
        });

        commandNames.sort(null);

        return commandNames;
    }
}
