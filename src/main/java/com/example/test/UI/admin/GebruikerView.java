package com.example.test.UI.admin;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "Gebruiker", layout = MainLayout.class)
public class GebruikerView extends VerticalLayout{


    private Button btn1;

    public GebruikerView(){
        H2 header = new H2("Users")      ;
        btn1 = new Button("create new user");
        btn1.addClickListener(e -> UI.getCurrent().navigate(CreateNewUser.class));
        add(header, btn1);
    }

}
