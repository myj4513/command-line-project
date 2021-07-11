package exceptions;

public class NoExistingIdException extends RuntimeException{
    public NoExistingIdException(){
        super("존재하지 않는 아이디입니다.");
    }
}
