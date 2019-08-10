package com.example.workshopmanager.model;



import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name = "cars")
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Car {

    @Id
    private String plate;
    private Date firstRegistrationDate;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    private String carBrand;
    private CarType carType;
    private String carModel;
    private String vinNumber;
    private String productionDate;
    private EngineType engineType;
    private int maxCarWeight;
    private int accetableCarWeight;
    private int accetableCarSetWeight;
    private int carOwnWeight;
    private String dateOfExpiryRegistrationCertificate;
    private String dateOfIssuingOfRegistrationCertificate;
    private String vehiceCategory;
    private String approvalCertificateNumber;
    private int numberOfAxles;
    private int maxWeightOfTrailerWithBrakes;
    private int maxWeightOfTrailerWithoutBrakes;
    private String engineCapacity;
    private String maxPowerInKW;
    private int numberOfSeats;
    private int numberOfStandingPlaces;
    private String dateOfNextDiagnosticInspection;

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Date getFirstRegistrationDate() {
        return firstRegistrationDate;
    }

    public void setFirstRegistrationDate(Date firstRegistrationDate) {
        this.firstRegistrationDate = firstRegistrationDate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }



    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public int getMaxCarWeight() {
        return maxCarWeight;
    }

    public void setMaxCarWeight(int maxCarWeight) {
        this.maxCarWeight = maxCarWeight;
    }

    public int getAccetableCarWeight() {
        return accetableCarWeight;
    }

    public void setAccetableCarWeight(int accetableCarWeight) {
        this.accetableCarWeight = accetableCarWeight;
    }

    public int getAccetableCarSetWeight() {
        return accetableCarSetWeight;
    }

    public void setAccetableCarSetWeight(int accetableCarSetWeight) {
        this.accetableCarSetWeight = accetableCarSetWeight;
    }

    public int getCarOwnWeight() {
        return carOwnWeight;
    }

    public void setCarOwnWeight(int carOwnWeight) {
        this.carOwnWeight = carOwnWeight;
    }

    public String getDateOfExpiryRegistrationCertificate() {
        return dateOfExpiryRegistrationCertificate;
    }

    public void setDateOfExpiryRegistrationCertificate(String dateOfExpiryRegistrationCertificate) {
        this.dateOfExpiryRegistrationCertificate = dateOfExpiryRegistrationCertificate;
    }

    public String getDateOfIssuingOfRegistrationCertificate() {
        return dateOfIssuingOfRegistrationCertificate;
    }

    public void setDateOfIssuingOfRegistrationCertificate(String dateOfIssuingOfRegistrationCertificate) {
        this.dateOfIssuingOfRegistrationCertificate = dateOfIssuingOfRegistrationCertificate;
    }

    public String getVehiceCategory() {
        return vehiceCategory;
    }

    public void setVehiceCategory(String vehiceCategory) {
        this.vehiceCategory = vehiceCategory;
    }

    public String getApprovalCertificateNumber() {
        return approvalCertificateNumber;
    }

    public void setApprovalCertificateNumber(String approvalCertificateNumber) {
        this.approvalCertificateNumber = approvalCertificateNumber;
    }

    public int getNumberOfAxles() {
        return numberOfAxles;
    }

    public void setNumberOfAxles(int numberOfAxles) {
        this.numberOfAxles = numberOfAxles;
    }

    public int getMaxWeightOfTrailerWithBrakes() {
        return maxWeightOfTrailerWithBrakes;
    }

    public void setMaxWeightOfTrailerWithBrakes(int maxWeightOfTrailerWithBrakes) {
        this.maxWeightOfTrailerWithBrakes = maxWeightOfTrailerWithBrakes;
    }

    public int getMaxWeightOfTrailerWithoutBrakes() {
        return maxWeightOfTrailerWithoutBrakes;
    }

    public void setMaxWeightOfTrailerWithoutBrakes(int maxWeightOfTrailerWithoutBrakes) {
        this.maxWeightOfTrailerWithoutBrakes = maxWeightOfTrailerWithoutBrakes;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getMaxPowerInKW() {
        return maxPowerInKW;
    }

    public void setMaxPowerInKW(String maxPowerInKW) {
        this.maxPowerInKW = maxPowerInKW;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfStandingPlaces() {
        return numberOfStandingPlaces;
    }

    public void setNumberOfStandingPlaces(int numberOfStandingPlaces) {
        this.numberOfStandingPlaces = numberOfStandingPlaces;
    }

    public String getDateOfNextDiagnosticInspection() {
        return dateOfNextDiagnosticInspection;
    }

    public void setDateOfNextDiagnosticInspection(String dateOfNextDiagnosticInspection) {
        this.dateOfNextDiagnosticInspection = dateOfNextDiagnosticInspection;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}
