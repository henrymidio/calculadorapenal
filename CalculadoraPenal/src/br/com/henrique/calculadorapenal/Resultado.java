package br.com.henrique.calculadorapenal;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

public class Resultado extends Activity {

	private EditText campoAcusado;
	private EditText campoProcesso;
	private GridView gv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_resultado);

		// Recupera dados da Intent
		Pena pena = (Pena) getIntent().getSerializableExtra("Pena");

		String[] tabela = new String[] { "Progressão", pena.getProgressao(),
				"Condicional", pena.getCondicional() };

		// Recupera views
		campoAcusado = (EditText) findViewById(R.id.editAcusado);
		campoProcesso = (EditText) findViewById(R.id.editProcesso);
		gv = (GridView) findViewById(R.id.gridview);
		

		// Seta griedview
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, tabela);
		gv.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.resultado, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
