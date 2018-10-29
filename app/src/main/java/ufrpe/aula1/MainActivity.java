package ufrpe.aula1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    TextView login,pass;
    Button bt;
    Preferencias pref=new Preferencias();
    public static final String MESSAGE_LOGIN = "Messagemdologin";
    EditText user;
    EditText log ;
    EditText passw;
    Button cancel ;
    Button cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context c = getApplicationContext();
        login = (TextView) findViewById(R.id.edit_login);
        login.setText(pref.getString(this,"login").toString());
        pass=(TextView) findViewById(R.id.edit_password);
        bt = (Button) findViewById(R.id.bt_logar);
        //pref.removeall(c);
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (login.getText().toString().equals(pref.getString(c,"login").toString()) && pass.getText().toString().equals(pref.getString(c,"senha").toString()))
                {
                    Toast.makeText(getApplicationContext(),"Logado",Toast.LENGTH_LONG);
                    Intent intent = new Intent(getApplicationContext(), Tela1.class);
                    intent.putExtra(MESSAGE_LOGIN,login.getText().toString());
                    startActivity(intent);
                }else
                {
                    Toast.makeText(getApplicationContext(),"Usuário/Senha inválidos",Toast.LENGTH_LONG);
                }
            }
        });
        //abrir painel se não houver cadastro
        if (pref.getString(c,"usuario")=="")
        {
            LayoutInflater layoutInflaterAndroid = LayoutInflater.from(this);
            View mView = layoutInflaterAndroid.inflate(R.layout.activity_cadastro, null);
            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(this);
            alertDialogBuilderUserInput.setView(mView);
            user = (EditText) mView.findViewById(R.id.id_cad_nome);
            log = (EditText) mView.findViewById(R.id.id_cad_login);
            passw = (EditText) mView.findViewById(R.id.id_cad_senha);
            cancel = (Button) mView.findViewById(R.id.id_cad_cancel);
            cadastrar = (Button) mView.findViewById(R.id.id_cad_cadastrar);
            final AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
            cadastrar.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    if (user.getText().toString().equals("") || passw.getText().toString().equals("") || log.getText().toString().equals(""))
                        Toast.makeText(c, "Valores Invalidos", Toast.LENGTH_LONG).show();
                    else {
                        pref.setString(c, "usuario", user.getText().toString());
                        pref.setString(c, "login", log.getText().toString());
                        pref.setString(c, "senha", passw.getText().toString());
                        Toast.makeText(c, "Usuário Cadastrado", Toast.LENGTH_LONG).show();
                        alertDialogAndroid.cancel();
                    }
                }
            });
            alertDialogAndroid.show();
        }


    }
}
