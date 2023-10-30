package pro.sky.mikhaillukichevalgorithm1.exception;

public class StringListIllegalArgumentException extends RuntimeException{
    public StringListIllegalArgumentException(String message) {
        super(message);
        System.out.println(message);
    }
}
