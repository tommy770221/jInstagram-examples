package com.sachinhandiekar.examples.listener;


import com.sachinhandiekar.examples.Constants;
import org.jinstagram.auth.InstagramAuthService;
import org.jinstagram.auth.oauth.InstagramService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DemoAppContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {

        String clientId = "e65d486214ba40db9e9d7cd7f1890187";
        String clientSecret = "cc9d92dcd46f4a3fae22fdf754c46bba";
        String callbackUrl = "http://localhost:8080/IGWebDemo/handleInstagramToken/";


        InstagramService service = new InstagramAuthService()
                .apiKey(clientId)
                .apiSecret(clientSecret)
                .callback(callbackUrl)
                .build();

        sce.getServletContext().setAttribute(Constants.INSTAGRAM_SERVICE, service);



    }

    public void contextDestroyed(ServletContextEvent sce) {

        sce.getServletContext().removeAttribute(Constants.INSTAGRAM_SERVICE);

    }


}