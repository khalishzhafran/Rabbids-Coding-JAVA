import Core.GameManager;
import Core.Commands.CommandFactory.CommandFactory;
// import Core.Commands.InteractionCommands.Pickup;
import Core.Commands.MoveCommands.MoveBackward;
import Core.Commands.MoveCommands.MoveForward;
import Core.Commands.TurnCommands.TurnLeft;
import Core.Commands.TurnCommands.TurnRight;
import Core.GameSpace.Level;
import Core.GameSpace.LevelBuilder;
import Objects.ControllableObjects.Rabbid;
import Objects.ObjectFactory.ObjectFactory;
import Property.CommandType;
import Property.ObjectType;

public class App {
    public static void main(String[] args) throws Exception {
        GameManager gameManager = GameManager.getInstance();

        Rabbid rabbid = (Rabbid) ObjectFactory.createObject(ObjectType.Rabbid);
        CommandFactory.setControllable(rabbid);

        MoveForward moveForward = (MoveForward) CommandFactory.createCommand(CommandType.MoveForward);
        MoveBackward moveBackward = (MoveBackward) CommandFactory.createCommand(CommandType.MoveBackward);
        TurnLeft turnLeft = (TurnLeft) CommandFactory.createCommand(CommandType.TurnLeft);
        TurnRight turnRight = (TurnRight) CommandFactory.createCommand(CommandType.TurnRight);
        // Pickup pickup = (Pickup) CommandFactory.createCommand(CommandType.Pickup);

        Level level1 = new LevelBuilder()
                .setMoveForward(moveForward)
                .setMoveBackward(moveBackward)
                .buildLevel();
        Level level2 = new LevelBuilder()
                .setMoveForward(moveForward)
                .setMoveBackward(moveBackward)
                .setTurnLeft(turnLeft)
                .setTurnRight(turnRight)
                .buildLevel();
        // Level level3 = new LevelBuilder().buildLevel(moveForward, moveBackward,
        // turnLeft, turnRight, pickup);

        level1.setObjectToGrid(4, 8, rabbid);
        level2.setObjectToGrid(2, 5, rabbid);

        gameManager.addLevel(level2);
        gameManager.addLevel(level1);
        gameManager.startGame();
    }
}
