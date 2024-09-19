package empre.rubik.api.services.relatorio;


import empre.rubik.api.entites.categoria.Categoria;
import empre.rubik.api.repository.CategoriaRepository;
import empre.rubik.api.services.relatorio.dto.DadosEntradaRelatorioDTO;
import empre.rubik.api.services.relatorio.dto.RetornoMediaCategoriaDTO;
import empre.rubik.api.services.relatorio.dto.RetornoRelatorioGeral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public RetornoRelatorioGeral RelatorioGeralBaseadoEmUmCliente(Long id, LocalDate data){
        List<RetornoMediaCategoriaDTO> listaDasMediasCategorias=new ArrayList<>();
        List<String> nomeCategorias= new ArrayList<>();
        var categorias=  categoriaRepository.findAll().stream().map(Categoria::getId).toList();
        for(Long cat : categorias){
            var nomeCategoria=  categoriaRepository.getReferenceById(cat).getNome();
            var peso=categoriaRepository.getReferenceById(cat).getPeso();
            var media=categoriaRepository.pegarMediaBaseadaNaCategoriaDaPergunta(id,cat, data);
            listaDasMediasCategorias.add(new RetornoMediaCategoriaDTO(nomeCategoria,peso,media));
            nomeCategorias.add(nomeCategoria);
        }
        var mediaGeral= mediaGeralCategoriasBaseadoEmUmCliente(id,categorias,data);
        return new RetornoRelatorioGeral(listaDasMediasCategorias,mediaGeral,nomeCategorias);
    }
    private Integer mediaGeralCategoriasBaseadoEmUmCliente(Long id, List<Long> categorias, LocalDate data){
      var somaDosPesosDasCategorias=0;
      var somaDasMedias=0;
      for(Long cat : categorias){
          somaDosPesosDasCategorias+=categoriaRepository.findById(cat).get().getPeso();
          somaDasMedias+=categoriaRepository.pegarMediaBaseadaNaCategoriaDaPergunta(id,cat,data);
      }
      var valor= (somaDasMedias/somaDosPesosDasCategorias)*100;
      return  valor;
    }

}
