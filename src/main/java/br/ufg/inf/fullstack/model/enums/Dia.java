package br.ufg.inf.fullstack.model.enums;

public enum Dia {

	DOMINGO(0, "Domingo"),
	SEGUNDA(1, "Segunda-feira"),
	TERCA(2, "Ter�a-feira"),
	QUARTA(3, "Quarta-feira"),
	QUINTA(4, "Quinta-feira"),
	SEXTA(5, "Sexta-feira"),
	SABADO(6, "S�bado"),;

	Dia(int id, String value) {
		this.id = id;
		this.value = value;
	}
	
	private int id;
	private String value;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public static Dia get(int id) {
		Dia res = null;
		for(Dia dia : Dia.values()) {
			if(dia.getId() == id) {
				res = dia;
				break;
			}
		}
		return res;
	}
	
}
