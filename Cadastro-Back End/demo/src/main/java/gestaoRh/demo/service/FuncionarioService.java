package gestaoRh.demo.service;

import gestaoRh.demo.model.Departamento;
import gestaoRh.demo.model.Funcionario;
import gestaoRh.demo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarTodos() {
        return (List<Funcionario>) funcionarioRepository.findAll();
    }

    public Optional<Funcionario> buscarPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void deletar(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public List<Funcionario> buscarPorDepartamento(Departamento departamento) {
        return funcionarioRepository.findByDepartamento(departamento);
    }

    public List<Funcionario> buscarPorCargo(String cargo) {
        return funcionarioRepository.findByCargoContainingIgnoreCase(cargo);
    }

    public Optional<Funcionario> buscarPorEmail(String email) {
        return funcionarioRepository.findByEmail(email);
    }
}
