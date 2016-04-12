package kushal.game.catchme;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Game extends View{

	public Game(Context context) {
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Paint text = new Paint();
		text.setColor(Color.RED);
		
		text.setTextSize(54);
		canvas.drawText("hello game over", canvas.getWidth()/4, canvas.getHeight()/2, text);
	}

}
