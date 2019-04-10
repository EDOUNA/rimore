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

    @Column
    private Timestamp start_date;

    @Column
    private Timestamp end_date;

    @Column(nullable = false)
    private Integer active;
}
