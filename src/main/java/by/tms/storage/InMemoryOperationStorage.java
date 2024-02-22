package by.tms.storage;

import by.tms.model.Operation;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOperationStorage {
    private static final List<Operation> operations = new ArrayList<>();

    public void save(Operation operation) {
        operations.add(operation);
    }

    public List<Operation> findAllByUsername(String username) {
        return operations
                .stream()
                .filter(o -> o.getAuthor().getUsername().equals(username))
                .toList();
    }
}
