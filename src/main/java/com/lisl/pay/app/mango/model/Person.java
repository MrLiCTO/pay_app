package com.lisl.pay.app.mango.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String id;

    private String sex;

    private Integer age;

    private String name;
}