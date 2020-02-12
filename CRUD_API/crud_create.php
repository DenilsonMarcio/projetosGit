<?php

include('db_valores.php');

$conexao = mysqli_connect($servidor, $usuario, $senha, $bdados);
	

$crud_nome=$_GET['CRUD_Nome'];
$crud_contato=$_GET['CRUD_Contato'];
$crud_email=$_GET['CRUD_Email'];
$crud_historia=$_GET['CRUD_Historia'];

$consulta = "insert into crud_cadastro (CRUD_Nome, CRUD_Contato, CRUD_Email, CRUD_Historia ) values (".$crud_nome.",".$crud_contato.",".$crud_email.",".$crud_historia.")";

if(mysqli_query($conexao, $consulta))
{
     echo "Cadastro realizado com sucesso!";
}
else
{
     echo "Não foi possível realizar o cadastro!";
	 echo "***********************************";
     echo mysqli_error($conexao);
}

mysqli_close($conexao);

?>