package TheBadParodyToGame.writeRead;

// TODO: docs
public class CannotFindFileException
        extends ReadException {

    public CannotFindFileException(AreaReader<?> reader, String fileName) {
        super(reader, fileName);
    }

    @Override
    public String toString() {
        return String.format(
                "%s couldn't fine file names %s.",
                getReader().toString(),
                getFileName());
    }
}
