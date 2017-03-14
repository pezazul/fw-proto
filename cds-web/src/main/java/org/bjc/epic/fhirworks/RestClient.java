package org.bjc.epic.fhirworks;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by kmh9665 on 3/13/2017.
 */
@Component
public class RestClient
{
    public static final String PATIENT_ID_TYPE_EXTERNAL = "EXTERNAL";

    @Value("${epic.user.id}")
    private String userId;

    @Value("${epic.password")
    private String password;

    private RestTemplate restTemplate;

    private Environment environment;


    public RestClient(Environment environment,
                      RestTemplateBuilder builder)
    {
        restTemplate = builder.requestFactory(HttpComponentsAsyncClientHttpRequestFactory.class).basicAuthorization("emp$" + environment.getProperty("epic.user.id"),
                environment.getProperty("epic.password")).build();
        this.environment = environment;
    }

    public Map getPatientIds(String patientId, String idType)
    {
        ResponseEntity<Map> response =
                restTemplate.postForEntity(environment.getProperty("epic.interconnect.base.url") + environment.getProperty("epic.interconnect.getpatientid.endpoint"),
                        new PatientIdRequest(patientId, idType, environment.getProperty("epic.user.id")),
                        Map.class);
        System.out.println(response.getBody());
        return response.getBody();

    }
}
