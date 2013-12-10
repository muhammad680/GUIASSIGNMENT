package assign;

import java.util.ArrayList;
import java.util.Random;

public class ClothesController {
	
	ArrayList<Cothes> sweaterList = new ArrayList<Cothes>();
	ArrayList<Cothes> tshirtList = new ArrayList<Cothes>();
	ArrayList<Cothes> trousersList = new ArrayList<Cothes>();
	ArrayList<Cothes> jacketList = new ArrayList<Cothes>();
	ArrayList<Cothes> shoesList = new ArrayList<Cothes>();
	Random rand  = new Random();
	
	public ClothesController()
	{
		Dao d = new Dao();//instantiating the DAO class
		setArrays(d.getAllProducts());	
	}
	
	
	public void setArrays( ArrayList<Cothes> array){
		
		for(Cothes p : array){
		
			if (p.getType().equals("sweater")){
			sweaterList.add(p);
			
			}	
			else if (p.getType().equals("tshirts")){
			tshirtList.add(p);
			}
			else if (p.getType().equals("trousers")){
			trousersList.add(p);
			}
			else if (p.getType().equals("jacket")){
			jacketList.add(p);
			}
			else if (p.getType().equals("shoes")){
			shoesList.add(p);
			}
		}
	}
	
	public Cothes randomsweater()
	{
		int r = rand.nextInt(sweaterList.size());
		return sweaterList.get(r);
		
	}
	public Cothes randomtshirt()
	{	
		int r = rand.nextInt(tshirtList.size());
		return tshirtList.get(r);
		
	}
	public Cothes randomtrousers()
	{
		int r = rand.nextInt(trousersList.size());
		return trousersList.get(r);
		
	}
	public Cothes randomjacket(){
		int r = rand.nextInt(jacketList.size());
		return jacketList.get(r);
		
	}
	public Cothes randomshoes(){
		int r = rand.nextInt(shoesList.size());
		return shoesList.get(r);
		
	}
		
}
