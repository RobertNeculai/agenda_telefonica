package org.fasttrackit.Domain;

import java.util.StringJoiner;

public class Agenda {
        private long id;
    private String last_name;
    private String first_name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    private String phonenumber;




    @Override
    public String toString() {
        return new StringJoiner(", ", Agenda.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nume='" + last_name + "'")
                .add("prenume='" + first_name + "'")
                .add("telefon=" + phonenumber)
                .toString();
    }

    }
