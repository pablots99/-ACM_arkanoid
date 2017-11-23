/*Auror: Pablo Torres Searle
 * Tiene dos contructores
 * 
 */
package codigo;
import java.awt.Color;

import javax.swing.colorchooser.ColorChooserComponentFactory;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Bola extends GOval {
	/**Este es el contructor basico que es identico al de la clase GOval
	 * 
	 * @param _ancho
	 * @param _alto
	 */
	double xVelocidad =3 ;
	double yVelocidad =-3 ;
	public Bola(double _ancho, double _alto) {
		super(_ancho,_alto);
		
	}
	/**
	 *
	 * @param _ancho define el ancho y alto de la bola
	 * @param _color permite añadir el color
	 */
	public Bola(double _ancho,Color _color) {
		super(_ancho,_ancho);
		if(_ancho< 0) {
			this.setSize(1,1);
		}
		this.setFillColor(_color);
		this.setFilled(true);
	}
	/**se encarga de mover a la pelota y chequear a ver si ha habido colision
	 * 
	 */
	public void muevete(Arkanoid _arkanoid) {
		if(this.getX() + this.getWidth() >= _arkanoid.getWidth() ) { // choca en la pared derecha
			xVelocidad*= -1;
		}
		if(this.getY()+this.getHeight() <= this.getHeight()) { // choca arriba
			yVelocidad*= -1;
		}
		if(this.getX()+this.getHeight() <= 0 +this.getWidth()) { // choca en la pared izquierda
			xVelocidad*= -1;
		}

		//colison con los ladrillos----------------------------------------------------
		if(brikBreak(getX(), getY(), _arkanoid)) { // chequeo esquina superio izq
			if(brikBreak(getX()+ getWidth(), getY(), _arkanoid)) {// chequeo esquina superio der
				if(brikBreak(getX(), getY()+getHeight(), _arkanoid)) {// chequeo esquina inferior izq
					if(brikBreak(getX()+ getWidth(), getY(), _arkanoid)) {// chequeo esquina inferior derecha
					}
				}
			}
		}



		move(xVelocidad,yVelocidad);

		/**
		 * Metodo boolean que sirva para ver si la ola choca con los ladrillos y el cursor
		 * 
		 */
	}
	boolean brikBreak(double posX, double posY , Arkanoid _arkanoid) {
		boolean noChoca = true;
		GObject auxiliar;
		auxiliar= _arkanoid.getElementAt(posX,posY);

		if (auxiliar instanceof Ladrillo) {
			_arkanoid.remove(auxiliar);
			noChoca =false;
			yVelocidad*=-1;
		}
	
		//colision con la  barra--------------------------------------------------------------------------------------
		else if (auxiliar instanceof Pala) {
			yVelocidad*=-1;
			noChoca= false;
		}
		return noChoca;

	}


}