package empre.rubik.api.resources;


import empre.rubik.api.dto.dtoResposta.CadastroRespostaDto;
import empre.rubik.api.dto.dtoResposta.DetalharRespostaDto;
import empre.rubik.api.entites.Resposta;
import empre.rubik.api.repository.RespostaRepository;
import jakarta.annotation.Resources;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("respostas")
public class RespostaResource {
    @Autowired
    RespostaRepository respostaRepository;
    @PostMapping

    public ResponseEntity inserir(@RequestBody CadastroRespostaDto resposta, UriComponentsBuilder builde){
        Resposta r=new Resposta(resposta);
        respostaRepository.save(r);
        var uri= builde.path("/respostas/{id}").buildAndExpand(r.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DetalharRespostaDto(r));

    }

}
