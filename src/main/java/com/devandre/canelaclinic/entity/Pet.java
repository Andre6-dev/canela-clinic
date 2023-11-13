package com.devandre.canelaclinic.entity;

import com.devandre.canelaclinic.entity.shared.AbstractEntity;
import com.devandre.canelaclinic.enums.Gender;
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
@Table(name = "pets")
public class Pet extends AbstractEntity {

    @Id
    @Column(name = "pet_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petId;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "breed", nullable = false, length = 45)
    private String breed;

    @Column(name = "color", nullable = false, length = 45)
    private String color;

    @Column(name = "species", nullable = false, length = 45)
    private String species;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "microchip_id", length = 45)
    private String microchipId;

    private Double weight;

    @Column(name = "next_visit")
    private Date nextVisit;

    @Column(name = "photo_url")
    private String photoUrl;

    @ToString.Exclude
    @OneToMany(mappedBy = "pet", orphanRemoval = true)
    private Set<Procedure> procedures = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(petId, pet.petId) && Objects.equals(name, pet.name) && Objects.equals(breed, pet.breed) && Objects.equals(color, pet.color) && Objects.equals(species, pet.species) && Objects.equals(birthDate, pet.birthDate) && gender == pet.gender && Objects.equals(microchipId, pet.microchipId) && Objects.equals(weight, pet.weight) && Objects.equals(nextVisit, pet.nextVisit) && Objects.equals(photoUrl, pet.photoUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petId, name, breed, color, species, birthDate, gender, microchipId, weight, nextVisit, photoUrl);
    }
}
