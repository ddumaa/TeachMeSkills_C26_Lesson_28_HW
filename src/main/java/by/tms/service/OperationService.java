package by.tms.service;

import by.tms.model.Operation;
import by.tms.model.User;
import by.tms.storage.InMemoryOperationStorage;

import java.util.List;

public class OperationService {

    private final InMemoryOperationStorage storage = new InMemoryOperationStorage();

    public Operation calculate(Operation operation) {
        switch (operation.getType()) {
            case "+":
                operation.setResult(operation.getNum1() + operation.getNum2());
                storage.save(operation);
                return operation;
            case "-":
                operation.setResult(operation.getNum1() - operation.getNum2());
                storage.save(operation);
                return operation;
            case "*":
                operation.setResult(operation.getNum1() * operation.getNum2());
                storage.save(operation);
                return operation;
            case "/":
                operation.setResult(operation.getNum1() / operation.getNum2());
                storage.save(operation);
                return operation;
        }
        throw new IllegalArgumentException();
    }

    public List<Operation> findHistory(User user) {
        return storage.findAllByUsername(user.getUsername());
    }
}