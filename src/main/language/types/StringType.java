package main.language.types;

public class StringType extends AbstractType<String> {
    public StringType(String value) {
        super(value);
    }

    @Override
    public Type getType() {
        return Type.STRING;
    }
}
