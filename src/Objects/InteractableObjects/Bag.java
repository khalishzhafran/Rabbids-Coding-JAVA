package Objects.InteractableObjects;

public class Bag extends InteractableObject {

    public Bag() {
        objectSymbol = "B";
    }

    @Override
    protected void interact() {
        System.out.println("Bag is opened");
    }

}
