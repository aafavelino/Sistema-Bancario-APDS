public interface PadraoConta{
  public void saque(float valor);
  public void deposito (float valor,Conta conta);
  public void transferencia(float valor,Conta conta);
  public void extrato();
}