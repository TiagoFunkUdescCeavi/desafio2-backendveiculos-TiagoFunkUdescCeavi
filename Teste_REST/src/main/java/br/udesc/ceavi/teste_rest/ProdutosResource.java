package br.udesc.ceavi.teste_rest;

import br.udesc.ceavi.teste_rest.model.Produto;
import br.udesc.ceavi.teste_rest.persistence.DAOGenerico;
import br.udesc.ceavi.teste_rest.persistence.ProdutoDAO;
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

@Path("produto")
public class ProdutosResource {

    @Context
    private UriInfo context;

    public ProdutosResource() {
    }

    @GET
    @Path( "/{id}" )
    @Produces(MediaType.APPLICATION_JSON)
    public Produto getJson( @PathParam( "id" ) String id) {
        return (Produto) DAOGenerico.ler( Produto.class, Long.parseLong( id ) );
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> getListaProdutos( ){
        return ProdutoDAO.listar();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Produto p) {
        DAOGenerico.salvar( p );
    }
}
