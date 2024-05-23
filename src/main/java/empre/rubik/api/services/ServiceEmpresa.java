package empre.rubik.api.services;

import empre.rubik.api.dto.dtoEmpresa.CadastraEmpresaDto;
import empre.rubik.api.dto.dtoPergunta.PerguntaCadastroDto;
import empre.rubik.api.entites.Empresa;
import empre.rubik.api.entites.Pergunta;
import empre.rubik.api.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceEmpresa {
    @Autowired
    EmpresaRepository empresaRepository;
    public Empresa save(CadastraEmpresaDto cadastro){
            return  empresaRepository.save(detalharEmpresa(cadastro,new Empresa()));
    }
    public Empresa detalharEmpresa(CadastraEmpresaDto cadastro, Empresa empresa){
        empresa.setNome(cadastro.nome());
        return empresa;
    }
}

