package empre.rubik.api.services;

import empre.rubik.api.dto.dtoPergunta.PerguntaCadastroDto;
import empre.rubik.api.entites.Pergunta;
import empre.rubik.api.repository.PerguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePergunta {
    @Autowired
    PerguntaRepository perguntaRepository;

    public Pergunta save(PerguntaCadastroDto cadastro){
            return perguntaRepository.save(detalharPergunta(cadastro,new Pergunta()));
    }
    public Pergunta detalharPergunta(PerguntaCadastroDto cadastro, Pergunta pergunta){
        pergunta.setTexto(cadastro.texto());
        pergunta.setTipoPergunta(cadastro.tipoPergunta());
        return pergunta;
    }
}

