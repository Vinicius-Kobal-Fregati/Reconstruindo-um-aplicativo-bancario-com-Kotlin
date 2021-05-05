package br.com.livedio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuItemAdapter : RecyclerView.Adapter<MenuItemAdapter.MenuItemAdapterViewHolder>() { //Estamos extendendo de outra classe adaptadora. Um ViewHolder é uma classe que vai gerenciar a posição de cada posição da nossa lista.

    private val list = mutableListOf<MenuItemModel>() //Aqui temos uma lista mutável com o tipo de MenuItemModel, é uma classe também e está presente no arquivo MenuItemModel.kt.

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemAdapterViewHolder { //Declaramos o layout de cada item do menu
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)// Iniciamos com o LayoutInflater.from, passamos o contexto, a partir do parent e chamamos o método inflate que vai inflar nosso layout (precisamos criar um próprio para isso, nesse caso, item_menu.xml), passando o activity main. O segundo parâmetro é o ViewGroup, no nosso caso, o parent, o terceiro é um parâmmetro para anexar o layout no hoot, por padrão, usamos false.
        return MenuItemAdapterViewHolder(view) //Vamos retornar nossa classe ViewHolder passando nossa variável view.
    }

    override fun getItemCount(): Int { //Esse método é utilizado internamente pelo recycler para poder ver como ele vai tratar a reciclagem dos itens.
        return list.size //Apenas retornamos o tamanho da nossa lista.
    }

    override fun onBindViewHolder(holder: MenuItemAdapterViewHolder, position: Int) {
        holder.iniciaViews(list[position]) //Aqui chamamos nosso holder, aplicamos o iniciaViews e passamos a posição atual da nossa lista. Com isso é possível acessar o item daquele momento.
    }

    fun setItensList(list: List<MenuItemModel>) { //Aqui vamos setar todos os dados na nossa lista.
        this.list.clear()
        this.list.addAll(list)
    }

    class MenuItemAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle by lazy { //By lazy é o carregamento "lento", ou sea, ele é criado mas não é inicializado logo no começo, ele só será chamado quando usarmos (chamarmos) ele. Também poderíamos usar o lateinit.
            itemView.findViewById<TextView>(R.id.tv_title)
        }

        fun iniciaViews(item: MenuItemModel) { //Esse método recebe um parâmetro que vai ser nosso modelo, item.
            tvTitle.text = item.titulo //Aqui nos chamamos, setamos o by lazy, nesse momento ele funcionará.
        }
    }
}