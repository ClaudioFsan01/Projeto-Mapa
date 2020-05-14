import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
	
public class Agencia {
	
	
		
	    private Map<Integer, Conta> mapaContas = new HashMap<>(); /* A classe HashMap<> implementa a interface Map.
	                                                              Map<Integer, Conta> passado para a interface Map a chave e o valor que ser�o associados*/
	    
		
		//private Map<Integer, Conta> mapaContasOrdenadoPeloTitular = new TreeMap<>();
		private Map<Integer, Conta> mapaContasOrdenadoPeloSaldo = new TreeMap<>(); /*TreeMap ir� iterar de acordo com a "ordena��o natural" das chaves de acordo 
		com o m�todo compareTo() (ou um Comparator fornecido externamente). Al�m disso, ele implementa a interface SortedMap , que cont�m m�todos que dependem 
		dessa ordem de classifica��o. 
		
		A TreeMap<> possui um comparador para ordenar os objetos no mapa de acordo com o criterio definido pelo programador
		no m�todo comparaTo() do objeto ordenado no mapa.
		*/
	
		public void inserirContaMapaDesordenado(Conta conta) {
				
			mapaContas.put(conta.getNumero(), conta); /*O m�todo put(Object, Object) da interface Map recebe a chave e o valor de uma nova
                                                       associa��o.*/				
		}
		
		
		public void inserirContaMapaOrdenado(Conta conta) {
			/* A chave escolhida para associar ao objeto � o numero da conta mas o criterio de ordena��o das contas no mapa � outro*/
			
				mapaContasOrdenadoPeloSaldo.put(conta.getNumero(), conta);			
			
		}
		
		
		public Map<Integer, Conta> retornaMapaContasDesordenado(){
			tratarMapaVazio(mapaContas); // verifica se o mapa est� vazio 
			return mapaContas;  // retonra a mapa de conta 
		}
		
		public Map<Integer, Conta> retornaMapaContasOrdenado(){
			tratarMapaVazio(mapaContasOrdenadoPeloSaldo);
			return mapaContasOrdenadoPeloSaldo;
		}
	
		
		// remover uma conta da lista
		
		/*public void removerConta(int index ) {
			tratarListaVazia();
			
			  if(contas.remove(index) !=null) {
				  System.out.println(" Elemento removido com sucesso !");
			  }else {
				  System.out.println(" Elemento n�o foi removido com sucesso !");
			  }
		}*/
		
	/*	public boolean removerContaPeloNumero(int numero) {
			tratarMapaVazio();
			
			Conta conta = pesquisarContaPeloNumero(numero);			
				
			      if(conta != null) {
			    	  contas.remove(conta); // se o numero da conta do objeto acessado for igual ao numero passado no parametro 
						// o objeto em questao ser� removido da lista
						return true;		    	  
			      }	
			
			return false;		
			
			
		}*/
		
		// alterar contas na lista 
		
		/*public void alterarContas(int numeroContaAntiga, Conta nova) {
			
			if(removerContaPeloNumero(numeroContaAntiga)) {
				System.out.println("Conta antiga removida com sucesso ! \n");
			}else {
				System.out.println("Conta antiga n�o foi removida com sucesso ! \n");
			}
			
			inserirConta(nova);
			
		}*/
		
		
		// atualizar endere�o da conta
		
		
		/*public boolean atualizarEndereco(int numeroConta, String endereco) {
			  
			tratarMapaVazio();
			
			Conta conta = pesquisarContaPeloNumero(numeroConta);
			 
			 if(conta != null) {
				 conta.setEndereco(endereco);
				 return true;
			 }		
			
			return false;
		}
		*/
		
	   public Conta pesquisarContaPeloNumero(int numeroConta, int opcao) {
			
		   if(opcao ==1) {
			   
             tratarMapaVazio(mapaContasOrdenadoPeloSaldo);		   
			   return mapaContasOrdenadoPeloSaldo.get(numeroConta);
			   
		   }else {
			   
			   tratarMapaVazio(mapaContas);
			   
			   return mapaContas.get(numeroConta);
			   
		   }
		 
		   /*get(numeroConta) Ser� buscado um objeto associado � chave numeroConta no mapa caso exista o objeto associado � essa chave � retornado e caso 
		    * contrario � retornado o valor null. */
		   
		  /* if(conta != null) {
			   return conta;
		   }
		   
		   return null;*/
		   
	   }	
		
		
		public void tratarMapaVazio(Map<Integer, Conta> mapaContasOrdeOuDesord) { // verifica se a lista est� vazia caso sim lan�a a exce��o de ponteiro nulo
			if(mapaContasOrdeOuDesord.isEmpty()) {
				throw new NullPointerException(" Mapa vazio ! \n"); 
			}
			
		}
		
		
		
	


}
