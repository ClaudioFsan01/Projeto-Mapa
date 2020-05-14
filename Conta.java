
public abstract class Conta  implements java.lang.Comparable<Conta>{// Classe Conta abstrata pois ela n�o pode ser instanciada pois n�o existe conta generica somente conta poupan�a e corrente
	 // quem for instanciar uma conta , obrigatoriamente deve instanciar a ContaCorrente ou ContaPoupan�a
	

	protected int numero;
	private String nome;		
	protected double saldo;
	protected String endereco;
	
	public void setNumero(int numero) {
		if(numero<0) {
			System.out.println("Inserir um numero inteiro maior que zero");
		}
		else {
			this.numero = numero;
		}
		
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNome(String nome) {
		if(nome != " " && nome != null) {
			this.nome = nome;
		}
		else {
			System.out.println(" Inserir um nome valido !");
		}
		
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setEndereco(String endereco) {
		if(endereco != " " && endereco != null) {
			this.endereco = endereco;
			System.out.println(" Endere�o inserido com sucesso !");
			
		}
		else {
			System.out.println(" Inserir um endere�o valido !");
			}	
		
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int compareTo(Conta outraContra)
	{
		if(this.getSaldo() == outraContra.getSaldo()) {
			return 0; //se o objeto comparado for igual a este objeto
		}else {
			if(this.getSaldo() < outraContra.getSaldo()) {
				return -1; //se o saldo deste objeto for menor que o saldo do objeto dado
			}else {
				return 1;
			}	
		
	  }

   }
	
	
	/* Inserindo aqui o m�todos abstratos deposita(double valor),  saca(double valor)
	  Isso faz com que as classes filhas  ContaCorrente e ContaPoupan�a obrigatoriamente reescrevam esses m�todos cada uma com as 
	  suas peculiaridades. 
	  Nesse contexto n�o me foi conveniente criar uma interface que implemente esses metodos pois quero que uma referencia 
	  do tipo Conta acesse esses m�todos que ser�o reecritos nas classes filhas ContaCorrente e ContaPoupan�a.
	  E tambem n�o me foi conveniente declarar essa classe Conta sendo do tipo interface pois quero que as classes filhas herdem sem ter que 
	  implementar os m�todos acima pois em uma interface n�o se implementa o corpo (o que o m�todo faz ou como faz uma determinada execu��o).
	  
	  Existe um recurso em Java que, em uma classe abstrata, podemos escrever que determinado m�todo.
    ser� sempre escrito pelas classes filhas. Isto �, um m�todo abstrato.
   Ele indica que todas as classes filhas (concretas, isto �, que n�o forem abstratas) devem reescrever
   esse m�todo ou n�o compilar�o. � como se voc� herdasse a responsabilidade de ter aquele m�todo.*/
	
	public abstract void deposita(double valor);
	public abstract void saca(double valor);	
	
	


}
