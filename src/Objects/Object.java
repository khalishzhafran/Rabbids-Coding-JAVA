package Objects;

public abstract class Object {
    public int xPos;
    public int yPos;
    public String objectSymbol;

    public void setPosition(int x, int y) {
        xPos = x;
        yPos = y;
    }
}
