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
import javax.ws.rs.QueryParam;
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
    public Veiculo getJson( @PathParam( "id" ) String id ) {
        return (Veiculo) DAOGenerico.ler( Veiculo.class, Long.parseLong( id ) );
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> getListaJson(){
        return VeiculoDao.listar();
    }
    
    /**
     * Enfia no cu essa merda.
     */
//    @GET
//    @Path( "/buscarw?categoria={cat}&modelo={mod}"
//            + "&montadora={mont}&cor={cor}"
//            + "&quilometragem={quil}&operadorQuilometragem={operQuil}"
//            + "&motor={mot}&operadorMotor={operMot}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.TEXT_PLAIN)
//    public List<Veiculo> getConsulta( 
//            @QueryParam( "cat") String cat, @QueryParam( "mod" ) String mod,
//            @QueryParam( "mont" ) String mont, @QueryParam( "cor" ) String cor,
//            @QueryParam( "quil" ) String quil, @QueryParam( "operQuil") String operQuil,
//            @QueryParam( "mot") String motor, @QueryParam( "operMot" ) String operMot){
//        int contador = 0;
//        String condicaoConsulta = "";
//        String ce = "\"";//Caractere especial
//        
//        if( !cat.equalsIgnoreCase( "null" ) ){
//            condicaoConsulta += "v.categoria = " + ce + cat + ce;
//            contador++;
//        }
//        if( !mod.equalsIgnoreCase( "null" ) ){
//            if( contador != 0 ){
//                condicaoConsulta += ",";
//            }
//            condicaoConsulta += "v.modelo = " + ce + mod + ce;
//            contador++;
//        }
//        if( !mont.equalsIgnoreCase( "null" ) ){
//            if( contador != 0 ){
//                condicaoConsulta += ",";
//            }
//            condicaoConsulta += "v.montadora = " + ce + mont + ce;
//            contador++;
//        }
//        if( !cor.equalsIgnoreCase( "null" ) ){
//            if( contador != 0 ){
//                condicaoConsulta += ",";
//            }
//            condicaoConsulta += "v.cor = " + ce + cor + ce;
//            contador++;
//        }
//        if( !quil.equalsIgnoreCase( "null" ) ){
//            if( contador != 0 ){
//                condicaoConsulta += ",";
//            }
//            condicaoConsulta += "v.quilometragem";
//            if( operQuil.equalsIgnoreCase( "igual" ) ){
//                condicaoConsulta += " = ";
//            }else if( operQuil.equalsIgnoreCase( "menor" ) ){
//                condicaoConsulta += " < ";
//            }else if( operQuil.equalsIgnoreCase( "maior") ){
//                condicaoConsulta += " > ";
//            }else if( operQuil.equalsIgnoreCase( "menorIgual") ){
//                condicaoConsulta += " <= ";
//            }else if( operQuil.equalsIgnoreCase( "maiorIgual") ){
//                condicaoConsulta += " >= ";
//            }
//            condicaoConsulta += quil;
//            contador++;
//        }
//        if( !motor.equalsIgnoreCase( "null" ) ){
//            if( contador != 0 ){
//                condicaoConsulta += ",";
//            }
//            condicaoConsulta += "v.motor";
//            if( operQuil.equalsIgnoreCase( "igual" ) ){
//                condicaoConsulta += " = ";
//            }else if( operQuil.equalsIgnoreCase( "menor" ) ){
//                condicaoConsulta += " < ";
//            }else if( operQuil.equalsIgnoreCase( "maior") ){
//                condicaoConsulta += " > ";
//            }else if( operQuil.equalsIgnoreCase( "menorIgual") ){
//                condicaoConsulta += " <= ";
//            }else if( operQuil.equalsIgnoreCase( "maiorIgual") ){
//                condicaoConsulta += " >= ";
//            }
//            condicaoConsulta += motor;
//            contador++;
//        }
//        System.out.println( condicaoConsulta );
//        return VeiculoDao.buscarComFiltro( condicaoConsulta );
//    }
    
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
    public void excluir( @PathParam( "id") String id ){
        VeiculoDao.excluir( Long.parseLong( id ) );
    }
}
