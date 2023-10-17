package TheBadParodyToGame.area;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.position.BusyPositionException;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;

public interface Area<OBJ extends ObjectInArea> extends ConstantArea<OBJ> {
        /**
         * Anyways place {@code obj} at {@code pos}.
         * 
         * @param pos
         * @param obj
         * @throws PositionCannotExistInAreaException if {@code pos} can't exist in
         *                                            Area.
         */
        void set(Position pos, OBJ obj) throws PositionCannotExistInAreaException;

        /**
         * Place {@code obj} at {@code pos} in Area
         * 
         * @param pos
         * @param obj
         * @throws BusyPositionException              if {@code pos} is busy;
         * @throws PositionCannotExistInAreaException if {@code pos} can't exist in
         *                                            Area.
         */
        void place(Position pos, OBJ obj) throws BusyPositionException, PositionCannotExistInAreaException;

        /**
         * If {@code pos} is busy, nothing will happen,
         * else place {@code obj} at {@code pos} in Area.
         * 
         * @param pos
         * @param obj
         * @throws PositionCannotExistInAreaException if pos can't exist in Area.
         */
        void tryPlace(Position pos, OBJ obj) throws PositionCannotExistInAreaException;

        /**
         * Replace old object at {@code pos} to new assigned {@code obj}.
         * 
         * @param pos
         * @param obj
         * @throws EmptyPositionException             if {@code pos} is empty;
         * @throws PositionCannotExistInAreaException if {@code pos} can't exist in
         *                                            Area.
         */
        void replace(Position pos, OBJ obj) throws EmptyPositionException, PositionCannotExistInAreaException;

        /**
         * If {@code pos} is empty do nothing, else replace old object at {@code pos} to
         * new assigned {@code obj}.
         * 
         * @param pos
         * @param obj
         * @throws PositionCannotExistInAreaException if {@code pos} can't exist in
         *                                            Area.
         */
        void tryReplace(Position pos, OBJ obj) throws PositionCannotExistInAreaException;

        /**
         * Removes object from assigned {@code pos}.
         * 
         * @param pos
         * @throws EmptyPositionException             if {@code pos} is empty;
         * @throws PositionCannotExistInAreaException if {@code pos} can't exist in
         *                                            Area.
         */
        void remove(Position pos) throws EmptyPositionException, PositionCannotExistInAreaException;

        /**
         * If {@code pos} is empty, nothing will happen,
         * else remove object from assigned {@code pos}.
         * 
         * @param pos
         * @throws PositionCannotExistInAreaException if {@code pos} can't exist in
         *                                            Area.
         */
        void tryRemove(Position pos) throws PositionCannotExistInAreaException;

        /**
         * Relocate object from {@code oldPos} to {@code newPos}.
         * 
         * @param oldPos
         * @param newPos
         * @throws EmptyPositionException             if {@code oldPos} is empty;
         * @throws BusyPositionException              {@code newPos} is busy;
         *                                            If {@code oldPos} is empty and
         *                                            {@code newPos}
         *                                            is Busy
         *                                            synchronically, throws
         *                                            {@code EmptyPositionException}
         * @throws PositionCannotExistInAreaException if {@code oldPos} or
         *                                            {@code newPos} can't
         *                                            exist in Area.
         */
        void relocate(Position oldPos, Position newPos)
                        throws EmptyPositionException, BusyPositionException, PositionCannotExistInAreaException;

        /**
         * If {@code oldPos} is empty or/and {@code newPos} is busy nothing will happen,
         * else relocate object from {@code oldPos} to {@code newPos}.
         * 
         * @param oldPos
         * @param newPos
         * @throws PositionCannotExistInAreaException if {@code oldPos} or
         *                                            {@code newPos} can't
         *                                            exist in Area.
         */
        void tryRelocate(Position oldPos, Position newPos) throws PositionCannotExistInAreaException;

        /**
         * Relocate object from {@code oldPos} to {@code newPos} even if {@code newPos}
         * is busy.
         * 
         * @param oldPos
         * @param newPos
         * @throws EmptyPositionException             if {@code oldPos} is empty;
         * @throws PositionCannotExistInAreaException if {@code oldPos} or
         *                                            {@code newPos} can't
         *                                            exist in Area.
         */
        void relocateToEverywhere(Position oldPos, Position newPos)
                        throws EmptyPositionException, PositionCannotExistInAreaException;
}
