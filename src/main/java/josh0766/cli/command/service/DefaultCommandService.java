package josh0766.cli.command.service;

import josh0766.cli.node.CliNode;
import josh0766.cli.node.service.NodeManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultCommandService {

    @Autowired
    private NodeManagerService nodeManagerService;

    public void enterEnableMode () {
        nodeManagerService.changeNode(CliNode.ENABLE);
    }

    public void enterLicenseMode () {
        nodeManagerService.changeNode(CliNode.LICENSE);
    }
}
