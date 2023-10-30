package pro.sky.mikhaillukichevalgorithm1.exception;

public class StringListElementIsNotFoundException extends RuntimeException{
    public StringListElementIsNotFoundException(String message) {
        super(message);
        System.out.println(message);
    }
}
