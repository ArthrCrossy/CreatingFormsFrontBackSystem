ALTER TABLE funcionarios
    ADD COLUMN status VARCHAR(10) DEFAULT 'NEUTRO';

ALTER TABLE funcionarios
    ADD CONSTRAINT chk_status_funcionario CHECK (status IN ('ATIVO', 'DESATIVO', 'NEUTRO'));
