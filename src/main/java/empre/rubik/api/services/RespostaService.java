package empre.rubik.api.services;


import empre.rubik.api.entites.resposta.Resposta;
import empre.rubik.api.entites.resposta.dto.CadastrarRespostaDTO;
import empre.rubik.api.entites.resposta.dto.DetalharRespostaDTO;
import empre.rubik.api.repository.FormularioRepository;
import empre.rubik.api.repository.PerguntaRepository;
import empre.rubik.api.repository.RespostaRepository;
import empre.rubik.api.repository.UsuarioRepository;
import empre.rubik.api.services.Validacoes.Validador;
import empre.rubik.api.services.relatorio.dto.DadosEntradaRelatorioDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;
    @Autowired
    private PerguntaRepository perguntaRepository;
    @Autowired
    private FormularioRepository formularioRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    List<Validador> validores;

    public ResponseEntity cadastrar(CadastrarRespostaDTO dados ,UriComponentsBuilder builder ){

        //validores.forEach(validador -> validador.Validar(new DadosEntradaRelatorioDTO(dados.id_usuario(),LocalDateTime.now().toLocalDate())));
        var resposta= verificarDados(dados);
        var uri=builder.path("/cadastrar/{id}").buildAndExpand(resposta.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalharRespostaDTO(resposta));
    }
    private Resposta verificarDados(CadastrarRespostaDTO dados) {
       var pergunta= perguntaRepository.findById(dados.id_pergunta()).orElseThrow(()-> new  EntityNotFoundException("Pergunta não encontrada"));
       var formulario= formularioRepository.findById(dados.id_formulario()).orElseThrow(()->new EntityNotFoundException("Formulario não encontrada"));
       var usuario= usuarioRepository.findById(dados.id_usuario()).orElseThrow(()->new EntityNotFoundException("Usuario não encontrado"));
       Resposta resposta= new Resposta(pergunta,usuario,formulario.getId(),dados.valor());
       return respostaRepository.save(resposta);
    }

}
