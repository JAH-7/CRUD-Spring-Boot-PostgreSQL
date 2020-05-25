package pe.creativity.Restfull.controller;


import org.apache.coyote.Constants;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import pe.creativity.Restfull.util.ConstantsUtil;

import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Component
@Path("/hello")
public class WelcomeRestController {
    /*
     En los backends típicos que sirven como API para las interfaces,
     la respuesta se compone de dos partes: el código de estado HTTP
     y los encabezados de respuesta, si los hay, y el valor pasado en
     forma de formatos JSON o XML. Los datos de salida se obtienen con
     la ayuda de a Serializer, destinados a ese servicio específico
     */
    @GET
    @Path("/welcome")
    @Produces("text/plain")
    public String Welcome() {
        return "<h1>HOLA</h1>";
    }

    @GET
    @Path("/response")
    public Response getName() {
        return Response.status(201, "Mi nombre es Hansel").build();
    }


}
