package org.fasttrackit.transfer;

import java.time.LocalDate;
import java.util.StringJoiner;

public class UpdateAgendaRequest {


    // DTO (Data transfer Object)

        private String nume;
        private String prenume;
        private String telefon;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UpdateAgendaRequest.class.getSimpleName() + "[", "]")
                .add("nume='" + nume + "'")
                .add("prenume='" + prenume + "'")
                .add("telefon=" + telefon)
                .toString();
    }
}
