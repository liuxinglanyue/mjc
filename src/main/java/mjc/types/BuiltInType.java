package mjc.types;

/**
 * BuiltInType represents a built-in MiniJava type.
 *
 * There are only three static instances of this class, one for each of the built-in
 * types int, int[] and boolean.
 */
public class BuiltInType extends Type {

    public final static Type Int = new BuiltInType("int");
    public final static Type IntArray = new BuiltInType("int[]");
    public final static Type Boolean = new BuiltInType("boolean");

    private final String name;

    /**
     * Construct a new built-in type with the given name.
     *
     * @param name Name of the type.
     */
    private BuiltInType(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isBuiltIn() {
        return true;
    }

    @Override
    public boolean isInt() {
        return this == Int;
    }

    @Override
    public boolean isIntArray() {
        return this == IntArray;
    }

    @Override
    public boolean isBoolean() {
        return this == Boolean;
    }

    @Override
    public boolean isClass() {
        return false;
    }

    @Override
    public boolean isReference() {
        return this == IntArray;
    }

    @Override
    public boolean isAssignableTo(final Type type) {
        return type.isUndefined() || type == this;
    }

    @Override
    public boolean isEqualComparableTo(final Type type) {
        return type.isUndefined() || type == this;
    }

    @Override
    public boolean isRelationalComparableTo(final Type type) {
        return type.isUndefined() || type.isInt() && isInt();
    }

    @Override
    public boolean isAddableTo(final Type type) {
        return type.isUndefined() || type.isInt() && isInt();
    }

    @Override
    public boolean isSubtractableFrom(final Type type) {
        return type.isUndefined() || type.isInt() && isInt();
    }

    @Override
    public boolean isMultipliableWith(final Type type) {
        return type.isUndefined() || type.isInt() && isInt();
    }

    @Override
    public boolean isDisjunctableWith(final Type type) {
        return type.isUndefined() || type.isBoolean() && isBoolean();
    }

    @Override
    public boolean isConjunctableWith(final Type type) {
        return type.isUndefined() || type.isBoolean() && isBoolean();
    }

    @Override
    public String descriptor() {
        if (this == Int) {
            return "I";
        } else if (this == IntArray) {
            return "[I";
        } else if (this == Boolean) {
            return "Z";
        } else {
            throw new Error("Unknown type");
        }
    }
}
