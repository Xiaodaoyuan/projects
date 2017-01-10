package com.xiaody.application.elasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Created by Xiaody on 2016/12/29.
 */
@Document(indexName = "bank", type = "account")
public class Account {
    @Id
    private String id;
    @Field(type = FieldType.Long)
    private int account_number;
    @Field(type = FieldType.Long)
    private double balance;
    @Field(type = FieldType.String)
    private String firstname;
    @Field(type = FieldType.String)
    private String lastname;
    @Field(type = FieldType.Long)
    private int age;
    @Field(type = FieldType.String)
    private String gender;
    @Field(type = FieldType.String)
    private String address;
    @Field(type = FieldType.String)
    private String employer;
    @Field(type = FieldType.String)
    private String email;
    @Field(type = FieldType.String)
    private String city;
    @Field(type = FieldType.String)
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
