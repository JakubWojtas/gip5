package com.example.test.UI.user;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "userSetting", layout = userMainlayout.class)
public class userSettingView extends VerticalLayout {
    private TextField username;
    private TextField email;
    private TextField firstname;
    private TextField lastname;
    private TextField Tel;
    private HorizontalLayout hl1;
    private HorizontalLayout hl2;
    private HorizontalLayout hl3;
    private HorizontalLayout hl4;
    private Button btnEdit;


    public userSettingView(){
        H2 header = new H2("create new user");
        username = new TextField("username", "username");
        username.setClassName("txtUsername");
        username.setValue("user");
        username.setReadOnly(true);
        email = new TextField("email", "email");
        email.setClassName("txtemail");
        email.setValue("user@gmail.com");
        email.setReadOnly(true);
        hl1 = new HorizontalLayout();
        hl1.add(username, email);
        hl1.setClassName("hl1");
        firstname = new TextField("firstname", "firstname");
        firstname.setClassName("txtFirstname");
        firstname.setValue("Test");
        firstname.setReadOnly(true);
        lastname = new TextField("lastname", "lastname");
        lastname.setClassName("txtLastname");
        lastname.setValue("Test");
        lastname.setReadOnly(true);
        hl2 = new HorizontalLayout();
        hl2.add(firstname,lastname);
        hl2.setClassName("hl2");
        Tel = new TextField("Tel", "Tel");
        Tel.setMaxLength(16);
        Tel.setClassName("txtTel");
        Tel.setValue("+32 123 12 12 12");
        Tel.setReadOnly(true);
        hl3 = new HorizontalLayout();
        hl3.add(Tel);
        hl3.setClassName("hl3");
        btnEdit = new Button("edit");
        btnEdit.setClassName("btnCreate");
        hl4 = new HorizontalLayout();
        hl4.add(btnEdit);
        hl4.setClassName("hl4");
        add(header, hl1 , hl2, hl3, hl4);
    }
}
