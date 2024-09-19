package empre.rubik.api.services;


import empre.rubik.api.entites.pergunta.Pergunta;
import empre.rubik.api.entites.pergunta.dto.AtualizarPerguntaDTO;
import empre.rubik.api.entites.pergunta.dto.DetalharPerguntaDTO;
import empre.rubik.api.entites.pergunta.dto.CadastroPerguntaDTO;
import empre.rubik.api.repository.CategoriaRepository;
import empre.rubik.api.repository.FormularioRepository;
import empre.rubik.api.repository.PerguntaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PerguntaService {

    @Autowired
    private PerguntaRepository perguntaRepository;

    @Autowired
    private FormularioRepository formularioRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public ResponseEntity inserirPergunta(CadastroPerguntaDTO dados, UriComponentsBuilder builder) {
        if(!formularioRepository.existsById(dados.idFormulario())){
            throw new EntityNotFoundException("Formulario não encontrado");
        }
        if(!categoriaRepository.existsById(dados.idCategoria())){
            throw new EntityNotFoundException("Categoria não encontrado");
        }
        var categoria= categoriaRepository.getReferenceById(dados.idCategoria());
        var formulario= formularioRepository.getReferenceById(dados.idFormulario());
        var pergunta=  perguntaRepository.save(new Pergunta(dados.texto(),formulario,categoria));
        var uri= builder.buildAndExpand("/inserir/{id}").expand(pergunta.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DetalharPerguntaDTO(pergunta));
    }

    public Page<DetalharPerguntaDTO> listarPergunta(Pageable pageable) {
        return  perguntaRepository.findAll(pageable).map(DetalharPerguntaDTO::new);
    }
    public ResponseEntity listarPerguntaId(Long id){
      var pergunta= perguntaRepository.findById(id).orElseThrow( () -> new EntityNotFoundException("Pergunta não encontrado"));
        return  ResponseEntity.ok().body(new DetalharPerguntaDTO(pergunta));
    }

    public ResponseEntity deletarPerguntaId(Long id){
        if(!perguntaRepository.existsById(id)){
            throw new EntityNotFoundException("Pergunta não encontrado");
        }
        perguntaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity atualizarPergunta(AtualizarPerguntaDTO dados) {
        if(!perguntaRepository.existsById(dados.id())){
            throw new EntityNotFoundException("Pergunta não encontrado");
        }
        var pergunta= perguntaRepository.getReferenceById(dados.id());
        if(dados.texto()!=null){
            pergunta.setTexto(dados.texto());
        }
        return ResponseEntity.ok().body(new DetalharPerguntaDTO(pergunta));
    }
}
