-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 20/05/2024 às 23:37
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `oficina`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `baixaestoque`
--

CREATE TABLE `baixaestoque` (
  `IdBaixaEstoque` int(11) NOT NULL,
  `IdPeca` int(11) DEFAULT NULL,
  `DataHoraSolicitada` datetime DEFAULT NULL,
  `DataHoraConcluida` datetime DEFAULT NULL,
  `QuantidadePeca` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
--

CREATE TABLE `cliente` (
  `IdCliente` int(11) NOT NULL,
  `Nome` text DEFAULT NULL,
  `Telefone` char(11) DEFAULT NULL,
  `Endereco` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `estoque`
--

CREATE TABLE `estoque` (
  `IdEstoque` int(11) NOT NULL,
  `IdPeca` int(11) DEFAULT NULL,
  `QuantidadeDisponivel` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `faturamento`
--

CREATE TABLE `faturamento` (
  `IdFaturamento` int(11) NOT NULL,
  `IdOS` int(11) DEFAULT NULL,
  `ValorServico` double DEFAULT NULL,
  `ValorPecas` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `os`
--

CREATE TABLE `os` (
  `IdOS` int(11) NOT NULL,
  `IdCliente` int(11) DEFAULT NULL,
  `Descricao` text DEFAULT NULL,
  `StatusOS` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `peca`
--

CREATE TABLE `peca` (
  `IdPeca` int(11) NOT NULL,
  `Nome` text DEFAULT NULL,
  `Quantidade` double DEFAULT NULL,
  `Peso` double DEFAULT NULL,
  `Medida` text DEFAULT NULL,
  `Marca` text DEFAULT NULL,
  `Modelo` text DEFAULT NULL,
  `Ano` int(11) DEFAULT NULL,
  `Cor` text DEFAULT NULL,
  `Valor` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `pedido`
--

CREATE TABLE `pedido` (
  `IdPedidoCompra` int(11) NOT NULL,
  `IdPeca` int(11) DEFAULT NULL,
  `Quantidade` double DEFAULT NULL,
  `Concluido` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `baixaestoque`
--
ALTER TABLE `baixaestoque`
  ADD PRIMARY KEY (`IdBaixaEstoque`),
  ADD KEY `IdPeca` (`IdPeca`);

--
-- Índices de tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`IdCliente`);

--
-- Índices de tabela `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`IdEstoque`),
  ADD KEY `IdPeca` (`IdPeca`);

--
-- Índices de tabela `faturamento`
--
ALTER TABLE `faturamento`
  ADD PRIMARY KEY (`IdFaturamento`),
  ADD KEY `IdOS` (`IdOS`);

--
-- Índices de tabela `os`
--
ALTER TABLE `os`
  ADD PRIMARY KEY (`IdOS`),
  ADD KEY `IdCliente` (`IdCliente`);

--
-- Índices de tabela `peca`
--
ALTER TABLE `peca`
  ADD PRIMARY KEY (`IdPeca`);

--
-- Índices de tabela `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`IdPedidoCompra`),
  ADD KEY `IdPeca` (`IdPeca`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `baixaestoque`
--
ALTER TABLE `baixaestoque`
  MODIFY `IdBaixaEstoque` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `IdCliente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `estoque`
--
ALTER TABLE `estoque`
  MODIFY `IdEstoque` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `faturamento`
--
ALTER TABLE `faturamento`
  MODIFY `IdFaturamento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `os`
--
ALTER TABLE `os`
  MODIFY `IdOS` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `peca`
--
ALTER TABLE `peca`
  MODIFY `IdPeca` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `pedido`
--
ALTER TABLE `pedido`
  MODIFY `IdPedidoCompra` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `baixaestoque`
--
ALTER TABLE `baixaestoque`
  ADD CONSTRAINT `baixaestoque_ibfk_1` FOREIGN KEY (`IdPeca`) REFERENCES `peca` (`IdPeca`);

--
-- Restrições para tabelas `estoque`
--
ALTER TABLE `estoque`
  ADD CONSTRAINT `estoque_ibfk_1` FOREIGN KEY (`IdPeca`) REFERENCES `peca` (`IdPeca`);

--
-- Restrições para tabelas `faturamento`
--
ALTER TABLE `faturamento`
  ADD CONSTRAINT `faturamento_ibfk_1` FOREIGN KEY (`IdOS`) REFERENCES `os` (`IdOS`);

--
-- Restrições para tabelas `os`
--
ALTER TABLE `os`
  ADD CONSTRAINT `os_ibfk_1` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`IdCliente`);

--
-- Restrições para tabelas `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`IdPeca`) REFERENCES `peca` (`IdPeca`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
