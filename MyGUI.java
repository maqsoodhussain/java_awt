import java.awt.*;
import java.awt.event.*;

public class MyGUI extends Frame implements KeyListener, MouseListener, WindowListener{

 Label l1;
 Button b1;
 int count;
boolean keyFlag=false;

TextField t1;
Button b2;
char a;

 MyGUI(){

 setSize(400,200);
addWindowListener(this);

 FlowLayout fl = new FlowLayout();
setLayout(fl);

 l1=new Label("Click count");
 add(l1);

 b1=new Button("Click me!");
 add(b1);

t1=new TextField();
t1.setColumns(10);
add(t1);
b2=new Button("Copy text!");
add(b2);

 b1.addMouseListener(this);
 l1.addMouseListener(this);
b2.addMouseListener(this);
b2.addKeyListener(this);
t1.addKeyListener(this);
 setVisible(true);
 }
 
 public void mouseClicked(MouseEvent e){
if(e.getSource()==b1)
	{
	count++;
	l1.setText("Click count: "+count);
	}
if(e.getSource()==b2)
	{
	l1.setText(t1.getText());
	}
 }
 public void mousePressed(MouseEvent e){}
 public void mouseReleased(MouseEvent e){}
 public void mouseEntered(MouseEvent e){
 if(e.getSource()==l1)
	l1.setText("Don't click");
}
 public void mouseExited(MouseEvent e){
	l1.setText("Click count: "+count);
}

public void windowDeactivated(WindowEvent e) {}    
public void windowDeiconified(WindowEvent e) {}    
public void windowIconified(WindowEvent e) {}    
public void windowOpened(WindowEvent arg0) {}   
public void windowActivated(WindowEvent e) {}    
public void windowClosed(WindowEvent e) {}    
public void windowClosing(WindowEvent e) {    
dispose();    
}  


public void keyPressed(KeyEvent e){
if(e.getSource()==b2)
	{
	if(e.getKeyCode()==e.VK_SPACE)
		keyFlag=true;
	if(e.getKeyCode()==e.VK_W && keyFlag)	
		{
		l1.setText(t1.getText());
		keyFlag=false;
		}
}


}
public void keyReleased(KeyEvent e){
if(e.getSource()==b2)
	{if(e.getKeyCode()==e.VK_SPACE)
		keyFlag=false;}
}
public void keyTyped(KeyEvent e){
if(e.getSource()==t1)
	{
	if(e.getKeyChar()=='a' || e.getKeyChar()=='e' || e.getKeyChar()=='i' || e.getKeyChar()=='o' || e.getKeyChar()=='u')
		e.setKeyChar(a);
	}
}


public static void main(String[] args) {
 MyGUI a=new MyGUI();
 }
 }
