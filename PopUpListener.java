package assign;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;

public class PopUpListener extends MouseAdapter {
	
	public void mousePressed(MouseEvent e){
		if (e.isPopupTrigger()){
			
			popup.show(e.getComponent(),e.getX(),e.getY());
		
			}
		
	}
	public void mouseReleased(MouseEvent e){
		if (e.isPopupTrigger()){
			
			popup.show(e.getComponent(),e.getX(),e.getY());
		}
		
	}
	
	JPopupMenu popup;
	
	public PopUpListener(JPopupMenu popup){
		this.popup = popup;
	}
	
	
	
	

}
