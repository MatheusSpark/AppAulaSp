package devandroid.matheus.appaulasp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "App_aulaSp";
    //Instanciando o nome da SharedPref
    private static final String PREF_NOME = "App_aulaSp_Pref";
    //Instanciando a SharedPref
    SharedPreferences preferences;
    //Instanciando o objeto onde irá ser salvo os dados (generico)
    SharedPreferences.Editor dados;
    //Simulando um objeto Produto
    String nomeProduto;
    int codigoProduto;
    float precoProduto;
    boolean estoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: Rodando");
        preferences = getSharedPreferences(PREF_NOME, Context.MODE_PRIVATE);
        Log.i(TAG, "onCreate: Pasta Shared Criada");
        //Abrindo a edição do objeto
        dados = preferences.edit();
        //setando as informações do objeto dados baseado no projeto produto.
        nomeProduto = "notebook";
        codigoProduto = 1234;
        precoProduto = 1999.50F;
        estoque = true;
        // salvado dados no SharedPreferences
        dados.putString("nomeProduto", nomeProduto);
        dados.putInt("codigoProduto", codigoProduto);
        dados.putFloat("precoProduto", precoProduto);
        dados.putBoolean("estoque", estoque);
        dados.apply();
        //Modo Debug, acessando os dados pela memória.
        Log.i(TAG, "onCreate: Dados sendo salvados");
        Log.i(TAG, "onCreate: Produto: " +nomeProduto);
        Log.i(TAG, "onCreate: Codigo Produto: " + codigoProduto);
        Log.i(TAG, "onCreate: Preço: " + precoProduto);
        Log.i(TAG, "onCreate: Estoque: " + estoque);
        //Recuperando dados
        Log.i(TAG, "onCreate: Recuperando dados");
        Log.i(TAG, "onCreate: Produto: " +preferences.getString("nomeProduto", ""));
        Log.i(TAG, "onCreate: Codigo Produto: " + preferences.getInt("codigoProduto",0));
        Log.i(TAG, "onCreate: Preço: " + preferences.getFloat("precoProduto", 0.0F));
        Log.i(TAG, "onCreate: Estoque: " + preferences.getBoolean("estoque", false));
        //Eliminando dado especifico do SharedPref
        dados.remove("estoque");
        dados.apply();
        //Limpando SharedPref
        dados.clear();
        dados.apply();
    }
}