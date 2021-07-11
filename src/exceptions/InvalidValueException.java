package exceptions;

public class InvalidValueException extends RuntimeException{
    public InvalidValueException(){
        super("올바르지 않은 입력입니다.");
    }
}
