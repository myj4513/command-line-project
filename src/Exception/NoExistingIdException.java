package Exception;

public class NoExistingIdException extends Exception{
    public NoExistingIdException(){
        super("존재하지 않는 아이디입니다.");
    }
}
