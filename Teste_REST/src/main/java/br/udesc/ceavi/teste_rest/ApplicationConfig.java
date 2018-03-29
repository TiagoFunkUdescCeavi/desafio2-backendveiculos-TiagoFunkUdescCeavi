/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.teste_rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author tiago
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.udesc.ceavi.teste_rest.ClienteResource.class);
        resources.add(br.udesc.ceavi.teste_rest.FornecedorResource.class);
        resources.add(br.udesc.ceavi.teste_rest.HelloworldResource.class);
        resources.add(br.udesc.ceavi.teste_rest.ProdutosResource.class);
        resources.add(br.udesc.ceavi.teste_rest.VeiculosResource.class);
    }
    
}
