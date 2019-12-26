package com.fmall.enums;

public enum OKNO {
    OK(1, "是"),
    NO(0, "否");

    public final Integer type;
    public final String value;

    OKNO(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
