package empre.rubik.api.services;


import empre.rubik.api.entites.formulario.Formulario;
import empre.rubik.api.entites.formulario.dto.AtualizarFormularioDTO;
import empre.rubik.api.entites.formulario.dto.CadastroFormularioDTO;
import empre.rubik.api.entites.formulario.dto.DetalharFormularioDTO;
import empre.rubik.api.repository.FormularioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class FormularioService {

    @Autowired
    private FormularioRepository formularioRepository;

    public ResponseEntity inserirFormulario(CadastroFormularioDTO dados, UriComponentsBuilder builder){
        var formulario = formularioRepository.save(new Formulario(dados));
        var uri= builder.path("/formulario/{id}").buildAndExpand(formulario.getId()).toUri();
        return  ResponseEntity.created(uri).body(formulario);

    }
    public ResponseEntity atualizarFormulario(AtualizarFormularioDTO dados){
        if(!formularioRepository.existsById(dados.id())){
            throw  new EntityNotFoundException("Formulario não encontrado");
        }
        var formulario = formularioRepository.getReferenceById(dados.id());
        if(dados.titulo()!=null){
            formulario.setTitulo(dados.titulo());
        }
        return ResponseEntity.ok().body(formulario);
    }
    public Page<DetalharFormularioDTO> listarFormulario(Pageable pageable){
        return formularioRepository.findAll(pageable).map(DetalharFormularioDTO::new);
    }

    public ResponseEntity listarFormularioId(Long id){
        if(!formularioRepository.existsById(id)){
            throw  new EntityNotFoundException("Formulario não encontrado");
        }
        var formulario=formularioRepository.getReferenceById(id);
        return ResponseEntity.ok().body(new DetalharFormularioDTO(formulario));
    }

    public ResponseEntity deletarFormularioId(Long id) {
        if(!formularioRepository.existsById(id)){
            throw new EntityNotFoundException("Formulario não encontrado");
        }
        formularioRepository.deleteById(id);
       return ResponseEntity.noContent().build();
    }

}
