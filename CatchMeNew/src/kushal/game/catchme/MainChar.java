package kushal.game.catchme;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Random;
import java.util.Timer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;

public class MainChar extends View{

	Random ra;
	Bitmap bp[],dp,dc,tp,bo;
	static boolean gas;
	static boolean flag;
	CountDownTimer time;
	Man im[] ;
	float chY , x, y,x2,y2;
	 int chX,fileF;
	 static int canWei,bool;
	 static Context content1;
	 final pee xx;
	 final see xxx;
	 final Fee mm;
	 BombMan boo[] = new BombMan[100];
	public MainChar(Context context) {
		super(context);
		setBackgroundResource(R.drawable.img2);
		content1 = context;
		ra = new Random();
		gas =true;
		bool =0;
		sp =0;
		fileF = 0;
		count =0;
		countTime=0;
		speed = 0;
		bp = new Bitmap[20];
		tp = BitmapFactory.decodeResource(getResources(), R.drawable.smil);
		dp = BitmapFactory.decodeResource(getResources(), R.drawable.openbox);
		dc = BitmapFactory.decodeResource(getResources(), R.drawable.closebox);
		x= 100;
		y=200;
		x2=-1;
		y2=-1;
		chY = 0 ;
		xx = new pee(300000,2000);
		xx.start();
		xxx = new see(300000,5000);
		xxx.start();
		mm = new Fee(3000000,1000);
		mm.start();
	}
	int pp=0;
	static int s = 0,count =0,p=0,countTime=0;
	int arr[] = new int[1000];
	Man xp[] = new Man[50];
	
	static int sp =0;
	
	
	@Override
	protected void onDraw( Canvas canvas) {
		// TODO Auto-generated method stub
		canWei = canvas.getWidth();
	//canvas.drawColor(Color.DKGRAY);
		super.onDraw(canvas);
		System.out.println("Draw on");
		for(int i=0;i<sp;i++){
			canvas.drawBitmap(boo[i].getImage(), boo[i].chX, boo[i].chY, null);
			canvas.drawBitmap(xp[i].getImage(),xp[i].chX,xp[i].chY,null);
		}
		for(int i=0;i<sp;i++){
		if(xp[i].chY<canvas.getHeight()-10){
			xp[i].chY +=speed;
	
		}
		else{
			xp[i].chY = 0;
		}
		if(boo[i].chY<canvas.getHeight()-10){
			
			boo[i].chY+=speed;
		}
		else{
			boo[i].chY = 0;
		}
		}
		for(int i=0;i<sp;i++){
			if(boo[i].getPuck().intersect(getBox())){
				bool = 1;
				Paint text = new Paint();
				text.setColor(Color.RED);
				gas = false;
				text.setTextSize(54);
				canvas.drawText("Game Over ",canvas.getWidth()/2-100, canvas.getHeight()/2, text);
				xx.cancel();
				xxx.cancel();
			       char aa[]=new char[50];
			       int ab=0;
			       fileF ++;
			       if(fileF == 1){
			file();
			}
				Context context = getContext();
				Intent ii = new Intent(context, GameOver.class);
				context.startActivity(ii);
			
			}
			if(xp[i].getPuck().intersect(getBox())){
				flag = true;
				xp[i].chX = ra.nextInt(canvas.getWidth());
				xp[i].chY = 0;
				count++;
				System.gc();
			}
		}
		Paint text = new Paint();
		text.setColor(Color.RED);
		
		text.setTextSize(canvas.getHeight()/32);
		s++;
		canvas.drawText(" Score ->"+count,10, 20, text);
		canvas.drawText(" Time ->"+countTime,10, 50, text);
		canvas.drawBitmap(dp,x-32,y-32,null);
		
		System.gc();
		if(bool == 0)
		invalidate();
		}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
	    x = (float)event.getX();
	    y = (float)event.getY();
	    switch (event.getAction()) {
	        case MotionEvent.ACTION_DOWN:
	        	 x2= x;
	              y2 = y;
	              break;
	        case MotionEvent.ACTION_MOVE:
	        	  float x3 = x - x2;
	              float y3 = y - y2;
	              break;
	        case MotionEvent.ACTION_UP:
	    }
	return true;
	}

public RectF getBox(){
	RectF rect = new RectF(x-44, y-44, x+44, y+44);
	
	return rect;
}
public void file(){
	char aa[] = new char[50];
	int ab=0;
	int count1=0;
	int countTime1 =0 ;
	File file=new File("/mnt/sdcard/jump.txt");
	try{
		
		FileInputStream fw = new FileInputStream(file);
		int a = fw.read();
		while(a!=-1){
			aa[ab]=(char)a;
			a =fw.read();
			ab++;
			
		}
		String ss="",sp="";
		int ii=0;
		while(ii<aa.length ){
			if(aa[ii]==' ')
			{
				ii++;
				break;
			}
			else{
			ss = ss+aa[ii];
			ii++;
			}
		}
		
		while(ii<aa.length ){
			if(aa[ii]==' ')
			{
				ii++;
				break;
			}
			else{
				sp = sp+aa[ii];
				ii++;
			}
			
		}
		System.out.println("count ->"+count);
		System.out.println("CountTime ->"+countTime);
		
		if(ss.equals("") || sp.equals("")){
		 
		}
		else{
			count1=(int)Integer.parseInt(ss);
			System.out.println("countData ->"+count1);
			System.out.println("SS ->"+ss);
			System.out.println("SP ->"+sp);
			countTime1=(int)Integer.parseInt(sp);
			System.out.println("CountTimeData ->"+countTime1);
		}
	mm.cancel();
	}catch(Exception e){
		e.printStackTrace();
		try{
		boolean bool = file.createNewFile();
		count1 = 0;
		countTime1 = 0;}
		catch(Exception x){
			x.printStackTrace();
			
		}
	}
	try{
	File file1=new File("/mnt/sdcard/jump.txt");
		FileWriter fw2 = new FileWriter(file1);	
		if(count>count1){
		fw2.write(""+count);}else{
			fw2.write(""+count1);
		}
		if(countTime>countTime1){
		fw2.write(" "+countTime+" ");}else{
			fw2.write(" "+countTime1+" ");
		}
		fw2.close();
	}catch(Exception e){
		e.printStackTrace();
	}
}



	class pee extends CountDownTimer{

		public pee(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
			
		}

		@Override
		public void onFinish() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTick(long millisUntilFinished) {
			xp[sp] = new Man(content1);
			boo[sp] = new BombMan(content1);
			sp++;
		}
		
	}
	static int speed =0;
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
			speed +=5;
		}
		
	}
	class Fee extends CountDownTimer{

		public Fee(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
			
		}

		@Override
		public void onFinish() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTick(long millisUntilFinished) {
			countTime++;
		}
		
	}
}
