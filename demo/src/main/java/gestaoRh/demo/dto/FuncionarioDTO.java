package gestaoRh.demo.dto;

import gestaoRh.demo.model.Departamento;
import gestaoRh.demo.model.StatusFuncionario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {
    private Integer id;
    private String nomeCompleto;
    private String email;
    private String cargo;
    private Departamento departamento;
    private LocalDate dataContratacao;
    private StatusFuncionario status;
}