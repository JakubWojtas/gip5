package com.example.test.UI.admin;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "Analytics", layout = MainLayout.class)
public class AnalyticsView extends VerticalLayout {
    public AnalyticsView(){
        H2 header = new H2("analyse");
        add(header);
    }
}
