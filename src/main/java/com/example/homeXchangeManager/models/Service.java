package com.example.homeXchangeManager.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private int serviceId;

    @NotNull
    @Column(name = "service_name")
    private String serviceName;

    @NotNull
    @Column(name = "help_text")
    private String helpText;

    @NotNull
    @Column(name = "service_description")
    private String serviceDescription;

    public Service() {
    }

    public Service(String serviceName, String helpText, String serviceDescription) {
        this.serviceName = serviceName;
        this.helpText = helpText;
        this.serviceDescription = serviceDescription;
    }

    // Getters and setters

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }
}
