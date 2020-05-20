/* Um mapa é composto por um conjunto de associações entre um objeto chave a um objeto valor. 
	 * java.util.Map é um mapa, pois é possível usá-lo para mapear uma chave a um valor, por
       exemplo: mapeie à chave "empresa" o valor "Caelum". 
       
       O método put(Object, Object) da interface Map recebe a chave e o valor de uma nova
      associação. Para saber o que está associado a um determinado objeto-chave, passa-se esse objeto no
    método get(Object) . Sem dúvida essas são as duas operações principais e mais frequentes realizadas
   sobre um mapa.
   
   Um mapa é muito usado para "indexar" objetos de acordo com determinado critério, para podermos
   buscar esse objetos rapidamente. Um mapa costuma aparecer juntamente com outras coleções, para
   poder realizar essas buscas!
   *
    Suas principais implementações são o HashMap , o TreeMap e o Hashtable .
    
    Apesar do mapa fazer parte do framework, ele não estende a interface Collection , por ter um
   comportamento bem diferente. Porém, as coleções internas de um mapa (a de chaves e a de valores)
    são acessíveis por métodos definidos na interface Map .
   */


import java.util.Scanner;
import java.lang.Math;
import java.util.Map;


public class Principal {
	
	public static void main(String [] args) {
		int op;
		
		Scanner sc = new Scanner(System.in);
		Agencia ag = new Agencia();
		Conta conta= null;
			
		 do {
			   op= menu(sc);
			   
			 switch(op){
			 
			 case 1:
				 
				  try {
					  conta = new ContaCorrente();				 
						 cadastrarConta(conta,sc);
						 adicionarConta(conta, sc,ag);
						 
				  }catch(IllegalArgumentException e) {
					  System.out.println(" \n"+ e.getMessage());		
				  }catch(UnsupportedOperationException e) {
					  System.out.println(" \n"+ e.getMessage());	
				  }
				 
				 break;
				 
			 case 2:
				 try {
					 conta = new ContaPoupanca();				 
					 cadastrarConta(conta,sc);
					 adicionarConta(conta, sc,ag);
					 
				 }catch(IllegalArgumentException e) {
					  System.out.println(" \n"+ e.getMessage());		
				  }catch(UnsupportedOperationException e) {
					  System.out.println(" \n"+ e.getMessage());	
				  }
				 
				  
				 break;
				 
			 case 3:
				 try {
					 
					 System.out.println(" Deseja exibir o mapa de contas (1- ordenado) ou (2-desordenado) ?");
					  op= sc.nextInt();
					 if(op ==1) {			 
						 
						 escolherMapaExibir(sc,ag);					 
						 
					 }else {
						 Map<Integer, Conta> mapaContasDesordenado = ag.retornaMapaContasOrdemDesordemNumeroConta(op); // retorna a lista de contas
						 exibirMapaContas(mapaContasDesordenado);
					 }				
				 }catch(NullPointerException e) {
					 System.out.println(" \n"+ e.getMessage());					 
				 }
				 break;
				 
			 case 4:
				 try {
				 pesquisarConta(sc, ag);
				 }catch(NullPointerException e) {					
					 System.out.println(e.getMessage());
				 }
				 
				 break;
			 case 5:/*
				 try {
				 removerConta(sc, ag);
				 }catch(NullPointerException e) {
					 System.out.println(" \n"+ e.getMessage());				
				 }*/
				 break;
				 
			 case 6:/*
				    try {
				    	 alterarConta(sc, conta, ag);	
				    }catch(NullPointerException e) {
				    	System.out.println(" \n"+ e.getMessage());			
				    }	*/		 
					
				 break;
				 
			 case 7:/*
				 try {
				 atualizarConta(sc, conta, ag);
				 }catch(NullPointerException e) {
					 System.out.println(" \n"+ e.getMessage());	
				 }*/
				 break;
				 
			 case 8:
				 try {
					 realizarDeposito(sc, conta, ag);
				 }catch(IllegalArgumentException e) {
					 System.out.println(" \n"+ e.getMessage());	
				 }
				
				 break;
				 
			 case 9:
				 try {
					 realizarSaque(sc, conta, ag);
				 }catch(SaldoInsuficienteException e) {
					 System.out.println(" \n"+ e.getMessage());	
					 System.out.println(" \n"+ e.getMensagem());	 /*Somente no método saca da classe ContaPoupanca
					   é passado uma String no parametro do construtor  SaldoInsuficienteException. 
					   Criei um método personalizado getMensagem() para retornar essa mensagem */  
				 }
				
				 break;
				 
			 case 10:
				 System.out.println(" \n Programa encerrado ! \n");
				 break;
				 
				 default:
					 System.out.println(" \n Opção invalida !");
					 break;
		 }			 
			
			 
		 }while(op !=10); 
		 
		
	}
	
	
	
