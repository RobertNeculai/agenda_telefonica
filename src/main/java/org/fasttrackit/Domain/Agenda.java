package org.fasttrackit.Domain;

import java.util.StringJoiner;

public class Agenda {
        private long id;
        private String nume;
        private String prenume;
        private String telefon;

        public long getId() {
            return id;
        }

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

    public void setId(long id) {
            this.id = id;
        }


    @Override
    public String toString() {
        return new StringJoiner(", ", Agenda.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nume='" + nume + "'")
                .add("prenume='" + prenume + "'")
                .add("telefon=" + telefon)
                .toString();
    }

    }
