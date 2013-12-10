package assign;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;

public class Assignment extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	ClothesController product;
	Cothes sweater, tshirts, jacket, trousers,shoes;
	JPopupMenu popup; 
	JMenuItem j,help,total;// used in the random;
	JButton button;			
	JPanel products;
			
			
	JLabel sweaterlabel = new JLabel();
	JLabel sweaterImage = new JLabel();
			
	JLabel tshirtsLabel = new JLabel();
	JLabel tshirtsImage = new JLabel();
			
	JLabel jacketLabel = new JLabel();
	JLabel jacketImage = new JLabel();
	
	JLabel trousersLabel = new JLabel();
	JLabel trousersImage = new JLabel();
			
	JLabel shoesLabel = new JLabel();
	JLabel shoesImage = new JLabel();
			
	JLabel totalLabel = new JLabel();
			
	//create radio buttons
	JRadioButton sweaterradio = new JRadioButton();
			
	JRadioButton tshirtsradio = new JRadioButton();
	
	JRadioButton jacketradio = new JRadioButton();
			
	JRadioButton trousersradio = new JRadioButton();
			
	JRadioButton shoesradio = new JRadioButton();	
	//Constructor
	public Assignment()
	{
				
		super ("Assignment");
		product = new ClothesController();
		setContentPane(setLayout());
		setSize(500,500);
		setLocation(100,100);
		setVisible(true);
		
				
	}			
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == button)
		{
			products.setVisible(true); 
		
			if (!sweaterradio.isSelected())
			{
				sweater=product.randomsweater();
				sweaterlabel.setText("<html>"+sweater.getName()+"<br>€" + sweater.getPrice()+"</html>");
				sweaterImage.setIcon(sweater.getIcon());						
			}
			if (!tshirtsradio.isSelected())
			{
				tshirts =product.randomtshirt();
				tshirtsLabel.setText("<html>"+tshirts.getName()+"<br>€" + tshirts.getPrice()+"</html>");
				tshirtsImage.setIcon(tshirts.getIcon());							
			}
			if (!jacketradio.isSelected())
			{
				jacket = product.randomjacket();
				jacketLabel.setText("<html>"+jacket.getName()+"<br>€" + jacket.getPrice()+"</html>");
				jacketImage.setIcon(jacket.getIcon());							
			}
			if (!trousersradio.isSelected())
			{
				trousers =product.randomtrousers();
				trousersLabel.setText("<html>"+trousers.getName()+"<br>€" + trousers.getPrice()+"</html>");
				trousersImage.setIcon(trousers.getIcon());									
			}
			if (!shoesradio.isSelected())
			{
				shoes=product.randomshoes();
				shoesLabel.setText("<html>"+shoes.getName()+"<br>€" + shoes.getPrice()+"</html>");
				shoesImage.setIcon(shoes.getIcon());			
			}
			total.setVisible(true);
		}
		else if (e.getSource() ==j)
		{
			System.exit(DISPOSE_ON_CLOSE);
		}
		else if (e.getSource()==total)
		{
			totalLabel.setText("The Total is " + (sweater.getPrice() + tshirts.getPrice() +jacket.getPrice() + trousers.getPrice() + shoes.getPrice()));
		}
		else if (e.getSource() ==help)
		{
			JFrame help = new JFrame("HELP");
			JLabel helplabel = new JLabel("<html>Start by clcik on the button 'Random'<br><br>This would chooose random outfits for you. If you are not happy with the random outfits you can click on random again<br><br> If you like one of the chosen outfits you can select it  and then randomize it again<br>");
			help.add(helplabel);
			help.setSize(300,300);
			help.setLocation(300,300);
			help.show();
		}
		revalidate();
		repaint();
}
	
		
			
	private Container setLayout() 
	{						
		Container masterpanel = new JPanel(new BorderLayout());
		//create products panel
		products = new JPanel(new GridLayout(1,5));
		products.setVisible(false); 
		//sweater panel
		JPanel sweater = new JPanel(new BorderLayout());
		sweaterlabel.setText("hats");
		sweater.add(sweaterlabel,BorderLayout.NORTH);
		sweater.add(sweaterradio,BorderLayout.SOUTH);
		sweater.add(sweaterImage, BorderLayout.EAST);
		//t-shirts panel
		JPanel tshirts = new JPanel(new BorderLayout());
		tshirtsLabel.setText("tops");
		tshirts.add(tshirtsLabel,BorderLayout.NORTH);
		tshirts.add(tshirtsradio,BorderLayout.SOUTH);
		tshirts.add(tshirtsImage, BorderLayout.CENTER);
		
		//jackets panel
		JPanel jacket = new JPanel(new BorderLayout());
		jacketLabel.setText("jacket");
		jacket.add(jacketLabel,BorderLayout.NORTH);
		jacket.add(jacketradio,BorderLayout.SOUTH);
		jacket.add(jacketImage, BorderLayout.CENTER);
		
		//trousers panel
		JPanel trousers = new JPanel(new BorderLayout());
		trousersLabel.setText("bottoms");
		trousers.add(trousersLabel,BorderLayout.NORTH);
		trousers.add(trousersradio,BorderLayout.SOUTH);
		trousers.add(trousersImage, BorderLayout.CENTER);
		
		//shoes panel
		JPanel shoes = new JPanel (new BorderLayout());
		shoesLabel.setText("shoes");
		shoes.add(shoesLabel,BorderLayout.NORTH);
		shoes.add(shoesradio,BorderLayout.SOUTH);
		shoes.add(shoesImage, BorderLayout.CENTER);
		
		//button panel
		JPanel button1 = new JPanel();
		button = new JButton("Random");
		button.addActionListener(this);
		button1.add(button);
		
		// Panel to put the button
		JPanel west = new JPanel(new GridLayout(1,0));
		west.add(button1);
	
		//add to products
		products.add(sweater);
		products.add(tshirts);
		products.add(jacket);
		products.add(trousers);
		products.add(shoes);
		
		//Create Total Panel
		JPanel total = new JPanel(new BorderLayout());
		total.add(totalLabel,BorderLayout.WEST);
		
		//add to the master panel
		masterpanel.add(products,BorderLayout.EAST);
		masterpanel.add(total,BorderLayout.SOUTH);
		masterpanel.add(west,BorderLayout.WEST);
		
		PopUpListener popup = new PopUpListener(SetPopup());
		
		masterpanel.addMouseListener(popup);
		return masterpanel;
		
		
		}
				
		public JPopupMenu SetPopup()
		{
			JPopupMenu pop = new JPopupMenu();
			j = new JMenuItem("Close");
			j.addActionListener(this);
			help = new JMenuItem("Help");
			help.addActionListener(this);
			total = new JMenuItem("Total");
			total.addActionListener(this);
			//make invisible
			//total.setVisible(false);
			//add menu items to popup
			pop.add(j);
			pop.add(help);
			pop.add(total);
			return pop;			
		}
}