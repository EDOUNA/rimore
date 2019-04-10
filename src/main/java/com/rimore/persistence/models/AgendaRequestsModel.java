package com.rimore.persistence.models;

import java.sql.Timestamp;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "agenda_requests")
public class AgendaRequestsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @Column(name = "created_at")
    public Timestamp createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    @Column(name = "updated_at")
    public Timestamp updatedAt;

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

    @Column(nullable = false, name = "start_date")
    @NotBlank(message = "Start date is required")
    public Timestamp startDate;

    @Column(name = "end_date")
    @NotBlank(message = "End date is required")
    public Timestamp endDate;

    @Column(nullable = false, name = "user_id")
    @NotBlank(message = "UserId is required")
    public Integer userId;

    @Column
    public Integer active;

    // Getters and setters
    public void AgendaRequestModel(Integer userId, Timestamp startDate, Timestamp endDate) {
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
