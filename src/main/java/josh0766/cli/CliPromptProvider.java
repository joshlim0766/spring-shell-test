package josh0766.cli;

import josh0766.cli.node.service.NodeManagerService;
import org.jline.utils.AttributedString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

@Component
@Order(value = 3)
public class CliPromptProvider implements PromptProvider {

    @Autowired
    private NodeManagerService nodeManagerService;

    @Override
    public AttributedString getPrompt() {
        String prompt = "CLI";

        prompt += nodeManagerService.getCurrentNode().getPrompt();

        return new AttributedString(prompt, nodeManagerService.getCurrentNode().getPromptStyle());
    }
}
