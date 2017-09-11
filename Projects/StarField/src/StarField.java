import javax.swing.JFrame;

public class StarField {

	public static void main(String[] args) {
		System.out.println("Hello");
        JFrame win = new JFrame("All Alone?...");
        
        DrawingComponent DC = new DrawingComponent();
        //DC.clockStart();
        win.add(DC);
  
        win.setSize(498,574);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);
	}

}
