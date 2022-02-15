package com.kinali.complaintsnet.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.james.mime4j.dom.datetime.DateTime;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "dates")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Date {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id" )
    private  int id;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    // randevu oluşturulma tarihi
    @Column(name = "date_time")
    private LocalDate dateTime;
    // randevu buluşma tarihi.
    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    // doktorla ile randevu açma sistemini bağlamış olduk.
    @OneToOne
    @JoinColumn(name = "city_id")
    private City city;






}
