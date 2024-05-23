package empre.rubik.api.services;


import empre.rubik.api.dto.dtoResposta.CadastroRespostaDto;
import empre.rubik.api.entites.Empresa;
import empre.rubik.api.entites.Pergunta;
import empre.rubik.api.entites.Resposta;
import empre.rubik.api.repository.EmpresaRepository;
import empre.rubik.api.repository.PerguntaRepository;
import empre.rubik.api.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceResposta {
    @Autowired
    PerguntaRepository perguntaRepository;
    @Autowired
    EmpresaRepository empresaRepository;
    @Autowired
    RespostaRepository respostaRepository;
    public Resposta save(CadastroRespostaDto cadastro) {
        Resposta resposta= new Resposta();
        Pergunta pergunta = perguntaRepository.getReferenceById(cadastro.id_pergunta());
        Empresa empresa = empresaRepository.getReferenceById(cadastro.id_empresa());
        if ((pergunta != null) && (empresa != null)) {
            resposta = detalharResposta(cadastro, pergunta, empresa,resposta);
        }
        return respostaRepository.save(resposta);
    }
    public Resposta  detalharResposta(CadastroRespostaDto cadastro,Pergunta pergunta, Empresa empresa,Resposta resposta) {
            resposta.setPergunta(pergunta);
            resposta.setTexto(cadastro.texto());
            resposta.setEmpresa(empresa);
            return resposta;
    }

}
