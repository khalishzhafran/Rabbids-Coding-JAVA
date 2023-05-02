package Core.Commands.MoveCommands;

import Core.Commands.CommandSystems.ICommand;
import Core.Commands.CommandSystems.Receiver;
import Objects.ControllableObjects.ControllableObject;

public class MoveForward implements ICommand {

    private Receiver receiver;
    private ControllableObject controllableObject;

    public MoveForward(Receiver receiver, ControllableObject controllableObject) {
        this.receiver = receiver;
        this.controllableObject = controllableObject;
    }

    @Override
    public void execute() {
        receiver.moveForward(controllableObject);
    }

    @Override
    public void undo() {
        receiver.moveBackward(controllableObject);
    }

}
