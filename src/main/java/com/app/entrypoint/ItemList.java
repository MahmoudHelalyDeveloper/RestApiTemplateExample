package com.app.entrypoint;

import java.util.ArrayList;
import java.util.List;

import com.app.mapper.ItemsCopy;

public class ItemList {

	private List<ItemsCopy> lista;

	public ItemList() {

		lista = new ArrayList<>();

	}

	/**
	 * @return the lista
	 */
	public List<ItemsCopy> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<ItemsCopy> lista) {
		this.lista = lista;
	}

}
