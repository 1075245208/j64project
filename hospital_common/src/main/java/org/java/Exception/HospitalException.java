package org.java.Exception;

import org.java.entity.ExceptionResult;
import org.java.enums.HospitalEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class HospitalException {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResult> exception(HospitalException_variable ex){
        HospitalEnum shoppingEnum = ex.getShoppingEnum();
        return ResponseEntity.status(shoppingEnum.getCode()).body(new ExceptionResult(shoppingEnum));
    }
}
