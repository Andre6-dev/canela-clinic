package com.devandre.canelaclinic.entity;

import com.devandre.canelaclinic.entity.shared.ProfileAbstractEntity;
import com.devandre.canelaclinic.enums.TypeEmployee;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
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
@Table(name = "employees")
public class Employee extends ProfileAbstractEntity {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "type_employee", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeEmployee typeEmployee;

    @Column(name = "legend_color")
    private String legendColor;

    @ToString.Exclude
    @OneToMany(mappedBy = "employee",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    private Set<Schedule> schedules = new LinkedHashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "employee", orphanRemoval = true)
    private Set<Procedure> procedures = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) && typeEmployee == employee.typeEmployee && Objects.equals(legendColor, employee.legendColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, typeEmployee, legendColor);
    }
}
