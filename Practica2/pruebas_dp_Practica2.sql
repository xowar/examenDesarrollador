-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-07-2022 a las 16:44:31
-- Versión del servidor: 8.0.30
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pruebas_dp`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `ListarDatosUnidos` (IN `_id` VARCHAR(8))   SELECT
	p.id as 'Id',
	CONCAT(P.nombre, ' ', P.appaterno, ' ', P.apmaterno) as 'Nombre Completo',
    A.calle as 'Calle',
  	A.numero as 'Numero de Casa',
  	A.colonia as 'Colonia'
FROM persons as P
JOIN addresses as A on P.id = A.id
JOIN distributors as D on P.id = D.id
WHERE P.id = _id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ListarTodo` ()   SELECT
	p.id as 'Id',
	CONCAT(P.nombre, ' ', P.appaterno, ' ', P.apmaterno) as 'Nombre Completo',
    A.calle as 'Calle',
  	A.numero as 'Numero de Casa',
  	A.colonia as 'Colonia'
FROM persons as P
JOIN addresses as A on P.id = A.id
JOIN distributors as D on P.id = D.id$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `addresses`
--

CREATE TABLE `addresses` (
  `id` varchar(8) DEFAULT NULL,
  `calle` varchar(30) DEFAULT NULL,
  `numero` varchar(8) DEFAULT NULL,
  `colonia` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `addresses`
--

INSERT INTO `addresses` (`id`, `calle`, `numero`, `colonia`) VALUES
('MAPF1234', 'ASOCIACION', '213', 'PUESTA DEL SOL'),
('EOU', 'OSO', '452', 'ALARCON'),
('ERL4513', 'UNION', '4512', 'VILLA VERDE'),
('AAR4518', 'TULIPAN', '9885', 'REAL DEL VALLE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distributors`
--

CREATE TABLE `distributors` (
  `id` varchar(8) DEFAULT NULL,
  `fecharegistro` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `distributors`
--

INSERT INTO `distributors` (`id`, `fecharegistro`) VALUES
('MAPF1234', '2022-07-30'),
('EOU', '2022-07-30'),
('ERL4513', '2022-07-30'),
('AAR4518', '2022-07-30');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persons`
--

CREATE TABLE `persons` (
  `id` varchar(8) DEFAULT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `appaterno` varchar(30) DEFAULT NULL,
  `apmaterno` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `persons`
--

INSERT INTO `persons` (`id`, `nombre`, `appaterno`, `apmaterno`) VALUES
('MAPF1234', 'MARIO ALBERTO', 'PEÑUELAS', 'FERNANDEZ'),
('EOU', 'EDGAR', 'ONTIVEROS', 'URENDA'),
('ERL4513', 'EDUARDO', 'RODRIGEZ', 'LIZARRAGA'),
('AAR4518', 'ABIGAIL', 'AGUILAR', 'ROBLES');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
