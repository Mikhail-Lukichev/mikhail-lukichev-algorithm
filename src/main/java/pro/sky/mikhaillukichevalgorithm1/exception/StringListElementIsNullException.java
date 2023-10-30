package pro.sky.mikhaillukichevalgorithm1.exception;

public class StringListElementIsNullException extends RuntimeException{
    public StringListElementIsNullException(String message) {
        super(message);
        System.out.println(message);
    }
}
