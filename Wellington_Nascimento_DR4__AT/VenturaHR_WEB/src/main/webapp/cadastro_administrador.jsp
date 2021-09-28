<%-- 
    Document   : cadastro
    Created on : 17 de ago de 2021, 09:35:12
    Author     : welli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <title>Cadastro de candidato</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<head>
<body>
    
       
    <form action="/usuarios/criarConta" method="post">
        <div class="container text-center">
            <h2>Cadastro candidato</h2>
        </div>
        <br>
        <div class="container">
            <label for="nome">Nome:</label>
            <input type="text" class="form-control" placeholder="Entre com o Nome" name="nome">
        </div>
        <br>
        <div class="container">
            <label for="nome">Endereço</label>
            <input type="text" class="form-control" placeholder="Entre com o Nome" name="endereco">
        </div>
        <br>
                
        <div class="container">
            <label for="cpf">Telefone:</label>
            <input type="text" class="form-control" placeholder="Entre com o CPF" name="telefone">
        </div>
        <br>        
        <br>
        <div class="container">
            <label for="email">Email:</label>
            <input type="email" class="form-control" placeholder="Entre com o E-mail" name="email">
        </div>
        <br>
        <div class="container">
            <label for="senha">Senha:</label>
            <input type="password" class="form-control" placeholder="Entre com a senha" name="senha">
        </div>
          <br>
         <div class="container">
            <label for="email">Cpf:</label>
            <input type="text" class="form-control" placeholder="Entre com o E-mail" name="cpf">
        </div>
            <br>
         <div class="container">
            <label for="email">Razão Social:</label>
            <input type="text" class="form-control" placeholder="Entre com o E-mail" name="razaoSocial">
        </div>
            <br>
        <div class="container">
            <label for="email">Cnpj;</label>
            <input type="text" class="form-control" placeholder="Entre com o E-mail" name="cnpj">
        </div>
        <br>
        <div class="container">
                <button type="submit" class="btn btn-primary btn-block">Enviar</button>
        </div>
    </form>
</body>
<html>