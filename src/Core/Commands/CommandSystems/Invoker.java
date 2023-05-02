package Core.Commands.CommandSystems;

import java.util.Stack;

public class Invoker {
    private Stack<ICommand> commands = new Stack<ICommand>();

    public void addCommand(ICommand command) {
        if (command == null)
            return;
        commands.push(command);
    }

    public void executeCommands() throws InterruptedException {
        for (ICommand command : commands) {
            command.execute();
            Thread.sleep(1000);
        }
    }

    public void undo() {
        if (commands.size() > 0) {
            ICommand command = commands.pop();
            command.undo();
        }
    }

    public Stack<ICommand> getCommands() {
        return commands;
    }
}
