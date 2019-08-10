package com.example.workshopmanager.controller;

import com.example.workshopmanager.model.Owner;
import com.example.workshopmanager.repository.OwnerRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Route("addClient")
public class OwnerAdder extends VerticalLayout {

    private Owner owner;

    @Autowired
    public OwnerAdder(OwnerRepository ownerRepository) {

        String emailPattern = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
        String zipCodePattern = "\\d{2}-\\d{3}";
        String errorMessage = "Użytkownik nie został utworzony. Wypełnij wymagane pola.";

        TextField clientName = new TextField();
        clientName.setAutofocus(true);
        clientName.setLabel("Imię: ");
        clientName.setRequired(true);
        clientName.setWidth("300px");
        clientName.getStyle().set("bottom", "50px");

        TextField clientSurname = new TextField();
        clientSurname.setLabel("Nazwisko: ");
        clientSurname.setRequired(true);
        clientSurname.setWidth("300px");

        TextField clientAdressStreet = new TextField();
        clientAdressStreet.setLabel("Ulica: ");
        clientAdressStreet.setWidth("300px");

        TextField clientAdressCity = new TextField();
        clientAdressCity.setLabel("Miasto: ");
        clientAdressCity.setWidth("300px");

        TextField clientAdressZipCode = new TextField();
        clientAdressZipCode.setLabel("Kod pocztowy: ");
        clientAdressZipCode.setWidth("300px");
        clientAdressZipCode.setPattern(zipCodePattern);

        TextField clientPhoneNumber = new TextField();
        clientPhoneNumber.setLabel("Nr tel: ");
        clientPhoneNumber.setRequired(true);
        clientPhoneNumber.setWidth("300px");

        TextField clientEmail = new TextField();
        clientEmail.setLabel("E-mail: ");
        clientEmail.setPattern(emailPattern);
        clientEmail.setWidth("300px");

        Checkbox isClientACompany = new Checkbox();
        isClientACompany.setLabel("Czy klient jest firmą");

        TextField clientNIPNumber = new TextField();
        clientNIPNumber.setLabel("NIP: ");
        clientNIPNumber.setReadOnly(true);
        clientNIPNumber.setWidth("300px");

        isClientACompany.addClickListener(event -> {
            if (!isClientACompany.getValue()) {
                clientNIPNumber.setReadOnly(true);
            } else {
                clientNIPNumber.setReadOnly(false);
            }
        });

        Button submitButton = new Button("Dodaj klienta", event -> {

            if (!clientName.getValue().isEmpty() && !clientSurname.getValue().isEmpty() && !clientPhoneNumber.getValue().isEmpty()){
//                     && clientAdressZipCode.getValue().matches(zipCodePattern)
//                    && clientEmail.getValue().matches(emailPattern)) {
                Owner owner = new Owner().builder()
                        .ownerName(clientName.getValue())
                        .ownerSurname(clientSurname.getValue())
                        .ownerAdressStreet(clientAdressStreet.getValue())
                        .ownerAdressCity(clientAdressCity.getValue())
                        .ownerAdressZipCode(clientAdressZipCode.getValue())
                        .ownerPhoneNumber(clientPhoneNumber.getValue())
                        .ownerEmail(clientEmail.getValue())
                        .isOwnerACompany(isClientACompany.getValue())
                        .ownerNIPNumber(clientNIPNumber.getValue())
                        .cars(new ArrayList<>())
                        .build();
                ownerRepository.save(owner);
                clientName.setValue("");
                clientSurname.setValue("");
                clientAdressStreet.setValue("");
                clientAdressCity.setValue("");
                clientAdressZipCode.setValue("");
                clientEmail.setValue("");
                clientPhoneNumber.setValue("");
                isClientACompany.setValue(false);
                clientNIPNumber.setValue("");

                Label content = new Label("Użytkownik " + owner.getOwnerName() + " " + owner.getOwnerSurname() +
                            " " + "został dodany do bazy");
                Notification notification = new Notification(content);
                    notification.setDuration(3000);
                    notification.setPosition(Notification.Position.MIDDLE);
                    notification.getElement().attachShadow();
                    notification.open();

//                if (owner != null) {
//                    Label content = new Label("Użytkownik " + owner.getOwnerName() + " " + owner.getOwnerSurname() +
//                            " " + "został dodany do bazy");
//                    Notification notification = new Notification(content);
//                    notification.setDuration(3000);
//                    notification.setPosition(Notification.Position.MIDDLE);
//                    notification.getElement().attachShadow();
//                    notification.open();
//                } else {
//                    Label content = new Label(errorMessage);
//                    Notification notification = new Notification(content);
//                    notification.setDuration(3000);
//                    notification.setPosition(Notification.Position.MIDDLE);
//                    notification.getElement().attachShadow();
//                    notification.open();
//                }
            } else {
                Notification saveErrorNotification = new Notification(errorMessage, 3000,
                        Notification.Position.MIDDLE);
                    saveErrorNotification.getElement().attachShadow();
                    saveErrorNotification.open();
//                Label content = new Label(errorMessage);
//                    Notification notification = new Notification(content);
//                    notification.setDuration(3000);
//                    notification.setPosition(Notification.Position.MIDDLE);
            }
        });


        add(clientName, clientSurname, clientAdressStreet, clientAdressCity, clientAdressZipCode, clientPhoneNumber,
                clientEmail, isClientACompany, clientNIPNumber, submitButton);
    }

}
