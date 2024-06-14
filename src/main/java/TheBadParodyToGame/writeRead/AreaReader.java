package TheBadParodyToGame.writeRead;

import java.io.Closeable;

import TheBadParodyToGame.area.ConstantArea;

public interface AreaReader<A extends ConstantArea<?>> extends Closeable {

    /**
     * Before calling this method you should set the file name using
     * {@code setFileName} method.
     *
     * @return area read from file with name "{@code fileName}.json"
     * @throws InvalidFileException
     */
    A readArea()
            throws InvalidFileException;

    /**
     * Sets the name of file from which area will be read.
     *
     * @param fileName
     * @throws CannotFindFileException if file with assigned name wasn't found
     */
    void setFileName(String fileName)
            throws CannotFindFileException,
            InvalidFileException;
}
