package project;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//base box that all moveables/items will build off of
public class Sprite extends Rectangle
{
	private double moveLen = 50;
	
	//Constructor
	public Sprite(int x, int y, Color c)
	{
		setX(x);
		setY(y);
		setWidth(moveLen);
		setHeight(moveLen);
		setFill(c);
	}
	
	//Copy Constructor
	public Sprite(Sprite s)
	{
		setX(s.getX());
		setY(s.getY());
		setWidth(s.getArcWidth());
		setHeight(s.getArcHeight());
		setFill(s.getFill());
	}
	
	//Moves the object right 
	public void moveR(Scene s)
	{
		setX(getX()+moveLen);
		if(getX() > s.getWidth())
		{
			setX(0);
		}
	}
	
	//Moves the object left
	public void moveL(Scene s)
	{
		setX(getX()-moveLen);
		if(getX() < 0)
		{
			setX(s.getWidth());
		}
	}
	
	//Setters/Getters (x/y already have them as per Rectangle class)
	public double getMoveLen()
	{
		return moveLen;
	}
	
	public void setMoveLen(double ml)
	{
		moveLen = ml;
	}
	
	public void getCoord()
	{
		System.out.println("("+getX()+","+getY()+")");
	}
	
	public static void main(String[] args)
	{
		Sprite s = new Sprite(100,100,Color.BLACK);
		Pane root = new Pane();
        root.setPrefSize(550, 750);
		Scene c = new Scene(root, 550, 750);
		System.out.println(c.getHeight()+","+c.getWidth());
		s.getCoord();
		s.moveR(c);
		s.getCoord();
		
	}

	

}