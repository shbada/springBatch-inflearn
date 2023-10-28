package com.spring.batch._56_reader_jpaPaging;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Customer2 {

    @Id
    @GeneratedValue
    private Long Id;
    private String username;
    private int age;

    @OneToOne(mappedBy = "customer2")
    private Address address;

}
