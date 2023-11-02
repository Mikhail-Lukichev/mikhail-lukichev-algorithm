package pro.sky.mikhaillukichevalgorithm1.exception;

public class IntegerListIndexOutOfBoundsException extends RuntimeException{
    public IntegerListIndexOutOfBoundsException(String message) {
        super(message);
        System.out.println(message);
    }
}
