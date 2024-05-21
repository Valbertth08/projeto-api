package empre.rubik.api.resources;


import empre.rubik.api.dto.dtoPergunta.PerguntaCadastroDto;
import empre.rubik.api.entites.Pergunta;
import empre.rubik.api.repository.PerguntaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("pergunta")
public class PerguntaResource {
    @Autowired
    PerguntaRepository perguntaRepository;
    @PostMapping
    @Transactional
    public void cadastro(@RequestBody @Valid PerguntaCadastroDto perguntaCadastroDto){
         perguntaRepository.save(new Pergunta(perguntaCadastroDto));
    }


}
