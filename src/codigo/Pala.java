package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GRect;

public class Pala extends GRect{
	/**
	 * 
	 * @param _ancho Ancho de la pal.a
	 * @param _alto Alto de la pala.
	 * @param _color Color de la pala.
	 */

	public Pala(double _ancho, double _alto, Color _color) {
		super(_ancho,_alto);
		this.setFilled(true);
		this.setFillColor(_color);


	}
	/**
	 * 
	 * @param evento
	 * @return 
	 */
	public  void mueveBarra(int posX,int anchoPantalla){
		if( posX+ getWidth() <= anchoPantalla ) {
			setLocation(posX, getY());	

		}



	}
}
