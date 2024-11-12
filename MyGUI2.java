import java.awt.*;
import java.awt.event.*;

public class MyGUI2 extends Frame{

 Label l1;
 Button b1;
 int count;


 MyGUI2(){

 setSize(400,200);
addWindowListener(new WindowAdapter()
	{
	public void windowClosing(WindowEvent e) {    
		dispose();    
		} 
	}
);

 FlowLayout fl = new FlowLayout();
setLayout(fl);

 l1=new Label("Click count");
 add(l1);

 b1=new Button("Click me!");
 add(b1);

b1.addMouseListener(new MouseAdapter()
	{
	public void mouseClicked(MouseEvent e){
		count++;
		l1.setText("Click count: "+count);
	}
}
);

 setVisible(true);
 }
 
 

public static void main(String[] args) {
 MyGUI2 a=new MyGUI2();
 }
 }
