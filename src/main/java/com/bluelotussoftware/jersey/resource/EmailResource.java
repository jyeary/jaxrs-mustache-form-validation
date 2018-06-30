package com.bluelotussoftware.jersey.resource;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0.0
 */
@Path("/email")
public class EmailResource {

    /**
     * Holds a reference to the provided email address.
     */
    private String email;

    /**
     * Default view.
     *
     * @return a {@code Map} containing the values to set in the Mustache
     * template.
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Template(name = "/form")
    public Map<String, Object> form() {
        return Collections.singletonMap("title", "Email Check");
    }

    /**
     * The REST method which handles the {@literal POST} which includes the
     * email address to validate.
     *
     * @param email The email address to validate. This address can not be
     * {@code null}, blank, or empty.
     * @return A 200 OK response and the the success template if the email
     * address is valid, otherwise it will return a failure template.
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    @Template(name = "/success")
    @ErrorTemplate(name = "/fail")
    public Response post(@NotBlank @Email @FormParam("email") String email) {
        setEmail(email);
        Map<String, String> map = new HashMap<>();
        map.put("title", "Success");
        map.put("email", getEmail());
        return Response.ok(map).build();
    }

    /**
     * Getter for email address.
     *
     * @return An email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for email address.
     *
     * @param email An email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
