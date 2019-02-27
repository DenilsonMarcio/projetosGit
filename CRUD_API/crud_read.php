<?php
include('db_valores.php');

$conexao = mysqli_connect($servidor, $usuario, $senha, $bdados);

$crud_id=$_GET['ID_crud'];

$gravacoes = mysqli_query($conexao,"select * from crud_cadastro where ID_crud=".$crud_id);

$dados = array();

while($linha = mysqli_fetch_assoc($gravacoes))
{
    $dados[] = $linha; 
}

echo json_encode($dados);

mysqli_close($conexao);

?>