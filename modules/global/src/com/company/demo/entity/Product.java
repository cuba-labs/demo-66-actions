package com.company.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|title")
@Table(name = "DEMO_PRODUCT")
@Entity(name = "demo$Product")
public class Product extends StandardEntity {
    private static final long serialVersionUID = -3110588856018104803L;

    @NotNull
    @Column(name = "TITLE", nullable = false)
    protected String title;

    @Column(name = "SUMMARY")
    protected String summary;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }


}