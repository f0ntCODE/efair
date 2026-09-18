package com.market.efair.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.market.efair.exception.LowAgeException;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public final class Client extends User{

    private String CPF;
    private String address;
    private LocalDate birthDate;
    
    @OneToMany(mappedBy = "clientId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

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

        if(isLowAge(birthDate)){
            throw new LowAgeException("Client must be at least 18 years old.");
        }

        this.birthDate = birthDate;
    }

    private boolean isLowAge(LocalDate birthDate){
        
        LocalDate currentDate = LocalDate.now();
        LocalDate lowAgeDate = currentDate.minusYears(18);
        
        if(birthDate.isAfter(lowAgeDate)){return true;}

        int monthsDifference = currentDate.getMonthValue() - birthDate.getMonthValue();
        
        if(monthsDifference < 0){ 

            return true;

        }
        
        else if(currentDate.getDayOfMonth() < birthDate.getDayOfMonth() && monthsDifference == 0){
            
            return true;
        
        }

        return false;

    }

    //helper methods
    public void addOrder(Order order){
        this.orders.add(order);
    }

    public void removeOrder(Order order){
        this.orders.remove(order);
    }

}
