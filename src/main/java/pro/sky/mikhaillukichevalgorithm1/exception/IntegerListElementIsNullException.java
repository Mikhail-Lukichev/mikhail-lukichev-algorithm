package pro.sky.mikhaillukichevalgorithm1.exception;

public class IntegerListElementIsNullException extends RuntimeException{
    public IntegerListElementIsNullException(String message) {
        super(message);
        System.out.println(message);
    }
}
