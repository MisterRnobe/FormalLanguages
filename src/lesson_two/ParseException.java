package lesson_two;

import com.sun.istack.internal.NotNull;

public class ParseException extends RuntimeException {
    public ParseException()
    {
        super();
    }

    public ParseException(String message)
    {
        super(message);

    }
    public ParseException(String message, int index)
    {
        this(message+" at "+index+ " column!");
    }
}
