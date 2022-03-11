package com.example.test.UI.user;

import com.example.test.UI.LoginView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;


public class userMainlayout extends AppLayout {
    public userMainlayout(){
        createHeader();
        createDrawer();
    }

    private void createHeader(){

        H1 logo = new H1("Inventory management");
        logo.addClassName("logo");
        Button btnLogout = new Button("log out");
        btnLogout.addClickListener(e -> UI.getCurrent().navigate(LoginView.class));

        DrawerToggle draw = new DrawerToggle();
        draw.addClassName("drawer");
        HorizontalLayout header = new HorizontalLayout(draw, logo, btnLogout);
        header.addClassName("header");
        header.setWidth("100%");
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        addToNavbar(header);

    }

    private void createDrawer(){
        RouterLink listLink1 = new RouterLink("Stock", userStockView.class);
        RouterLink listLink2 = new RouterLink("Setting", userSettingView.class);
        listLink1.setHighlightCondition(HighlightConditions.sameLocation());
        listLink2.setHighlightCondition(HighlightConditions.sameLocation());

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setClassName("verticalLayout");
        verticalLayout.add(listLink1,listLink2);
        addToDrawer(verticalLayout);
    }
}
