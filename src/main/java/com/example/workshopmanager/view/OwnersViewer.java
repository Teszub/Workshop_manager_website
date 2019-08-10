package com.example.workshopmanager.view;

import com.example.workshopmanager.controller.OwnerAdder;
import com.example.workshopmanager.model.Owner;
import com.example.workshopmanager.repository.OwnerRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.contextmenu.GridContextMenu;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("allOwners")
public class OwnersViewer extends VerticalLayout {

    private OwnerAdder ownerAdder;

    @Autowired
    public OwnersViewer(OwnerRepository ownerRepository) {
        Grid<Owner> grid = new Grid<>(Owner.class);
        grid.getColumnByKey("id").setWidth("30px");
        grid.addColumn(Owner::getOwnerName).setHeader("Imię");
        grid.addColumn(Owner::getOwnerSurname).setHeader("Nazwisko");
        grid.addColumn(Owner::getOwnerAdressStreet).setHeader("Ulica");
        grid.addColumn(Owner::getOwnerAdressCity).setHeader("Miasto");
        grid.addColumn(Owner::getOwnerAdressZipCode).setHeader("Kod pocztowy");
        grid.addColumn(Owner::getOwnerPhoneNumber).setHeader("Telefon");
        grid.addColumn(Owner::getOwnerEmail).setHeader("E-mail");
        grid.addColumn(Owner::getOwnerNIPNumber).setHeader("NIP");
        grid.setItems(ownerRepository.findAll());

        GridContextMenu<Owner> contextMenu = new GridContextMenu<>(grid);
        contextMenu.addItem("Edytuj", event -> {
            event.getItem().ifPresent(owner -> {
                Dialog editWindow = new Dialog();
                editWindow.setWidth("800px");
                editWindow.setCloseOnEsc(true);
                editWindow.setCloseOnOutsideClick(false);

                FormLayout editForm = new FormLayout();

                TextField clientName = new TextField();
                clientName.setAutofocus(true);
                clientName.setLabel("Imię: ");
                clientName.setRequired(true);
                clientName.setSizeUndefined();
                clientName.setValue(owner.getOwnerName());

                TextField clientSurname = new TextField();
                clientSurname.setLabel("Nazwisko: ");
                clientSurname.setRequired(true);
                clientSurname.setValue(owner.getOwnerSurname());
                clientSurname.setWidth("200px");

                TextField clientAdressStreet = new TextField();
                clientAdressStreet.setLabel("Ulica: ");
                clientAdressStreet.setValue(owner.getOwnerAdressStreet());

                TextField clientAdressCity = new TextField();
                clientAdressCity.setLabel("Miasto: ");
                clientAdressCity.setValue(owner.getOwnerAdressCity());

                TextField clientAdressZipCode = new TextField();
                clientAdressZipCode.setLabel("Kod pocztowy: ");
                clientAdressZipCode.setPattern("\\d{2}-\\d{3}");
                clientAdressZipCode.setValue(owner.getOwnerAdressZipCode());

                TextField clientPhoneNumber = new TextField();
                clientPhoneNumber.setLabel("Nr tel: ");
                clientPhoneNumber.setRequired(true);
                clientPhoneNumber.setValue(owner.getOwnerPhoneNumber());

                TextField clientEmail = new TextField();
                clientEmail.setLabel("E-mail: ");
                clientEmail.setPattern("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
                clientEmail.setValue(owner.getOwnerEmail());

                Checkbox isClientACompany = new Checkbox();
                isClientACompany.setLabel("Czy klient jest firmą");
                isClientACompany.setValue(owner.isOwnerACompany());

                TextField clientNIPNumber = new TextField();
                clientNIPNumber.setLabel("NIP: ");
                clientNIPNumber.setReadOnly(true);
                clientNIPNumber.setValue(owner.getOwnerNIPNumber());

                isClientACompany.addClickListener(checkboxClickEvent -> {
                    if (!isClientACompany.getValue()) {
                        clientNIPNumber.setReadOnly(true);
                    } else {
                        clientNIPNumber.setReadOnly(false);
                    }
                });

                Label invisibleLabel = new Label();

                Button saveButton = new Button("Zapisz", saveEvent -> {
                    owner.setOwnerName(clientName.getValue());
                    owner.setOwnerSurname(clientSurname.getValue());
                    owner.setOwnerAdressStreet(clientAdressStreet.getValue());
                    owner.setOwnerAdressCity(clientAdressCity.getValue());
                    owner.setOwnerAdressZipCode(clientAdressZipCode.getValue());
                    owner.setOwnerPhoneNumber(clientPhoneNumber.getValue());
                    owner.setOwnerEmail(clientEmail.getValue());
                    owner.setOwnerACompany(isClientACompany.getValue());
                    owner.setOwnerNIPNumber(clientNIPNumber.getValue());

                    ownerRepository.save(owner);
                    grid.setItems(ownerRepository.findAll());
                    editWindow.close();
                });

                Button cancelEditingButton = new Button("Anuluj", cancelEvent ->{
                    editWindow.close();
                });

                editForm.add(clientName, clientSurname, clientAdressStreet, clientAdressCity, clientAdressZipCode,
                        clientPhoneNumber, clientEmail, isClientACompany, clientNIPNumber, invisibleLabel, saveButton,
                        cancelEditingButton);

                editWindow.add(editForm);
                editWindow.open();
            });

        });

        contextMenu.addItem("Usuń", event -> {
            event.getItem().ifPresent(owner -> {
                ownerRepository.delete(owner);
                grid.setItems(ownerRepository.findAll());
            });
            System.out.println("Owner was removed");
        });

        grid.removeColumnByKey("cars");
        grid.removeColumnByKey("id");
        grid.removeColumnByKey("ownerName");
        grid.removeColumnByKey("ownerSurname");
        grid.removeColumnByKey("ownerAdressStreet");
        grid.removeColumnByKey("ownerAdressCity");
        grid.removeColumnByKey("ownerAdressZipCode");
        grid.removeColumnByKey("ownerPhoneNumber");
        grid.removeColumnByKey("ownerEmail");
        grid.removeColumnByKey("ownerNIPNumber");
        grid.removeColumnByKey("ownerACompany");
        grid.setColumnReorderingAllowed(true);

        TextField searchField = new TextField();
        searchField.setPlaceholder("Znajdź");
//        searchField.addInputListener(event -> {
//            grid.setItems((Owner) ownerRepository.findb);
//        });
        add(searchField, grid);
    }

    //TODO add mouse item focus listener,
    //TODO add search field and method to searching
}
