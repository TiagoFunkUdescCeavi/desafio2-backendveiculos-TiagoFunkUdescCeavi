/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.teste_rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author tiago
 */
@Path("helloworld")
public class HelloworldResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloworldResource
     */
    public HelloworldResource() {
    }

    /**
     * Retrieves representation of an instance of br.udesc.ceavi.teste_rest.HelloworldResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "{ Tiago diz: Olá !! }";
    }

    /**
     * PUT method for updating or creating an instance of HelloworldResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
