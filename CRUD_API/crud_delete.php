<?php
include('db_valores.php');

$conexao = mysqli_connect($servidor, $usuario, $senha, $bdados);

$crud_id=$_GET['ID_crud'];

$consulta = "delete from crud_cadastro where ID_crud=".$crud_id."";

if(mysqli_query($conexao, $consulta))
{
     echo "Excluido do banco de dados!";
}
else
{
	echo "Erro ao excluir os dado!";
	echo "***********************************";
    echo mysqli_error($conexao);
	
}

mysqli_close($conexao);

?>