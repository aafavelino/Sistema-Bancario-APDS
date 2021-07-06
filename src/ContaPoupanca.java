public class ContaPoupanca extends Conta{
  public float rendimento; 
  
  public ContaPoupanca(float rendimento, float saldo,int agencia, int numConta){
    super(saldo, agencia, numConta);
    this.rendimento=rendimento;
  }
  @Override
  public float retornarSaldo(){
    return super.retornarSaldo()*rendimento;   
  }
}