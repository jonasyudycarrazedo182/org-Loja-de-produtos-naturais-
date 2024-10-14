package br.com.alura.orgs.dao

import br.com.alura.orgs.modelo.Produto

class ProdutosDao {

    fun adiciona(produto: Produto) {
        produtos.add(produto)
    }

    fun buscaTodos(): List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>(
            Produto(
                name = "Salada de frutas",
                descricao = "Laranja, manga e uva",
                valor = java.math.BigDecimal("19.83"),
            )
        )
    }

}


