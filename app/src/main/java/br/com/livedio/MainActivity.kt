package br.com.livedio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvList: RecyclerView //rvList seria a denominação para recyclerViewList, tem como tipo o RecyclerView. O lateinit seria próxima do Java, estamos criando um atributo de classe sem inicializá-lo, ou setar null. Por padrão, no Kotlin, precisamos inicializar ele, assim a gente cria um atributo (sabendo que opde ser nulo) e mesmo assim iniciamos ele.
    private val adapter = MenuItemAdapter() //Criamos outra variável (e já inicializamos) nomeada de adapter com o valor da classe MenuItemAdapter.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniciaViews()
        setItemsLista()
    }

    private fun iniciaViews() { // Esse é o nosso método inicial, ele vai ser chamado sempre que a tela for criada. Por isso ele está no onCreate.
        rvList = findViewById(R.id.rv_list) //Aqui encontramos uma view pelo seu id. Note que precisamos do R.id.
        rvList.adapter = adapter // Criamos o adapter (uma classe adaptadora), ele consegue modificar a exibição de cada item. Está presente no arquivo MenuItemAdapter.
        rvList.layoutManager = GridLayoutManager(this, 2) //Aqui dizemos a orientação deles e quantas colunas teremos em cada linha.
    }

    private fun setItemsLista() { //Criamos uma função que vai inserir valores na nossa lista.
        adapter.setItensList( //Aqui chamamos nosso adapter e aplicamos a função que criamos para setar os valores, passamos então a lista a ser inserida
            arrayListOf(
                MenuItemModel(
                    "cartões"
                ),
                MenuItemModel(
                    "meus comprovantes"
                ),
                MenuItemModel(
                    "investimentos"
                ),
                MenuItemModel(
                    "portabilidade de salário"
                ),
                MenuItemModel(
                    "cartões"
                ),
                MenuItemModel(
                    "meus comprovantes"
                ),
                MenuItemModel(
                    "investimentos"
                ),
                MenuItemModel(
                    "portabilidade de salário"
                )
            )
        )
    }
}