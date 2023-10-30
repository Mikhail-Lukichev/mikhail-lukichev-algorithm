package pro.sky.mikhaillukichevalgorithm1.exception;

public class StringListIndexOutOfBoundsException extends RuntimeException{
    public StringListIndexOutOfBoundsException(String message) {
        super(message);
        System.out.println(message);
    }
}
