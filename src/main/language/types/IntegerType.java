package main.language.types;

public class IntegerType extends AbstractType<Integer> {
    public IntegerType(Integer value) {
        super(value);
    }

    @Override
    public Type getType() {
        return Type.INTEGER;
    }
}
