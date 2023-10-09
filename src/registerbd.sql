-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 09-10-2023 a las 02:17:48
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `registerbd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `code` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `area` varchar(30) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `department`
--

INSERT INTO `department` (`code`, `name`, `area`) VALUES
('159', 'sistemas', 'Programacion'),
('359', 'ingenieria', 'Programacion'),
('dep123', 'psicologo', 'talento humano');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `leader`
--

DROP TABLE IF EXISTS `leader`;
CREATE TABLE IF NOT EXISTS `leader` (
  `code` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `cod_department` varchar(30) NOT NULL,
  `hiring_date` varchar(30) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `leader`
--

INSERT INTO `leader` (`code`, `name`, `cod_department`, `hiring_date`) VALUES
('1547', 'Jhon', '359', '10/08/2021'),
('2598', 'Adriana', '159', '01/08/2021'),
('5785', 'Andres', '159', '01/01/2019'),
('7889', 'Camilo', '359', '10/08/2021'),
('lea123', 'Johan', 'dep123', '07/10/2023');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `code` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `code_leader` varchar(30) NOT NULL,
  `responsibility` varchar(30) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`code`, `name`, `code_leader`, `responsibility`) VALUES
('100456', 'Michael', '1547', 'Desarrollador'),
('10064', 'Johan', '5785', 'Desarrollador'),
('100646', 'Eduardo', '2598', 'Lider'),
('user123', 'Andres', 'lea123', 'Desarrollador');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
