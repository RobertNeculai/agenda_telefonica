package org.fasttrackit.persistance;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.fasttrackit.Domain.Agenda;
import org.fasttrackit.transfer.CreateAgendaRequest;
import org.fasttrackit.transfer.UpdateAgendaRequest;

public class AgendaRepository {

        public void createContact(CreateAgendaRequest request) throws IOException, SQLException, ClassNotFoundException {
            // preventing SQL injection by avoiding concatanation using preparedStatement
            String sql="INSERT INTO agenda (nume,prenume,telefon ) VALUES (?,?,?)";
            try(Connection connection=DatabaseConfiguration.getConnection();
                PreparedStatement preparedStatement=connection.prepareStatement(sql)){
                preparedStatement.setString(1,request.getNume());
                preparedStatement.setString(2,request.getPrenume());
                preparedStatement.setString(3, request.getTelefon());
                preparedStatement.executeUpdate();
            }
        }
        public void updateContact(long id,UpdateAgendaRequest request) throws IOException, SQLException, ClassNotFoundException {
            // preventing SQL injection by avoiding concatanation using preparedStatement
            String sql="UPDATE agenda SET telefon=? WHERE id= ?";
            try(Connection connection=DatabaseConfiguration.getConnection();
                PreparedStatement preparedStatement=connection.prepareStatement(sql)){
                preparedStatement.setString(1, request.getTelefon());
                preparedStatement.setLong(2, id);
                preparedStatement.executeUpdate();
            }
        }
        public void deleteContact(long id) throws IOException, SQLException, ClassNotFoundException {
            // preventing SQL injection by avoiding concatanation using preparedStatement
            String sql="DELETE FROM agenda WHERE id= ?";
            try(Connection connection=DatabaseConfiguration.getConnection();
                PreparedStatement preparedStatement=connection.prepareStatement(sql)){
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
            }
        }
        public List<Agenda> getContact() throws IOException, SQLException, ClassNotFoundException {
            String sql=" SELECT id, nume, prenume, telefon FROM agenda";
            try(Connection connection=DatabaseConfiguration.getConnection();
                // Statement used only for no parameter queries
                Statement statement= connection.createStatement();
                ResultSet resultSet= statement.executeQuery(sql)) {
                List<Agenda> agenda=new ArrayList<>();
                while(resultSet.next()){
                    Agenda contact=new Agenda();
                    contact.setId(resultSet.getLong("id"));
                    contact.setNume(resultSet.getString("nume"));
                    contact.setPrenume(resultSet.getString("prenume"));
                    contact.setTelefon(resultSet.getString("telefon"));
                    agenda.add(contact);
                }
                return agenda;
            }
        }

    }
