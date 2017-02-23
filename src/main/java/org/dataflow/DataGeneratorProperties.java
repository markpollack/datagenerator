package org.dataflow;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "datagenerator")
public class DataGeneratorProperties {

    private String httpEndpoint = "https://mlp-scdf-1c1eloy-sensorstream-rxhttp.cfapps.io/";

    private int numSensors = 10;

    private float sigma = 1.0f;

    private int sleepInMillis = 25;

    public String getHttpEndpoint() {
        return httpEndpoint;
    }

    public void setHttpEndpoint(String httpEndpoint) {
        this.httpEndpoint = httpEndpoint;
    }

    public int getNumSensors() {
        return numSensors;
    }

    public void setNumSensors(int numSensors) {
        this.numSensors = numSensors;
    }

    public float getSigma() {
        return sigma;
    }

    public void setSigma(float sigma) {
        this.sigma = sigma;
    }

    public int getSleepInMillis() {
        return sleepInMillis;
    }

    public void setSleepInMillis(int sleepInMillis) {
        this.sleepInMillis = sleepInMillis;
    }
}
