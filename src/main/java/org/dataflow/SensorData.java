package org.dataflow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SensorData {

    @JsonProperty("sensor_id")
    private String sensorId;

    @JsonProperty("temp_val")
    private String temperature;


    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "sensorId='" + sensorId + '\'' +
                ", temperature='" + temperature + '\'' +
                '}';
    }
}
