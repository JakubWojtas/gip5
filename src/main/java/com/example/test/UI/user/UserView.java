package com.example.test.UI.user;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route(value = "user", layout = userMainlayout.class)
@PageTitle("inventory management")
public class UserView extends AppLayout  {


    public UserView() {

    }

}
