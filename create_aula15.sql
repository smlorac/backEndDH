CREATE TABLE IF NOT EXISTS enderecos(
    id INT AUTO_INCREMENT PRIMARY KEY,
    rua VARCHAR(64),
    numero VARCHAR(8),
    cidade VARCHAR(32),
    bairro VARCHAR(32)
);

CREATE TABLE IF NOT EXISTS pacientes(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(32),
    sobrenome VARCHAR(32),
    rg VARCHAR(10),
    dataCadastro VARCHAR(10),
    idEndereco INT,
    FOREIGN KEY (idEndereco) REFERENCES enderecos(id)
);