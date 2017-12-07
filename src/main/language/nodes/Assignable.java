package main.language.nodes;

import main.language.misc.VariablesPool;
import main.language.types.AbstractType;

interface Assignable {
    void assign(VariablesPool pool, AbstractType<?> value);
}
