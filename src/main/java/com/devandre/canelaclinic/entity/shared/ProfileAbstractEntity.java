package com.devandre.canelaclinic.entity.shared;

import com.devandre.canelaclinic.enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * andre on 10/11/2023
 */
@Getter
@Setter
@MappedSuperclass
public abstract class ProfileAbstractEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone", unique = true)
    private String phone;

    private String address;

    @Column(name = "profile_photo")
    private String profilePhoto;

    @Column(name = "birth_date")
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
