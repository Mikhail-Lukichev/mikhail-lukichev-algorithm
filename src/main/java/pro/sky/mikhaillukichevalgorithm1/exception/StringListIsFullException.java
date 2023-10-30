package pro.sky.mikhaillukichevalgorithm1.exception;

public class StringListIsFullException extends RuntimeException{
    public StringListIsFullException(String message) {
        super(message);
        System.out.println(message);
    }
}
