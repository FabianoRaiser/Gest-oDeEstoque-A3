-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 17/06/2024 às 14:43
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
-- Banco de dados: `oficina_teste`
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
  `Nome` varchar(150) DEFAULT NULL,
  `Telefone` char(11) DEFAULT NULL,
  `Endereco` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `cliente`
--

INSERT INTO `cliente` (`IdCliente`, `Nome`, `Telefone`, `Endereco`) VALUES
(3, 'Pedro Santos', '99876-5432', 'Avenida das Palmeiras'),
(4, ' Ana Oliveira', '98765-1234', 'Rua dos Girassóis'),
(5, 'João Silva', '98765-8765', 'Travessa das Acácias'),
(6, 'João Silva', '98765-8765', 'Travessa das Acácias'),
(7, 'João Silva', '98765-8765', 'Travessa das Acácias'),
(8, 'Ana Costa', '66666-6666', 'Rua XV de Novembro, 1011'),
(9, 'Pedro Santos', '55555-5555', 'Av. Borges de Medeiros, 1313');

-- --------------------------------------------------------

--
-- Estrutura para tabela `faturamento`
--

CREATE TABLE `faturamento` (
  `IdFaturamento` int(11) NOT NULL,
  `IdOS` int(11) DEFAULT NULL,
  `ValorServico` double DEFAULT NULL,
  `ValorPecas` double DEFAULT NULL,
  `IdCliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `os`
--

CREATE TABLE `os` (
  `IdOS` int(11) NOT NULL,
  `IdCliente` int(11) DEFAULT NULL,
  `Descricao` varchar(150) DEFAULT NULL,
  `ValorServico` decimal(10,2) DEFAULT NULL,
  `ValorTotal` decimal(10,2) DEFAULT NULL,
  `IdPeca` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `os`
--

INSERT INTO `os` (`IdOS`, `IdCliente`, `Descricao`, `ValorServico`, `ValorTotal`, `IdPeca`) VALUES
(1, NULL, NULL, NULL, NULL, 1),
(2, NULL, NULL, NULL, NULL, 2),
(4, 3, 'teste	', 150.00, 300.00, NULL),
(5, NULL, NULL, NULL, NULL, 1),
(6, NULL, NULL, NULL, NULL, 2),
(8, 5, 'teste46', 200.00, 300.00, NULL),
(10, 7, 'Testando', 150.00, 500.00, NULL),
(11, 4, 'teste', 200.00, 300.00, NULL),
(12, 7, 'Teste2', 100.00, 300.00, NULL);

-- --------------------------------------------------------

--
-- Estrutura para tabela `peca`
--

CREATE TABLE `peca` (
  `IdPeca` int(11) NOT NULL,
  `Nome` varchar(150) DEFAULT NULL,
  `Quantidade` double DEFAULT NULL,
  `Peso` double DEFAULT NULL,
  `Medida` varchar(150) DEFAULT NULL,
  `Marca` varchar(150) DEFAULT NULL,
  `Modelo` varchar(150) DEFAULT NULL,
  `Ano` int(11) DEFAULT NULL,
  `Cor` varchar(150) DEFAULT NULL,
  `Valor` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `peca`
--

INSERT INTO `peca` (`IdPeca`, `Nome`, `Quantidade`, `Peso`, `Medida`, `Marca`, `Modelo`, `Ano`, `Cor`, `Valor`) VALUES
(1, 'Amortecedor Frontal', 10, 5, 'kg', 'Cofap', 'B47768', 2022, 'Preto', 350),
(2, 'Velas de Ignição', 20, 0.2, 'kg', 'NGK', 'BKR6E', 2023, 'Metalico', 80),
(3, ' Disco de Freio', 15, 7, 'kg', 'Bosch', 'BD8001', 2021, 'Prata', 200),
(4, 'Filtro de Ar', 25, 0.5, 'kg', 'Fram', 'CA9997', 2022, 'Branco', 60),
(5, 'Bateria Automotiva', 50, 18, 'kg', 'Moura', 'M70ED', 2023, 'Preto', 450);

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
-- Despejando dados para a tabela `pedido`
--

INSERT INTO `pedido` (`IdPedidoCompra`, `IdPeca`, `Quantidade`, `Concluido`) VALUES
(1, 4, 1, NULL);

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
-- Índices de tabela `faturamento`
--
ALTER TABLE `faturamento`
  ADD PRIMARY KEY (`IdFaturamento`),
  ADD KEY `IdCliente` (`IdCliente`);

--
-- Índices de tabela `os`
--
ALTER TABLE `os`
  ADD PRIMARY KEY (`IdOS`),
  ADD KEY `IdCliente` (`IdCliente`),
  ADD KEY `IdPeca` (`IdPeca`) USING BTREE;

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
  MODIFY `IdCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `faturamento`
--
ALTER TABLE `faturamento`
  MODIFY `IdFaturamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `os`
--
ALTER TABLE `os`
  MODIFY `IdOS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `peca`
--
ALTER TABLE `peca`
  MODIFY `IdPeca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `pedido`
--
ALTER TABLE `pedido`
  MODIFY `IdPedidoCompra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `baixaestoque`
--
ALTER TABLE `baixaestoque`
  ADD CONSTRAINT `baixaestoque_ibfk_1` FOREIGN KEY (`IdPeca`) REFERENCES `peca` (`IdPeca`);

--
-- Restrições para tabelas `faturamento`
--
ALTER TABLE `faturamento`
  ADD CONSTRAINT `IdCliente` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`IdCliente`),
  ADD CONSTRAINT `faturamento_ibfk_1` FOREIGN KEY (`IdOS`) REFERENCES `os` (`IdOS`);

--
-- Restrições para tabelas `os`
--
ALTER TABLE `os`
  ADD CONSTRAINT `fk_os_peca` FOREIGN KEY (`IdPeca`) REFERENCES `peca` (`IdPeca`),
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