	static int menu(Scanner sc) {
		int op=0;
		
		  System.out.println("    Menu de opçoes : \n");
		  
		  System.out.println("(1)- Criar Conta Corrente : \n"
		  		            +"(2)- Criar Conta Poupança : \n"
		  		            +"(3)- Exibir o Mapa de contas : \n"
		  		            +"(4)- Pesquisar Conta : \n"
		  		            +"(5)- Remover Conta: \n"
		  		            +"(6)- Alterar Conta no Mapa: \n" 
		  		            +"(7)- Atualizar Conta : \n"
		  		            +"(8)- Depositar : \n"
		  		            +"(9)- Sacar : \n"
		  		            +"(10)- Sair");		  
		 op = sc.nextInt();
		  
		return op;
	}
	/*
	public static void  atualizarConta(Scanner sc, Conta conta, Agencia ag) {
		
		System.out.println(" Entre com o numero da conta : \n");
		int numeroConta = sc.nextInt();
		
		System.out.println(" Entre com o endereço atual do titular da conta : \n");
		String endereco = sc.next();
		
		if(! ag.atualizarEndereco(numeroConta, endereco)) {// se o retorno igual a falso
			System.out.println(" Conta inexistente ou numero da conta invalido ! \n");
		}
		
	}
	/*
	public static void alterarConta(Scanner sc, Conta conta, Agencia ag) {
		
		 removerConta(sc,ag);	
		
		  System.out.println(" \n Deseja inserir uma Conta (1-Corrente) (2- Poupança) :\n");
		    if(sc.nextInt()==1) {
		    	conta = new ContaCorrente();
		    	cadastrarConta(conta,sc);
		    	ag.inserirConta(conta);
		    }else {
		    	conta = new ContaPoupanca();
		    	cadastrarConta(conta,sc);
		    	ag.inserirConta(conta);
		    }
			
		
	}
	*/
	
	public static void cadastrarConta(Conta conta, Scanner sc) {
		
		int numConta = (int)(Math.random()*1000)+1;	
		
		 conta.setNumero(numConta);
		
		 System.out.println("\n Entre com o nome do titular :");
		 conta.setNome(sc.next());   
		
		 System.out.println("\n Entre com o endereço do titular :");
		 conta.setEndereco(sc.next());	
		 
		 System.out.println("\n Entre com o valor do deposito :");
		 conta.deposita(sc.nextDouble());			 
		 exibirConta(conta);
		
	}
	
	public static void  adicionarConta(Conta conta, Scanner sc, Agencia ag) {
	
		int op = escolherMapa(sc);
		if(op==1) {
			
			int tipoOrdem = escolherTipoOrdenacao(sc);
						 
			 ag.inserirContaMapaOrdenado(conta, tipoOrdem);				
			
		}else {
			ag.inserirContaMapaDesordenado(conta);
		}
		
	}
	
