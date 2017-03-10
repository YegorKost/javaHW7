package com.yegor.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by YegorKost on 06.03.2017.
 */

public class Student implements Serializable{
    private Integer id;
    private String name;
    private String surname;
    private Long phone_number;
    private LocalDate birthday;
    private String email;

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!id.equals(student.id)) return false;
        if (!name.equals(student.name)) return false;
        if (!surname.equals(student.surname)) return false;
        if (phone_number != null ? !phone_number.equals(student.phone_number) : student.phone_number != null)
            return false;
        if (birthday != null ? !birthday.equals(student.birthday) : student.birthday != null) return false;
        return email != null ? email.equals(student.email) : student.email == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + (phone_number != null ? phone_number.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone_number=" + phone_number +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                '}';
    }
}
