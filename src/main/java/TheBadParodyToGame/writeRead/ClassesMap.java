package TheBadParodyToGame.writeRead;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import TheBadParodyToGame.objectsInArea.affectingToHP.Apple;
import TheBadParodyToGame.objectsInArea.affectingToHP.Fire;
import TheBadParodyToGame.objectsInArea.buildingMaterials.Stone;
import TheBadParodyToGame.objectsInArea.movingObjects.entities.EnemyFollowsPlayer;
import TheBadParodyToGame.objectsInArea.movingObjects.entities.EnemyKnowsPlayerPosition;
import TheBadParodyToGame.objectsInArea.movingObjects.entities.EnemyMovesRandomly;
import TheBadParodyToGame.objectsInArea.movingObjects.entities.player.Player;

class ClassesMap {
    private static final Map<String, Class<?>> classMap = new HashMap<>();
    private static final Map<Class<?>, String> stringMap = new HashMap<>();

    public static final String PLAYER = "PLAYER";
    public static final String STONE = "STONE";
    public static final String FIRE = "FIRE";
    public static final String APPLE = "APPLE";
    public static final String ENEMY_MOVES_RANDOMLY = "ENEMY_MOVES_RANDOMLY";
    public static final String ENEMY_FOLLOWS_PLAYER = "ENEMY_FOLLOWING_PLAYER";

    static {
        classMap.put(PLAYER, Player.class);
        stringMap.put(Player.class, PLAYER);

        classMap.put(STONE, Stone.class);
        stringMap.put(Stone.class, STONE);

        classMap.put(FIRE, Fire.class);
        stringMap.put(Fire.class, FIRE);

        classMap.put(APPLE, Apple.class);
        stringMap.put(Apple.class, APPLE);

        classMap.put(ENEMY_MOVES_RANDOMLY, EnemyMovesRandomly.class);
        stringMap.put(EnemyMovesRandomly.class, ENEMY_MOVES_RANDOMLY);

        classMap.put(ENEMY_FOLLOWS_PLAYER, EnemyFollowsPlayer.class);
        stringMap.put(EnemyFollowsPlayer.class, ENEMY_FOLLOWS_PLAYER);
    }

    private ClassesMap() {
    }

    public static String getStringByClass(Class<?> cls) {
        return stringMap.get(cls);
    }

    public static Class<?> getClassByString(String str) {
        return classMap.get(str);
    }

    public static List<Class<?>> getAllClassesWithoutEntities() {
        List<Class<?>> result = new ArrayList<>();

        result.add(Stone.class);
        result.add(Fire.class);
        result.add(Apple.class);

        return result;
    }

    public static List<Class<?>> getAllClasses() {
        List<Class<?>> result = getAllClassesWithoutEntities();

        result.add(Player.class);
        result.add(EnemyMovesRandomly.class);
        result.add(EnemyKnowsPlayerPosition.class);

        return result;
    }
}
