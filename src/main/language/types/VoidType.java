package main.language.types;

public class VoidType extends AbstractType<Object> {
    public VoidType() {
        super(new Object(){
            @Override
            public String toString() {
                return "void";
            }
        });
    }

    @Override
    public Type getType() {
        return Type.VOID;
    }
}
