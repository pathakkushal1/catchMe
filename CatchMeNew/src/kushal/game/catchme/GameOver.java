package kushal.game.catchme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

public class GameOver extends Activity{
	ImageButton yes,no;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        setContentView(R.layout.gameover);
	        yes = (ImageButton) findViewById(R.id.yes);
	        no = (ImageButton) findViewById(R.id.no);
	        
	        
	        Context context = getApplicationContext();
			CharSequence text = "Your Current Score -> "+MainChar.count+" Time -> "+MainChar.countTime;
			int duration = Toast.LENGTH_LONG;
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			
			
	        yes.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent start = new Intent("kushal.game.catchme.StartingPoint");
					startActivity(start);
				}
			});
	        no.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					System.exit(1);
					//Intent start3 = new Intent("kushal.game.catchme.Send");
					//startActivity(start3);
				}
			});
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	@Override
	public void onBackPressed() {
		Context context = getApplicationContext();
		CharSequence text = "Please Press Ok Button";
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
}
