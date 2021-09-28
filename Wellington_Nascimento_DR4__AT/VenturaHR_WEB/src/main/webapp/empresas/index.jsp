
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <form action="usuario/login" method="GET">
            <h2>Empresa</h2>
            <h2>Cadastrar Vagas</h2>
            <h2>Bem Vindo, ${usuario.nome}!</h2>

            <c:if test="${empty vagas}">
                <h2>No momento não há vagas</h2>
            </c:if>

            <c:if test="${not empty vagas}">
                <table border="1" cellpadding="3" cellspacing="0">
                    <tr>
                        <th>Cargo</th>
                        <th>Cidade</th>
                        <th>Critérios</th>
                    </tr>
                    <c:forEach var="vaga" items="${vagas}">
                        <tr>
                            <td>${vaga.cargo}</td>
                            <td>${vaga.cidade}</td>
                            <td>
                                <c:forEach var="criterio" items="${vaga.criterioList}">
                                    ${criterio.descricao}<br />

                                </c:forEach>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="container-fluid">

                    <input type="button" value="Publicar Vaga" onclick="document.location='empresas/publicarVaga.jsp'">
   
                </div>
            </c:if>
        </form>
    </body>
</html>
