CREATE TABLE funcionarios (
                              id SERIAL PRIMARY KEY,
                              nome_completo VARCHAR(255) NOT NULL,
                              email VARCHAR(255) UNIQUE NOT NULL,
                               telefone VARCHAR(20),
                              cargo VARCHAR(100),
                              departamento VARCHAR(50) CHECK (departamento IN ('TI', 'RH', 'Financeiro', 'Marketing', 'Operações')),
                              data_contratacao DATE NOT NULL,
                              salario NUMERIC(10, 2) NOT NULL
);