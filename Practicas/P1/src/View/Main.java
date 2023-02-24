package View;

import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	Window w= new Window("P1G11", 1200, 1080);   
            }
        });
		
	}
}
