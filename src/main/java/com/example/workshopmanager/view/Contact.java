package com.example.workshopmanager.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("contact")
@StyleSheet("/background.css")
public class Contact extends VerticalLayout {

    @Autowired
    public Contact() {

        VerticalLayout contacLayout = new VerticalLayout();
        Label data1 = new Label("Dane kontaktowe:");
        data1.getStyle().set("font-size", "4vw");
        Label data2 = new Label("U Przema - mechanik");
        data2.getStyle().set("font-size", "4vw");
        Label data3 = new Label("ulica Jabłoniowa 45");
        data3.getStyle().set("font-size", "4vw");
        Label data4 = new Label("Gdańsk 80-175");
        data4.getStyle().set("font-size", "4vw");
        Label data5 = new Label("telefon: 708-477-170");
        data5.getStyle().set("font-size", "4vw");
        Label gap = new Label();
        gap.setHeight("2vw");

        contacLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        contacLayout.setDefaultHorizontalComponentAlignment(
                FlexComponent.Alignment.CENTER);

        contacLayout.add(data1, data2, data3, data4, data5, gap);
        contacLayout.setWidth("100%");
        contacLayout.setHeight("70%");


        Button returnToMain = new Button("Do strony głównej", new Icon(VaadinIcon.ARROW_LEFT));
        returnToMain.getStyle().set("font-size", "2vw");
        returnToMain.addClickListener(event -> {
            UI.getCurrent().navigate("");
        });

        add(contacLayout, returnToMain);

    }

}
