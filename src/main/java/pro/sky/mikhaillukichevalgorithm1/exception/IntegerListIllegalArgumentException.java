package pro.sky.mikhaillukichevalgorithm1.exception;

public class IntegerListIllegalArgumentException extends RuntimeException{
    public IntegerListIllegalArgumentException(String message) {
        super(message);
        System.out.println(message);
    }
}
