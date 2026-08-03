package com.pedrohenrique.library_management_api.core.domain.entities;

import com.pedrohenrique.library_management_api.core.domain.enums.ReservationStatus;

import java.time.LocalDate;

public class Reservation {
    private Long id;
    private Long userId;
    private Long bookId;
    private LocalDate reservationDate;
    private ReservationStatus status;

    public Reservation(Long id, Long userId, Long bookId, LocalDate reservationDate, ReservationStatus status) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.reservationDate = reservationDate;
        this.status = status;
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Long getBookId() { return bookId; }
    public LocalDate getReservationDate() { return reservationDate; }
    public ReservationStatus getStatus() { return status; }

    public void setId(Long id) {
        this.id = id;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }
    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public void cancel() {
        this.status = ReservationStatus.CANCELED;
    }

    public void expire() {
        this.status = ReservationStatus.EXPIRED;
    }

    public void fulfill() {
        this.status = ReservationStatus.FULFILLED;
    }
}