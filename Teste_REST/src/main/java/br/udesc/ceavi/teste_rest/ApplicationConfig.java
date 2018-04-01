package br.udesc.ceavi.teste_rest;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("web")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.udesc.ceavi.teste_rest.ModelosResource.class);
        resources.add(br.udesc.ceavi.teste_rest.MontadorasResource.class);
        resources.add(br.udesc.ceavi.teste_rest.VeiculosResource.class);
    }
    
}
