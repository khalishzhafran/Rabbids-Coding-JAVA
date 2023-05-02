package Objects.InteractableObjects;

public class Button extends InteractableObject {

    public Button() {
        objectSymbol = "Bn";
    }

    @Override
    protected void interact() {
        System.out.println("Button is pressed");
    }

}
