package med.vall.api.controler;

import med.vall.api.medico.DadosCadastroMecidos;
import med.vall.api.medico.DadosListagemMedico;
import med.vall.api.medico.Medico;
import med.vall.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMecidos dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public List<DadosListagemMedico> Listar(){

        return (List<DadosListagemMedico>) repository.findAll().stream().map(DadosListagemMedico::new).toList();
    }
}
