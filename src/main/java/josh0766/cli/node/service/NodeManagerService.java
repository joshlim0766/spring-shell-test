package josh0766.cli.node.service;

import josh0766.cli.command.CommandRegistryHelper;
import josh0766.cli.node.CliNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Order(value = 2)
public class NodeManagerService {

    private CliNode currentNode = CliNode.DEFAULT;

    @Autowired
    private CommandRegistryHelper commandRegistryHelper;

    @PostConstruct
    public void init () {
        commandRegistryHelper.reconstructCommandRegistry(currentNode);
    }

    public void changeNode (CliNode cliNode) {
        currentNode = cliNode;

        commandRegistryHelper.reconstructCommandRegistry(currentNode);
    }

    public CliNode getCurrentNode () {
        return currentNode;
    }
}
