package org.fasttrackit.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.config.ObjectMapperConfiguration;
import org.fasttrackit.service.AgendaService;
import org.fasttrackit.transfer.CreateAgendaRequest;
import org.fasttrackit.transfer.UpdateAgendaRequest;

    @WebServlet("/contacts")
    public class AgendaServlet extends HttpServlet {
        private AgendaService agendaService=new AgendaService();
        //EndPoint
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            CreateAgendaRequest request= ObjectMapperConfiguration.objectMapper.readValue(req.getReader(),CreateAgendaRequest.class);

            try {
                agendaService.createContact(request);
            } catch (SQLException | ClassNotFoundException e) {
                resp.sendError(500,"Internal server error: "+e.getMessage());
            }
        }
        // Endpoint Delete
        @Override
        protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String id=req.getParameter("id");
            try {
                agendaService.deleteContact(Long.parseLong(id));
            } catch (SQLException | ClassNotFoundException e) {
                resp.sendError(500,"Internal server error: "+e.getMessage());
            }
        }

        @Override
        protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String id = req.getParameter("id");
            UpdateAgendaRequest request= ObjectMapperConfiguration.objectMapper.readValue(req.getReader(),UpdateAgendaRequest.class);
            try {
                agendaService.UpdateContact(Long.parseLong(id),request);
            } catch (SQLException | ClassNotFoundException e) {
                resp.sendError(500, "Internal server error: " + e.getMessage());
            }
        }
        //Endpoint Update
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            CreateAgendaRequest request= ObjectMapperConfiguration.objectMapper.readValue(req.getReader(),CreateAgendaRequest.class);
            try {
                ObjectMapperConfiguration.objectMapper.writeValue(resp.getWriter(),agendaService.getContacts());
            } catch (SQLException | ClassNotFoundException e) {
                resp.sendError(500, "Internal server error: " + e.getMessage());
            }
        }
    }
