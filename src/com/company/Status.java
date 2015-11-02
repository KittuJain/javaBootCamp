package com.company;

public class Status {
    private String message;

    public Status(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status that = (Status) o;

        return message.equals(that.message);

    }

    @Override
    public int hashCode() {
        return message.hashCode();
    }
}
