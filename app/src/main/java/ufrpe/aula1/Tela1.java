package ufrpe.aula1;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Tela1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Context c;
    Bancodados bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);
        c=this;
        bd =new Bancodados(c);
        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.MESSAGE_LOGIN);
        TextView textview = (TextView) findViewById(R.id.boasvindas);
        textview.setText("Bem Vindo(a): "+msg);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //drawerLayout=(DrawerLayout)findViewById(R.id.main_drawer);
        navigationView=(NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.home)
        {
            finish();
            return true;
        }else if (id==R.id.item_cadastrar_rubricas)
        {
            Toast.makeText(getApplicationContext(),"Cadastrar Rubricas",Toast.LENGTH_LONG).show();
            LayoutInflater layoutInflaterAndroid = LayoutInflater.from(this);
            View mView = layoutInflaterAndroid.inflate(R.layout.activity_cadastro_rubricas, null);
            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(this);
            alertDialogBuilderUserInput.setView(mView);
            final EditText edit_rubrica = (EditText) mView.findViewById(R.id.id_edit_rubrica);
            Button cadastrar = (Button) mView.findViewById(R.id.id_bt_rubrica);
            final AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
            cadastrar.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Rubricas rubricas = new Rubricas();
                    rubricas.setDescricao(edit_rubrica.getText().toString());
                    if (bd.insert_rubrica(rubricas)==-1)
                        Toast.makeText(getApplicationContext(), "Rubrica "+rubricas.getDescricao()+" Não Cadastrada", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(), "Rubrica "+rubricas.getDescricao()+" Cadastrada", Toast.LENGTH_LONG).show();
                    alertDialogAndroid.cancel();
            }
            });
            alertDialogAndroid.show();
        }else if (id==R.id.item_pesquisa_rubrica)
        {
            Toast.makeText(getApplicationContext(),"Pesquisar Rubricas",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), pesquisa_rubrica.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;


    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Toast.makeText(this,menuItem.getTitle().toString(),Toast.LENGTH_LONG).show();
        return false;
    }
}
