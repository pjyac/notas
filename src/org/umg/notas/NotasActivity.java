package org.umg.notas;




import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class NotasActivity extends Activity {
	public static Button btnotas = null;
	public static EditText txtuser, txtpass;
	public static Spinner spsemeste, spyear;
	public static String usuario, password, semester, year;
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 if (android.os.Build.VERSION.SDK_INT > 9) {
		      StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		      StrictMode.setThreadPolicy(policy);
		    }
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_notas);
		
		btnotas = (Button)findViewById(R.id.button1);
		txtuser = (EditText)findViewById(R.id.editText1);
		txtpass = (EditText)findViewById(R.id.editText2);
		spsemeste = (Spinner)findViewById(R.id.spinner1);
		spyear = (Spinner)findViewById(R.id.spinner2);
				
	
		final Context context = this;
		
		btnotas.setOnClickListener(new View.OnClickListener() {
			 
			  
			  public void onClick(View arg0) {
				  if (usuario != null) {
						  usuario = web_notas.usuario;
				  }
				  else
				  {
					  usuario = txtuser.getText().toString();
				  }
				  if (password != null){
					  password = web_notas.password;
				  }
				  else{
					  password = txtpass.getText().toString();  
				  }			 
				  	  semester = spsemeste.getSelectedItem().toString();  
					  year = spyear.getSelectedItem().toString();  		  
				  Log.d("semestre", semester);
				  Log.d("anio", year);
			    Intent intent = new Intent(context, web_notas.class);
			    intent.putExtra("user", usuario);
			    intent.putExtra("passwd", password);
			    intent.putExtra("sem" , semester);
			    intent.putExtra("anio", year);	   
			    startActivity(intent);
			  }
	 
			});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.notas, menu);
		return true;
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		
		spsemeste = (Spinner)findViewById(R.id.spinner1);
		spyear = (Spinner)findViewById(R.id.spinner2);
		
		usuario = web_notas.usuario;
			password =web_notas.password;
			
			semester = null;
			year = null;
	}

	

}
