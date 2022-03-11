package com.example.test.UI.admin;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "Setting", layout = MainLayout.class)
public class SettingView extends VerticalLayout {

    public SettingView(){
        H2 header = new H2("User details");

        add(header);
    }
}
