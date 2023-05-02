package Core.Commands.CommandSystems;

public interface ICommand {
    public void execute();

    public void undo();
}
