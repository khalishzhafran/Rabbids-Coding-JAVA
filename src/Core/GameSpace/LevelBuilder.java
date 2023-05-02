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

    public Level buildLevel(MoveForward moveForward, MoveBackward moveBackward, TurnLeft turnLeft,
            TurnRight turnRight,
            Pickup pickup) {
        level.setMoveForward(moveForward);
        level.setMoveBackward(moveBackward);
        level.setTurnLeft(turnLeft);
        level.setTurnRight(turnRight);
        level.setPickup(pickup);
        return level;
    }
}
