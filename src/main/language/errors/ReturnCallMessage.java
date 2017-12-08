package main.language.errors;

import main.language.types.AbstractType;

public class ReturnCallMessage extends RuntimeException {
    private AbstractType<?> result;
    public ReturnCallMessage(AbstractType<?> result)
    {
        this.result = result;
    }

    public AbstractType<?> getResult() {
        return result;
    }
}
