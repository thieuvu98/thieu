package vn.com.webbanhang.exception;

public class InvoiceNotFoundException extends RuntimeException{
    public InvoiceNotFoundException(String message){
        super(message);
    }
}
