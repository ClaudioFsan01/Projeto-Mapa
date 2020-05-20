import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
	
public class Agencia {
	
	
		
	    private Map<Integer, Conta> mapaContasDesordenado = new HashMap<>(); /* A classe HashMap<> implementa a interface Map.
	                                                              Map<Integer, Conta> passado para a interface Map a chave e o valor que ser�o associados*/
	    private Map<Integer, Conta> mapaContasOrdenPeloNumeroConta = new TreeMap<>();
	    
		private Map<String, Conta> mapaContasOrdenPeloTitular = new TreeMap<>();
		//private Map<Integer, Conta> mapaContasOrdenadoPeloTitular = new TreeMap<>();
		
		private Map<Double, Conta> mapaContasOrdenadoPeloSaldo = new TreeMap<>(); /*TreeMap ir� iterar de acordo com a "ordena��o natural" das chaves de acordo 
		com o m�todo compareTo() (ou um Comparator fornecido externamente). Al�m disso, ele implementa a interface SortedMap , que cont�m m�todos que dependem 
		dessa ordem de classifica��o. 
		
		A TreeMap<> possui um comparador para ordenar os objetos no mapa de acordo com o criterio definido pelo programador
		no m�todo comparaTo() do objeto ordenado no mapa.
		*/
	
		public void inserirContaMapaDesordenado(Conta conta) {
				
			mapaContasDesordenado.put(conta.getNumero(), conta); /*O m�todo put(Object, Object) da interface Map recebe a chave e o valor de uma nova
                                                       associa��o.*/				
		}
		
		
		public void inserirContaMapaOrdenado(Conta conta, int tipoOrdenacao) {
			/* A chave escolhida para associar ao objeto � o numero da conta mas o criterio de ordena��o das contas no mapa � outro*/
			
			if(tipoOrdenacao ==1) {
				mapaContasOrdenPeloNumeroConta.put(conta.getNumero(), conta);
			}else {
				if(tipoOrdenacao == 2) {
					mapaContasOrdenPeloTitular.put(conta.getNome(), conta);
				}else {
					mapaContasOrdenadoPeloSaldo.put(conta.getSaldo(), conta);	
				}
			}
						
			
		}
		
		
		public Map<Integer, Conta> retornaMapaContasOrdemDesordemNumeroConta(int opcao){
			if(opcao==1) {
				tratarMapaOrdenDesordNumeroConta(mapaContasOrdenPeloNumeroConta);				
				return mapaContasOrdenPeloNumeroConta;
			}else {
				tratarMapaOrdenDesordNumeroConta(mapaContasDesordenado);
				return mapaContasDesordenado;
			}
			 // verifica se o mapa est� vazio 
			  // retonra a mapa de conta 
		}
		
		public Map<String, Conta> retornaMapaContasOrdenadoPeloTitular(){
			tratarMapaOrdenadoPeloTitular();
			return mapaContasOrdenPeloTitular;
		}
		
		public Map<Double, Conta> retornaMapaContasOrdenadoPeloSaldo(){
			tratarMapaOrdenadoPeloSaldo();
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
			   
			   tratarMapaOrdenDesordNumeroConta(mapaContasOrdenPeloNumeroConta);		   
			   return mapaContasOrdenPeloNumeroConta.get(numeroConta);
			   
		   }else {
			   
			   tratarMapaOrdenDesordNumeroConta(mapaContasDesordenado);
			   
			   return mapaContasDesordenado.get(numeroConta);
			   
		   }
		 
		   /*get(numeroConta) Ser� buscado um objeto associado � chave numeroConta no mapa caso exista o objeto associado � essa chave � retornado e caso 
		    * contrario � retornado o valor null. */
		   
		  /* if(conta != null) {
			   return conta;
		   }
		   
		   return null;*/
		   
	   }
	   
	   
	   public Conta pesquisarContaPeloTitular(String titular) {
		   
		   tratarMapaOrdenadoPeloTitular();
		   
		  return mapaContasOrdenPeloTitular.get(titular);
		   
	   }
	   
	   
	   public Conta pesquisarContaPeloSaldo(Double saldo) {
		   
		   tratarMapaOrdenadoPeloSaldo();
		   
		   return  mapaContasOrdenadoPeloSaldo.get(saldo);
	   }
		
		
		public void tratarMapaOrdenDesordNumeroConta(Map<Integer, Conta> ordenDesordNumeroConta) { // verifica se a lista est� vazia caso sim lan�a a exce��o de ponteiro nulo
						
				if(ordenDesordNumeroConta.isEmpty()) {
					throw new NullPointerException(" Mapa est� vazio ! \n"); 
				}			
			
		}
		
		
		public void tratarMapaOrdenadoPeloTitular() {
			if(mapaContasOrdenPeloTitular.isEmpty()) {
				throw new NullPointerException(" Mapa ordenado pelo titular da conta est� vazio ! \n");
			}
			
		}
		
		public void tratarMapaOrdenadoPeloSaldo() {
			
			if(mapaContasOrdenadoPeloSaldo.isEmpty()) {
				throw new NullPointerException(" Mapa ordenado pelo saldo da conta est� vazio ! \n"); 
			}
			
		}
		
		
		
	


}
