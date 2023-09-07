package io.github.filme.rest.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmeDTO {

	private UUID id;
	private String nome;
	private String autor;
	private Integer lancamento;
	private String genero;

}
