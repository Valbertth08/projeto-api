package empre.rubik.api.resources;


import empre.rubik.api.dto.dtoEmpresa.CadastraEmpresaDto;
import empre.rubik.api.dto.dtoEmpresa.DetalharEmpresaDto;
import empre.rubik.api.services.ServiceEmpresa;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("empresa")
public class EmpresaResource {
    @Autowired
    ServiceEmpresa serviceEmpresa;
    @PostMapping
    public ResponseEntity inserir(@RequestBody @Valid CadastraEmpresaDto cadastraEmpresaDto, UriComponentsBuilder builde){
        var empresa=serviceEmpresa.save(cadastraEmpresaDto);
        var uri= builde.path("/empresa/{id}").buildAndExpand(empresa.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalharEmpresaDto(empresa));
    }
}
