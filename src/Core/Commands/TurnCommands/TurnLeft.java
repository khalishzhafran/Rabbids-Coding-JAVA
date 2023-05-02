package Core.Commands.TurnCommands;

import Core.Commands.CommandSystems.ICommand;
import Core.Commands.CommandSystems.Receiver;
import Objects.ControllableObjects.ControllableObject;

public class TurnLeft implements ICommand {
    private Receiver receiver;
    private ControllableObject controllableObject;

    public TurnLeft(Receiver receiver, ControllableObject controllableObject) {
        this.receiver = receiver;
        this.controllableObject = controllableObject;
    }

    @Override
    public void execute() {
        receiver.turnLeft(controllableObject);
    }

    @Override
    public void undo() {
        receiver.turnRight(controllableObject);
    }

}
