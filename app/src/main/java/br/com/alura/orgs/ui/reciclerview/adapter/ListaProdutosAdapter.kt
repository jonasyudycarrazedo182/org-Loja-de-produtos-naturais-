package br.com.alura.orgs.ui.reciclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.databinding.ProdutoItemBinding
import br.com.alura.orgs.extensions.tentaCarregarImagem
import br.com.alura.orgs.modelo.Produto
import coil.load
import java.text.NumberFormat
import java.util.Locale

class ListaProdutosAdapter(private val context: Context, produtos: List<Produto>) :
    RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ListaProdutosAdapter.ViewHolder {
        val inflater = LayoutInflater.from(this.context)
        val binding = ProdutoItemBinding.inflate(inflater, parent, false)
        return ListaProdutosAdapter.ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ListaProdutosAdapter.ViewHolder, position: Int) {

        val produto = produtos[position]
        holder.vincula(produto)

    }

    override fun getItemCount(): Int = produtos.size
    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()

    }

    private val produtos = produtos.toMutableList()

    class ViewHolder(private val binding: ProdutoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun vincula(produto: Produto) {
            val name = binding.produtoItemName
            name.text = produto.name
            val description = binding.produtoItemDescricao
            description.text = produto.descricao
            val valor = binding.produtoItemValor
            val valorEmMoeda: String = formatarParaMoedaBrasileira(produto.valor)
            valor.text = valorEmMoeda

            val visibilidade = if (produto.ImagemUrl != null) {
                View.VISIBLE
            } else {
                View.GONE
            }

            binding.imageView.visibility = visibilidade

            binding.imageView.tentaCarregarImagem(produto.ImagemUrl)
        }

    }
}

private fun formatarParaMoedaBrasileira(valor: java.math.BigDecimal): String {
    val formatador: NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
    return formatador.format(valor)
}


