package br.unitins.DTO;


import br.unitins.model.Contato;
import br.unitins.model.Endereco;
import br.unitins.model.Usuario;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

public record UsuarioSimplesDTO(
        @NotBlank(message = "O nome deve ser informado ")
        String nome,
        LocalDate dataNacimento,
        @NotBlank(message = "O cpf deve ser informado ")
        String cpf,
        String cep,

        @NotBlank(message = "O email ou login deve ser informado ")
        String email,
        @NotBlank(message = "O senha deve ser informado ")
        String senha
) {

}
