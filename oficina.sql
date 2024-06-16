-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 16/06/2024 às 21:29
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
(8, 'guizas', '1111', 'teste'),
(9, 'Teste ', '11111-1111', 'Testando endereco');

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
-- Estrutura para tabela `os_peca`
--

CREATE TABLE `os_peca` (
  `IdOS` int(11) NOT NULL,
  `IdPeca` int(11) NOT NULL,
  `Quantidade` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `os_peca`
--

INSERT INTO `os_peca` (`IdOS`, `IdPeca`, `Quantidade`) VALUES
(1, 2, 4),
(11, 2, 3),
(11, 3, 3),
(12, 1, 2),
(12, 2, 2),
(12, 3, 1),
(12, 4, 2);

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
(1, 'Amortecedor Frontal', NULL, 5, 'kg', 'Cofap', 'B47768', 2022, 'Preto', 350),
(2, 'Velas de Ignição', NULL, 0.2, 'kg', 'NGK', 'BKR6E', 2023, 'Metalico', 80),
(3, ' Disco de Freio', NULL, 7, 'kg', 'Bosch', 'BD8001', 2021, 'Prata', 200),
(4, 'Filtro de Ar', NULL, 0.5, 'kg', 'Fram', 'CA9997', 2022, 'Branco', 60),
(5, 'Bateria Automotiva', NULL, 18, 'kg', 'Moura', 'M70ED', 2023, 'Preto', 450);

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

-- --------------------------------------------------------

--
-- Estrutura para tabela `pedido_peca`
--

CREATE TABLE `pedido_peca` (
  `IdPedido` int(11) NOT NULL,
  `IdPeca` int(11) NOT NULL,
  `Quantidade` int(11) DEFAULT NULL
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
  ADD KEY `IdCliente` (`IdCliente`),
  ADD KEY `IdPeca` (`IdPeca`) USING BTREE;

--
-- Índices de tabela `os_peca`
--
ALTER TABLE `os_peca`
  ADD PRIMARY KEY (`IdOS`,`IdPeca`),
  ADD KEY `IdPeca` (`IdPeca`);

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
-- Índices de tabela `pedido_peca`
--
ALTER TABLE `pedido_peca`
  ADD PRIMARY KEY (`IdPedido`,`IdPeca`),
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
  MODIFY `IdFaturamento` int(11) NOT NULL AUTO_INCREMENT;

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
  ADD CONSTRAINT `faturamento_ibfk_1` FOREIGN KEY (`IdOS`) REFERENCES `os` (`IdOS`);

--
-- Restrições para tabelas `os`
--
ALTER TABLE `os`
  ADD CONSTRAINT `fk_os_peca` FOREIGN KEY (`IdPeca`) REFERENCES `peca` (`IdPeca`),
  ADD CONSTRAINT `os_ibfk_1` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`IdCliente`);

--
-- Restrições para tabelas `os_peca`
--
ALTER TABLE `os_peca`
  ADD CONSTRAINT `os_peca_ibfk_1` FOREIGN KEY (`IdOS`) REFERENCES `os` (`IdOS`),
  ADD CONSTRAINT `os_peca_ibfk_2` FOREIGN KEY (`IdPeca`) REFERENCES `peca` (`IdPeca`);

--
-- Restrições para tabelas `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`IdPeca`) REFERENCES `peca` (`IdPeca`);

--
-- Restrições para tabelas `pedido_peca`
--
ALTER TABLE `pedido_peca`
  ADD CONSTRAINT `pedido_peca_ibfk_1` FOREIGN KEY (`IdPedido`) REFERENCES `pedido` (`IdPedidoCompra`),
  ADD CONSTRAINT `pedido_peca_ibfk_2` FOREIGN KEY (`IdPeca`) REFERENCES `peca` (`IdPeca`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
