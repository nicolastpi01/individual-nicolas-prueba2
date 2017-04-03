package tateti;

public class Ficha {
	private String id;
	
	public Ficha(String id) {
		this.setId(id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		try {
			this.esValido(id);
			this.id = id;
		}
		catch (FichaNoValidaException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		 
	}
	
	private boolean esValido(String id) throws FichaNoValidaException {
		boolean valido = id == "x" || id == "o";
		if(!valido) throw new FichaNoValidaException();
		return valido;
	}

	public Ficha contraria() {
		if(id=="x") return new Ficha("o");
		else return new Ficha("x");
	}

}
