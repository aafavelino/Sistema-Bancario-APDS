public class ContaCorrente extends Conta {
    private float taxaAdministracao;

    public ContaCorrente(float taxaAdministracao, float saldo, int agencia, int numConta) {
        super(saldo, agencia, numConta);
        this.taxaAdministracao = taxaAdministracao;
    }

    @Override
    public float retornarSaldo() {
        return super.retornarSaldo() - taxaAdministracao;
    }
}