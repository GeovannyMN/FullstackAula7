package br.ufg.inf.fullstack.model.enums;

public enum Escolaridade {
	
	MEDIO(0, "M�dio"),
	GRADUACAO(1, "Gradua��o"),
	ESPECIALIZACAO(2, "Especializa��o"),
	MESTRADO(3, "Mestrado"),
	DOUTORADO(4, "Doutorado");
		
	private int id;
	private String value;
	
	Escolaridade(int id, String value) {
		this.id = id;
		this.value = value;
	}
	
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
	
	public static Escolaridade get(int id) {
		Escolaridade res = null;
		for(Escolaridade esc : Escolaridade.values()) {
			if(esc.getId() == id) {
				res = esc;
				break;
			}
		}
		return res;
	}
	
}
