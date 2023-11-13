package com.devandre.canelaclinic.entity;

import com.devandre.canelaclinic.entity.shared.ProfileAbstractEntity;
import com.devandre.canelaclinic.enums.ClientStatus;
import jakarta.persistence.*;
import lombok.*;

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
@Table(name = "clients")
public class Client extends ProfileAbstractEntity {

    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(name = "dni", nullable = false, length = 8, unique = true)
    private String dni;

    @Enumerated(EnumType.STRING)
    private ClientStatus status;

    @ToString.Exclude
    @OneToMany(mappedBy = "client", orphanRemoval = true)
    private Set<Pet> pets = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(clientId, client.clientId) && Objects.equals(dni, client.dni) && status == client.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, dni, status);
    }
}
