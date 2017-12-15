package main.language.nodes.interfaces;
import main.language.mem.Memory;
import main.language.types.AbstractType;

import java.util.List;
import java.util.Stack;


public interface Assignable {
    void assign(AbstractType<?> value, Stack<Memory> memoryStack);
}
