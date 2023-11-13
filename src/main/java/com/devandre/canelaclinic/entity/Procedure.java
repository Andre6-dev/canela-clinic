package com.devandre.canelaclinic.entity;

import com.devandre.canelaclinic.enums.ProcedureStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

/**
 * andre on 10/11/2023
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "procedures")
public class Procedure {

    @Id
    @Column(name = "procedure_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long procedureId;

    @Column(name = "created_date", nullable = false)
    private Instant creationDate = Instant.now();

    @Column(name = "medical_procedure")
    private String medicalProcedure;

    @Column(columnDefinition = "TEXT")
    private String remarks;

    @Column(name = "next_due_date")
    private Date nextDueDate;

    @Enumerated(EnumType.STRING)
    private ProcedureStatus status;

    private Double weight;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Procedure procedure = (Procedure) o;
        return Objects.equals(procedureId, procedure.procedureId) && Objects.equals(creationDate, procedure.creationDate) && Objects.equals(medicalProcedure, procedure.medicalProcedure) && Objects.equals(remarks, procedure.remarks) && Objects.equals(nextDueDate, procedure.nextDueDate) && status == procedure.status && Objects.equals(weight, procedure.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(procedureId, creationDate, medicalProcedure, remarks, nextDueDate, status, weight);
    }
}
