package com.rimore.persistence.models;

import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name = "agenda_requests")
public class AgendaRequestsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private Timestamp created_at;

    @PrePersist
    protected void onCreate() {
        created_at = new Timestamp(System.currentTimeMillis());
    }

    @Column(nullable = false)
    private Timestamp updated_at;

    @PreUpdate
    protected void onUpdate() {
        updated_at = new Timestamp(System.currentTimeMillis());
    }

    @Column(nullable = false, name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp end_date;

    @Column(nullable = false, name = "user_id")
    private Integer userId;

    @Column(nullable = false)
    private Integer active;
}
