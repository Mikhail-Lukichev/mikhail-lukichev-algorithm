package pro.sky.mikhaillukichevalgorithm1.exception;

public class IntegerListIsFullException extends RuntimeException{
    public IntegerListIsFullException(String message) {
        super(message);
        System.out.println(message);
    }
}
