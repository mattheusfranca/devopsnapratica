package br.udesc.devopsnapratica.controlador;

import java.util.Optional;

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
	public Response verificarTriangulo(Triangulo entradaDTO)  {
		Optional<Triangulo> novoTriangulo = criarTriangulo(entradaDTO);
		if(novoTriangulo.isPresent())
			return Response.ok(novoTriangulo.get().getTipoTriangulo()).build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Não forma triangulo!").build();
	}
	

	@POST
	@Path("/perimetro")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response calcularPerimetroTriangulo(Triangulo entradaDTO)  {
		Optional<Triangulo> novoTriangulo = criarTriangulo(entradaDTO);
		if(novoTriangulo.isPresent())
			return Response.ok(novoTriangulo.get().calcularPerimetro()).build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Não forma triangulo!").build();
	}
	
	private Optional<Triangulo> criarTriangulo(Triangulo entradaDTO) {
		Triangulo novoTriangulo;
		try {
			novoTriangulo = new Triangulo(entradaDTO.getLadoA(), entradaDTO.getLadoB(), entradaDTO.getLadoC());
		} catch (NaoFormaTrianguloException e) {
			return Optional.ofNullable(null);
		}
		return Optional.of(novoTriangulo);
	}
	
}
