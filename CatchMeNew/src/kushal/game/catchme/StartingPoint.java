package kushal.game.catchme;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class StartingPoint extends Activity {

    MainChar mc;
    protected void onCreate(Bundle InstanceState) {
        super.onCreate(InstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mc = new MainChar(this);
        setContentView(mc);
        

    }
    
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	int count =0;
	@Override
	public void onBackPressed() {
		count++;
		Context context = getApplicationContext();
		CharSequence text = "Press One More time To Exit";
		int duration = Toast.LENGTH_SHORT;
		if(count==2)
			System.exit(0);
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

}
