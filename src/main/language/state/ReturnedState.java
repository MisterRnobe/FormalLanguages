package main.language.state;

import main.language.types.AbstractType;

public class ReturnedState extends State {
    private AbstractType<?> value;

    public ReturnedState(AbstractType<?> value) {
        this.value = value;
    }

    public AbstractType<?> getValue() {
        return value;
    }
}
