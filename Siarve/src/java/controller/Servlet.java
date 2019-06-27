/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author carlosfernandes
 */
import dao.AgendamentoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.EstudanteDAO;
import model.Estudante;

import dao.AgendamentoDAO;
import model.Agendamento;

import dao.UsuarioDAO;
import model.Usuario;

import dao.LoginDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

@WebServlet("/")
public class Servlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private EstudanteDAO estudanteDao;
    private AgendamentoDAO agendamentoDao;
    private UsuarioDAO usuarioDao;
    private LoginDAO login;

    public void init() {
        estudanteDao = new EstudanteDAO();
        agendamentoDao = new AgendamentoDAO();
        usuarioDao = new UsuarioDAO();
        login = new LoginDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");

        if (email != null) {
            try {
                switch (action) {
                    case "/estudantenew":

                        showNewForm(request, response);
                        break;
                    case "/estudanteinsert":
                        insertEstudante(request, response);
                        break;
                    case "/estudantedelete":
                        deleteEstudante(request, response);
                        break;
                    case "/estudanteedit":
                        showEditForm(request, response);
                        break;
                    case "/estudantepdate":
                        updateEstudante(request, response);
                        break;
                    case "/estudantelist":
                        listEstudante(request, response);
                        break;
//+++++++++++++++++++++++++++++++++++Agendamento+++++++++++++++++++++++++++++++++
                    case "/agendamentonew":
                        agendamentoshowNewForm(request, response);
                        break;
                    case "/agendamentoinsert":
                        agendamentoinsert(request, response);
                        break;
                    case "/agendamentodelete":
                        agendamentodelete(request, response);
                        break;
                    case "/agendamentoedit":
                        agendamentoshowEditForm(request, response);
                        break;
                    case "/agendamentoupdate":
                        agendamentoupdate(request, response);
                        break;

                    case "/agendamentolist":
                        listAgendamento(request, response);
                        break;
//+++++++++++++++++++++++++++++++++++Usuario+++++++++++++++++++++++++++++++++

                    case "/usernew":
                        usershowNewForm(request, response);
                        break;
                    case "/userinsert":
                        userinsert(request, response);
                        break;
                    case "/userdelete":
                        userdelete(request, response);
                        break;
                    case "/useredit":
                        usershowEditForm(request, response);
                        break;
                    case "/userupdate":
                        userupdate(request, response);
                        break;

                    case "/usertolist":
                        listuser(request, response);
                        break;

                    case "/logoult":
                        logoult(request, response);
                        break;

                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }

        } else {
            try {
                Login(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            //response.sendRedirect("index.jsp");
            //response.sendRedirect("index.jsp");
        }
    }

    private void listEstudante(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Estudante> listEstudante = estudanteDao.selectAllEstudante();
        request.setAttribute("listEstudante", listEstudante);
        RequestDispatcher dispatcher = request.getRequestDispatcher("estudante-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("estudante-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Estudante exiistEstudante = estudanteDao.selectEstudante(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("estudante-form.jsp");
        request.setAttribute("estudante", exiistEstudante);
        dispatcher.forward(request, response);

    }

    private void insertEstudante(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nome = request.getParameter("nome");
        String rne = request.getParameter("rne");
        String passaport = request.getParameter("passaport");
        String pais = request.getParameter("pais");
        String endereco_atual = request.getParameter("endereco_atual");
        String data_entrada = request.getParameter("data_entrada");
        Estudante estudantes = new Estudante(nome, rne, passaport, pais, endereco_atual, data_entrada);
        estudanteDao.insertEstudante(estudantes);
        response.sendRedirect("estudantelist");
    }

    private void updateEstudante(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String rne = request.getParameter("rne");
        String passaport = request.getParameter("passaport");
        String pais = request.getParameter("pais");
        String endereco_atual = request.getParameter("endereco_atual");
        String data_entrada = request.getParameter("data_entrada");

        Estudante estudantes = new Estudante(id, nome, rne, passaport, pais, endereco_atual, data_entrada);
        estudanteDao.updateEstudante(estudantes);
        response.sendRedirect("estudantelist");
    }

    private void deleteEstudante(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        estudanteDao.deleteEstudante(id);
        System.out.println("carlos : " + estudanteDao.deleteEstudante(id));
        response.sendRedirect("estudantelist");

    }

    //+++++++++++++++++++++++++++++Agendamento++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private void listAgendamento(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Agendamento> listAgendamento = agendamentoDao.selectAllEstudante();
        request.setAttribute("listAgendamento", listAgendamento);
        RequestDispatcher dispatcher = request.getRequestDispatcher("agendamento-list.jsp");
        dispatcher.forward(request, response);
    }

    private void agendamentoshowNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("agendamento-form.jsp");
        dispatcher.forward(request, response);
    }

    private void agendamentoshowEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Agendamento exiistAgendamento = agendamentoDao.selectAgendamento(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("agendamento-form.jsp");
        //System.out.println("exiistAgendamento");
        request.setAttribute("agendamento", exiistAgendamento);
        dispatcher.forward(request, response);

    }

    private void agendamentoinsert(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nome = request.getParameter("nome");
        String rne = request.getParameter("rne");
        String codigo = request.getParameter("codigo");

        String data_agendamento = request.getParameter("data_agendamento");
        Agendamento agendamento = new Agendamento(nome, rne, codigo, data_agendamento);
        agendamentoDao.insertAgendamento(agendamento);
        response.sendRedirect("agendamentolist");
    }

    private void agendamentoupdate(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String rne = request.getParameter("rne");
        String codigo = request.getParameter("codigo");
        String data_agendamento = request.getParameter("data_agendamento");

        Agendamento agendamento = new Agendamento(id, nome, rne, codigo, data_agendamento);
        agendamentoDao.updateEstudante(agendamento);
        response.sendRedirect("agendamentolist");
    }

    private void agendamentodelete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        agendamentoDao.deleteAgendamento(id);
        //System.out.println("carlos : " + estudanteDao.deleteEstudante(id));
        response.sendRedirect("agendamentolist");

    }

    //++++++++++++++++++++++++++++++++++++++++Usuario+++++++++++++++++++++++++++++++++++++++++++++
    private void listuser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        List<Usuario> listUsuario = usuarioDao.selectAllUsers();
        request.setAttribute("listUsuario", listUsuario);
        request.setAttribute("session", (String) session.getAttribute("email"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }

    private void usershowNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }

    private void usershowEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Usuario exiistUsuario = usuarioDao.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        // System.out.println("exiistUsuario");
        request.setAttribute("usuario", exiistUsuario);
        dispatcher.forward(request, response);

    }

    private void userinsert(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String setor = request.getParameter("setor");
        String senha = request.getParameter("senha");

        Usuario usuario = new Usuario(name, email, setor, senha);
        usuarioDao.insertUser(usuario);
        response.sendRedirect("usertolist");
    }

    private void userupdate(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String setor = request.getParameter("setor");
        String senha = request.getParameter("senha");

        Usuario usuario = new Usuario(id, name, email, setor, senha);
        usuarioDao.updateUser(usuario);
        response.sendRedirect("usertolist");
    }

    private void userdelete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        usuarioDao.deleteUser(id);
        //System.out.println("carlos : " + estudanteDao.deleteEstudante(id));
        response.sendRedirect("usertolist");

    }

    //++++++++++++++++++++++++++++LOGIN+++++++++++++++++++++++++++++
    private void Login(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if (email != null && senha != null) {
            if (login.login(email, senha)) {
                HttpSession sessao = request.getSession();
                sessao.setAttribute("email", email);
                response.sendRedirect("agendamentolist");
            } else {
                request.setAttribute("erro", 0);
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            response.sendRedirect("index.jsp");
        }

    }

    private void logoult(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("index.jsp");
    }
}
