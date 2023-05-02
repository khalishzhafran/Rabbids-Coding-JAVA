package Core.Events;

public class GameEvent {
    public static void AddListener(String eventName, GameEventListener listener) {
    }

    public static void Broadcast(String message) {
        System.out.println(message);
    }
}
