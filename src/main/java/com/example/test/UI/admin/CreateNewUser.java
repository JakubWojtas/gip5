package com.example.test.UI.admin;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@CssImport("./styles/CreateNewUserStyle.css")
@Route(value = "newuser", layout = MainLayout.class)
public class CreateNewUser extends VerticalLayout {

    private TextField username;
    private TextField email;
    private TextField firstname;
    private TextField lastname;
    private TextField Tel;
    private HorizontalLayout hl1;
    private HorizontalLayout hl2;
    private HorizontalLayout hl3;
    private HorizontalLayout hl4;
    private Button btnCreate;
    private Button btnCancel;
    public CreateNewUser(){
        H2 header = new H2("create new user");
        username = new TextField("username", "username");
        username.setClassName("txtUsername");
        email = new TextField("email", "email");
        email.setClassName("txtemail");
        hl1 = new HorizontalLayout();
        hl1.add(username, email);
        hl1.setClassName("hl1");
        firstname = new TextField("firstname", "firstname");
        firstname.setClassName("txtFirstname");
        lastname = new TextField("lastname", "lastname");
        lastname.setClassName("txtLastname");
        hl2 = new HorizontalLayout();
        hl2.add(firstname,lastname);
        hl2.setClassName("hl2");
        Tel = new TextField("Tel", "Tel");
        Tel.setMaxLength(10);
        Tel.setClassName("txtTel");
        hl3 = new HorizontalLayout();
        hl3.add(Tel);
        hl3.setClassName("hl3");
        btnCreate = new Button("create");
        btnCreate.setClassName("btnCreate");
        btnCancel= new Button ("cancel");
        btnCancel.setClassName("btnCancel");
        btnCancel.addClickListener(e -> UI.getCurrent().navigate(GebruikerView.class));
        hl4 = new HorizontalLayout();
        hl4.add(btnCreate,btnCancel);
        hl4.setClassName("hl4");
        add(header, hl1 , hl2, hl3, hl4);
    }
}
