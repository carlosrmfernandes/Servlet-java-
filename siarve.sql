-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Tempo de geração: 27/06/2019 às 13:21
-- Versão do servidor: 5.7.25
-- Versão do PHP: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `siarve`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `agendamentos`
--

CREATE TABLE `agendamentos` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `rne` varchar(45) DEFAULT NULL,
  `codigo` varchar(45) DEFAULT NULL,
  `data_agendamento` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Despejando dados para a tabela `agendamentos`
--

INSERT INTO `agendamentos` (`id`, `nome`, `rne`, `codigo`, `data_agendamento`) VALUES
(22, 'Milton de Jesus', 'KI99-M', '8092382-901', '2019-07-06'),
(23, 'Rafael Francisco Fernandes', 'KI99-M0R23', '82372-1892A', '2019-07-06'),
(24, 'Clayton', 'UYO12', '26723-2373', '2019-07-18'),
(25, 'Iracema', 'Klw34', '23783278-12', '2019-06-28');

-- --------------------------------------------------------

--
-- Estrutura para tabela `estudantes`
--

CREATE TABLE `estudantes` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `rne` varchar(45) DEFAULT NULL,
  `passaport` varchar(45) DEFAULT NULL,
  `pais` varchar(45) DEFAULT NULL,
  `endereco_atual` varchar(45) DEFAULT NULL,
  `data_entrada` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Despejando dados para a tabela `estudantes`
--

INSERT INTO `estudantes` (`id`, `nome`, `rne`, `passaport`, `pais`, `endereco_atual`, `data_entrada`) VALUES
(12, 'Milton de Jesus', 'KI99-M', 'JK12OL', 'Angola', 'Santa Barbara', '2019-05-07'),
(13, 'Rafael Francisco Fernandes', 'KI99-M0R23', 'LO23IU', 'Angola', 'Santo Antonio', '2019-05-16'),
(14, 'Rosa Fernandes', 'UI8712', 'Hj123', 'Angola', 'Prenda', '2019-05-08');

-- --------------------------------------------------------

--
-- Estrutura para tabela `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `setor` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Despejando dados para a tabela `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `senha`, `setor`) VALUES
(10, 'Edmundo Nascimento', 'ed@gmail.com', 'ed2016', 'J23'),
(11, 'Isabel de Jesus', 'isabel@hotmail.com', '1234', 'B1'),
(12, 'Kadson', 'kadson@unesc.net', '12345', 'JK12');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `agendamentos`
--
ALTER TABLE `agendamentos`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `estudantes`
--
ALTER TABLE `estudantes`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `agendamentos`
--
ALTER TABLE `agendamentos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de tabela `estudantes`
--
ALTER TABLE `estudantes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de tabela `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
