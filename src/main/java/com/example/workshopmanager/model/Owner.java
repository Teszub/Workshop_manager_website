package com.example.workshopmanager.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
@Entity(name = "owners")
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ownerName;
    private String ownerSurname;
    private String ownerAdressStreet;
    private String ownerAdressCity;
    private String ownerAdressZipCode;
    private String ownerPhoneNumber;
    private String ownerEmail;
    private boolean isOwnerACompany;
    private String ownerNIPNumber;
    @OneToMany(mappedBy = "owner")
    private List<Car> cars;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }

    public String getOwnerAdressStreet() {
        return ownerAdressStreet;
    }

    public void setOwnerAdressStreet(String ownerAdressStreet) {
        this.ownerAdressStreet = ownerAdressStreet;
    }

    public String getOwnerAdressCity() {
        return ownerAdressCity;
    }

    public void setOwnerAdressCity(String ownerAdressCity) {
        this.ownerAdressCity = ownerAdressCity;
    }

    public String getOwnerAdressZipCode() {
        return ownerAdressZipCode;
    }

    public void setOwnerAdressZipCode(String ownerAdressZipCode) {
        this.ownerAdressZipCode = ownerAdressZipCode;
    }

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public boolean isOwnerACompany() {
        return isOwnerACompany;
    }

    public void setOwnerACompany(boolean ownerACompany) {
        isOwnerACompany = ownerACompany;
    }

    public String getOwnerNIPNumber() {
        return ownerNIPNumber;
    }

    public void setOwnerNIPNumber(String ownerNIPNumber) {
        this.ownerNIPNumber = ownerNIPNumber;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerName='" + ownerName + '\'' +
                ", ownerSurname='" + ownerSurname + '\'' +
                ", ownerAdressStreet='" + ownerAdressStreet + '\'' +
                ", ownerAdressCity='" + ownerAdressCity + '\'' +
                ", ownerAdressZipCode='" + ownerAdressZipCode + '\'' +
                ", ownerPhoneNumber='" + ownerPhoneNumber + '\'' +
                ", ownerEmail='" + ownerEmail + '\'' +
                ", ownerNIPNumber='" + ownerNIPNumber + '\'' +
                '}';


    }
}
