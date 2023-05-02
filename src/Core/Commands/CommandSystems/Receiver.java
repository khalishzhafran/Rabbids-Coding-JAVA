package Core.Commands.CommandSystems;

import Core.Events.GameEvent;
import Objects.ControllableObjects.ControllableObject;
import Objects.InteractableObjects.InteractableObject;

public class Receiver {
    private final int moveAmount = 1;
    private final int turnAmount = 90;

    public void moveForward(ControllableObject controllableObject) {
        switch (controllableObject.z) {
            case 0:
                controllableObject.yPos += moveAmount;
                break;
            case 90:
                controllableObject.xPos += moveAmount;
                break;
            case 180:
                controllableObject.yPos -= moveAmount;
                break;
            case 270:
                controllableObject.xPos -= moveAmount;
                break;
        }

        GameEvent.Broadcast("positionChanged");
    }

    public void moveBackward(ControllableObject controllableObject) {
        switch (controllableObject.z) {
            case 0:
                controllableObject.yPos -= moveAmount;
                break;
            case 90:
                controllableObject.xPos -= moveAmount;
                break;
            case 180:
                controllableObject.yPos += moveAmount;
                break;
            case 270:
                controllableObject.xPos += moveAmount;
                break;
        }

        GameEvent.Broadcast("positionChanged");
    }

    public void turnLeft(ControllableObject controllableObject) {
        controllableObject.z -= turnAmount;

        if (controllableObject.z == -360) {
            controllableObject.z = 0;
        }
    }

    public void turnRight(ControllableObject controllableObject) {
        controllableObject.z += turnAmount;

        if (controllableObject.z == 360) {
            controllableObject.z = 0;
        }
    }

    public void pickUp(ControllableObject controllableObject, InteractableObject interactableObject) {
        // if (controllableObject.position.equals(interactableObject.position)) {
        // System.out.println(controllableObject + " pick up " + interactableObject);
        // }
    }

    public void drop(ControllableObject controllableObject, InteractableObject interactableObject) {
        // System.out.println(controllableObject + " drop " + interactableObject + " at
        // " + controllableObject.position);
    }
}
