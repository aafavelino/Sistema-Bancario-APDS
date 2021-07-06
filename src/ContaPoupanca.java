public class ContaPoupanca extends Conta{
  public float rendimento; 
  public float saldoR;

  public ContaPoupanca(int saldo){
    saldoR=saldo+10/100;
    rendimento=saldo-saldoR;
  
  }
  public float retornarSaldo(int saldo, int rendimento){
    return saldo+rendimento;
    
  }
}
