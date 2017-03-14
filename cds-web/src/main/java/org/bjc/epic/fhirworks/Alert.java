package org.bjc.epic.fhirworks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

/**
 * Created by kmh9665 on 3/12/2017.
 */
@Entity
public class Alert
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String patientId;
    private String visitId;
    private String alertDescription;
    private Date alertDate;
    private String alertType;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getPatientId()
    {
        return patientId;
    }

    public void setPatientId(String patientId)
    {
        this.patientId = patientId;
    }

    public String getVisitId()
    {
        return visitId;
    }

    public void setVisitId(String visitId)
    {
        this.visitId = visitId;
    }

    public String getAlertDescription()
    {
        return alertDescription;
    }

    public void setAlertDescription(String alertDescription)
    {
        this.alertDescription = alertDescription;
    }

    public Date getAlertDate()
    {
        return alertDate;
    }

    public void setAlertDate(Date alertDate)
    {
        this.alertDate = alertDate;
    }

    public String getAlertType()
    {
        return alertType;
    }

    public void setAlertType(String alertType)
    {
        this.alertType = alertType;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Alert alert = (Alert) o;
        return Objects.equals(id, alert.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }

    @Override
    public String toString()
    {
        return "Alert{" +
                "id=" + id +
                ", patientId='" + patientId + '\'' +
                ", visitId='" + visitId + '\'' +
                ", alertDescription='" + alertDescription + '\'' +
                ", alertDate=" + alertDate +
                ", alertType='" + alertType + '\'' +
                '}';
    }
}
