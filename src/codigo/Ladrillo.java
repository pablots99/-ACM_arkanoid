package codigo;

import java.awt.Color;

import acm.graphics.GRect;
/**
 * 
 * @author pablo
 *
 */
public class Ladrillo extends GRect{
/**
 * 
 * @param _ancho
 * @param _alto
 * @param width
 * @param height
 * @param _color
 */
	public Ladrillo(double _ancho, double _alto, double width, double height, Color _color) {
		super(_ancho, _alto, width, height);
		this.setFilled(true);
		this.setFillColor(_color);

	}

	
}
