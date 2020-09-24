
package Icono;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dibujo extends JPanel {
    //ventana
    private JFrame ventana;
    //contenedor
    private Container contenedor;

    private final int[] FIGURA ={
        0x00000,
        0x97bde,
        0x94a10,
        0x94a10,
        0x94a10,
        0x94a10,
        0x94a10,
        0x97bde,
        0x95842,
        0x94042,
        0x94842,
        0x94442,
        0x94242,
        0xf43de,
        0x00000

    };

    //Mascara
    private final int MASCARA = 0x100001;
    //Ancho de bits
    private final int ANCHOBITS =32;
    
    private int coordenada_x;
    private int coordenada_y;
    
    // definiendo hilo de ejecucion
    private Thread hilo;

    public Dibujo() {
        // INICIALIZAR LA VENTANA
        ventana = new JFrame("Dibujando icono");
        //Definirlo en tamano la ventana
        ventana.setSize(800, 600);
        
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        
        contenedor = ventana.getContentPane();
        contenedor.setSize(800, 600);
        //agregar la vetana en el contedor
        contenedor.add(this, BorderLayout.CENTER);
        
        // definir hilo
        this.hilo = new Thread();
        
       
    }


    /**
     *
     * @param graphics
     */
    @Override
/*    protected*/ public void paintComponent(Graphics graphics) {
        // TODO Auto-generated method stub
        super.paintComponent(graphics);
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
        
        

        for(int i=0; i<this.FIGURA.length;  i++) {
            for (int j=0;j<this.ANCHOBITS;j++) {
                int temp = this.FIGURA[i] & (this.MASCARA >>j);
                if (temp !=0) {
                    graphics.drawLine( this.coordenada_y+j, 
                            this.coordenada_x+i, 
                            this.coordenada_y+j, 
                            this.coordenada_x+i);
                }
            }
        }
    }

    public void dibujar() {
        
        this.coordenada_x =(int)(Math.random()*500);
        this.coordenada_y =(int)(Math.random()*500);

        for (;;){
            try{
                this.coordenada_x = this.coordenada_x -40;


                    this.hilo.sleep(300); 
             paint(getGraphics());
        } catch(Exception e){
                System.out.println(e.getMessage());

                 }
            try{
                this.coordenada_y = this.coordenada_y +40;


                    this.hilo.sleep(300); 
             paint(getGraphics());
        } catch(Exception e){
                System.out.println(e.getMessage());

                 }
            try{
                this.coordenada_x = this.coordenada_y +30;


                    this.hilo.sleep(300); 
             paint(getGraphics());
        } catch(Exception e){
                System.out.println(e.getMessage());

                 }
            try{
                this.coordenada_y = this.coordenada_x -30;


                    this.hilo.sleep(300); 
             paint(getGraphics());
        } catch(Exception e){
                System.out.println(e.getMessage());

                 }
 
            }
        }
        }