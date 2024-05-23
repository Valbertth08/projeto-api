package empre.rubik.api.dto.dtoEmpresa;

import empre.rubik.api.entites.Empresa;

public record DetalharEmpresaDto(String nome) {
    public DetalharEmpresaDto(Empresa empresa){
        this(empresa.getNome());
    }

}
