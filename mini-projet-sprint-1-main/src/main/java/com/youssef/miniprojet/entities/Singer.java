package com.youssef.miniprojet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor @NoArgsConstructor
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SingerId;
    private String SingerName;
    private String Description;
    private Double Featureprice;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Specify expected date format
    private Date Birthdate;





}
