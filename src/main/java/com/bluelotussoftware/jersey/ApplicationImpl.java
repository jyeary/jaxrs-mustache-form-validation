package com.bluelotussoftware.jersey;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.beanvalidation.MvcBeanValidationFeature;
import org.glassfish.jersey.server.mvc.mustache.MustacheMvcFeature;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0.0
 */
@ApplicationPath("ws")
public class ApplicationImpl extends ResourceConfig {

    public ApplicationImpl() {
        // Enable Mustache MVC functionality.
        register(MustacheMvcFeature.class);
        // Set the path to the Mustache templates.
        property(MustacheMvcFeature.TEMPLATE_BASE_PATH, "/templates");

        /*
         * Enable the Bean Validation Functionality for use with the MVC
         * functionality. Otherwise, errors will produce a 400 response and will not use
         * the @ErrorTemplate functionality to display the error messages.
         */
        register(MvcBeanValidationFeature.class);
        packages("com.bluelotussoftware.jersey.resource");
    }

}
