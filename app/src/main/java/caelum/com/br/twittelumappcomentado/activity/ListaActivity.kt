package caelum.com.br.twittelumappcomentado.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ArrayAdapter
import caelum.com.br.twittelumappcomentado.MainActivity
import caelum.com.br.twittelumappcomentado.R
import kotlinx.android.synthetic.main.activity_lista.*

//Usamos a AppCompatActivity para manter compatibilidade
class ListaActivity: AppCompatActivity() {

    //Sobrescrever o metodo onCreate da AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Vincular o layout com a activity
        setContentView(R.layout.activity_lista)

        //A lista é carregada uma unica vez por ciclo.
        //Somente quando a activity é criada
        CarregarListaString()

        //Vincular ação  click do FloatingActionButton
        //fab_add.setOnClickListener{mostrarSnackbar(it)}

        //Vincular ação  click do FloatingActionButton
        fab_add.setOnClickListener{CarregarMainActivity()}

    }

    //Carregar a activity MainActivity quendo o botão for clicado
    private fun CarregarMainActivity()
    {
        val intentMain = Intent(this, MainActivity::class.java)
        startActivity(intentMain)
    }

    private fun CarregarListaString()
    {
        val tweets = gerarListaTweets()
        //Na tela só podemos colocar views, precisaremos adaptar nossa lista de tweets para que ela possa ser exibida pelo ListView
        val adapterTweet = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tweets)
        //Carregar atraves do adapter a lista de string.
        lst_tweet.adapter =adapterTweet
    }


    private fun gerarListaTweets():List<String>
    {
        return listOf("Meu primeiro tweet","Meu segundo tweet", "Meu terceiro tweet")
    }


    private fun mostrarSnackbar(view: View)
    {
        Snackbar.make(view,"FAB Clicado",Snackbar.LENGTH_SHORT).show()
    }


}