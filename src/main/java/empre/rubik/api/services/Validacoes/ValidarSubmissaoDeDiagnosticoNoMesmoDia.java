package empre.rubik.api.services.Validacoes;

import empre.rubik.api.repository.RespostaRepository;
import empre.rubik.api.services.relatorio.dto.DadosEntradaRelatorioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarSubmissaoDeDiagnosticoNoMesmoDia implements Validador {

    @Autowired
    private RespostaRepository respostaRepository;

    @Override
    public void Validar(DadosEntradaRelatorioDTO dados) {
        var valor= respostaRepository.validarClienteAgendamentoMesmoDia(dados.data(), dados.id());
        if(valor){
            throw new valicaoException("O diagnostico insticional só pode ser feito 1 vez por dia, tente novamente amanha.");
        }
    }
}
