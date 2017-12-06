package main.language.misc;

import main.language.nodes.VariableNode;
import main.language.types.AbstractType;

import java.util.ArrayList;
import java.util.Optional;

public class VariablesPool extends ArrayList<Node<String, AbstractType<?>>> {
    public void update(String name, AbstractType<?> value)
    {
        for (int i = 0; i < this.size(); i++) {
            if (get(i).getKey().equals(name)) {
                get(i).setValue(value);
                return;
            }
        }
        this.add(new Node<>(name, value));
    }
    public AbstractType<?> getByName(String name)
    {
        Optional<Node<String, AbstractType<?>>> node = stream().filter(n->n.getKey().equals(name)).findFirst();
        if (node.isPresent())
            return node.get().getValue();
        else
            throw new RuntimeException("Variable "+name+" was not found!");
    }
}
