package main.language.types;

public class DoubleType extends AbstractType<Double> {

    public DoubleType(Double value) {
        super(value);
    }

    @Override
    public Type getType() {
        return Type.DOUBLE;
    }
}
