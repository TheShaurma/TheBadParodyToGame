package TheBadParodyToGame.writeRead;

public class InvalidFileException
        extends ReadException {

    public InvalidFileException(AreaReader<?> reader, String fileName) {
        super(reader, fileName);
    }

    @Override
    public String toString() {
        return String.format(
                "%s couldn't read from %s because this file is invalid.",
                getReader().toString(),
                getFileName());
    }
}
