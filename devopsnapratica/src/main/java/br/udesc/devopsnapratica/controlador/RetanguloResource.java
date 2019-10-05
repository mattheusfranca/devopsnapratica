package br.udesc.devopsnapratica.controlador;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.udesc.devopsnapratica.modelo.Retangulo;

@Path("/retangulo")
public class RetanguloResource {

	@POST
	@Path("/area")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response calcularAreaRetangulo(Retangulo entrada)  {
		return Response.ok(entrada.calcularArea()).build();
	}

	@POST
	@Path("/perimetro")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response calcularPerimetroRetangulo(Retangulo entrada)  {
		return Response.ok(entrada.calcularPerimetro()).build();
	}
	
}

