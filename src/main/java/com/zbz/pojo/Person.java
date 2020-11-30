package com.zbz.pojo;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DayDV;

import java.util.Date;

public class Person {

    private Long uid;
    private String name;
    private Date birthday;

    public void speak(String something) {
        System.out.println(this.name + "say:" + something);
    }
}
