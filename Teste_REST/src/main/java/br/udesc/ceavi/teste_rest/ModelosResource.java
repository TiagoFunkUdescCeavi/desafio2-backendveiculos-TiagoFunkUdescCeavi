package br.udesc.ceavi.teste_rest;

import br.udesc.ceavi.teste_rest.model.Modelo;
import br.udesc.ceavi.teste_rest.model.Montadora;
import br.udesc.ceavi.teste_rest.persistence.DAOGenerico;
import br.udesc.ceavi.teste_rest.persistence.ModeloDao;
import br.udesc.ceavi.teste_rest.persistence.MontadoraDao;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("modelos")
public class ModelosResource {

    @Context
    private UriInfo context;

    public ModelosResource() {
    }

    @GET
    @Path( "/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Modelo getJson( @PathParam( "id" ) String id ) {
        return (Modelo) DAOGenerico.ler( Modelo.class, Long.parseLong( id ) );
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Modelo> getListaJson(){
        return ModeloDao.listar();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJson(Modelo m) {
        System.out.println( "POST: " + m.toString() );
        DAOGenerico.salvar( m );
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Modelo m) {
        DAOGenerico.update( m );
    }
    
    @DELETE
    @Path( "/{id}")
    @Consumes( MediaType.APPLICATION_JSON )
    public void excluir( @PathParam( "id" ) String id ){
        ModeloDao.excluir( Long.parseLong( id ) );
    }
}
