package com.mycompany.klimanlaplicationcomputerinrerface;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.Date;
@XmlRootElement(name="sensor")


public class Sensor implements Serializable {
    private static final long serialVersionUID = 1L;
    private String sensornamn;
    private int värde;
    
    public Sensor(){}
    
    public Sensor(String sensornamn, int värde){
        this.sensornamn = sensornamn;
        this.värde = värde;
  
    }
    @XmlElement
    public String getSensornamn() {
        return sensornamn;
    }
    @XmlElement
    public void setSensornman(String sensornamn){
        this.sensornamn = sensornamn;
    }
    @XmlElement
    public int getVärde() {
        return värde;
    }
    @XmlElement
    public void setVärde(int värde) {
        this.värde = värde;
    }
}
