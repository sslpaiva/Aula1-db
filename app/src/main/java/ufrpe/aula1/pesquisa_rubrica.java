package ufrpe.aula1;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class pesquisa_rubrica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa_rubrica);
        Bancodados bd=new Bancodados(this);
        Cursor cursor = bd.carrega_rubricas();
        String[] nomecampos=new String[] {"_id","descricao"};
        int[] idview=new int[]{R.id.id_idrubricas,R.id.id_descricao_rubrica};
        ListView lista=(ListView) findViewById(R.id.listView_rubricas);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(),
                R.layout.listview_rubricas,cursor,nomecampos,idview,0);
        lista.setAdapter(adapter);
        Button cancelar = (Button) findViewById(R.id.id_cancel_rubrica);
        cancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

    }
}