	/*public static void removerConta(Scanner sc, Agencia ag) {
		
		
		System.out.println(" \n Remover pelo (1-numero da conta) ou (2-index) ? : \n");	
		if(sc.nextInt()==1) {
			System.out.println(" \n Informe o numero da conta : \n");		 
			  if(ag.removerContaPeloNumero(sc.nextInt())) {
				  System.out.println("\n Conta removida com sucesso ! \n");
			  }
			  else {
				  System.out.println("\n Conta não foi encontrada ! \n");
			  }
			
			
		}else {
			System.out.println(" \n Informe o index : \n");	
			 ag.removerConta(sc.nextInt()-1);			
		}
		
		
	}*/
	
	public static void pesquisarConta(Scanner sc, Agencia ag) {
		int mapaEscolhido =0, opcao;
		
		mapaEscolhido = escolherMapa(sc);
		
		if(mapaEscolhido==1) {
			
			 System.out.println(" \n Deseja pesquisar pelo (1-numero da conta), (2-Titular), (3-Saldo ): \n");	
			 opcao = sc.nextInt();
			 
			 if(opcao==1) {
				 
				 buscarPeloNumero(sc, ag, mapaEscolhido);
				 
			 }else {
				 if(opcao== 2) {
					 buscarPeloTitular(sc, ag);
				 }else {
					 buscarPeloSaldo(sc,ag);
				 }
			 }
			
			
		}else {			
			
			 buscarPeloNumero(sc, ag, mapaEscolhido);	
			
			
		}
		
		
	}
	
	
	public static void escolherMapaExibir(Scanner sc, Agencia ag) {
		
	  	  System.out.println(" \n Deseja exibir mapa ordenado pelo (1- Numero da conta), (2- Titular), (3 - Saldo) : \n");
	  	  int op = sc.nextInt();
	  	  
	  	  if(op==1) {
	  		Map<Integer, Conta> mapaContasOrdenadoPeloNumero = ag.retornaMapaContasOrdemDesordemNumeroConta(op);
	  		exibirMapaContas(mapaContasOrdenadoPeloNumero);
	  	  }else {
	  		  if(op==2) {
	  			Map<String, Conta> mapaContasOrdenadoPeloTitular = ag.retornaMapaContasOrdenadoPeloTitular();
	  			exibirMapaContasOrdenadoTitular(mapaContasOrdenadoPeloTitular);
	  		  }else {
	  			Map<Double, Conta> mapaContasOrdenadoPeloSaldo = ag.retornaMapaContasOrdenadoPeloSaldo();
	  			exibirMapaContasOrdenadoSaldo( mapaContasOrdenadoPeloSaldo);
	  		  }
	  	  }
		
	}
	
	
      public static void buscarPeloNumero(Scanner sc, Agencia ag,  int mapaEscolhido) {
    	  
    	  System.out.println(" \n Informe o numero da conta : \n");		 
			 Conta conta = ag.pesquisarContaPeloNumero(sc.nextInt(), mapaEscolhido);
			 
			 validarConta(conta);	
    	  
      }
      
      public static void buscarPeloTitular(Scanner sc, Agencia ag) {
    	  
    	  System.out.println(" \n Informe o nome do titular da conta : \n");	    	  
    	  Conta conta = ag.pesquisarContaPeloTitular(sc.next());    	  
    	
    	  validarConta(conta);
      }
      
      
      public static void buscarPeloSaldo(Scanner sc, Agencia ag) {
    	  
    	  System.out.println(" \n Informe o saldo da conta : \n");	    	  
    	  Conta conta = ag.pesquisarContaPeloSaldo(sc.nextDouble());   
    	  
    	  validarConta(conta);
    	  
      }
      
      
      public static void validarConta(Conta conta) {
    	  
    	  if(conta != null) {
				 exibirConta(conta);
			 }else {
				 System.out.println(" Não foi encontrado uma conta associada ou conta inexistente ! \n");
			 }
			
    	  
      }
      
      
	
	
	public static void  realizarDeposito(Scanner sc, Conta conta, Agencia ag) {
	   int op =0;
		
		op = escolherMapa(sc);
		
		 System.out.println("\n Entre com o numero da Conta : \n");
		  conta = ag.pesquisarContaPeloNumero(sc.nextInt(), op);
		  if(conta != null) {
			  
		 System.out.println("\n Entre com o valor do deposito : \n");
			  conta.deposita(sc.nextDouble());
		  }else {
			  System.out.println("\n Conta não encontrada ou inexistente : \n");
		  }
		
		
	}
	
