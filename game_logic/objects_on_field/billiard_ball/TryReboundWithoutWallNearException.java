package game_logic.objects_on_field.billiard_ball;

public class TryReboundWithoutWallNearException extends Exception {
    public String toString() {
        return "Tried to rebound without any wall near.";
    }
}
