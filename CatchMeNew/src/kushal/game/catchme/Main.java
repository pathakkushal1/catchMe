package kushal.game.catchme;

import kushal.game.catchme.Matrix.see;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Main extends Activity{

	Matrix m , y;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        m = new Matrix(this);
	       
	       setContentView(m);
	     
	        
	}



	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		s.cancel();
	}



	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		System.out.println("Resume");
		//  setContentView(y);
		// y = new Matrix(this);
		if(Matrix.bool == 2){
			Intent is = new Intent("kushal.game.catchme.CopyOfMain");
			startActivity(is);}                                            
		Matrix.bool = 0;
		System.out.println("bool ->"+Matrix.bool);
	}




static see s;
public static void help(see m){
	s = m;
}


	@Override
protected void onPostResume() {
	// TODO Auto-generated method stub
	super.onPostResume();
	s.start();
}



@Override
protected void onStop() {
	// TODO Auto-generated method stub
	super.onStop();
	s.cancel();
}



	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		s.start();
	}

	
	
}
