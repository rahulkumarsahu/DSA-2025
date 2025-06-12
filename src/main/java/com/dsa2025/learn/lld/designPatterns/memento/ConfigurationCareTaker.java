package com.dsa2025.learn.lld.designPatterns.memento;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationCareTaker {

    List<ConfigurationMemento> history = new ArrayList<>();

    public void addMemento(ConfigurationMemento memento) {
        history.add(memento);
    }

    public ConfigurationMemento undo() {
        if (!history.isEmpty()) {
            int lastIndex = history.size() - 1;
            ConfigurationMemento lastMemento = history.get(lastIndex);
            history.remove(lastIndex);
            return lastMemento;
        }
        return null;
    }

}
