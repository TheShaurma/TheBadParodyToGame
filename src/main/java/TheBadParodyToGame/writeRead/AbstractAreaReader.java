package TheBadParodyToGame.writeRead;

import TheBadParodyToGame.area.ConstantArea;

public abstract class AbstractAreaReader<A extends ConstantArea<?>>
        implements AreaReader<A> {

    private String fileName;
    protected static final String[] PATH = {
            "data",
            "rooms"
    };

    @Override
    public void setFileName(String fileName)
            throws CannotFindFileException,
            InvalidFileException {
        this.fileName = fileName;
    }

    protected String getFileName() {
        return fileName;
    }
}
