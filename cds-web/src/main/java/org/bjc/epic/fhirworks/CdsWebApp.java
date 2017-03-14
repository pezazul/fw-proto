package org.bjc.epic.fhirworks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by kmh9665 on 3/12/2017.
 */
@SpringBootApplication
public class CdsWebApp
{

    private static final Logger log = LoggerFactory.getLogger(CdsWebApp.class);

    public static void main(String[] args)
    {
        SpringApplication.run(CdsWebApp.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx,
                                               AlertRepository alertRepository,
                                               RestClient restClient)
    {
        return args ->
        {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames)
            {
                System.out.println(beanName);
            }

            System.out.println(alertRepository.count());

            Alert alert = new Alert();
            alert.setPatientId("1");
            alert.setVisitId("1");
            alert.setAlertDate(new Date(System.currentTimeMillis() - 1000 * 12 * 60 * 60));
            alert.setAlertType("Generic");
            alert.setAlertDescription("Hypoglycemia risk alert");
            alertRepository.save(alert);

            alert = new Alert();
            alert.setPatientId("1");
            alert.setVisitId("2");
            alert.setAlertDate(new Date(System.currentTimeMillis() - 1000 * 5 * 60 * 60));
            alert.setAlertType("Generic");
            alert.setAlertDescription("STI testing recommended");
            alertRepository.save(alert);

            alert = new Alert();
            alert.setPatientId("2");
            alert.setVisitId("3");
            alert.setAlertDate(new Date(System.currentTimeMillis() - 1000 * 14 * 60 * 60));
            alert.setAlertType("Generic");
            alert.setAlertDescription("Clinical Deterioration Alert");
            alertRepository.save(alert);


            System.out.println(alertRepository.findByPatientId("1"));
            System.out.println(alertRepository.findByVisitId("3"));

            restClient.getPatientIds("Z4575", RestClient.PATIENT_ID_TYPE_EXTERNAL);


        };
    }

}

