package br.udesc.ceavi.teste_rest;

import br.udesc.ceavi.teste_rest.model.Montadora;
import br.udesc.ceavi.teste_rest.persistence.DAOGenerico;
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

@Path("montadoras")
public class MontadorasResource {

    @Context
    private UriInfo context;

    public MontadorasResource() {
    }

    @GET
    @Path( "/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Montadora getJson( @PathParam( "id" ) String id ) {
        return (Montadora) DAOGenerico.ler( Montadora.class, Long.parseLong( id ) );
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Montadora> getListaJson(){
        return MontadoraDao.listar();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJson(Montadora m) {
        DAOGenerico.salvar( m );
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Montadora m) {
        DAOGenerico.update( m );
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes( MediaType.APPLICATION_JSON )
    public void excluir( @PathParam( "id" ) String id ){
        MontadoraDao.excluir( Long.parseLong( id ) );
    }
}
