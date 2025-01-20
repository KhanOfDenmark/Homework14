package org.skypro.skyshop.exceptions;

public class BestResultNotFound extends NullPointerException{
    public BestResultNotFound() { super(); }
    public BestResultNotFound(Object message) { super(message.toString()); }
}
