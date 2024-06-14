package TheBadParodyToGame.writeRead;

public abstract class ReadException
        extends Exception {

    private final AreaReader<?> reader;
    private final String fileName;

    public ReadException(AreaReader<?> reader, String fileName) {
        this.reader = reader;
        this.fileName = fileName;
    }

    public AreaReader<?> getReader() {
        return reader;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public String toString() {
        return String.format(
                "%s had troubles with reading from %s.",
                getReader().toString(),
                getFileName());
    }
}
