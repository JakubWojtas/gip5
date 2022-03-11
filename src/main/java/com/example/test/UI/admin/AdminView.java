package com.example.test.UI.admin;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("inventory management")
@Route(value = "admin", layout = MainLayout.class)
public class AdminView extends AppLayout {


    public AdminView(){

    }
}
