package josh0766.cli.command;

import josh0766.cli.command.service.DefaultCommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@Slf4j
@ShellComponent
@Order(value = 3)
public class DefaultCommand {

    @Autowired
    private DefaultCommandService defaultCommandService;

    @ShellMethod(value = "Enter the enable mode", key = {"enable"})
    public void enterEnableMode () {
        defaultCommandService.enterEnableMode();
    }

    @ShellMethod(value = "Enter the emergency shell", key = {"emergency"})
    public void enterEmergencyMode () {
    }

    @ShellMethod(value = "Enter the license mode", key = {"license"})
    public void enterLicenseMode () {
        defaultCommandService.enterLicenseMode();
    }

    @ShellMethod(value = "Show CPU information", key = {"show-cpu-info"})
    public void showCpuInfo () {
    }

    @ShellMethod(value = "Show memory information", key = {"show-memory-info"})
    public void showMemoryInfo () {
    }

    @ShellMethod(value = "Show version", key = {"show-version"})
    public void showVersion () {
    }

    @ShellMethod(value = "Show version history", key = {"show-version-history"})
    public void showVersionHistory () {
    }
}
