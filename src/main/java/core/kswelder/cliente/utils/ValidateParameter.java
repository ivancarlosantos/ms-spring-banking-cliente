package core.kswelder.cliente.utils;

import core.kswelder.cliente.exception.RegraNegocioException;

public class ValidateParameter {

    private ValidateParameter(){}

    public static Long validate(String value){
        Long id;
        try{
            id = Long.parseLong(value);
        }catch (NumberFormatException e){
            throw new RegraNegocioException(e.getMessage());
        }
        return id;
    }
}
