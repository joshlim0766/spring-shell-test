package josh0766.cli.node;

import org.jline.utils.AttributedStyle;

import java.util.ArrayList;
import java.util.List;

public enum CliNode {
    DEFAULT("> ", PromptStyle.DEFAULT_PROMPT, new String[] {
            "enable", "license", "show-cpu-info", "show-memory-info", "show-version", "show-version-history", "@emergency"
    }, null),
    LICENSE("(license)# ", PromptStyle.LICENSE_PROMPT, new String[] {
            "check-hw-license", "get-hw-info", "set-hw-license"
    }, DEFAULT),
    ENABLE("# ", PromptStyle.ENABLE_PROMPT, new String[] {
            "configure-terminal", "enable-password", "enable-password-history", "@emergency-password",
            "@emergency-password-history", "monitor", "reboot", "root-password", "shutdown"
    }, DEFAULT),
    CONFIGURE_TERMINAL("(config)# ", PromptStyle.CONFIGURE_TERMINAL, new String[] {
            "database", "ha", "host", "network", "service"
    }, ENABLE);

    private enum PromptStyle {
        DEFAULT_PROMPT(AttributedStyle.DEFAULT, AttributedStyle.GREEN),
        LICENSE_PROMPT(AttributedStyle.DEFAULT, AttributedStyle.YELLOW),
        ENABLE_PROMPT(AttributedStyle.DEFAULT, AttributedStyle.YELLOW),
        CONFIGURE_TERMINAL(AttributedStyle.DEFAULT, AttributedStyle.YELLOW);

        private final AttributedStyle style;

        PromptStyle (AttributedStyle font, int color) {
            style = font.foreground(color);
        }

        public AttributedStyle getStyle () {
            return style;
        }
    }

    private final String prompt;

    private final PromptStyle promptStyle;

    private final List<String> hiddenCommands = new ArrayList<>();
    private final List<String> commands = new ArrayList<>();

    private final CliNode parentNode;

    CliNode (String prompt, PromptStyle style, String[] commands, CliNode parentNode) {
        this.prompt = prompt;
        this.promptStyle = style;
        this.commands.add("exit");
        this.commands.add("quit");
        this.commands.add("list");
        this.commands.add("clear");

        for (String command : commands) {
            addCommand(command);
        }

        this.parentNode = parentNode;
    }

    public String getPrompt () {
        return prompt;
    }

    public AttributedStyle getPromptStyle () {
        return promptStyle.getStyle();
    }

    public void addCommand (String commandName) {
        if (commandName.startsWith("@")) {
            hiddenCommands.add(commandName.substring(1));
        }
        else {
            commands.add(commandName);
        }
    }

    public String[] getCommands () {
        return commands.stream().toArray(String[]::new);
    }

    public boolean hasCommand (String commandName) {
        return (commands.stream().filter(command -> command.equals(commandName)).count() == 1) ||
                (hiddenCommands.stream().filter(command -> command.equals(commandName)).count() == 1);
    }

    public boolean isHiddenCommand (String commandName) {
        return hiddenCommands.stream().filter(command -> command.equals(commandName)).count() == 1;
    }

    public CliNode getParentNode() {
        return parentNode;
    }
}
