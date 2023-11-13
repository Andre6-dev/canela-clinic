package com.devandre.canelaclinic.entity;

import com.devandre.canelaclinic.entity.shared.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * andre on 10/11/2023
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "medicine_stocks")
public class Stock extends AbstractEntity {

    @Id
    @Column(name = "stock_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockId;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "expiration_date", nullable = false)
    private Date expirationDate;

    @ToString.Exclude
    @OneToMany(mappedBy = "stock", orphanRemoval = true)
    private Set<Medicine> medicines = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(stockId, stock.stockId) && Objects.equals(quantity, stock.quantity) && Objects.equals(expirationDate, stock.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockId, quantity, expirationDate);
    }
}
