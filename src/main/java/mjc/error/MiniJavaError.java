package mjc.error;

/**
 * The MiniJavaError class represents an error in the input program.
 */
public final class MiniJavaError {
    final int line;
    final int column;
    final MiniJavaErrorType type;
    final Object[] args;

    /**
     * Constructs a new error.
     *
     * Errors are usually not created explicitly (which is why this constructor is package
     * private), but by using the {@link MiniJavaErrorType#on(int, int, Object...)} factory
     * method.
     *
     * @param line Line of the error.
     * @param column Column of the error.
     * @param type Type of the error.
     * @param args Arguments for the error message (as defined by the type).
     */
    MiniJavaError(int line, int column, MiniJavaErrorType type, Object... args) {
        this.line = line;
        this.column = column;
        this.type = type;
        this.args = args;
    }

    /**
     * @return Line of the error.
     */
    public int getLine() {
        return line;
    }

    /**
     * @return Column of the error.
     */
    public int getColumn() {
        return column;
    }

    /**
     * @return Type of the error.
     */
    public MiniJavaErrorType getType() {
        return type;
    }

    /**
     * @return Formatted error message.
     */
    public String getMessage() {
        return args.length == 0 ? type.getMessage() : String.format(type.getMessage(), args);
    }

    @Override
    public String toString() {
        return "[" + getLine() + "," + getColumn() + "] error: " + getMessage();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other)
            return true;
        if (other instanceof MiniJavaError && ((MiniJavaError) other).type.equals(type))
            return true;
        return other.equals(type); // Compare equal to our type as well (convenient in tests).
    }
}