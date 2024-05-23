package empre.rubik.api.resources;


import empre.rubik.api.dto.dtoPergunta.DetalharPerguntaDto;
import empre.rubik.api.dto.dtoPergunta.PerguntaCadastroDto;
import empre.rubik.api.entites.Pergunta;
import empre.rubik.api.repository.PerguntaRepository;
import empre.rubik.api.services.ServicePergunta;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("pergunta")
public class PerguntaResource {
    @Autowired
    ServicePergunta servicePergunta;
    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid PerguntaCadastroDto cadastro, UriComponentsBuilder builde){
        var pergunta=servicePergunta.save(cadastro);
        var uri=builde.path("/pergunta/{id}").buildAndExpand(pergunta.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DetalharPerguntaDto(pergunta));
    }


}
