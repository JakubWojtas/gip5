package com.example.test.UI.user;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "userStock", layout = userMainlayout.class)
public class userStockView extends VerticalLayout {

    public userStockView(){
        H2 header = new H2("Inventory");

        add(header);
    }
}
