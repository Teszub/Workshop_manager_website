package com.example.workshopmanager.view;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.AppLayoutMenu;
import com.vaadin.flow.component.applayout.AppLayoutMenuItem;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route("")
@StyleSheet("/background.css")
public class Main extends HorizontalLayout {

    public Main() {
        AppLayout appLayout = new AppLayout();

        AppLayoutMenu menu = appLayout.createMenu();
        Image img = new Image("https://i.pinimg.com/originals/72/82/5c/72825cd366980b3ba05c314c9e6e75bb.png", "Car workshop Logo");
        img.setHeight("100px");
        appLayout.setBranding(img);
        Image mainPicture = new Image("/images/helloImage.png", "hello");
        mainPicture.setSizeFull();
        AppLayoutMenuItem login = new AppLayoutMenuItem("Zaloguj/Wyloguj");
        login.addMenuItemClickListener(menuItemClickEvent ->
        {
            UI.getCurrent().getPage().executeJavaScript("window.open(\"/login\", \"_self\");");
        });

        AppLayoutMenuItem registering = new AppLayoutMenuItem("Zarejestruj", "register");
        AppLayoutMenuItem pricesCustomer = new AppLayoutMenuItem("Cennik", "prices");
        AppLayoutMenuItem calendar = new AppLayoutMenuItem("Terminarz", "dates");
        AppLayoutMenuItem contactDetails = new AppLayoutMenuItem("Kontakt", "contact");
        AppLayoutMenuItem editionPrices = new AppLayoutMenuItem("Zarządzaj cenami", "car-add");
        editionPrices.setVisible(false);
        contactDetails.addMenuItemClickListener(ClickEvent -> {
            contactDetails.getUI().ifPresent(ui -> ui.navigate("/contact"));
        });

        pricesCustomer.addMenuItemClickListener(ClickEvent -> {
            pricesCustomer.getUI().ifPresent(ui -> ui.navigate("/prices"));
        });

        menu.addMenuItems(
                pricesCustomer,
                calendar,
                contactDetails,
                editionPrices,
                login,
                registering);

//        VerticalLayout informationLayout = new VerticalLayout();
//        Label companyName = new Label("U Przema - mechanik");
//        companyName.getStyle().set("font-size", "3vw");
//
//        Label firstLine = new Label("Jesteśmy warsztatem z bardzo dużym doświadczeniem w branży, dokonujemy wszystkich napraw mechanicznych i nie tylko, stawiamy na precyzję i jakość. ");
//
//        Label gap = new Label();
//        gap.setHeight("1vw");
//        Label secondLine = new Label("Nie ważne jaki masz probelm - zadzwoń do nas lub umów wizytę przez naszą stronę internetową a zrobimy wszystko aby sprostać twoim oczekiwaniom.");
//
//        informationLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
//        informationLayout.setDefaultHorizontalComponentAlignment(
//                FlexComponent.Alignment.CENTER);
//
//        informationLayout.add(companyName, firstLine, gap, secondLine, gap);
//        informationLayout.setWidth("100%");

        Component content = new Span(

//                informationLayout,
                mainPicture

        );

        appLayout.setContent(content);

        add(appLayout);
    }
}
