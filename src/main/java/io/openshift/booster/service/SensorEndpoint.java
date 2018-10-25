package io.openshift.booster.service;

import java.util.List;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;


@Path("/sensorData")
@Component
public class SensorEndpoint {
    @GET
    @Produces("application/json")
    public List<SensorData> sensorData(){
        return SensorData.STORAGE;
    }   
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public int addSensorData(SensorData sensorData){
        sensorData.timestamp((new Date()).toString());
        System.out.println(sensorData.toString());
        SensorData.STORAGE.add(sensorData);
        return SensorData.STORAGE.size();
    }
}
