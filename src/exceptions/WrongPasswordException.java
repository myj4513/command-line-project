package exceptions;

public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException(){
        super("올바르지 않은 비밀번호입니다.");
    }
}
