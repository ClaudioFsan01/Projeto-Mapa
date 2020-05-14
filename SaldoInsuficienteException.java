

public class SaldoInsuficienteException extends RuntimeException {
	/*RuntimeException � a exception m�e de todas as exceptions unchecked. 
	 Exemplo de exce��o unchecked pois o compilador n�o checa se voc� est� tratando essas exce��es porque 
	tais problemas poderiam ser evitados pelo programador */
	
	/* Podemos transformar essa Exception de unchecked para checked, obrigando a quem chamar o m�todo 
	  saca(double valor) na classe Conta a dar try-catch , ou throws ex:
	 
public class SaldoInsuficienteException extends Exception {
String mensagem;	
	SaldoInsuficienteException(String mensagem){
		this.mensagem = mensagem;
	}
	
}
*/
	
	/*
	 Quando estendemos uma classe, n�o herdamos seus construtores, mas podemos acess�-los atrav�s
da palavra chave super de dentro de um construtor. As exce��es do Java possuem uma s�rie de
construtores �teis para poder popul�-las j� com uma mensagem de erro.
*/
	
	
	
	
	String mensagem;
	
	public SaldoInsuficienteException(String mensagem){
		this.mensagem = mensagem;
	}
	
	public SaldoInsuficienteException(double valor){
	  System.out.println("Saldo insuficiente na conta corrente para sacar o valor :"+valor);
		
	}
	
	
	public String getMensagem() {
		return this.mensagem;
	}

}
