package br.udesc.devopsnapratica.controlador;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.udesc.devopsnapratica.exception.NaoFormaTrianguloException;
import br.udesc.devopsnapratica.modelo.Triangulo;

@Path("/triangulo")
public class TrianguloResource {

	@POST
	@Path("/tipo")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response verificaTriangulo(Triangulo entrada)  {
		Triangulo novoTriangulo;
		try {
			novoTriangulo = new Triangulo(entrada.getLadoA(), entrada.getLadoB(), entrada.getLadoC());
		} catch (NaoFormaTrianguloException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
		return Response.ok(novoTriangulo.getTipoTriangulo()).build();
	}
}
