package kushal.game.catchme;

import java.util.Random;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.view.View;

public class Man extends View {

	Random ra ;
	int a;
	static int p;
	 int chX,chY;
	 Bitmap smile[] ;
	public Man(Context context) {
		super(context);
	ra	= new Random();
	smile = new Bitmap[6];
		chX = ra.nextInt(480);
		chY = 0;
		a = ra.nextInt(5);
		p=a;
	}
	Bitmap bp;
	public Bitmap getImage(){
		
		smile[0] = BitmapFactory.decodeResource(getResources(), R.drawable.sbad);
		smile[1] = BitmapFactory.decodeResource(getResources(), R.drawable.spink);
		smile[2] = BitmapFactory.decodeResource(getResources(), R.drawable.scool);
		smile[3] = BitmapFactory.decodeResource(getResources(), R.drawable.smil);
		smile[4] = BitmapFactory.decodeResource(getResources(), R.drawable.sblue);
		smile[5] = BitmapFactory.decodeResource(getResources(), R.drawable.sblick);
		return smile[a];
	
	}
	
	public RectF getPuck(){
		RectF rect = new RectF(chX, chY, chX+32, chY+32);
		
		return rect;
	}


}
