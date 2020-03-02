package org.fasttrackit.persistance;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.fasttrackit.Domain.AgendaItem;
import org.fasttrackit.transfer.CreateAgendaRequest;
import org.fasttrackit.transfer.GetAgendaRequest;
import org.fasttrackit.transfer.UpdateAgendaRequest;

public class AgendaRepository {

        public void createContact(CreateAgendaRequest request) throws IOException, SQLException, ClassNotFoundException {
            // preventing SQL injection by avoiding concatanation using preparedStatement
            String sql="INSERT INTO agenda (last_name,first_name,phonenumber ) VALUES (?,?,?)";
            try(Connection connection=DatabaseConfiguration.getConnection();
                PreparedStatement preparedStatement=connection.prepareStatement(sql)){
                preparedStatement.setString(1,request.getLast_name());
                preparedStatement.setString(2,request.getFirst_name());
                preparedStatement.setString(3, request.getPhonenumber());
                preparedStatement.executeUpdate();
            }
        }
        public void updateContact(long id,UpdateAgendaRequest request) throws IOException, SQLException, ClassNotFoundException {
            // preventing SQL injection by avoiding concatanation using preparedStatement
            String sql="UPDATE agenda SET phonenumber=? WHERE id= ?";
            try(Connection connection=DatabaseConfiguration.getConnection();
                PreparedStatement preparedStatement=connection.prepareStatement(sql)){
                preparedStatement.setString(1, request.getPhonenumber());
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
        public List<AgendaItem>getContact(GetAgendaRequest request) throws IOException, SQLException, ClassNotFoundException
        {
            String sql="SELECT id, last_name, first_name, phonenumber FROM agenda WHERE first_name LIKE ?";
            try(Connection connection=DatabaseConfiguration.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(sql))
            {
            preparedStatement.setString(1,request.getFirst_name());
                ResultSet resultSet= preparedStatement.executeQuery();
                List<AgendaItem> agenda=new ArrayList<>();
                while(resultSet.next()){
                    AgendaItem contact=new AgendaItem();
                    contact.setId(resultSet.getLong("id"));
                    contact.setLast_name(resultSet.getString("last_name"));
                    contact.setFirst_name(resultSet.getString("first_name"));
                    contact.setPhonenumber(resultSet.getString("phonenumber"));
                    agenda.add(contact);
                }
                return agenda;
            }
        }
        public List<AgendaItem> getContacts() throws IOException, SQLException, ClassNotFoundException {
            String sql=" SELECT id, last_name, first_name, phonenumber FROM agenda";
            try(Connection connection=DatabaseConfiguration.getConnection();
                // Statement used only for no parameter queries
                Statement statement= connection.createStatement();
                ResultSet resultSet= statement.executeQuery(sql)) {
                List<AgendaItem> agenda=new ArrayList<>();
                while(resultSet.next()){
                    AgendaItem contact=new AgendaItem();
                    contact.setId(resultSet.getLong("id"));
                    contact.setLast_name(resultSet.getString("last_name"));
                    contact.setFirst_name(resultSet.getString("first_name"));
                    contact.setPhonenumber(resultSet.getString("phonenumber"));
                    agenda.add(contact);
                }
                return agenda;
            }
        }

    }
