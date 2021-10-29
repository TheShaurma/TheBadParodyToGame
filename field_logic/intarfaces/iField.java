package field_logic.intarfaces;

public interface iField {
    // this method will call obj.setField(this)
    void putObject(iDot pos, iObjectOnField obj);

    iObjectOnField getObject(iDot pos);

    void removeObject(iDot pos);
}
