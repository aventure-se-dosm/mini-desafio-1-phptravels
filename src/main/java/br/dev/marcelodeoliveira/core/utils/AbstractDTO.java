package br.dev.marcelodeoliveira.core.utils;

import org.apache.poi.ss.usermodel.Row;

public class AbstractDTO {
    protected String id;
    protected Row row;

    public AbstractDTO(Row row2) {
	this.row = row2;
    }
}
