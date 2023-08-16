package med.vall.api.medico;

import med.vall.api.endereco.DadosEndereco;

import javax.validation.Valid;
import javax.validation.constraints.*;

public record DadosCadastroMecidos(
        @NotBlank
        String nome,
        @NotBlank @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull @Valid
        DadosEndereco endereco) {

}
