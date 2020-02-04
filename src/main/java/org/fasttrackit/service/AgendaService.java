package org.fasttrackit.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.fasttrackit.Domain.Agenda;
import org.fasttrackit.persistance.AgendaRepository;
import org.fasttrackit.transfer.CreateAgendaRequest;
import org.fasttrackit.transfer.UpdateAgendaRequest;

public class AgendaService {

        private AgendaRepository agendaRepository=new AgendaRepository();

        public void createContact(CreateAgendaRequest request) throws IOException, SQLException, ClassNotFoundException {
            System.out.println("Creating contact: "+request);
            agendaRepository.createContact(request);
            //apply business logic in service layer
        }
        public void UpdateContact(long id,UpdateAgendaRequest request) throws IOException, SQLException, ClassNotFoundException {
            System.out.println("Update contact: "+id+": "+request);
            agendaRepository.updateContact(id,request);
        }
        public void deleteContact(long id) throws IOException, SQLException, ClassNotFoundException {
            System.out.println("Deleting contact: "+id);
            agendaRepository.deleteContact(id);
        }
        public List<Agenda> getContacts() throws IOException, SQLException, ClassNotFoundException {
            System.out.println("List of contacts: ");
            return agendaRepository.getContact();
        }


    }
