package ufrpe.aula1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
public class Bancodados extends SQLiteOpenHelper {

    private static final String TAG = "sql";
    // Nome do banco
    public static final String NOME_BANCO = "banco_dados";
    private static final int VERSAO_BANCO = 1;

    public Bancodados(Context context) {
        // context, nome do banco, factory, versão
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "Criando as Tabelas rubrica,entradas e saidas...");
        db.execSQL("create table if not exists rubricas (" +
                "_id integer primary key autoincrement, " +
                "descricao text); ");

        db.execSQL("create table if not exists entradas (" +
                "_id integer primary key autoincrement, " +
                "id_rubrica INT,"+
                "descricao text,"+
                "valor float(10,2),"+
                "data date); ");

        db.execSQL("create table if not exists saidas (" +
                "_id integer primary key autoincrement, " +
                "id_rubrica INT,"+
                "descricao text,"+
                "valor float(10,2),"+
                "data date); ");

        Log.d(TAG, "Tabelas criadas com sucesso.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Caso mude a versão do banco de dados, podemos executar um SQL aqui

    }

    public long insert_rubrica(Rubricas rubricas)
    {
        long res;
        SQLiteDatabase db = getWritableDatabase();
        try {
                ContentValues values = new ContentValues();
                values.put("descricao", rubricas.getDescricao());
                res= db.insert("rubricas", null, values);
                db.close();
                return res;
        } finally {
            db.close();
        }
    }
    public Cursor carrega_rubricas(){
        Cursor cursor;
        String[] campos =  {"_id","descricao"};
        SQLiteDatabase db = getWritableDatabase();
        cursor = db.query("rubricas", campos, null, null,
                null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

}
