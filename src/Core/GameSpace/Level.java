package Core.GameSpace;

import java.util.ArrayList;
import java.util.List;

import Core.Commands.CommandSystems.ICommand;
import Core.Commands.InteractionCommands.Pickup;
import Core.Commands.MoveCommands.MoveBackward;
import Core.Commands.MoveCommands.MoveForward;
import Core.Commands.TurnCommands.TurnLeft;
import Core.Commands.TurnCommands.TurnRight;
import Objects.Object;

public class Level {
    private Grid grid;

    private MoveForward moveForward;
    private MoveBackward moveBackward;
    private TurnLeft turnLeft;
    private TurnRight turnRight;
    private Pickup pickup;

    private List<ICommand> availableCommands = new ArrayList<ICommand>();

    public Level() {
        grid = new Grid();
    }

    public void setObjectToGrid(int x, int y, Object object) {
        grid.setObject(x, y, object);
    }

    public void displayGrid() {
        grid.display();
    }

    public void setMoveForward(MoveForward moveForward) {
        this.moveForward = moveForward;
        availableCommands.add(moveForward);
    }

    public void setMoveBackward(MoveBackward moveBackward) {
        this.moveBackward = moveBackward;
        availableCommands.add(moveBackward);
    }

    public void setTurnLeft(TurnLeft turnLeft) {
        this.turnLeft = turnLeft;
        availableCommands.add(turnLeft);
    }

    public void setTurnRight(TurnRight turnRight) {
        this.turnRight = turnRight;
        availableCommands.add(turnRight);
    }

    public void setPickup(Pickup pickup) {
        this.pickup = pickup;
        availableCommands.add(pickup);
    }

    public MoveForward getMoveForward() {
        return moveForward;
    }

    public MoveBackward getMoveBackward() {
        return moveBackward;
    }

    public TurnLeft getTurnLeft() {
        return turnLeft;
    }

    public TurnRight getTurnRight() {
        return turnRight;
    }

    public Pickup getPickup() {
        return pickup;
    }

    public List<ICommand> getAvailableCommands() {
        return availableCommands;
    }
}
