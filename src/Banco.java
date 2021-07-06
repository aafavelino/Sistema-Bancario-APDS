import java.util.List;
import java.util.ArrayList;

public class Banco {
    List<Cliente> clientes = new ArrayList <Cliente>();
    
    public Cliente buscarCliente (String cpf) {
    	
    	for( String achandocpf : clientes){
    		if (achandocpf.contains(cpf)) {
    			return achandocpf;
    		}		
    	}
    }
    
    public void cadastrarCliente(String nome, String cpf, Conta conta) {
    	
    	Cliente auxcliente = new Cliente (nome, cpf, conta);
    	
    	clientes.add(auxcliente);
    }
     
}
