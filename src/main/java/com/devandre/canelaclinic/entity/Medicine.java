package com.devandre.canelaclinic.entity;

import com.devandre.canelaclinic.entity.shared.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "medicines")
public class Medicine extends AbstractEntity {

    @Id
    @Column(name = "medicine_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicineId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    private String laboratory;

    @Column(name = "label_volume")
    private String labelVolume;

    @Column(name = "quantity_per_stock")
    private Long quantityPerStock;

    private String manufacturer;

    private String supplier;

    @Column(name = "label_whole")
    private String labelWhole;

    @Column(name = "label_stock")
    private String labelStock;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @ToString.Exclude
    private CategoryMedicine categoryMedicine;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    @ToString.Exclude
    private Stock stock;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return Objects.equals(medicineId, medicine.medicineId) && Objects.equals(name, medicine.name) && Objects.equals(description, medicine.description) && Objects.equals(laboratory, medicine.laboratory) && Objects.equals(labelVolume, medicine.labelVolume) && Objects.equals(quantityPerStock, medicine.quantityPerStock) && Objects.equals(manufacturer, medicine.manufacturer) && Objects.equals(supplier, medicine.supplier) && Objects.equals(labelWhole, medicine.labelWhole) && Objects.equals(labelStock, medicine.labelStock) && Objects.equals(price, medicine.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicineId, name, description, laboratory, labelVolume, quantityPerStock, manufacturer, supplier, labelWhole, labelStock, price);
    }
}
