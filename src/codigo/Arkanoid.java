package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

/* Auotor: Pablo Torres Searle
 */
import acm.graphics.*;
public class Arkanoid extends acm.program.GraphicsProgram{
	Bola bola1= new Bola(20,Color.BLUE);



	Pala pala1= new Pala(79,15,Color.GREEN);

	int anchoLadrillo;
	int altoLadrillo;
	public void init() {
		addMouseListeners();
		setSize(400,600);
		add(bola1,40,getHeight()*0.80 -bola1.getHeight());
		add(pala1,0,getHeight()*0.85 -bola1.getHeight());
		anchoLadrillo= 43;
		altoLadrillo= 20;
	}
	public void run() {
		nivel1();
		
		while(true) {
		
			bola1.muevete(this);
			pause (20);

		}
	}
	public void mouseMoved (MouseEvent evento) {

		pala1. mueveBarra (evento.getX(), getWidth());
	}
	private void nivel1() {
		for(int j=0; j<9; j++) {
			for(int i=j; i<9; i++)	{
				Ladrillo miladrillo = new Ladrillo(anchoLadrillo*i -anchoLadrillo*j/2,
						altoLadrillo*j +altoLadrillo,anchoLadrillo,altoLadrillo,Color.blue);
				add(miladrillo);

			}
		}

	}


}
