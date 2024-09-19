package empre.rubik.api.services;

import empre.rubik.api.entites.admin.Admin;
import empre.rubik.api.entites.admin.dto.AtualizarAdminDTO;
import empre.rubik.api.entites.admin.dto.CadastroAdminDTO;
import empre.rubik.api.entites.admin.dto.DetalharAdminDTO;
import empre.rubik.api.entites.cliente.Cliente;
import empre.rubik.api.entites.cliente.dto.AtualizarClienteDTO;
import empre.rubik.api.entites.cliente.dto.CadastroClienteDTO;
import empre.rubik.api.entites.cliente.dto.DetalharClienteDTO;
import empre.rubik.api.repository.AdminRepository;
import empre.rubik.api.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public ResponseEntity inserirAdmin(CadastroAdminDTO dados, UriComponentsBuilder builder){
        var admin=adminRepository.save(new Admin(dados));
        var uri= builder.path("/cliente/{id}").buildAndExpand(admin.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalharAdminDTO(admin));
    }
    public ResponseEntity atualizarAdmin(AtualizarAdminDTO dados){
        if(!adminRepository.existsById(dados.id())){
            throw new EntityNotFoundException("Admin não encontrado");
        }
        var admin= adminRepository.getReferenceById(dados.id());
        if(dados.nome()!=null){
            admin.setNome(dados.nome());
        }
        return ResponseEntity.ok().body(admin);
    }
    public Page<DetalharAdminDTO> listarAdmin(Pageable pageable){
        return  adminRepository.findAll(pageable).map(DetalharAdminDTO::new);
    }
    public ResponseEntity listarAdminId(Long id){
        if(!adminRepository.existsById(id)){
            throw new EntityNotFoundException("Admin não encontrado");
        }
        var admin= adminRepository.getReferenceById(id);
        return ResponseEntity.ok().body(admin);
    }

    public void deletarAdminId(Long id) {
        if(!adminRepository.existsById(id)){
            throw new EntityNotFoundException("Admin não encontrado");
        }
        adminRepository.deleteById(id);
    }
}
