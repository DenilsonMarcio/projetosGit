-- OPCIONAL
CREATE DATABASE IF NOT EXISTS --Nome do seu banco-- ;
USE --Nome do seu banco-- ;
-- OPCIONAL

CREATE TABLE `crud_cadastro` (
  `ID_crud` int(11) NOT NULL,
  `CRUD_Nome` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `CRUD_Contato` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `CRUD_Email` varchar(50) COLLATE latin1_general_ci,
  `CRUD_Historia` varchar(255) COLLATE latin1_general_ci
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

ALTER TABLE `crud_cadastro`
  ADD PRIMARY KEY (`ID_crud`);


ALTER TABLE `crud_cadastro`
  MODIFY `ID_crud` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;


SET @@auto_increment_increment=1;

