import java.util.ArrayList;

public class Cliente {
	private String nome;
	public String CPF;
	public Conta conta;
	private ArrayList <String> historico;
	 
 public Cliente(String nome, String CPF, Conta conta) {
   this.nome=nome;
   this.CPF=CPF;
   this.conta=conta;
   historico=new ArrayList <String>();
  }
  
 public void adicionarHistorico(String operacao) {
   historico.add(operacao);
  }

 public void retornarHistorico() {
   for (String hist: historico) {
     System.out.println(hist);
    }
  }
}