package org.fasttrackit.transfer;

import java.util.StringJoiner;

public class GetAgendaRequest {

        // DTO (Data transfer Object)

        private String last_name;
        private String first_name;
        private String phonenumber;

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

        @Override
        public String toString() {
            return new StringJoiner(", ", org.fasttrackit.transfer.GetAgendaRequest.class.getSimpleName() + "[", "]")
                    .add("nume='" + last_name + "'")
                    .add("prenume='" + first_name + "'")
                    .add("telefon=" + phonenumber)
                    .toString();
        }
    }