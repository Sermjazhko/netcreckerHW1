package com.netcracker.part1;

import java.util.Objects;

public class Author {
    private String name;
    private String email;
    private char gender;

    public Author(){}

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Author[" +
                "name='" + name  +
                ", email='" + email +
                ", gender=" + gender +
                ']';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Author author = (Author) obj;

        return gender == author.gender && this.name.equals(author.name) && this.email.equals(author.email);
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = result*31 + name.hashCode();
        result = result*31 + email.hashCode();
        result = result*31 + (int)gender;

        return result;
    }
}
