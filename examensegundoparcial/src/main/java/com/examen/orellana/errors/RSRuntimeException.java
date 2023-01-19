package com.examen.orellana.errors;

import com.examen.orellana.utils.RSCode;

public class RSRuntimeException extends RuntimeException{
    private RSCode code; 

    public RSRuntimeException(String arg0, RSCode code){
        super(arg0);
        this.code = code;
    }

    public int getCode(){
        return this.code.code;
    }
}
