package field_logic.intarfaces;

public interface iFieldWithIterableObjects extends iField {
    void putIterableObject(String name, iIterableObjectOnField obj);

    iIterableObjectOnField getIterableObject(String name);

    void removeIterableObject(String name);
}
