package Exception;

public class InvalidValueException extends Exception{
    public InvalidValueException(){
        super("올바르지 않은 입력입니다.");
    }
}
