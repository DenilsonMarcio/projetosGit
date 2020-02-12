<?php
include('db_valores.php');

$conexao = mysqli_connect($servidor, $usuario, $senha, $bdados);

$crud_id=$_GET['ID_crud']; 
$crud_nome=$_GET['CRUD_Nome'];
$crud_contato=$_GET['CRUD_Contato'];
$crud_email=$_GET['CRUD_Email'];
$crud_historia=$_GET['CRUD_Historia'];

$consulta = "update crud_cadastro set CRUD_Nome=".$crud_nome.", CRUD_Contato=".$crud_contato.", CRUD_Email=".$crud_email.", CRUD_Historia=".$crud_historia." where ID_crud=".$crud_id."";

if(mysqli_query($conexao, $consulta))
{
     echo "Atualizado com successo!";
}
else
{
     echo "Não foi possível atualizar o cadastro.";
	 echo "***********************************";
	 echo mysqli_error($conexao);
}

mysqli_close($conexao);

?>