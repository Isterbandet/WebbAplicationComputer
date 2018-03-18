package com.mycompany.klimanlaplicationcomputerinrerface;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.io.IOException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;


public class KlimanlClient {
    private static ClientConfig config = new DefaultClientConfig();
    private static Client client = Client.create(config);
    private static WebResource service = client.resource(
            UriBuilder.fromUri("http://localhost:8080/").build());
    
    
    
    public void addTempsensor(){
        //Adda en kompis med post
       Sensor tempsensor = new Sensor("Temperatur", 133);
       
       ClientResponse response = service.path("/KlimAnl/rest/KlimatService/tempsensor/add")
               .accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, tempsensor);
       System.out.println("SATAN I PEKELE");
       System.out.println(tempsensor);
       System.out.println("Response" + response.getEntity(String.class));
    }
    
    public void listaTempsensorer(){
         Gson gson = new Gson();
                
        //Hämta alla kompsiar
        String jsonString = service.path("/KlimAnl/rest/KlimatService/allatempsensorer")
        .accept(MediaType.APPLICATION_JSON).get(String.class);
        
        Sensor[] sensor = gson.fromJson(jsonString, Sensor[].class);
        for (Sensor k : sensor){
            System.out.println("Sensortyp : " + k.getSensornamn()+ " C* : " + k.getVärde() );
        }
    }
    /*
    public void tabortKompis(String kompis){
        //Ta bort en polare
        String jsonKompis = service.path("rest/KompisarServiceX/kompisarJSON/"+kompis+"/delete")
                .accept(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(kompis +"borttagen");
        
    
    
    
    }
    
    */
    
    
    public static void main(String[] args) throws IOException {
        
       

        KlimanlClient temperatur = new KlimanlClient();
        temperatur.listaTempsensorer();//1
        
       
        
       
     
       temperatur.addTempsensor();
    
}


}