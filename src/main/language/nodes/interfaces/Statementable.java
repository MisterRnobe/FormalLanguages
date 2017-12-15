package main.language.nodes.interfaces;

import main.language.mem.Memory;
import main.language.state.State;

import java.util.List;
import java.util.Stack;

public interface Statementable {
    State execute(Stack<Memory> memoryStack);

}
