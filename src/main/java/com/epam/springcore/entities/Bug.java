package com.epam.springcore.entities;

import java.util.Objects;

public class Bug {
    private String id;
    private String description;
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bug bug = (Bug) o;
        return id.equals(bug.id) &&
                description.equals(bug.description) &&
                userId.equals(bug.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, userId);
    }
}
