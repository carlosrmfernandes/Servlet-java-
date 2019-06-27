<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title></title>
    </head>
    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#apagar").on('click', function () {
                bootbox.alert("Nao e possivel apagar esse usuario, contactar a T.I");
                return false;
            });
        });
    </script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <body>
        <div class="col-md-12">
            <center>
                <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #1f3368;">
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: aliceblue;">
                                    <i class="fas fa-user-graduate" style="font-size:25px;"></i> Estudante
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="nav-item nav-link" href="estudantenew"><i class="fas fa-address-book"></i> Cadastro</a>
                                    <a class="nav-item nav-link" href="estudantelist"><i class="fas fa-list-ul"></i> Listagen</a>
                                </div>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: aliceblue;">
                                    <i class="fas fa-user-friends" style="font-size:25px;"></i> Usuarrio
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="nav-item nav-link" href="usernew"><i class="fas fa-address-book"></i> Cadastro</a>
                                    <a class="nav-item nav-link" href="usertolist"><i class="fas fa-list-ul"></i> Listagen</a>
                                </div>
                            </li>

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: aliceblue;">
                                    <i class="fas fa-calendar-alt" style="font-size:25px;"></i> Agendamento
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="nav-item nav-link" href="agendamentonew"><i class="fas fa-address-book"></i> Cadastro</a>
                                    <a class="nav-item nav-link" href="agendamentolist"><i class="fas fa-list-ul"></i> Listagen</a>
                                </div>
                            </li>
                        </ul>
                        <a class="btn btn-light" href="logoult" style="border-radius: 30px;">Sair</a>
                        <!--                        <form class="form-inline my-2 my-lg-0" action="showFilter" method="post">
                                                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="id">
                                                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                                                </form>-->
                    </div>
                </nav>
            </center>
            <div class="row">
                <div class="col-md-12 col-md-offset-1">
                    <div align="center">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col">Codigo</th>
                                    <th scope="col">Nome</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Setor</th>
                                    <th scope="col">Acao</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <c:forEach var="user" items="${listUsuario}">
                                    <tr>
                                        <td><c:out value="${user.id}" /></td>
                                        <td><c:out value="${user.name}" /></td>
                                        <td><c:out value="${user.email}" /></td>
                                        <td><c:out value="${user.setor}" /></td>
                                        <td>
                                            <c:if test="${session == user.email}">
                                                <a class="btn btn-primary" style="border-radius: 30px;" href="useredit?id=<c:out value='${user.id}' />">Editar</a>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
                                                <a class="btn btn-danger" id="apagar" style="border-radius: 30px;" href="userdelete?id=<c:out value='${user.id}' />">Apagar</a>                    	
                                            </c:if>

                                        </td>
                                    </tr>
                                </c:forEach>
                                </tr>
                            </tbody>
                        </table>
                    </div>	
                </div>
            </div>

        </div>

    </body>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>     
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/4.4.0/bootbox.js"></script>
</html>
