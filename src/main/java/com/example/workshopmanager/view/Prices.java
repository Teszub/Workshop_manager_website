package com.example.workshopmanager.view;

import com.example.workshopmanager.model.Price;
import com.example.workshopmanager.model.PriceCategory;
import com.example.workshopmanager.repository.PriceRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("prices")
@StyleSheet("/background.css")
public class Prices extends VerticalLayout {
    private PriceRepository priceRepository;

    @Autowired
    public Prices(PriceRepository priceRepository) {

        this.priceRepository = priceRepository;

        Accordion accordion = new Accordion();


        Grid<Price> diagnosticsG = new Grid<>(Price.class);
        diagnosticsG.removeColumnByKey("id");
        diagnosticsG.removeColumnByKey("price");
        diagnosticsG.removeColumnByKey("serviceName");
        diagnosticsG.removeColumnByKey("priceCategory");
        diagnosticsG.getStyle().set("font-size", "1vw");
        diagnosticsG.addColumn(Price::getServiceName).setHeader("Nazwa usługi: ");
        diagnosticsG.addColumn(Price::getPrice).setHeader("Cena za usługę w PLN (od): ");
        diagnosticsG.setHeightByRows(true);
        diagnosticsG.setItems(priceRepository.findPriceByPriceCategory(PriceCategory.DIAGNOSTICS));


        Label diagnosticsName = new Label("Diagnostyka pojazdu:");
        diagnosticsName.getStyle().set("font-size", "1vw");


        AccordionPanel accordionPanel1 = new AccordionPanel(diagnosticsName, diagnosticsG);


        Label breakesName = new Label("Naprawa układu hamulcowego:");
        breakesName.getStyle().set("font-size", "1vw");

        Grid<Price> breaksG = new Grid<>(Price.class);
        breaksG.removeColumnByKey("id");
        breaksG.removeColumnByKey("price");
        breaksG.removeColumnByKey("serviceName");
        breaksG.removeColumnByKey("priceCategory");
        breaksG.getStyle().set("font-size", "1vw");
        breaksG.addColumn(Price::getServiceName).setHeader("Nazwa usługi: ");
        breaksG.addColumn(Price::getPrice).setHeader("Cena za usługę w PLN (od): ");
        breaksG.setHeightByRows(true);
        breaksG.setItems(priceRepository.findPriceByPriceCategory(PriceCategory.BREAKES));

        AccordionPanel accordionPanel2 = new AccordionPanel(breakesName, breaksG);

        Label ignitionName = new Label("Naprawa układu zapłonowego:");
        ignitionName.getStyle().set("font-size", "1vw");

        Grid<Price> ignitionG = new Grid<>(Price.class);
        ignitionG.removeColumnByKey("id");
        ignitionG.removeColumnByKey("price");
        ignitionG.removeColumnByKey("serviceName");
        ignitionG.removeColumnByKey("priceCategory");
        ignitionG.getStyle().set("font-size", "1vw");
        ignitionG.addColumn(Price::getServiceName).setHeader("Nazwa usługi: ");
        ignitionG.addColumn(Price::getPrice).setHeader("Cena za usługę w PLN (od): ");
        ignitionG.setHeightByRows(true);
        ignitionG.setItems(priceRepository.findPriceByPriceCategory(PriceCategory.IGNITION));

        AccordionPanel accordionPanel3 = new AccordionPanel(ignitionName, ignitionG);

        Label suspensionName = new Label("Naprawa układu kierowniczego i układu zawieszenia:");
        suspensionName.getStyle().set("font-size", "1vw");

        Grid<Price> suspensionG = new Grid<>(Price.class);
        suspensionG.removeColumnByKey("id");
        suspensionG.removeColumnByKey("price");
        suspensionG.removeColumnByKey("serviceName");
        suspensionG.removeColumnByKey("priceCategory");
        suspensionG.getStyle().set("font-size", "1vw");
        suspensionG.addColumn(Price::getServiceName).setHeader("Nazwa usługi: ");
        suspensionG.addColumn(Price::getPrice).setHeader("Cena za usługę w PLN (od): ");
        suspensionG.setHeightByRows(true);
        suspensionG.setItems(priceRepository.findPriceByPriceCategory(PriceCategory.SUSPENSION));

        AccordionPanel accordionPanel4 = new AccordionPanel(suspensionName, suspensionG);



        Label engineName = new Label("Naprawa układu napędowego i osprzętu silnika:");
        engineName.getStyle().set("font-size", "1vw");

        Grid<Price> engineG = new Grid<>(Price.class);
        engineG.removeColumnByKey("id");
        engineG.removeColumnByKey("price");
        engineG.removeColumnByKey("serviceName");
        engineG.removeColumnByKey("priceCategory");
        engineG.getStyle().set("font-size", "1vw");
        engineG.addColumn(Price::getServiceName).setHeader("Nazwa usługi: ");
        engineG.addColumn(Price::getPrice).setHeader("Cena za usługę w PLN (od): ");
        engineG.setHeightByRows(true);
        engineG.setItems(priceRepository.findPriceByPriceCategory(PriceCategory.ENGINE));

        AccordionPanel accordionPanel5 = new AccordionPanel(engineName, engineG);


        Label vulcanizationName = new Label("Wulkanizacja:");
        vulcanizationName.getStyle().set("font-size", "1vw");

        Grid<Price> vulcanizationG = new Grid<>(Price.class);
        vulcanizationG.removeColumnByKey("id");
        vulcanizationG.removeColumnByKey("price");
        vulcanizationG.removeColumnByKey("serviceName");
        vulcanizationG.removeColumnByKey("priceCategory");
        vulcanizationG.getStyle().set("font-size", "1vw");
        vulcanizationG.addColumn(Price::getServiceName).setHeader("Nazwa usługi: ");
        vulcanizationG.addColumn(Price::getPrice).setHeader("Cena za usługę w PLN (od): ");
        vulcanizationG.setHeightByRows(true);
        vulcanizationG.setItems(priceRepository.findPriceByPriceCategory(PriceCategory.VULCANIZATION));

        AccordionPanel accordionPanel6 = new AccordionPanel(vulcanizationName, vulcanizationG);

        Label otherName = new Label("Pozostałę usługi:");
        otherName.getStyle().set("font-size", "1vw");

        Grid<Price> otherG = new Grid<>(Price.class);
        otherG.removeColumnByKey("id");
        otherG.removeColumnByKey("price");
        otherG.removeColumnByKey("serviceName");
        otherG.removeColumnByKey("priceCategory");
        otherG.getStyle().set("font-size", "1vw");
        otherG.addColumn(Price::getServiceName).setHeader("Nazwa usługi: ");
        otherG.addColumn(Price::getPrice).setHeader("Cena za usługę w PLN (od): ");
        otherG.setHeightByRows(true);
        otherG.setItems(priceRepository.findPriceByPriceCategory(PriceCategory.OTHER));

        AccordionPanel accordionPanel7 = new AccordionPanel(otherName, otherG);

        accordion.setWidthFull();
        accordion.add(accordionPanel1);
        accordion.add(accordionPanel2);
        accordion.add(accordionPanel3);
        accordion.add(accordionPanel4);
        accordion.add(accordionPanel5);
        accordion.add(accordionPanel6);
        accordion.add(accordionPanel7);

        Button returnToMain = new Button("Do strony głównej", new Icon(VaadinIcon.ARROW_LEFT));
        returnToMain.getStyle().set("font-size", "2vw");
        returnToMain.addClickListener(event -> {

            UI.getCurrent().navigate("");
        });


        add(accordion, returnToMain);
    }


}
