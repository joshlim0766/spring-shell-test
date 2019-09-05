package josh0766.cli.command;

import josh0766.cli.node.CliNode;
import josh0766.cli.node.service.NodeManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@Slf4j
@ShellComponent
@Order(value = 3)
public class EnableCommand {

    @Autowired
    private NodeManagerService nodeManagerService;

    @ShellMethod(value = "Enter the configure mode", key = {"configure-terminal"})
    public void enterEnableMode () {
        nodeManagerService.changeNode(CliNode.CONFIGURE_TERMINAL);
    }

    @ShellMethod(value = "Change enable password", key = {"enable-password"})
    public void changeEnablePassword () {
    }

    @ShellMethod(value = "Show enable password history", key = {"enable-password-history"})
    public void showEnablePasswordHistory () {
    }

    @ShellMethod(value = "Enter the monitoring mode", key = {"monitor"})
    public void enterMonitorMode () {
    }

    @ShellMethod(value = "Reboot system", key = {"reboot"})
    public void reboot () {
    }

    @ShellMethod(value = "Change root password", key = {"root-password"})
    public void changeRootPassword () {
    }

    @ShellMethod(value = "Shutdown system", key = {"shutdown"})
    public void shutdown () {
    }
}
