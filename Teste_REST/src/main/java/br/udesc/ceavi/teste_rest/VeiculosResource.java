package br.udesc.ceavi.teste_rest;

import br.udesc.ceavi.teste_rest.model.Veiculo;
import br.udesc.ceavi.teste_rest.persistence.DAOGenerico;
import br.udesc.ceavi.teste_rest.persistence.VeiculoDao;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("veiculos")
public class VeiculosResource {

    @Context
    private UriInfo context;

    public VeiculosResource() {
    }

    @GET
    @Path( "/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Veiculo getJson( @PathParam( "id" ) String id) {
        return (Veiculo) DAOGenerico.ler( Veiculo.class, Long.parseLong( id ) );
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> getListaJson(){
        return VeiculoDao.listar();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Veiculo v) {
        DAOGenerico.salvar( v );
    }
    
    @PUT
    @Consumes( MediaType.APPLICATION_JSON)
    public void editar( Veiculo v ){
        DAOGenerico.update( v );
    }
    
    @DELETE
    @Path( "/{id}")
    @Consumes( MediaType.APPLICATION_JSON )
    public void excluir( @PathParam( "id" ) String id ){
        VeiculoDao.excluir( Long.parseLong( id ) );
    }
}
