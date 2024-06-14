package TheBadParodyToGame.writeRead;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import TheBadParodyToGame.objectsInArea.ObjectInArea;
import TheBadParodyToGame.objectsInArea.affectingToHP.Apple;
import TheBadParodyToGame.objectsInArea.affectingToHP.Fire;
import TheBadParodyToGame.objectsInArea.buildingMaterials.Stone;
import TheBadParodyToGame.objectsInArea.movingObjects.entities.EnemyFollowsPlayer;
import TheBadParodyToGame.objectsInArea.movingObjects.entities.EnemyKnowsPlayerPosition;
import TheBadParodyToGame.objectsInArea.movingObjects.entities.EnemyMovesRandomly;
import TheBadParodyToGame.objectsInArea.movingObjects.entities.player.Player;

class ClassesMap {
    private static final Map<String, Class<?>> classesMap = new HashMap<>();
    private static final Map<Class<?>, String> stringsMap = new HashMap<>();

    public static final String PLAYER = "PLAYER";
    public static final String STONE = "STONE";
    public static final String FIRE = "FIRE";
    public static final String APPLE = "APPLE";
    public static final String ENEMY_MOVES_RANDOMLY = "ENEMY_MOVES_RANDOMLY";
    public static final String ENEMY_FOLLOWS_PLAYER = "ENEMY_FOLLOWING_PLAYER";

    static {
        classesMap.put(PLAYER, Player.class);
        stringsMap.put(Player.class, PLAYER);

        classesMap.put(STONE, Stone.class);
        stringsMap.put(Stone.class, STONE);

        classesMap.put(FIRE, Fire.class);
        stringsMap.put(Fire.class, FIRE);

        classesMap.put(APPLE, Apple.class);
        stringsMap.put(Apple.class, APPLE);

        classesMap.put(ENEMY_MOVES_RANDOMLY, EnemyMovesRandomly.class);
        stringsMap.put(EnemyMovesRandomly.class, ENEMY_MOVES_RANDOMLY);

        classesMap.put(ENEMY_FOLLOWS_PLAYER, EnemyFollowsPlayer.class);
        stringsMap.put(EnemyFollowsPlayer.class, ENEMY_FOLLOWS_PLAYER);
    }

    private ClassesMap() {
    }

    public static String getStringByClass(Class<?> cls) {
        return stringsMap.get(cls);
    }

    public static Class<?> getClassByString(String str) {
        return classesMap.get(str);
    }

    public static List<String> getAllClassesStrings() {
        List<Class<?>> classes = getAllClasses();
        List<String> result = new ArrayList<>();

        for (Class<?> cls : classes) {
            result.add(getStringByClass(cls));
        }

        return result;
    }

    public static List<String> getAllClassesWithoutEntitiesStrings() {
        List<Class<?>> classes = getAllClassesWithoutEntities();
        List<String> result = new ArrayList<>();

        for (Class<?> cls : classes) {
            result.add(getStringByClass(cls));
        }

        return result;
    }

    public static List<Class<?>> getAllClasses() {
        List<Class<?>> result = getAllClassesWithoutEntities();

        result.add(Player.class);
        result.add(EnemyMovesRandomly.class);
        result.add(EnemyKnowsPlayerPosition.class);

        return result;
    }

    public static List<Class<?>> getAllClassesWithoutEntities() {
        List<Class<?>> result = new ArrayList<>();

        result.add(Stone.class);
        result.add(Fire.class);
        result.add(Apple.class);

        return result;
    }

    public static ObjectInArea createObjectOfClass(Class<?> cls) {
        if (cls == Apple.class) {
            return new Apple();
        } else if (cls == Fire.class) {
            return new Fire();
        } else {
            return new Stone();
        }
    }
}
