package Core.Commands.CommandFactory;

import Property.CommandType;
import Core.Commands.CommandSystems.ICommand;
import Core.Commands.CommandSystems.Receiver;
import Core.Commands.InteractionCommands.Pickup;
import Core.Commands.MoveCommands.MoveBackward;
import Core.Commands.MoveCommands.MoveForward;
import Core.Commands.TurnCommands.TurnLeft;
import Core.Commands.TurnCommands.TurnRight;
import Objects.ControllableObjects.ControllableObject;

public class CommandFactory {
    private static Receiver receiver = new Receiver();
    private static ControllableObject controllableObject;

    public static ICommand createCommand(CommandType commandType) {
        switch (commandType) {
            case MoveForward:
                return new MoveForward(receiver, controllableObject);
            case MoveBackward:
                return new MoveBackward(receiver, controllableObject);
            case TurnLeft:
                return new TurnLeft(receiver, controllableObject);
            case TurnRight:
                return new TurnRight(receiver, controllableObject);
            case Pickup:
                return new Pickup(receiver, controllableObject);
            default:
                throw new Error("Cannot create command, command type not found");
        }
    }

    public static void setControllable(ControllableObject controllableObject) {
        CommandFactory.controllableObject = controllableObject;
    }
}
