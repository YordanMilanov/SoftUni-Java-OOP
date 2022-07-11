package StackOfStrings_06;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings(List<String> data) {
        this.data = new ArrayList<>();
    }

    public String pop () {
        String currentString = this.data.get(this.data.size() - 1);
        this.data.remove(this.data.size() - 1);
        return currentString;
    }

    public String peek () {
        String currentString = this.data.get(this.data.size() - 1);
        return currentString;
    }

    public boolean isEmpty () {
        return this.data.isEmpty();
    }

    public void push (String string) {
        this.data.add(string);
    }
}
