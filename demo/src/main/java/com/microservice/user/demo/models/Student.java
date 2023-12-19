package com.microservice.user.demo.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue(value =  "Student")
@Table (name = "Student")
public class Student extends Persona{
    
}
