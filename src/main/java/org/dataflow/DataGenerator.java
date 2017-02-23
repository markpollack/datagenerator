package org.dataflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.util.Random;

@Component
public class DataGenerator {

    private final DataGeneratorProperties dataGeneratorProperties;

    private final RestTemplate restTemplate;

    private final Random random = new Random();


    @Autowired
    public DataGenerator(DataGeneratorProperties dataGeneratorProperties) {
        this.dataGeneratorProperties = dataGeneratorProperties;
        restTemplate = new RestTemplate();

    }

    public void run() throws InterruptedException {
        String uri = dataGeneratorProperties.getHttpEndpoint();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        while(true) {
            try {
                for (int i = 0; i < dataGeneratorProperties.getNumSensors(); i++) {
                    SensorData sensorData = generateData(i);
                    HttpEntity<SensorData> entity = new HttpEntity<SensorData>(sensorData, headers);
                    restTemplate.exchange(uri, HttpMethod.POST, entity, Void.class);
                    System.out.println("Posted " + sensorData);
                }
            } catch (Exception e) {
                System.out.println("Caught Exception " + e);
            } finally {
                Thread.sleep(dataGeneratorProperties.getSleepInMillis());
            }
        }

    }

    private SensorData generateData(int sensorId) {
        SensorData sensorData = new SensorData();
        sensorData.setSensorId(Integer.toString(sensorId));
        double val = Math.abs(random.nextGaussian() * dataGeneratorProperties.getSigma() + sensorId);
        sensorData.setTemperature(String.format("%.2f", val));
        return sensorData;
    }
}
