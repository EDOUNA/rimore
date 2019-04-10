package com.rimore.persistence.models;

import java.sql.Timestamp;
import javax.persistence.*;

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
    public Timestamp startDate;

    @Column(name = "end_date")
    public Timestamp endDate;

    @Column(nullable = false, name = "user_id")
    public Integer userId;

    @Column
    public Integer active;
}
