package com.example.test.UI;

import com.example.test.UI.admin.AdminView;
import com.example.test.UI.user.UserView;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.Route;

@Route("")
public class LoginView extends Composite<LoginOverlay> {
    public LoginView() {
       LoginOverlay loginOverlay = getContent();
       loginOverlay.setTitle("Inventory");
       loginOverlay.setDescription("");
       loginOverlay.setOpened(true);

       loginOverlay.addLoginListener(event ->{
           if("user".equals((event.getUsername()))){
               UI.getCurrent().navigate(UserView.class);
           } else if ("admin".equals(event.getUsername())){
               UI.getCurrent().navigate(AdminView.class);
           }
       });
    }
}
