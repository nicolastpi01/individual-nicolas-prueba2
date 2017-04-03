package tateti;

public class Tablero {
	private Ficha[][] tablero;
	
	public Tablero() {
		tablero = new Ficha[3][3];
	}
	
	public void ponerFicha(int coordx, int coordy, Ficha f) {
		tablero[coordx][coordy] = f;
		if(gano(f)) System.out.println("Ganaste jugador "+f.getId()+"!!!!");
		//if(empate()) System.out.println("Empate!!! :(");
	}
	
	public Ficha get(int coordx, int coordy) {
		return tablero[coordx][coordy];
	}

	public boolean gano(Ficha ficha) {
		return ganoEnRecta(ficha) || ganoEnPerpendicular(ficha);
	}
	
	/*
	public boolean empate() {
		return empate(new Ficha("x")) && empate(new Ficha("o")); 
	}
	
	private boolean empate(Ficha ficha) {
		return empateEnRecta(ficha) && empateEnPerpendicular(ficha);
	}
	
	private boolean empateEnPerpendicular(Ficha f) {
		boolean empatoDesc = false;
		boolean empatoAsc = false;
		int posx = 2;
		int posy = 0;
		for(int i=0; i<3; i++) {
			empatoDesc = empatoDesc || hayPieza(i,i,f.contraria());
			empatoAsc = empatoAsc || hayPieza(posx,posy,f.contraria());
			posx=posx - 1;
			posy=posy + 1;
		}
			return empatoDesc && empatoAsc;
	}
	
	private boolean empateEnRecta(Ficha ficha) {
		boolean empate=true;
		for(int i=0; i<3; i++) {
			empate = empate && hayEmpateLineaEnRectas(i, ficha);
		}
		return empate;
	}
	
	private boolean hayEmpateLineaEnRectas(int pos, Ficha f) {
		boolean hayEmpateEnLineaEnHorizontal = false;
		boolean hayEmpateEnLineaEnVertical = false;
		for(int i=0; i < 3; i++) {
			hayEmpateEnLineaEnHorizontal = hayEmpateEnLineaEnHorizontal || hayPieza(pos,i,f.contraria());
			hayEmpateEnLineaEnVertical = hayEmpateEnLineaEnVertical || hayPieza(i,pos,f.contraria());
		}
			return hayEmpateEnLineaEnVertical && hayEmpateEnLineaEnHorizontal;
	}
	*/
	
	private boolean ganoEnPerpendicular(Ficha f) {
		boolean ganoDesc = true;
		boolean ganoAsc = true;
		int posx = 2;
		int posy = 0;
		for(int i=0; i<3; i++) {
			ganoDesc = ganoDesc && hayPieza(i,i,f);
			ganoAsc = ganoAsc && hayPieza(posx,posy,f);
			posx=posx - 1;
			posy=posy + 1;
		}
			return ganoDesc || ganoAsc;
	}
	
	private boolean ganoEnRecta(Ficha ficha) {
		boolean gano=false;
		for(int i=0; i<3; i++) {
			gano = gano || hayLineaEnRectas(i, ficha);
		}
		return gano;
	}
	
	private boolean hayLineaEnRectas(int pos, Ficha f) {
		boolean hayLineaEnHorizontal = true;
		boolean hayLineaEnVertical = true;
		for(int i=0; i < 3; i++) {
			hayLineaEnHorizontal = hayLineaEnHorizontal && hayPieza(pos,i,f);
			hayLineaEnVertical = hayLineaEnVertical && hayPieza(i,pos,f);
		}
			return hayLineaEnHorizontal || hayLineaEnVertical;
	}
	
	private boolean hayPieza(int posx, int posy, Ficha f) {
		return get(posx, posy) != null && get(posx, posy).getId() == f.getId();
	}

}
