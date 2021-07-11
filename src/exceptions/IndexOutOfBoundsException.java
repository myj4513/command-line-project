package exceptions;

public class IndexOutOfBoundsException extends RuntimeException{
    public IndexOutOfBoundsException(){
        super("올바르지 않은 입력입니다.");
    }
}
