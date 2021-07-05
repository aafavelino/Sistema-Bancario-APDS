public class Conta implements PadraoConta {
	private float saldo; 
	private int agencia; 
	private int numConta;

	ArrayList<String> extratoConta = new ArrayList<String>();

	@Override
	public void saque (float valor) {  
		if (saldo>=valor){
			saldo-=valor
			extratoConta.add("Sacou "+ String(valor));
		} else{
			System.out.println("Erro:Saque maior que o saldo");
		}  
	}

	@Override 
	public void deposito (float valor, Conta conta) {
		extratoConta.add("Depositou "+ String(valor));
		conta.saldo+=valor;
	}

	@Override
	public void transferencia (float valor,Conta conta) {
		if (saldo>=valor){
	 		saldo-=valor;
	 		conta.saldo+=valor;
	 		extratoConta.add("Transferiu "+ String(valor)+" Para "+ String(conta.numConta));
	 	}
	 	else{
	 		System.out.println("Erro:Transferencia maior que o saldo");
	 	} 
	}
	public float retornarSaldo() {
		return saldo;
	}

	@Override 
	public void extrato () {
		System.out.println("Extrato da conta");
		for (String ext: extratoConta) {
			System.out.println(ext);
		}	
	}
}
