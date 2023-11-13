package com.devandre.canelaclinic.entity;

import com.devandre.canelaclinic.entity.shared.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

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
@Table(name = "invoices")
public class Invoice extends AbstractEntity {

    @Id
    @Column(name = "invoice_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    private String number;

    @Column(name = "total_amount")
    private Double totalAmount;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "medical_procedure_id")
    private Procedure procedure;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(invoiceId, invoice.invoiceId) && Objects.equals(number, invoice.number) && Objects.equals(totalAmount, invoice.totalAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, number, totalAmount);
    }
}
