package Core.GameSpace;

import Core.Events.GameEvent;
import Core.Events.GameEventListener;
import Objects.Object;

public class Grid {
    private final String ANSI_DEFAULT = "\u001B[0m";
    private final String ANSI_GREEN = "\u001B[42m";
    private final String ANSI_RED = "\u001B[41m";

    private final int GRID_SIZE = 10;
    private String[][] grid = new String[GRID_SIZE][GRID_SIZE];

    public Grid() {
        // GameEvent.AddListener("positionChanged");
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = "-";
            }
        }
    }

    public void setObject(int x, int y, Object object) {
        grid[x][y] = object.objectSymbol;
        object.setPosition(x, y);
    }

    public void display() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (grid[i][j] == "-") {
                    System.out.print("|" + ANSI_GREEN + "     " + grid[i][j] + "     " + ANSI_DEFAULT + "|");
                } else {
                    System.out.print("|" + ANSI_RED + "     " + grid[i][j] + "     " + ANSI_DEFAULT + "|");
                }
            }
            System.out.println();
        }
    }

    private void positionChanged(GameEventListener listener) {
        System.out.println("Position changed");
    }
}
