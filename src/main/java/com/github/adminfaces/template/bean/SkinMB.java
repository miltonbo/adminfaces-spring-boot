package com.github.adminfaces.template.bean;

import com.github.adminfaces.template.config.AdminConfig;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

import static com.github.adminfaces.template.util.Assert.has;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by rmpestano on 07/01/17.
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SkinMB implements Serializable {

    private String skin;

    @Autowired
    private AdminConfig adminConfig;

    @PostConstruct
    public void init() {
        skin = adminConfig.getSkin();
        if(!has(skin)) {
            skin = "skin-blue";
        }
    }


    public void changeSkin(String skin){
        this.skin = skin;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }
}
