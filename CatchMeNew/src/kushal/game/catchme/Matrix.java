package kushal.game.catchme;

import java.util.Random;






import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Matrix extends View{
	Button b ;
	Random ra = new Random();
	Bitmap smile[] =new Bitmap[7];
	int chy=0,a,xm,ym;
	Man xx[],yy[];
	static int sp ;
	static int bool;
	static Context co;
	LinearLayout l;
	Bitmap start,exit,help,about,high;
	 final see cc ;
	public Matrix(Context context) {
		super(context);

		setBackgroundResource(R.drawable.img);
		
		if(Help.i == 1)
			bool = 0;
		xx=new Man[500];
		yy=new Man[500];
		co = context;
		sp =0;
		
         xm=0;
         ym=0;
         bool = 0;
		l = new LinearLayout(context);
        l.setOrientation(LinearLayout.VERTICAL);
        start = BitmapFactory.decodeResource(getResources(), R.drawable.sstart);
        help = BitmapFactory.decodeResource(getResources(), R.drawable.shelp);
        about = BitmapFactory.decodeResource(getResources(), R.drawable.sabout);
        exit = BitmapFactory.decodeResource(getResources(), R.drawable.sexit);
        high = BitmapFactory.decodeResource(getResources(), R.drawable.shigh);
		cc= new see(500000,200);
		Main.help(cc);
		cc.start();
		
	}


			
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		System.out.print(canvas.getHeight());
		int xs,ys,zs;
		
		bool = 0;
		System.gc();
	
		for(int i=0;i<sp;i++){
			canvas.drawBitmap(xx[i].getImage(), xx[i].chX, xx[i].chY, null);
		}
		
	for(int i=0;i<sp;i++){
		if(xx[i].chY<canvas.getHeight()-10){
			xx[i].chY +=20;
		}
		else{
			xx[i] = null;
			for(int p =i ; p < sp ; p++)
					xx[p] = xx[p+1];
			sp--;
			System.gc();
		}
		
	}
	System.out.println("In Dare");
	int hi = canvas.getHeight();
	int hig;
	if(hi==600){
		canvas.drawBitmap(start, canvas.getWidth()/2-60, canvas.getHeight()/5-20, null);
		canvas.drawBitmap(high, canvas.getWidth()/2-100, canvas.getHeight()/5+90, null);
		canvas.drawBitmap(help, canvas.getWidth()/2-60, canvas.getHeight()/5+160, null);
		canvas.drawBitmap(about, canvas.getWidth()/2-80, canvas.getHeight()/5+220, null);
		canvas.drawBitmap(exit, canvas.getWidth()/2-60, canvas.getHeight()/5+290, null);
		if(ym>=canvas.getHeight()/5-20 && ym<=canvas.getHeight()/5+30){
			Context context = getContext();
			bool = 1;
			System.out.println("StartingPoint started");
			Intent ii = new Intent(context, StartingPoint.class);
			context.startActivity(ii);
		}
		
		else if((ym>=canvas.getHeight()/5+90 && ym<=canvas.getHeight()/5+140)){
			Context context = getContext();
			bool = 1;
			System.out.println("Help started");
			Intent ii = new Intent(context,High.class);
			context.startActivity(ii);
		}
		
		
		else if(ym>=canvas.getHeight()/5+160 && ym<=canvas.getHeight()/5+210){
			Context context = getContext();
			bool = 1;
			System.out.println("About started");
			Intent ii = new Intent(context, Help.class);
			context.startActivity(ii);
		}
		
		
		else if((ym>=canvas.getHeight()/5+220 && ym<=canvas.getHeight()/5+270)){
			Context context = getContext();
			bool = 1;
			System.out.println("About started");
			Intent ii = new Intent(context, About.class);
			context.startActivity(ii);
		}
		else if((ym>=canvas.getHeight()/5+290 && ym<=canvas.getHeight()/5+340)){
			System.exit(1);
		}

	}

	else if(hi>600){
	canvas.drawBitmap(start, canvas.getWidth()/2-60, canvas.getHeight()/5-20, null);
	canvas.drawBitmap(high, canvas.getWidth()/2-100, canvas.getHeight()/5+130, null);
	canvas.drawBitmap(help, canvas.getWidth()/2-60, canvas.getHeight()/5+280, null);
	canvas.drawBitmap(about, canvas.getWidth()/2-80, canvas.getHeight()/5+430, null);
	canvas.drawBitmap(exit, canvas.getWidth()/2-60, canvas.getHeight()/5+590, null);
	if(ym>=canvas.getHeight()/5-20 && ym<=canvas.getHeight()/5+30){
		Context context = getContext();
		bool = 1;
		System.out.println("StartingPoint started");
		Intent ii = new Intent(context, StartingPoint.class);
		context.startActivity(ii);
	}
	
	else if((ym>=canvas.getHeight()/5+130 && ym<=canvas.getHeight()/5+170)){
		Context context = getContext();
		bool = 1;
		System.out.println("Help started");
		Intent ii = new Intent(context,High.class);
		context.startActivity(ii);
	}
	
	
	else if(ym>=canvas.getHeight()/5+280 && ym<=canvas.getHeight()/5+320){
		Context context = getContext();
		bool = 1;
		System.out.println("About started");
		Intent ii = new Intent(context, Help.class);
		context.startActivity(ii);
	}
	
	
	else if((ym>=canvas.getHeight()/5+430 && ym<=canvas.getHeight()/5+470)){
		Context context = getContext();
		bool = 1;
		System.out.println("About started");
		Intent ii = new Intent(context, About.class);
		context.startActivity(ii);
	}
	else if((ym>=canvas.getHeight()/5+590 && ym<=canvas.getHeight()/5+630)){
		System.exit(1);
	}

	}
	
	else if(hi<600){
		canvas.drawBitmap(start, canvas.getWidth()/2-60, canvas.getHeight()/5-20, null);
		canvas.drawBitmap(high, canvas.getWidth()/2-100, canvas.getHeight()/5+70, null);
		canvas.drawBitmap(help, canvas.getWidth()/2-60, canvas.getHeight()/5+120, null);
		canvas.drawBitmap(about, canvas.getWidth()/2-80, canvas.getHeight()/5+170, null);
		canvas.drawBitmap(exit, canvas.getWidth()/2-60, canvas.getHeight()/5+210, null);
		if(ym>=canvas.getHeight()/5-20 && ym<=canvas.getHeight()/5+30){
			Context context = getContext();
			bool = 1;
			System.out.println("StartingPoint started");
			Intent ii = new Intent(context, StartingPoint.class);
			context.startActivity(ii);
		}
		
		else if((ym>=canvas.getHeight()/5+70 && ym<=canvas.getHeight()/5+120)){
			Context context = getContext();
			bool = 1;
			System.out.println("Help started");
			Intent ii = new Intent(context,High.class);
			context.startActivity(ii);
		}
		
		
		else if(ym>=canvas.getHeight()/5+120 && ym<=canvas.getHeight()/5+170){
			Context context = getContext();
			bool = 1;
			System.out.println("About started");
			Intent ii = new Intent(context, Help.class);
			context.startActivity(ii);
		}
		
		
		else if((ym>=canvas.getHeight()/5+170 && ym<=canvas.getHeight()/5+210)){
			Context context = getContext();
			bool = 1;
			System.out.println("About started");
			Intent ii = new Intent(context, About.class);
			context.startActivity(ii);
		}
		else if((ym>=canvas.getHeight()/5+210 && ym<=canvas.getHeight()/5+260)){
			System.exit(1);
		}

		}
	Paint text = new Paint();

	System.gc();
	if(bool != 1)
		invalidate();
	}
	                                     
	




	class see extends CountDownTimer{

		public see(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
			
		}

		@Override
		public void onFinish() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTick(long millisUntilFinished) {
			xx[sp] = new Man(co);
			if(sp<499)
			sp++;
			
		}
		
	}
	public boolean onTouchEvent(MotionEvent event) {
	    xm = (int)event.getX();
	    ym = (int)event.getY();
	    switch (event.getAction()) {
	        case MotionEvent.ACTION_DOWN:
	        	
	              
	        case MotionEvent.ACTION_MOVE:
	        	 
	             
	        case MotionEvent.ACTION_UP:
	    }
	return true;
	}
	
}
