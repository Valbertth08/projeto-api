package empre.rubik.api.resources;


import empre.rubik.api.dto.dtoResposta.CadastroRespostaDto;
import empre.rubik.api.dto.dtoResposta.DetalharRespostaDto;
import empre.rubik.api.entites.Resposta;
import empre.rubik.api.repository.RespostaRepository;
import empre.rubik.api.services.ServiceResposta;
import jakarta.annotation.Resources;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("respostas")
public class RespostaResource {
    @Autowired
    ServiceResposta serviceResposta;
    @PostMapping
    public ResponseEntity inserir(@RequestBody @Valid CadastroRespostaDto resposta, UriComponentsBuilder builde){
        var r =serviceResposta.save(resposta);
        var uri= builde.path("/respostas/{id}").buildAndExpand(r.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DetalharRespostaDto(r));

    }

}
