package Core.Commands.CommandSystems;

import java.util.Stack;

import Core.GameManager;

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
            GameManager.getInstance().resetDisplay();
            Thread.sleep(1000);
        }
    }

    public void clearCommands() {
        commands.clear();
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
