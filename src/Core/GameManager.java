package Core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

import Core.Commands.CommandSystems.ICommand;
import Core.Commands.CommandSystems.Invoker;
import Core.GameSpace.Level;

public class GameManager {
    public static GameManager Instance = new GameManager();

    private boolean isGameRunning = false;

    private List<Level> levelList = new ArrayList<Level>();
    private int currentLevelIndex;

    private Invoker invoker = new Invoker();

    public static GameManager getInstance() {
        return Instance;
    }

    public void startGame() throws InterruptedException {
        isGameRunning = true;
        currentLevelIndex = 0;

        int selectedCommand;
        Scanner scanner = new Scanner(System.in);

        resetDisplay();

        while (isGameRunning) {
            System.out.println("\nAvailable Command:");

            getCurrentLevel().displayAvailableCommand();

            System.out.println("\n7. Execute Command");
            System.out.println("8. Clear Command");
            System.out.println("9. Undo Command");
            System.out.println("0. Exit");
            System.out.print("Choose Command : ");

            selectedCommand = scanner.nextInt();

            switch (selectedCommand) {
                case 1:
                    invoker.addCommand(getCurrentLevel().getMoveForward());
                    break;
                case 2:
                    invoker.addCommand(getCurrentLevel().getMoveBackward());
                    break;
                case 3:
                    invoker.addCommand(getCurrentLevel().getTurnLeft());
                    break;
                case 4:
                    invoker.addCommand(getCurrentLevel().getTurnRight());
                    break;
                case 5:
                    invoker.addCommand(getCurrentLevel().getPickup());
                    break;
                case 7:
                    invoker.executeCommands();
                    continue;
                case 8:
                    invoker.clearCommands();
                    continue;
                case 9:
                    invoker.undo();
                    break;
                case 0:
                    isGameRunning = false;
                    break;
                default:
                    System.out.println("Invalid command");
                    continue;
            }

            resetDisplay();

            if (isLevelFinished()) {
                System.out.println("Level Finished!");
                Thread.sleep(5000);

                levelUp();
                invoker.clearCommands();
                if (currentLevelIndex >= levelList.size()) {
                    System.out.println("Game Finished!");
                    Thread.sleep(5000);
                    isGameRunning = false;
                } else {
                    resetDisplay();
                }
            }
        }

        scanner.close();
    }

    public void addLevel(Level level) {
        levelList.add(level);
    }

    private void levelUp() {
        currentLevelIndex++;
    }

    private void printCommandList() {
        System.out.println("Command List:");

        for (ICommand command : invoker.getCommands()) {
            System.out.println(command.getClass().getSimpleName());
        }
    }

    public void resetDisplay() {
        clearConsole();
        getCurrentLevel().displayGrid();
        printCommandList();
    }

    private Level getCurrentLevel() {
        return levelList.get(currentLevelIndex);
    }

    private boolean isLevelFinished() {
        return getCurrentLevel().isFinished();
    }

    private void clearConsole() {
        // Clear the console
        try {
            // Check if the operating system is Windows
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ex) {
        }
    }
}
