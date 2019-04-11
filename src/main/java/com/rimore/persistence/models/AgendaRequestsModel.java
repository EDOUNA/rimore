package com.rimore.persistence.models;

import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "agenda_requests")
public class AgendaRequestsModel {

    /**
     * Default contrusctor
     */
    public AgendaRequestsModel() {

    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
        updatedAt = createdAt;
        active = 1; // Setting the active state on 1 by default
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @Column(name = "created_at")
    public Timestamp createdAt;

    @Column(name = "updated_at")
    public Timestamp updatedAt;

    @Column(nullable = false, name = "start_date")
    @NotNull(message = "Start date is required")
    public Timestamp startDate;

    @Column(name = "end_date")
    @NotNull(message = "End date is required")
    public Timestamp endDate;

    @Column(nullable = false, name = "user_id")
    @NotNull(message = "UserId is required")
    public Integer userId;

    @Column
    public Integer active;

    public AgendaRequestsModel(long id, Timestamp createdAt, Timestamp updatedAt, Timestamp startDate,
            Timestamp endDate, Integer userId, Integer active) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userId = userId;
        this.active = active;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Timestamp getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActive() {
        return this.active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public AgendaRequestsModel id(long id) {
        this.id = id;
        return this;
    }

    public AgendaRequestsModel createdAt(Timestamp createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public AgendaRequestsModel updatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public AgendaRequestsModel startDate(Timestamp startDate) {
        this.startDate = startDate;
        return this;
    }

    public AgendaRequestsModel endDate(Timestamp endDate) {
        this.endDate = endDate;
        return this;
    }

    public AgendaRequestsModel userId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public AgendaRequestsModel active(Integer active) {
        this.active = active;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AgendaRequestsModel)) {
            return false;
        }
        AgendaRequestsModel agendaRequestsModel = (AgendaRequestsModel) o;
        return id == agendaRequestsModel.id && Objects.equals(createdAt, agendaRequestsModel.createdAt)
                && Objects.equals(updatedAt, agendaRequestsModel.updatedAt)
                && Objects.equals(startDate, agendaRequestsModel.startDate)
                && Objects.equals(endDate, agendaRequestsModel.endDate)
                && Objects.equals(userId, agendaRequestsModel.userId)
                && Objects.equals(active, agendaRequestsModel.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, startDate, endDate, userId, active);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", createdAt='" + getCreatedAt() + "'" + ", updatedAt='" + getUpdatedAt()
                + "'" + ", startDate='" + getStartDate() + "'" + ", endDate='" + getEndDate() + "'" + ", userId='"
                + getUserId() + "'" + ", active='" + getActive() + "'" + "}";
    }
}
