package com.mycloud.resttemplatedemo.model;/*
 *
 * @author Lawshiga
 *
 */

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String firstName;

    public String lastName;

    public String email;

    public UserData() {
    }

    public UserData(String s1, String s2, String s) {
        this.firstName = s1;
        this.lastName = s2;
        this.email = s;
    }
}
