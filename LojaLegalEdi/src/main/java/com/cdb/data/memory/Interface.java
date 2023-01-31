package com.cdb.data.memory;

import java.util.List;

public interface Interface {

	boolean save (Object obj);  //salvar
	void update (Object obj); //mostrar
    boolean delete (Object obj); //deletar
    
    List<Object> listItems() ; //listar
}
