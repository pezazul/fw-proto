package org.bjc.epic.fhirworks;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlertRepository extends CrudRepository<Alert, Long>
{

    List<Alert> findByPatientId(String patientId);

    List<Alert> findByVisitId(String patientId);
}