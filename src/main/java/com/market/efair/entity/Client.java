package com.market.efair.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.cglib.core.Local;

import java.text.DateFormat;
import java.time.LocalDate;

@Entity
@Table(name = "client")
public final class Client extends User{

    private String CPF;
    private String address;
    private LocalDate birthDate;

    public Client() {}

    public Client(String name,
                  String email,
                  String password,
                  String CPF,
                  String address,
                  LocalDate birthDate) {
        super(name, email, password);
        this.CPF = CPF;
        this.address = address;
        this.birthDate = birthDate;
    }

    public String getCPF() {
        return CPF;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    private boolean isLowAge(DateFormat birthDate){


        return false;

    }
}
