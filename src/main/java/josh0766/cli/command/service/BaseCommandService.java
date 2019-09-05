package josh0766.cli.command.service;

import josh0766.cli.command.CommandRegistryHelper;
import josh0766.cli.node.CliNode;
import josh0766.cli.node.service.NodeManagerService;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;
import org.jline.utils.InfoCmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.shell.ExitRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseCommandService {

    @Autowired
    private CommandRegistryHelper commandRegistryHelper;

    @Autowired
    private NodeManagerService nodeManagerService;

    @Autowired
    @Lazy
    private Terminal terminal;

    public CharSequence showCommands () {
        List<String> commandNames = commandRegistryHelper.getCurrentCommandNames();

        AttributedStringBuilder result = new AttributedStringBuilder();
        result.append("AVAILABLE COMMANDS\n\n", AttributedStyle.BOLD);

        commandNames.stream().
                filter(commandName -> !nodeManagerService.getCurrentNode().isHiddenCommand(commandName)).
                forEach(commandName -> {
                    result.append(commandName + "\n");
                });

        return result;
    }

    public void exit () {
        CliNode parentNode = nodeManagerService.getCurrentNode().getParentNode();
        if (parentNode == null) {
            throw new ExitRequest();
        }
        else {
            nodeManagerService.changeNode(parentNode);
        }
    }

    public void clear() {
        terminal.puts(InfoCmp.Capability.clear_screen);
    }
}
