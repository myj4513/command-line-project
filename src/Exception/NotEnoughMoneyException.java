package Exception;

public class NotEnoughMoneyException extends Exception{
    public NotEnoughMoneyException(){
        super("잔액이 부족합니다.");
    }
}
