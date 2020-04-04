package org.java.Exception;

import org.java.enums.HospitalEnum;

public class HospitalException_variable extends RuntimeException {

    private HospitalEnum shoppingEnum;//枚举类型的属性

    public HospitalEnum getShoppingEnum() {
        return shoppingEnum;
    }

    public void setShoppingEnum(HospitalEnum shoppingEnum) {
        this.shoppingEnum = shoppingEnum;
    }

    public HospitalException_variable(HospitalEnum shoppingEnum) {
        this.shoppingEnum = shoppingEnum;
    }
}
