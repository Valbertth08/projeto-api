package empre.rubik.api.services;


import empre.rubik.api.entites.cliente.Cliente;
import empre.rubik.api.entites.cliente.dto.AtualizarClienteDTO;
import empre.rubik.api.entites.cliente.dto.CadastroClienteDTO;
import empre.rubik.api.entites.cliente.dto.DetalharClienteDTO;
import empre.rubik.api.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseEntity inserirCliente(CadastroClienteDTO dados, UriComponentsBuilder builder){
        var cliente=clienteRepository.save(new Cliente(dados));
        var uri= builder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalharClienteDTO(cliente));
    }

    public ResponseEntity atualizarCliente(AtualizarClienteDTO dados){
        if(!clienteRepository.existsById(dados.id())){
            throw new EntityNotFoundException("Cliente não encontrado");
        }
        var cliente= clienteRepository.getReferenceById(dados.id());
        if(dados.nome()!=null){
            cliente.setNome(dados.nome());
        }
        return ResponseEntity.ok().body(cliente);
    }

    public Page<DetalharClienteDTO> listarCliente(Pageable pageable){
        return  clienteRepository.findAll(pageable).map(DetalharClienteDTO::new);
    }

    public ResponseEntity listarClienteId(Long id){
        if(!clienteRepository.existsById(id)){
            throw new EntityNotFoundException("Cliente não encontrado");
        }
        var cliente= clienteRepository.getReferenceById(id);
        return ResponseEntity.ok().body(new DetalharClienteDTO(cliente));
    }

    public void deletarClienteId(Long id) {
        if(!clienteRepository.existsById(id)){
            throw new EntityNotFoundException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }
}
