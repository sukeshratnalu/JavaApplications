package com.sb.javaApplication.collectios.realTimeExample;

public class ValidateID {
    static Boolean validateId(String id)throws InvalidIdException{
        if(id == null)
            throw new InvalidIdException("not valid ID");
        else
            return true;
    }
}
