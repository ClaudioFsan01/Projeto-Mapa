
public class ContaPoupanca extends Conta{
		

	public void deposita(double valor)
	{
		if(valor<0) {
			throw new IllegalArgumentException(" Voce tentou depositar um valor invalido na conta poupan�a !");
			
		}else {
			this.saldo += valor;
			System.out.println(" Deposito efetuado com sucesso na conta poupan�a no valor de : "+ valor);
		}
		
		
	}
	
		
	/*  
	 A palavra chave throw, que est� no imperativo, lan�a uma Exception . Isto � bem diferente de
throws , que est� no presente do indicativo, e que apenas avisa da possibilidade daquele m�todo lan��la,
obrigando o outro m�todo que v� utilizar deste de se preocupar com essa exce��o em quest�o.
	*/
	
	/* Como a classe  SaldoInsuficienteException extends a classe RuntimeException e essa classe � a exception m�e de todas
	  as exceptions unchecked ,ou seja,  o compilador n�o checa se voc� est� tratando essas exce��es porque 
	tais problemas poderiam ser evitados pelo programador. 
	* Neste caso quem chama o m�todo  saca(double valor) n�o � obrigado a inserir o try catch*/
	public void saca(double valor)
	{
		if(valor > this.saldo)
		{	
			throw new SaldoInsuficienteException(" Saldo insuficiente na conta poupan�a tente um valor menor");		
		}
		else
		{
			this.saldo -= valor;
			System.out.println(" Saque efetuado com sucesso na conta poupan�a no valor de : "+ valor);
			
		}
		 
	}
	
	
	



}
