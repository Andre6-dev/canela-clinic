package com.devandre.canelaclinic.entity;

import jakarta.persistence.*;
import lombok.*;

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
@Table(name = "schedules")
public class Schedule {

    @Id
    @Column(name = "schedule_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @Column(name = "title", nullable = false, length = 45)
    private String title;

    @Column(name = "time_start", nullable = false)
    private Date timeStart;

    @Column(name = "time_end", nullable = false)
    private Date timeEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    @ToString.Exclude
    private Employee employee;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(scheduleId, schedule.scheduleId) && Objects.equals(title, schedule.title) && Objects.equals(timeStart, schedule.timeStart) && Objects.equals(timeEnd, schedule.timeEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleId, title, timeStart, timeEnd);
    }
}
