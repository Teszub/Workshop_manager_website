package com.example.workshopmanager.controller;

import com.example.workshopmanager.model.Price;
import com.example.workshopmanager.model.PriceCategory;
import com.example.workshopmanager.repository.PriceRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;

@Route("prices-add")
@StyleSheet("/background.css")
public class PricesAdder extends VerticalLayout {

    @Autowired
    public PricesAdder(PriceRepository priceRepository) {

        TextField textFieldServiceName = new TextField("Nazwa usługi:");
        NumberField numberFieldPrice = new NumberField("Cena:");

        ComboBox<PriceCategory> comboBox = new ComboBox<>("Nazwa kategorii wyświetlenia:");
        comboBox.setItems(PriceCategory.values());

        Button saveButton = new Button("Zapisz nową usługę", new Icon(VaadinIcon.SCREWDRIVER));
        Button returnToMain = new Button("Do strony głównej", new Icon(VaadinIcon.ARROW_LEFT));

        returnToMain.addClickListener(event -> {
            UI.getCurrent().navigate("");
        });

        saveButton.addClickListener(clickEvent -> {
            Price price = new Price();
            price.setPrice(numberFieldPrice.getValue());
            price.setServiceName(textFieldServiceName.getValue());
            price.setPriceCategory(comboBox.getValue());
            priceRepository.save(price);

            Label content = new Label(
                    "You added new item to db");
            Notification notification = new Notification(content);
            notification.setDuration(500);
            notification.setPosition(Notification.Position.MIDDLE);
            notification.open();

        });

        Grid<Price> allPriceDBGrid = new Grid<>(Price.class);
        allPriceDBGrid.removeColumnByKey("id");
        allPriceDBGrid.removeColumnByKey("price");
        allPriceDBGrid.removeColumnByKey("serviceName");
        allPriceDBGrid.removeColumnByKey("priceCategory");
        allPriceDBGrid.addColumn(Price::getId).setHeader("Numer porządkowy: ")
                .setFlexGrow(0)
                .setWidth("100px")
                .setResizable(false);
        allPriceDBGrid.addColumn(Price::getServiceName).setHeader("Nazwa usługi: ");
        allPriceDBGrid.addColumn(Price::getPrice).setHeader("Cena:");
        allPriceDBGrid.addColumn(Price::getPriceCategory).setHeader("Nazwa kategorii wyświetlenia:");
        allPriceDBGrid.addColumn(TemplateRenderer.<Price>of(
                "<button on-click='buttonRemove'>Usuń</button><button on-click='handleUpdate'>Edycja ceny</button>")
                .withEventHandler("buttonRemove", price -> {
                    ListDataProvider<Price> dataProvider = (ListDataProvider<Price>) allPriceDBGrid
                            .getDataProvider();
                    priceRepository.delete(price);
                    dataProvider.refreshAll();

                })
                .withEventHandler("handleUpdate", price -> {
                    Dialog dialog = new Dialog();
                    NumberField priceChange = new NumberField("Zmień cenę:");
                    NativeButton saveChanges = new NativeButton("Zapisz zmiany");
                    dialog.add(priceChange, saveChanges);
                    dialog.open();
                    saveChanges.addClickListener(event -> {
                                price.setPrice(priceChange.getValue());
                                priceRepository.save(price);
                                dialog.close();
                            }
                    );
                })
        ).setHeader("Opcje:");

        /*
         *
         * https://vaadin.com/docs/v13/flow/components/tutorial-flow-grid.html
         *
         */

        allPriceDBGrid.setHeightByRows(true);

        allPriceDBGrid.setItems(priceRepository.findAll());
        add(allPriceDBGrid);

        add(textFieldServiceName, numberFieldPrice, comboBox, saveButton, allPriceDBGrid, returnToMain);

    }

}

