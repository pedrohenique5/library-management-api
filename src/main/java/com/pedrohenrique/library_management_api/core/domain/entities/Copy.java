package com.pedrohenrique.library_management_api.core.domain.entities;

import com.pedrohenrique.library_management_api.core.domain.enums.CopyStatus;

public class Copy {
    private Long id;
    private Long bookId;
    private String assetCode;
    private CopyStatus status;

    public Copy(Long id, Long bookId, String assetCode, CopyStatus status) {
        this.id = id;
        this.bookId = bookId;
        setAssetCode(assetCode);
        this.status = status;
    }

    public Long getId() { return id; }
    public Long getBookId() { return bookId; }
    public String getAssetCode() { return assetCode; }
    public CopyStatus getStatus() { return status; }

    public void setId(Long id) {
        this.id = id;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public void setAssetCode(String assetCode) {
        if (assetCode == null || assetCode.isBlank()) {
            throw new IllegalArgumentException("assetCode is required");
        }
        if (!assetCode.matches("^[A-Z]{2}-\\d{4}-\\d{3}$")) {
            throw new IllegalArgumentException("assetCode format is invalid. Expected format: XX-XXXX-XXX");
        }
        this.assetCode = assetCode;
    }
    public void setStatus(CopyStatus status) {
        this.status = status;
    }
}