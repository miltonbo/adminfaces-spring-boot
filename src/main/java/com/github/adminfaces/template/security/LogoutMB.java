package com.github.adminfaces.template.security;

import com.github.adminfaces.template.config.AdminConfig;
import com.github.adminfaces.template.util.Constants;
import org.omnifaces.util.Faces;

import javax.faces.context.ExternalContext;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by rmpestano on 03/02/17.
 */
@Component
@Scope("request")
public class LogoutMB {

    @Autowired
    AdminConfig adminConfig;


    public void doLogout() throws IOException {
        String loginPage = adminConfig.getLoginPage();
        if (loginPage == null || "".equals(loginPage)) {
            loginPage = Constants.DEFAULT_LOGIN_PAGE;
        }
        if (!loginPage.startsWith("/")) {
            loginPage = "/" + loginPage;
        }
        Faces.getSession().invalidate();
        ExternalContext ec = Faces.getExternalContext();
        ec.redirect(ec.getRequestContextPath() + loginPage);
    }

}
