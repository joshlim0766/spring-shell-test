package josh0766.cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

@SpringBootApplication
public class IsignplusCliApplication {

    public static void main (String[] args) {
        String[] disabledCommands = {};
        String[] fullArgs = StringUtils.concatenateStringArrays(args, disabledCommands);

        SpringApplication.run(IsignplusCliApplication.class, fullArgs);
    }
}

