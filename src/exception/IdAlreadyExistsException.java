package Exception;

public class IdAlreadyExistsException extends Exception{
    public IdAlreadyExistsException(){
        super("이미 존재하는 아이디입니다.");
    }
}
