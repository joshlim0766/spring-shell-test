package josh0766.cli.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@Slf4j
@ShellComponent
@Order(value = 3)
public class LicenseCommand {

    @ShellMethod(value = "Check H/W license", key = "check-hw-license")
    public void checkHwLicense () {
    }

    @ShellMethod(value = "Set H/W license", key = "set-hw-license")
    public void setHwLicense () {
    }

    @ShellMethod(value = "Get H/W information", key = "get-hw-info")
    public void getHwInfo () {
    }
}
