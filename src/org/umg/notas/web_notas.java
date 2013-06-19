package org.umg.notas;



import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class web_notas extends NotasActivity {
	private WebView webView;
	public static String usuario, password;
	public static Button btnvolver = null;
	@Override
	@TargetApi(9)
	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.web_notas);
		webView = (WebView) findViewById(R.id.webView1);
		 Bundle bundle=getIntent().getExtras();
		 webView.loadUrl("http://190.149.206.186/umg/umg.php?usr="+bundle.getString("user")+"&pss="+bundle.getString("passwd")+"&semester="+bundle.getString("sem")+"&anio="+bundle.getString("anio"));

		 usuario = bundle.getString("user");
		 password = bundle.getString("passwd");

		 btnvolver = (Button)findViewById(R.id.button2);
		 
		 btnvolver.setOnClickListener(new View.OnClickListener() { 
			 
			 
			  public void onClick(View arg0) {	
				  	finish();
			  }
	 
			});
	
	}

}
