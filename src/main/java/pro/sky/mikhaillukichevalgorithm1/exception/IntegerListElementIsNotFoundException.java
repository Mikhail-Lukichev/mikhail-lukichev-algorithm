package pro.sky.mikhaillukichevalgorithm1.exception;

public class IntegerListElementIsNotFoundException extends RuntimeException{
    public IntegerListElementIsNotFoundException(String message) {
        super(message);
        System.out.println(message);
    }
}