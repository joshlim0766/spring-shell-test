package josh0766.cli.command;

import josh0766.cli.command.service.BaseCommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.commands.Clear;
import org.springframework.shell.standard.commands.Quit;

@Slf4j
@ShellComponent
@Order(value = 3)
public class BaseCommand implements Quit.Command, Clear.Command {

    @Autowired
    private BaseCommandService baseCommandService;

    @ShellMethod(value = "Show commands in current node", key = {"list"})
    public CharSequence showCommands () {
        return baseCommandService.showCommands();
    }

    @ShellMethod(value = "Exit current mode.", key = {"quit", "exit"})
    public void exit () {
        baseCommandService.exit();
    }

    @ShellMethod("Clear the screen.")
    public void clear() {
        baseCommandService.clear();
    }
}
