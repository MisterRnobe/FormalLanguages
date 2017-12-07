package main.language.types;

public abstract class AbstractType<V> implements Cloneable {
    protected V value;
    protected AbstractType(V value) {
        this.value = value;
    }
    public abstract Type getType();
    public V getValue()
    {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public enum Type
    {
        INTEGER, DOUBLE, STRING
    }
}
