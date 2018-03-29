package br.udesc.ceavi.teste_rest;

import br.udesc.ceavi.teste_rest.model.Fornecedor;
import br.udesc.ceavi.teste_rest.persistence.DAOGenerico;
import br.udesc.ceavi.teste_rest.persistence.FornecedorDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("fornecedor")
public class FornecedorResource {

    @Context
    private UriInfo context;

    public FornecedorResource() {
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Fornecedor getJson( @PathParam( "id" ) String id ) {
        return (Fornecedor) DAOGenerico.ler( Fornecedor.class, Long.parseLong( id ) );
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fornecedor> getListaFornecedores() {
        return FornecedorDAO.listar();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJson(Fornecedor f) {
        DAOGenerico.salvar( f );
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String putFornecedor(Fornecedor f){
        Fornecedor f2 = (Fornecedor) DAOGenerico.ler( Fornecedor.class, f.getId() );
        if( f2 != null ){
            f2.setNomeFornecedor( f.getNomeFornecedor() );
            DAOGenerico.update( f2 );
            return "Sucesso";
        }else{
            return "Erro ao processar fornecedor";
        }
    }
    
    @DELETE
    @Path( "/(id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteFornecedor( @PathParam( "id" ) String id ){
        long valorID = Long.parseLong( id );
        Fornecedor f = (Fornecedor) DAOGenerico.ler( Fornecedor.class, valorID );
        System.out.println("ID: " + id);
        System.err.println( f.toString() );
        if( f != null ){
//            DAOGenerico.excluir( f );
//            return "Sucesso";
        }else{
//            return "Erro ao processar fornecedor";
        }
    }
}
