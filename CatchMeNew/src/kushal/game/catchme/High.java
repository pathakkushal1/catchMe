package kushal.game.catchme;

import java.io.File;
import java.io.FileInputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class High extends Activity{
	TextView sc,spp;
	@Override
	public void onBackPressed() {
		Context context = getApplicationContext();
		CharSequence text = "Please Press Ok Button";
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
	Matrix x ;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        
	        x = new Matrix(this);
	        setContentView(R.layout.high);
	        
	        sc = (TextView) findViewById(R.id.sc);
	        spp = (TextView) findViewById(R.id.sp);
	       char aa[]=new char[50];
	       int ab=0;
		try{
			File file=new File("/mnt/sdcard/jump.txt");
			FileInputStream fw = new FileInputStream(file);
			int a = fw.read();
			while(a!=-1){
				aa[ab]=(char)a;
				a =fw.read();
				ab++;
				
			}
			String ss="",sp="";
			int i=0;
			while(i<aa.length ){
				if(aa[i]==' ')
				{
					i++;
					break;
				}else{
				ss = ss+aa[i];
				i++;}
			}
			while(i<aa.length ){
				if(aa[i]==' ')
				{
					i++;
					break;
				}
				else{
					sp = sp+aa[i];
					i++;
				}
			}
			sc.setText(""+ss);
			spp.setText(""+sp+" sec");
		}catch(Exception e){
			e.printStackTrace();
		}
		Button bu = (Button) findViewById(R.id.highOk);
		bu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				System.exit(1);
			}
		});
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
		
	}
}
