package exceptions;

public class WrongPasswordException extends Exception{
    public WrongPasswordException(){
        super("올바르지 않은 비밀번호입니다.");
    }
}
