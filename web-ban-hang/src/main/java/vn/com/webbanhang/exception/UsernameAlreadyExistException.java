package vn.com.webbanhang.exception;

public class UsernameAlreadyExistException extends RuntimeException{
    public UsernameAlreadyExistException(String message){
        super(message);
    }
}
