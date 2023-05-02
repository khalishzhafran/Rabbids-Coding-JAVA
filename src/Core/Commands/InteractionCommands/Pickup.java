package Core.Commands.InteractionCommands;

import Core.Commands.CommandSystems.ICommand;
import Core.Commands.CommandSystems.Receiver;
import Objects.ControllableObjects.ControllableObject;
import Objects.InteractableObjects.InteractableObject;

public class Pickup implements ICommand {
    private Receiver receiver;
    private ControllableObject controllableObject;
    private InteractableObject interactableObject;

    public Pickup(Receiver receiver, ControllableObject controllableObject) {
        this.receiver = receiver;
        this.controllableObject = controllableObject;
    }

    @Override
    public void execute() {
        receiver.pickUp(controllableObject, interactableObject);
    }

    @Override
    public void undo() {
        receiver.drop(controllableObject, interactableObject);
    }

    public void setInteractableObject(InteractableObject interactableObject) {
        this.interactableObject = interactableObject;
    }
}
