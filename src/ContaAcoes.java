public class ContaAcoes extends Conta {
    public float rendimento;

    public ContaAcoes(float rendimento,float saldo,int agencia, int numConta) {
        super(saldo,agencia,numConta);
        this.rendimento = redimento;

    }

    @Override
    public float retornarSaldo() {
        return super.retornarSaldo()*rendimento;
    }
    
} 
