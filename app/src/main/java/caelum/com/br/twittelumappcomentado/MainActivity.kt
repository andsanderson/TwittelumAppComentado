package caelum.com.br.twittelumappcomentado

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //define qual vai ser o layout para essa activity
        setContentView(R.layout.activity_main)

        //Adicionar botão voltar no menu
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //define o comportamento do botão ao ser clicado
        btnPublicar.setOnClickListener(View.OnClickListener { publicarTweetNoToast()})
    }

    //Sobrescrever método responsavel por criar menu
     override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         super.onCreateOptionsMenu(menu)

         //Carregar layout do menu.
         //Inflate serve para carregar arquivo xlm "layout"
         menuInflater.inflate(R.menu.tweet_menu, menu)
         return true
    }

    //Sobrescrever método responsavel por identificar item do menu selecionado ...
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        super.onOptionsItemSelected(item)

        when (item?.itemId){
            R.id.tweet_menu_cadastrar->{
                publicarTweetNoToast()

            }
            //Caso o bnt voltar seja clicado executa a ação de finalizar Activity
            android.R.id.home -> finish()
        }
        return  true
    }


    private fun publicarTweetNoLog()
    {
        //Obter valor do text
        val valor = edtTweet.text.toString()

        //Escreverlog
        Log.i("tweet",valor)
    }

    private fun publicarTweetNoToast()
    {
        //Obter valor do text
        val valor = edtTweet.text.toString()

        //Mostrar caixa de mensagem na tela por um tem definido
        Toast.makeText(this,valor,Toast.LENGTH_SHORT).show()
        finish()

    }
}
