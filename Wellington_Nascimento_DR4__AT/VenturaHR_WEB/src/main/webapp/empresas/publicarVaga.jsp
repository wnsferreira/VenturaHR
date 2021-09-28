<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!DOCTYPE html>
<html>
    <head>
    <body>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VenturaHR - Publicação de Vaga</title>
    </head>
    <body>    
        <h1>Publicação de Vaga</h1>
        
        <h3>Dados da Vaga:</h3>

        <form action="vagas"method="post">            
            <input type="hidden" name="op" value="cadastrarVaga">
<!--            <input type="hidden" name="op" value="cadastrarCriterio">-->
            
            <table border="1" cellpadding="3" cellspacing="0">
                <tr>
                    <td>Cargo:</td>
                    <td><input type="text" name="cargo" value="${vaga.cargo}"</td>
                </tr>
                <tr>
                    <td>Cidade:</td>
                    <td><input type="text" name="cidade" value="${vaga.cidade}"</td>
                </tr>
                <tr>
                    <td>Forma de Contratação:</td>
                    <td><input type="text" name="formaContratacao" value="${vaga.formaContratacao}"</td>
                </tr>
                <td colspan="2">
                    <input type="submit" value="Próximo >>" />
                </td>
            </table>
        </form>
                
        <c:if test="${not empty vaga}">
            
        <h3>Descrição dos Critérios</h3>
        <form action="vagas" method="post">
            <input type="hidden" name="op" value="cadastrarCriterio">
            <h3>Critérios:</h3>
            <table border="1" cellpadding="3" cellspacing="0">
                <tr>
                    <td>Descrição</td>
                    <td>Perfil</td>
                    <td>Peso</td>
                </tr>
                <tr>
                    <td><input type="text" name="descricao"/></td>
                    <td><input type="text" name="perfil"/></td>
                    <td><input type="text" name="peso"/></td>
                </tr>
                <c:forEach var="criterio" items="${criterios}">
                    <tr>
                        <td>${criterio.descricao}</td>
                        <td>${criterio.perfil}</td>
                        <td>${criterio.peso}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="3">
                        <input type="submit" value="Próximo >>" />
                    </td>
                </tr>
            </table>
           <!--            <input type="submit" name="op" value="publicarVaga" /> -->
            
        </form>
    
        </c:if>   
        
    </body>
</html>
