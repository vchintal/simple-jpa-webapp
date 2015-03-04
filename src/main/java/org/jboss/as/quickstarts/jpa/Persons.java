package org.jboss.as.quickstarts.jpa;

import java.io.IOException;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.as.quickstarts.jpa.model.Person;

/**
 * Servlet implementation class Persons
 */
@WebServlet("/persons")
public class Persons extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "persons")
    EntityManager em;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Persons() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        Query q = em.createQuery("select p from Person p");
        List<Person> persons = q.getResultList();
        for (Person person : persons) {
            response.getWriter().println(person);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    }

}
