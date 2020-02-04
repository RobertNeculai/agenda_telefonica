package org.fasttrackit.transfer;

import java.time.LocalDate;
import java.util.StringJoiner;

public class CreateAgendaRequest {

    // DTO (Data transfer Object)
        private String nume;
        private String prenume;
        private String telefon;

        public String getPrenume() {
            return prenume;
        }

        public void setPrenume(String prenume) {
            this.prenume = prenume;
        }

        public String getNume() {
            return nume;
        }

        public void setNume(String nume) {
            this.nume = nume;
        }

        public String getTelefon() {
            return telefon;
        }

        public void setTelefon(String telefon) {
            this.telefon = telefon;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", CreateAgendaRequest.class.getSimpleName() + "[", "]")
                    .add("prenume='" + prenume + "'")
                    .add("nume='" + nume + "'")
                    .add("telefon=" + telefon)
                    .toString();
        }
    }
