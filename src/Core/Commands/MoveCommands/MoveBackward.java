package Core.Commands.MoveCommands;

import Core.Commands.CommandSystems.ICommand;
import Core.Commands.CommandSystems.Receiver;
import Objects.ControllableObjects.ControllableObject;

public class MoveBackward implements ICommand {
    private Receiver receiver;
    private ControllableObject controllableObject;

    public MoveBackward(Receiver receiver, ControllableObject controllableObject) {
        this.receiver = receiver;
        this.controllableObject = controllableObject;
    }

    @Override
    public void execute() {
        receiver.moveBackward(controllableObject);
    }

    @Override
    public void undo() {
        receiver.moveForward(controllableObject);
    }
}
