import java.awt.Color; 
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*; 

public class MainView {

	public MainView() {
		setupView();
	}

	private void setupView() {
		
		
		int width = 850;
		int height = 450;
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
        
		String IMG_PATH = "src/resources/";
        Color BACKGROUND_COLOUR = Color.decode("#3c5f6a");
        
        JButton villaButton = new JButton("Eco Villa");
        villaButton.setBounds(10, 10, 440, 270);
        
        JButton yurtButton = new JButton("Eco Yurt");
        yurtButton.setBounds(10, 290, 400, 270);
        
        BufferedImage img;
        
        try {
	         img = ImageIO.read(new File(IMG_PATH + "Villa.jpeg"));
	         villaButton.setIcon(new ImageIcon(img));
	         
	         img = ImageIO.read(new File(IMG_PATH + "Yurt.jpeg"));
	         yurtButton.setIcon(new ImageIcon(img));
	         
	         
        } catch (IOException e) {
	         e.printStackTrace();
	    }
        
        villaButton.setHorizontalTextPosition(AbstractButton.CENTER);
        villaButton.setVerticalTextPosition  (AbstractButton.BOTTOM);
        //villaButton.setFont(font);
        villaButton.setLayout(new FlowLayout (FlowLayout.CENTER));
        
        villaButton.addActionListener(new ActionListener()
        {
        	  public void actionPerformed(ActionEvent e)
        	  {
        		 panel.setVisible(false);
        	  }
        	
        });
        
        panel.add(villaButton);
        panel.add(yurtButton);
        
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(width, height);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);
        frame.getContentPane().setBackground(BACKGROUND_COLOUR);
        panel.setBackground(BACKGROUND_COLOUR);
        
        panel.setSize(width-10, height-10);
        panel.setVisible(true);
		frame.setVisible(true);
	
	}
}
