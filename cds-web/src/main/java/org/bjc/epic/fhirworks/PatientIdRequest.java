package org.bjc.epic.fhirworks;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by kmh9665 on 3/13/2017.
 */
public class PatientIdRequest
{
    @JsonProperty("PatientID")
    String patientId;
    @JsonProperty("PatientIDType")
    String idType;

    @JsonProperty("UserID")
    String userId;
    @JsonProperty("UserIDType")
    String userIdType;

    public PatientIdRequest(String patientId, String idType, String userId)
    {
        this.patientId = patientId;
        this.idType = idType;
        this.userId = userId;
        this.userIdType = "EXTERNAL";
    }
}
