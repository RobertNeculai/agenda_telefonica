package org.fasttrackit.transfer;

import java.time.LocalDate;
import java.util.StringJoiner;

public class CreateAgendaRequest {

    // DTO (Data transfer Object)
    private String last_name;
    private String first_name;
    private String phonenumber;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String telefon) {
        this.phonenumber = telefon;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CreateAgendaRequest.class.getSimpleName() + "[", "]")
                .add("prenume='" + first_name + "'")
                .add("nume='" + last_name + "'")
                .add("telefon=" + phonenumber)
                .add("email=" + email)
                .toString();
    }
}
