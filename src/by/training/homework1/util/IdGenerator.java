package by.training.homework1.util;

public class IdGenerator {
    private static int id;

    private IdGenerator() {
    }

    public static int generateId(){
        return ++id;
    }
}
