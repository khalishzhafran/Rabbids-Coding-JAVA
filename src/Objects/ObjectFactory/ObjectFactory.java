package Objects.ObjectFactory;

import Property.ObjectType;
import Objects.Object;
import Objects.ControllableObjects.Rabbid;
import Objects.InteractableObjects.Bag;
import Objects.InteractableObjects.Button;

public class ObjectFactory {
    public static Object createObject(ObjectType objectType) {
        switch (objectType) {
            case Rabbid:
                return new Rabbid();
            case Button:
                return new Button();
            case Bag:
                return new Bag();

            default:
                return null;
        }
    }
}
