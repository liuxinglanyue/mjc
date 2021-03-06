package mjc.types;

/**
 * Abstract base class for MiniJava types.
 */
public abstract class Type {
    /**
     * @return name of the type.
     */
    public abstract String getName();

    /**
     * @return true if this is a built-in type.
     */
    public boolean isBuiltIn() {
        return false;
    }

    /**
     * @return true if this is the int type.
     */
    public boolean isInt() {
        return false;
    }

    /**
     * @return true if this is the int array type.
     */
    public boolean isIntArray() {
        return false;
    }

    /**
     * @return true if this is the boolean type.
     */
    public boolean isBoolean() {
        return false;
    }

    /**
     * @return true if this is a user-defined class type.
     */
    public boolean isClass() {
        return false;
    }

    /**
     * @return true if this is the undefined type.
     */
    public boolean isUndefined() {
        return false;
    }

    /**
     * @return true if this is a reference type.
     */
    public boolean isReference() {
        return false;
    }

    /**
     * @return true if this type is assignable (=) to {@code type}.
     */
    public boolean isAssignableTo(final Type type) {
        return false;
    }

    /**
     * @return true if this type is comparable (==, !=) to {@code type}.
     */
    public boolean isEqualComparableTo(final Type type) {
        return false;
    }

    /**
     * @return true if this type is comparable (<, <=, >, >=) to {@code type}.
     */
    public boolean isRelationalComparableTo(final Type type) {
        return false;
    }

    /**
     * @return true if this type can be added (+) to {@code type}.
     */
    public boolean isAddableTo(final Type type) {
        return false;
    }

    /**
     * @return true if this type can be subtracted (-) from {@code type}.
     */
    public boolean isSubtractableFrom(final Type type) {
        return false;
    }

    /**
     * @return true if this type can be multiplied (*) by {@code type}.
     */
    public boolean isMultipliableWith(final Type type) {
        return false;
    }

    /**
     * @return true if this type can be combined with {@code type} using logical OR.
     */
    public boolean isDisjunctableWith(final Type type) {
        return false;
    }

    /**
     * @return true if this type can be combined with {@code type} using logical AND.
     */
    public boolean isConjunctableWith(final Type type) {
        return false;
    }

    /**
     * @return a Jasmin type descriptor for this type.
     */
    public String descriptor() {
        return null;
    }

    @Override
    public String toString() {
        return getName();
    }
}
