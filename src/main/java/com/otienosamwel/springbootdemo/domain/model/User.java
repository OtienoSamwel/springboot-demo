package com.otienosamwel.springbootdemo.domain.model;

import java.util.Objects;

public final class User {

    private final String FirstName;
    private final String LastName;
    private final int age;
    private final String occupation;

    public User(String firstName, String lastName, int age, String occupation) {
        FirstName = firstName;
        LastName = lastName;
        this.age = age;
        this.occupation = occupation;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(FirstName, user.FirstName) &&
                Objects.equals(LastName, user.LastName) &&
                Objects.equals(occupation, user.occupation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FirstName, LastName, age, occupation);
    }

    @Override
    public String toString() {
        return "User{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
