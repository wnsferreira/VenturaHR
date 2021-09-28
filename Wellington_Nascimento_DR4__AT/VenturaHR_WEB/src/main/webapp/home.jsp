<%-- 
    Document   : home
    Created on : 16 de ago de 2021, 09:37:18
    Author     : welli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<head>
<!--<form class="form-inline" action="j_security_check" method="post">-->
<form class="form-inline" action="usuarios" method="post">

        <h2>Ventura HR</h2>
        <br>
        <div class="form-group">
          
          <label for="email">Email address:</label>
<!--          <input type="email" name="j_username" class="form-control" id="email">-->
                <input type="email" value="joao@teste.com" name="email" id="username" class="form-control">
        </div>
        <div class="form-group">
           
            <label for="pwd">Password:</label>
<!--            <input type="password" name="j_password" class="form-control" id="pwd">-->
                <input type="text" value="123" name="senha" id="password" class="form-control">
        </div>
             
        <button type="submit" class="btn btn-default">Entrar</button>
        <br>
        <div class="container">
            <h2>Criar conta</h2>
            <div class="btn-group btn-group-justified">
                <a href="cadastro_candidato.jsp" class="btn btn-default">Candidato</a>
                <a href="cadastro_empresa.jsp" class="btn btn-default">Empresa</a>
                <a href="cadastro_administrador.jsp" class="btn btn-default">Administrador</a>
            </div>
        </div>
    </form>
</html>