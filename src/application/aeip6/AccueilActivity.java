package application.aeip6;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class AccueilActivity extends Activity {
	public final static String NUM_ETUDIANT = "3152609";
	private Button poly = null;
	private SharedPreferences preferences;
	private SharedPreferences.Editor editor;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        
        this.setPreferences(PreferenceManager.getDefaultSharedPreferences(this));
        this.setEditor(this.getPreferences().edit());
        
        Log.d("debug", "ceci est un test");
        
        poly = (Button)findViewById(R.id.poly);
        
        poly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(AccueilActivity.this);
            	Intent intent;
            	int num = preferences.getInt(NUM_ETUDIANT, 0);
            	Log.d("debug", String.valueOf(num));
            	if(preferences.getInt(NUM_ETUDIANT, 0) == 0){
            		intent = new Intent(AccueilActivity.this, LoginActivityPolys.class);
                	startActivity(intent);
            	}
            	else{
            		intent = new Intent(AccueilActivity.this, AccueilActivity.class);
            		startActivity(intent);
            	}
              
            }
          });
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.accueil, menu);
        return true;
    }
    
    public SharedPreferences getPreferences() {
		return preferences;
	}


	public void setPreferences(SharedPreferences preferences) {
		this.preferences = preferences;
	}


	public SharedPreferences.Editor getEditor() {
		return editor;
	}


	public void setEditor(SharedPreferences.Editor editor) {
		this.editor = editor;
	}
    
}
