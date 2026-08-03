package com.pedrohenrique.library_management_api.core.domain.entities;

import java.util.List;

public class Book {
    private Long id;
    private String title;
    private String isbn;
    private String synopsis;
    private Integer publicationYear;
    private Integer pageCount;
    private Long categoryId;
    private Long publisherId;
    private List<Long> authorIds;

    public Book(Long id, String title, String isbn, String synopsis, Integer publicationYear,
                Integer pageCount, Long categoryId, Long publisherId, List<Long> authorIds) {
        this.id = id;
        setTitle(title);
        setIsbn(isbn);
        this.synopsis = synopsis;
        this.publicationYear = publicationYear;
        this.pageCount = pageCount;
        this.categoryId = categoryId;
        this.publisherId = publisherId;
        this.authorIds = authorIds;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getIsbn() { return isbn; }
    public String getSynopsis() { return synopsis; }
    public Integer getPublicationYear() { return publicationYear; }
    public Integer getPageCount() { return pageCount; }
    public Long getCategoryId() { return categoryId; }
    public Long getPublisherId() { return publisherId; }
    public List<Long> getAuthorIds() { return authorIds; }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title is required");
        }
        this.title = title;
    }
    public void setIsbn(String isbn) {
        if (isbn != null && !isbn.matches("^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$")) {
            throw new IllegalArgumentException("ISBN format is invalid");
        }
        this.isbn = isbn;
    }
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }
    public void setAuthorIds(List<Long> authorIds) {
        this.authorIds = authorIds;
    }
}