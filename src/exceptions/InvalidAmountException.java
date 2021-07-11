package exceptions;

public class InvalidAmountException extends Exception{
    public InvalidAmountException(){
        super("올바르지 않은 금액입니다.");
    }
}
