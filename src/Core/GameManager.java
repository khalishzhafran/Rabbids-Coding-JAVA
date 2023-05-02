package Core;

import java.util.Scanner;
import java.io.IOException;

import Core.Commands.CommandSystems.ICommand;
import Core.Commands.CommandSystems.Invoker;
import Core.GameSpace.Level;

public class GameManager {
    public static GameManager Instance = new GameManager();

    private boolean isGameRunning = false;

    private Level level;
    private Invoker invoker = new Invoker();

    public static GameManager getInstance() {
        return Instance;
    }

    public void startGame() throws InterruptedException {
        isGameRunning = true;

        int selectedCommand;
        Scanner scanner = new Scanner(System.in);

        resetDisplay();

        while (isGameRunning) {
            System.out.println("\nAvailable Command:");
            for (int i = 0; i < level.getAvailableCommands().size(); i++) {
                if (level.getAvailableCommands().get(i) == null)
                    continue;
                System.out.println((i + 1) + ". " + level.getAvailableCommands().get(i).getClass().getSimpleName());
            }

            System.out.println("\n8. Execute Command");
            System.out.println("9. Undo Command");
            System.out.println("0. Exit");
            System.out.print("Choose Command : ");

            selectedCommand = scanner.nextInt();

            switch (selectedCommand) {
                case 1:
                    invoker.addCommand(level.getMoveForward());
                    break;
                case 2:
                    invoker.addCommand(level.getMoveBackward());
                    break;
                case 3:
                    invoker.addCommand(level.getTurnLeft());
                    break;
                case 4:
                    invoker.addCommand(level.getTurnRight());
                    break;
                case 5:
                    invoker.addCommand(level.getPickup());
                    break;
                case 8:
                    invoker.executeCommands();
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
        }

        scanner.close();
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    private void printCommandList() {
        System.out.println("Command List:");

        for (ICommand command : invoker.getCommands()) {
            System.out.println(command.getClass().getSimpleName());
        }
    }

    private void resetDisplay() {
        clearConsole();
        level.displayGrid();
        printCommandList();
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
