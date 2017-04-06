package com.lisl.pay.app.model.three;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
@ToString
@Getter
@Setter
public class PersonThree {
    @Id
    @Column(unique = true, nullable = false)
    private String id;

    private String sex;

    private Integer age;

    private String name;
}