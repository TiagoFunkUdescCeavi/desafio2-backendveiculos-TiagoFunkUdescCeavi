package resources;

import java.util.ArrayList;
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
import model.Veiculo;
import persistence.DAOGenerico;
import persistence.VeiculoDAO;

@Path("veiculos")
public class VeiculosResource {

    @Context
    private UriInfo context;

    public VeiculosResource() {
    }

    @GET
    @Path( "/{id}" )
    @Produces(MediaType.APPLICATION_JSON)
    public Veiculo getJson( @PathParam( "id" ) String id ) {
        return (Veiculo) DAOGenerico.ler( Veiculo.class, Long.parseLong( id ) );
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List< Veiculo > getListaVeiculos(){
        return VeiculoDAO.ordenarVeiculos();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Veiculo v) {
        DAOGenerico.salvar( v );
    }
}
