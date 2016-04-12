package kushal.game.catchme;

import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.view.View;

public class BombMan extends View{

	Random ra ;
	int a;
	static int p;
	 int chX,chY;
	 Bitmap smile ;
	public BombMan(Context context) {
		super(context);
	ra	= new Random();
	
		chX = ra.nextInt(480);
		chY = 0;
		a = ra.nextInt(6);
		p=a;
	}
	Bitmap bp;
	public Bitmap getImage(){
		
		smile = BitmapFactory.decodeResource(getResources(), R.drawable.bomb);
		
		return smile;
	}
	
	public RectF getPuck(){
		RectF rect = new RectF(chX, chY, chX, chY);
		
		return rect;
	}
}
