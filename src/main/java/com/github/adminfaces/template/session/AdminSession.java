package com.github.adminfaces.template.session;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by rmpestano on 04/02/17
 * Controls if user is logged in so AdminFilter can send user to login page when it is not logged in.
 *
 * By default it is always logged in so to have this feature one must @Specializes this bean and put
 * the security logic in IsLoggedIn method.
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AdminSession implements Serializable {

    private boolean isLoggedIn = true;

    //avoid multiple redirects when redirecting user back to previous page after session expiration
    private boolean userRedirected = false;

    public boolean isLoggedIn(){
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public boolean isUserRedirected() {
        return userRedirected;
    }

    public void setUserRedirected(boolean userRedirected) {
        this.userRedirected = userRedirected;
    }
}
