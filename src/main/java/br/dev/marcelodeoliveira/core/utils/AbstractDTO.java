package br.dev.marcelodeoliveira.core.utils;

import org.apache.poi.ss.usermodel.Row;

public class AbstractDTO {
    protected String id;
    protected Row row;

    public AbstractDTO(Row row2) {
	this.row = row2;
    }


    // Prover aqui a transformação
    // sem validar os atributos
    // (do cabeçalho da plalinha)
    // e concretizar lá embaixo?

    // ou validar se os atributos
    // são válidos antes de construir
    // a concretização?
    // (a cada leitura)

}
