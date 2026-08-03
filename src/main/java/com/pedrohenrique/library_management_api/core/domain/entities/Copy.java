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
        this.assetCode = assetCode;
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
        this.assetCode = assetCode;
    }
    public void setStatus(CopyStatus status) {
        this.status = status;
    }
}