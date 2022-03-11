package com.example.test.UI.admin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "Stock", layout = MainLayout.class)
public class StockView extends VerticalLayout {

    public StockView(){
        H2 header = new H2("Inventory");
        Button newItem = new Button("Create New item");

        add(header, newItem);
    }
}
