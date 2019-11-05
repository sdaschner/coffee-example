package com.sebastian_daschner.coffee_shop;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class CoffeeShopApplication extends Application {

    // nothing to configure

}

@Readiness
@ApplicationScoped
class Health implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("coffee-shop")
                .up()
                .build();
    }

}
