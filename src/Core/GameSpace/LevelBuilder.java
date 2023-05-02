package Core.GameSpace;

import Core.Commands.InteractionCommands.Pickup;
import Core.Commands.MoveCommands.MoveBackward;
import Core.Commands.MoveCommands.MoveForward;
import Core.Commands.TurnCommands.TurnLeft;
import Core.Commands.TurnCommands.TurnRight;

public class LevelBuilder {
    private Level level;

    public LevelBuilder() {
        level = new Level();
    }

    public LevelBuilder setMoveForward(MoveForward moveForward) {
        level.setMoveForward(moveForward);
        return this;
    }

    public LevelBuilder setMoveBackward(MoveBackward moveBackward) {
        level.setMoveBackward(moveBackward);
        return this;
    }

    public LevelBuilder setTurnLeft(TurnLeft turnLeft) {
        level.setTurnLeft(turnLeft);
        return this;
    }

    public LevelBuilder setTurnRight(TurnRight turnRight) {
        level.setTurnRight(turnRight);
        return this;
    }

    public LevelBuilder setPickup(Pickup pickup) {
        level.setPickup(pickup);
        return this;
    }

    public Level buildLevel() {
        return level;
    }
}
