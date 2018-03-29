package br.udesc.ceavi.teste_rest;

import br.udesc.ceavi.teste_rest.model.Cliente;
import br.udesc.ceavi.teste_rest.persistence.ClienteDAO;
import br.udesc.ceavi.teste_rest.persistence.DAOGenerico;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("cliente")
public class ClienteResource {

    @Context
    private UriInfo context;

    public ClienteResource() {
    }

    @GET
    @Path( "/{id}" )
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getJson( @PathParam( "id" ) String id ) {
        return (Cliente) DAOGenerico.ler( Cliente.class, Long.parseLong( id ) );
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getListaClientes( ){
        return ClienteDAO.listar();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson( Cliente c ) {
        DAOGenerico.salvar( c );
    }
}
