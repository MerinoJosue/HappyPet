-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-05-2024 a las 18:16:05
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `happypet_prueba`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `ID_Cita` int(11) UNSIGNED NOT NULL,
  `ID_Cliente` int(11) UNSIGNED NOT NULL,
  `ID_Mascota` int(11) UNSIGNED NOT NULL,
  `ID_Empleado` int(10) UNSIGNED NOT NULL,
  `Fecha` varchar(20) NOT NULL,
  `Hora` varchar(20) NOT NULL,
  `Motivo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `citas`
--

INSERT INTO `citas` (`ID_Cita`, `ID_Cliente`, `ID_Mascota`, `ID_Empleado`, `Fecha`, `Hora`, `Motivo`) VALUES
(1, 17, 1, 1, '', '', 'sfgsdfg'),
(2, 18, 1, 2, '2024-05-03', '23:14', 'cancer de teta'),
(3, 18, 1, 2, '2024-05-03', '23:14', 'cancer de teta'),
(4, 19, 4, 3, '2024-05-18', '02:20', 'no tiene rayas'),
(5, 17, 4, 1, '', '', 'no tiene rayas'),
(6, 20, 4, 2, '2024-05-23', '10:30', 'Cancer');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `Id_Cliente` int(11) UNSIGNED NOT NULL,
  `nombre` varchar(244) DEFAULT NULL,
  `dni` varchar(8) DEFAULT NULL,
  `apellido` varchar(244) DEFAULT NULL,
  `direccion` varchar(244) DEFAULT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  `Correo` varchar(244) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`Id_Cliente`, `nombre`, `dni`, `apellido`, `direccion`, `telefono`, `Correo`) VALUES
(17, 'Juan', '7657588', 'Guerrero Solis', 'Los Alamos', '987654345', 'juan@gmail.com'),
(18, 'Roberto', '7847368', 'Marquez', 'Los Andes', '989254345', 'Roberto@gmail.com'),
(19, 'Carla', '7947588', 'Bicaria ', 'Los Olivos', '987344345', 'Carla@gmail.com'),
(20, 'Jorge', '7687508', 'Chicana', 'Trapiche', '987601345', 'Jorge@gmail.com'),
(22, 'Paolo', '7897897', 'Suazo', 'Andrep_sm_31@gmail.com', '989788987', 'U20220915@utp.edu.pe');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_ventas`
--

CREATE TABLE `detalle_ventas` (
  `IdDetalleVentas` int(11) UNSIGNED NOT NULL,
  `IdVentas` int(11) UNSIGNED NOT NULL,
  `Id_Producto` int(11) UNSIGNED NOT NULL,
  `Cantidad` int(11) UNSIGNED DEFAULT NULL,
  `PrecioVenta` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `Id_Empleado` int(10) UNSIGNED NOT NULL,
  `Dni` varchar(8) NOT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Tel` varchar(9) DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL,
  `User` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`Id_Empleado`, `Dni`, `Nom`, `Tel`, `Estado`, `User`) VALUES
(1, '123', 'Juan Hernandez', '988252459', '1', 'juanito1'),
(2, '456', 'Cistiano Ronaldo', '988252459', '1', 'CR7'),
(3, '789', 'Chicana', '453536458', '1', 'chicanam');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascotas`
--

CREATE TABLE `mascotas` (
  `ID_Mascota` int(11) UNSIGNED NOT NULL,
  `ID_Cliente` int(11) UNSIGNED NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Especie` varchar(50) DEFAULT NULL,
  `Raza` varchar(50) DEFAULT NULL,
  `Edad` int(11) DEFAULT NULL,
  `Sexo` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mascotas`
--

INSERT INTO `mascotas` (`ID_Mascota`, `ID_Cliente`, `Nombre`, `Especie`, `Raza`, `Edad`, `Sexo`) VALUES
(1, 18, 'omunculo', NULL, NULL, NULL, NULL),
(2, 20, 'perro', NULL, NULL, NULL, NULL),
(3, 17, 'Gato\r\n', NULL, NULL, NULL, NULL),
(4, 18, 'Tigre', NULL, NULL, NULL, NULL),
(5, 17, 'Loro', NULL, NULL, NULL, NULL),
(6, 18, 'Leon', NULL, NULL, NULL, NULL),
(7, 19, 'Tortuga', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `Id_Producto` int(11) UNSIGNED NOT NULL,
  `Nombre` varchar(244) DEFAULT NULL,
  `Precio` double DEFAULT NULL,
  `Stock` int(11) UNSIGNED DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`Id_Producto`, `Nombre`, `Precio`, `Stock`, `Estado`) VALUES
(1, 'Canbo', 150, 99, '1'),
(2, 'Ricocan', 100, 98, '1'),
(3, 'Ricocat', 90, 100, '1'),
(4, 'Alkjoi', 110, 98, '1'),
(7, 'Dogshaw', 130, 35, '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `IdVentas` int(11) UNSIGNED NOT NULL,
  `Id_Cliente` int(11) UNSIGNED NOT NULL,
  `Id_Empleado` int(10) UNSIGNED NOT NULL,
  `NumeroSerie` varchar(244) DEFAULT NULL,
  `FechaVentas` date DEFAULT NULL,
  `Monto` double DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`ID_Cita`),
  ADD KEY `cita_ibfk_1` (`ID_Cliente`),
  ADD KEY `cita_ibfk_2` (`ID_Empleado`),
  ADD KEY `cita_ibfk_3` (`ID_Mascota`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`Id_Cliente`);

--
-- Indices de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD PRIMARY KEY (`IdDetalleVentas`,`IdVentas`,`Id_Producto`),
  ADD KEY `Ventas_has_Productos_FKIndex1` (`IdVentas`),
  ADD KEY `Ventas_has_Productos_FKIndex2` (`Id_Producto`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`Id_Empleado`);

--
-- Indices de la tabla `mascotas`
--
ALTER TABLE `mascotas`
  ADD PRIMARY KEY (`ID_Mascota`),
  ADD KEY `mascota_ibfk_1` (`ID_Cliente`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`Id_Producto`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`IdVentas`),
  ADD KEY `Ventas_FKIndex1` (`Id_Empleado`),
  ADD KEY `Ventas_FKIndex2` (`Id_Cliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `ID_Cita` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `Id_Cliente` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  MODIFY `IdDetalleVentas` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=155;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `Id_Empleado` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `mascotas`
--
ALTER TABLE `mascotas`
  MODIFY `ID_Mascota` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `Id_Producto` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `IdVentas` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=94;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `cita_ibfk_1` FOREIGN KEY (`ID_Cliente`) REFERENCES `cliente` (`Id_Cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `cita_ibfk_2` FOREIGN KEY (`ID_Empleado`) REFERENCES `empleado` (`Id_Empleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `cita_ibfk_3` FOREIGN KEY (`ID_Mascota`) REFERENCES `mascotas` (`ID_Mascota`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD CONSTRAINT `detalle_ventas_ibfk_1` FOREIGN KEY (`IdVentas`) REFERENCES `ventas` (`IdVentas`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `detalle_ventas_ibfk_2` FOREIGN KEY (`Id_Producto`) REFERENCES `productos` (`Id_Producto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `mascotas`
--
ALTER TABLE `mascotas`
  ADD CONSTRAINT `mascota_ibfk_1` FOREIGN KEY (`ID_Cliente`) REFERENCES `cliente` (`Id_Cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`Id_Empleado`) REFERENCES `empleado` (`Id_Empleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`Id_Cliente`) REFERENCES `cliente` (`Id_Cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
