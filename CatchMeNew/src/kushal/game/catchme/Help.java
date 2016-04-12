package kushal.game.catchme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class Help extends Activity{
	Button ok;
	static int i;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
		 i=0;
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        setContentView(R.layout.help);
	        ok = (Button) findViewById(R.id.ok1);
	        ok.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					System.exit(1);
			/*		CopyOfMain x = new CopyOfMain();
					Matrix.bool =  0;
					Object c = x;
					System.out.println("In Help");
					Matrix.bool =  2;
			Intent is = new Intent("kushal.game.catchme.Send");
			setResult(RESULT_OK, is);
			System.out.println("In start Help");
			//startActivity(is);
		finish();*/
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
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Matrix.bool =  0;
		System.out.println("Start ActivityResult");
		if(requestCode == RESULT_OK){
			System.out.println("In ActivityResult");
			startActivity(data);
			
		}
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
