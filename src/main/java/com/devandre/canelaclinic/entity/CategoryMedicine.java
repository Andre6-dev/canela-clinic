package com.devandre.canelaclinic.entity;

import com.devandre.canelaclinic.entity.shared.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * andre on 11/11/2023
 */
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories_medicines")
public class CategoryMedicine extends AbstractEntity {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "categoryMedicine", orphanRemoval = true)
    private Set<Medicine> medicines = new LinkedHashSet<>();

}
