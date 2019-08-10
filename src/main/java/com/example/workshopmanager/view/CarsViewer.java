package com.example.workshopmanager.view;

import com.example.workshopmanager.controller.CarAdd;
import com.example.workshopmanager.model.Car;
import com.example.workshopmanager.model.CarType;
import com.example.workshopmanager.model.EngineType;
import com.example.workshopmanager.repository.CarRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.contextmenu.GridContextMenu;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("allCars")
public class CarsViewer extends VerticalLayout {

    private CarAdd carAdd;

    @Autowired
    public CarsViewer(CarRepository carRepository) {
        Grid<Car> grid = new Grid<>(Car.class);

        grid.getColumnByKey("plate");
        grid.addColumn(Car::getCarBrand).setHeader("Marka");
        grid.addColumn(Car::getCarModel).setHeader("Model");
        grid.addColumn(Car::getCarType).setHeader("Rodzaj");
        grid.addColumn(Car::getPlate).setHeader("Nr rej.");
        grid.addColumn(Car::getProductionDate).setHeader("Data produkcji");
        grid.addColumn(Car::getVinNumber).setHeader("Nr VIN");
        grid.addColumn(Car::getEngineCapacity).setHeader("Pojemność silnika");
        grid.addColumn(Car::getMaxPowerInKW).setHeader("Moc (kW)");
        grid.addColumn(Car::getEngineType).setHeader("Rodzaj paliwa");
        grid.setItems(carRepository.findAll());

        GridContextMenu<Car> contextMenu = new GridContextMenu<>(grid);
        contextMenu.addItem("Edytuj", event -> {
            event.getItem().ifPresent(car -> {
                Dialog editWindow = new Dialog();
                editWindow.setWidth("800px");
                editWindow.setCloseOnEsc(true);
                editWindow.setCloseOnOutsideClick(false);

                FormLayout editForm = new FormLayout();

                TextField carPlateField = new TextField();
                carPlateField.setLabel("Nr rejestracyjny");
                carPlateField.setRequired(true);
                carPlateField.setAutofocus(true);
                carPlateField.setValue(car.getPlate());

                TextField carBrandField = new TextField();
                carBrandField.setLabel("Marka");
                carBrandField.setRequired(true);
                carBrandField.setValue(car.getCarBrand());

                TextField carModelField = new TextField();
                carModelField.setLabel("Model");
                carModelField.setRequired(true);
                carModelField.setValue(car.getCarModel());

                ComboBox<CarType> carTypeField = new ComboBox<CarType>();
                carTypeField.setLabel("Model");
                carTypeField.setItems(CarType.values());
                carTypeField.setRequired(true);
                carTypeField.setValue(car.getCarType());

                TextField carBuildYear = new TextField();
                carBuildYear.setLabel("Rok produkcji");
                carBuildYear.setPattern("\\d{4}");
                carBuildYear.setValue(car.getProductionDate());

                TextField carVinNumberField = new TextField();
                carVinNumberField.setLabel("VIN");
                carVinNumberField.setPattern("[A-HJ-NPR-Z0-9]{17}");
                carVinNumberField.setValue(car.getVinNumber());

                TextField carEngineCapacityField = new TextField();
                carEngineCapacityField.setLabel("Poj. silnika");
                carEngineCapacityField.setRequired(true);
                carEngineCapacityField.setValue(car.getEngineCapacity());

                TextField carMaxPowerField = new TextField();
                carMaxPowerField.setLabel("Moc silnika (kW)");
                carMaxPowerField.setValue(car.getMaxPowerInKW());

                ComboBox<EngineType> carEngineTypeField = new ComboBox<>();
                carEngineTypeField.setItems(EngineType.values());
                carEngineTypeField.setLabel("Rodzaj silnika");
                carEngineTypeField.setValue(car.getEngineType());

                Label invisibleLabel = new Label();

                Button saveButton = new Button("Zapisz", saveEvent -> {
                    car.setCarBrand(carBrandField.getValue());
                    car.setCarModel(carModelField.getValue());
                    car.setCarType(carTypeField.getValue());
                    car.setPlate(carPlateField.getValue().toUpperCase());
                    car.setProductionDate(carBuildYear.getValue());
                    car.setVinNumber(carVinNumberField.getValue().toUpperCase());
                    car.setEngineCapacity(carEngineCapacityField.getValue());
                    car.setMaxPowerInKW(carMaxPowerField.getValue());
                    car.setEngineType(carEngineTypeField.getValue());

                    carRepository.save(car);
                    grid.setItems(carRepository.findAll());
                    editWindow.close();
                });

                Button cancleButton = new Button("Anuluj", cancleEvent -> {
                    editWindow.close();
                });

                editForm.add(carBrandField, carModelField, carTypeField, carPlateField, carBuildYear, carVinNumberField,
                        carEngineCapacityField, carMaxPowerField, carEngineTypeField, invisibleLabel, saveButton, cancleButton);

                editWindow.add(editForm);
                editWindow.open();
            });
        });

        contextMenu.addItem("Usuń", event -> {
            event.getItem().ifPresent(car -> {
                carRepository.delete(car);
                grid.setItems(carRepository.findAll());
            });
        });

        grid.removeColumnByKey("accetableCarWeight");
        grid.removeColumnByKey("accetableCarSetWeight");
        grid.removeColumnByKey("carOwnWeight");
        grid.removeColumnByKey("firstRegistrationDate");
        grid.removeColumnByKey("owner");
        grid.removeColumnByKey("maxCarWeight");
        grid.removeColumnByKey("dateOfExpiryRegistrationCertificate");
        grid.removeColumnByKey("dateOfIssuingOfRegistrationCertificate");
        grid.removeColumnByKey("vehiceCategory");
        grid.removeColumnByKey("approvalCertificateNumber");
        grid.removeColumnByKey("numberOfAxles");
        grid.removeColumnByKey("maxWeightOfTrailerWithBrakes");
        grid.removeColumnByKey("maxWeightOfTrailerWithoutBrakes");
        grid.removeColumnByKey("numberOfSeats");
        grid.removeColumnByKey("numberOfStandingPlaces");
        grid.removeColumnByKey("dateOfNextDiagnosticInspection");
        grid.removeColumnByKey("plate");
        grid.removeColumnByKey("carBrand");
        grid.removeColumnByKey("carType");
        grid.removeColumnByKey("carModel");
        grid.removeColumnByKey("vinNumber");
        grid.removeColumnByKey("productionDate");
        grid.removeColumnByKey("engineType");
        grid.removeColumnByKey("engineCapacity");
        grid.removeColumnByKey("maxPowerInKW");

        add(grid);
    }

}
