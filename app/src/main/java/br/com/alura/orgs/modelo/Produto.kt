package br.com.alura.orgs.modelo

import java.math.BigDecimal

 data class Produto(
     val name: String,
     val descricao: String,
     val valor: BigDecimal,
     val ImagemUrl: String? = null


 ){

}