	public static void  realizarSaque(Scanner sc, Conta conta, Agencia ag) {
	int op =0;
		
		op = escolherMapa(sc);		
		 
		 System.out.println("\n Entre com o numero da Conta : \n");
		  conta = ag.pesquisarContaPeloNumero(sc.nextInt(), op);
		  if(conta != null) {
			  
		 System.out.println("\n Entre com o valor do saque : \n");
			  conta.saca(sc.nextDouble()); 
		  }else {
			  System.out.println("\n Conta não encontrada ou inexistente : \n");
		  }
		
		
	}	
	
	
	public static void exibirConta(Conta conta) {
		
		
	 System.out.println("\n Dados da Conta : \n");
	 
	 System.out.println("\n Numero : "+ conta.getNumero()+ "- Titular : "+ conta.getNome()+ " - Endereço : "+ conta.getEndereco()+ " - Saldo : "+ conta.getSaldo());
	}
	
	   /*
	    * O método "keySet()" retorna um Set(um conjunto) com todas as chaves do
        * nosso HashMap, e tendo o Set com todas as Chaves, 
         * podemos facilmente pegar
        * os valores que desejamos
        * */
	
	public static void exibirMapaContas(Map<Integer, Conta> OrdemDesordem) {
		
		for(Integer numeroConta : OrdemDesordem.keySet()) {/*Percorrendo cada chave do conjunto de chaves retornado pelo método
		mapaContas.keySet() e atribuindo cada chave a variavel  numeroConta */
			
			Conta conta = OrdemDesordem.get(numeroConta); /* mapaContas.get(numeroConta) buscando no mapa mapaContas o objeto associado 
			à chave numeroConta passado no parametro do método get(numeroConta) */
			
			System.out.println("\n Numero : "+ conta.getNumero()+ "- Titular : "+ conta.getNome()+ " - Endereço : "+ conta.getEndereco()+ " - Saldo : "+ conta.getSaldo());	
		}
	}
	
    public static void exibirMapaContasOrdenadoTitular(Map<String, Conta> contasOrdenadoTitular) {
		
		for(String titular : contasOrdenadoTitular.keySet()) {
			
			Conta conta = contasOrdenadoTitular.get(titular); 
			
			System.out.println("\n Numero : "+ conta.getNumero()+ "- Titular : "+ conta.getNome()+ " - Endereço : "+ conta.getEndereco()+ " - Saldo : "+ conta.getSaldo());	
		}
	}
    
    public static void exibirMapaContasOrdenadoSaldo(Map<Double, Conta> contasOrdenadoSaldo) {
		
  		for(Double saldo : contasOrdenadoSaldo.keySet()) {
  			
  			Conta conta = contasOrdenadoSaldo.get(saldo); 
  			System.out.println("\n Numero : "+ conta.getNumero()+ "- Titular : "+ conta.getNome()+ " - Endereço : "+ conta.getEndereco()+ " - Saldo : "+ conta.getSaldo());	
  		}
  	}

	public static int escolherMapa(Scanner sc) {
		
		 System.out.println("\n Deseja efetuar a operação no mapa (1-Ordenado) ou (2 -Desordenado) ? : \n");

		 return  sc.nextInt();
	}
	
	public static int escolherTipoOrdenacao(Scanner sc ) {
				
		 System.out.println("\n Deseja ordenar o mapa pelo (1-Numero da conta), (2 -Nome do Titular), (3- Saldo da Conta ) ? : \n");
		return sc.nextInt();
		 
	}
	
	
	
}





