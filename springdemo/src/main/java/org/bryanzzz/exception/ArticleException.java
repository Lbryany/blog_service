package org.bryanzzz.exception;

public class ArticleException extends RuntimeException {

    private static final long serivalVersionUID = 1L;

    public ArticleException(String message){
        super(message);
    }

    public ArticleException(String message, Throwable cause){
        super(message, cause);
    }

}
