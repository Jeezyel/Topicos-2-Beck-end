package br.unitins.DTO;

import br.unitins.model.Contato;
import br.unitins.model.Endereco;
import br.unitins.model.Telefone;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record UsuarioDTO(
        @NotBlank(message = "O nome deve ser informado ")
        String nome,

        LocalDate dataNacimento,
        @NotBlank(message = "O cpf deve ser informado ")
        String cpf,
        long contato,
        @Valid
        @NotNull(message = "O endereços deve ser infromado")
        List<Endereco> enderecos,
        @NotBlank(message = "O login deve ser informado ")
        String login,
        @NotBlank(message = "O senha deve ser informado ")
        String senha
) {
}
