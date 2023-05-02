package Core.Commands.TurnCommands;

import Core.Commands.CommandSystems.ICommand;
import Core.Commands.CommandSystems.Receiver;
import Objects.ControllableObjects.ControllableObject;

public class TurnRight implements ICommand {
    private Receiver receiver;
    private ControllableObject controllableObject;

    public TurnRight(Receiver receiver, ControllableObject controllableObject) {
        this.receiver = receiver;
        this.controllableObject = controllableObject;
    }

    @Override
    public void execute() {
        receiver.turnRight(controllableObject);
    }

    @Override
    public void undo() {
        receiver.turnLeft(controllableObject);
    }

}
