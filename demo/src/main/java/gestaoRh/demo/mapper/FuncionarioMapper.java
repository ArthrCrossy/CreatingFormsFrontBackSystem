package gestaoRh.demo.mapper;

import gestaoRh.demo.dto.*;
import gestaoRh.demo.model.Funcionario;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {


    public static FuncionarioDTO toListDTO(Funcionario funcionario) {
        if (funcionario == null) return null;

        return new FuncionarioDTO(
                funcionario.getId(),
                funcionario.getNomeCompleto(),
                funcionario.getEmail(),
                funcionario.getCargo(),
                funcionario.getDepartamento(),
                funcionario.getDataContratacao(),
                funcionario.getStatus()
        );
    }

}