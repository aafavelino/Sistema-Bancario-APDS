import java.util.Scanner;

public class Main {
    public static void main(String [] args){
     Scanner ler = new Scanner(System.in);
     
     Banco banco = new Banco();
     Conta c;

     int op;
     String  cpf2, nome, cpf, escolha;
     float valor;
     
     do{
     System.out.println("-----------------------");
     System.out.println("|\tMenu Banco\t|");
     System.out.println("-----------------------");
     System.out.println("1 - Adicionar cliente");
     System.out.println("2 - Sacar");
     System.out.println("3 - Fazer transferência");
     System.out.println("4 - Retirar extrato");
     System.out.println("5 - Depositar");
     System.out.println("6 - Retornar saldo da conta");
     System.out.println("7 - Sair");
     System.out.print("Digite a opção desejada: ");

     op = ler.nextInt();
     
     switch (op) {
         case 1: // Adicionar cliente
             System.out.print("\nDigite seu cpf: \n");
             cpf = ler.next();
             System.out.print("Digite seu nome: \n");
             nome = ler.next();
             System.out.print("Digite o tipo de conta ( CC, CP, CA)\n");
             escolha = ler.next();

             if(escolha.equals("CC")){
                c = new ContaCorrente(10.0f , 0.0f, 73, 132);
             }else if(escolha.equals("CP")){
                c = new ContaPoupanca(0.1f, 0.0f,42, 30);
             }else if(escolha.equals("CA")){
                c = new ContaAcoes(0.1f, 0.0f,43, 32);
             }else{
                 System.out.println("Conta inválida");
                 break;
             }
             banco.cadastrarCliente(nome,cpf, c);
             break;
        case 2: // Sacar
                System.out.print("Digite seu cpf:\n");
                cpf = ler.next();
                System.out.print("Digite o valor que você quer sacar:\n");
                valor = ler.nextFloat();
                    banco.buscarCliente(cpf).conta.saque(valor);
                    System.out.println("Saque realizado com sucesso");
                    System.out.println("Valor sacado: " +  valor);
              
             break;
        case 3: // Fazer tranferência
             
             System.out.print("Digite seu cpf:\n");
             cpf = ler.next();
             System.out.print("Digite o cpf do cliente que deseja tranferir:\n");
             cpf2 = ler.next();
             System.out.print("Digite o valor que deseja transferir: \n");
             valor = ler.nextFloat();

                 banco.buscarCliente(cpf).conta.transferencia(valor, banco.buscarCliente(cpf2).conta);
                 System.out.println("Transferência realizada com sucesso");
                 System.out.println("Valor tranferido = " + valor);
            
             break;

        case 4: // Retirar extrato
              System.out.print("Digite seu cpf:\n");
              cpf = ler.next();
              System.out.println("Historico  da conta: ");
              banco.buscarCliente(cpf).retornarHistorico();
            break;

        case 5: // Depositar
                System.out.print("Digite o cpf para depósito:\n");
                cpf = ler.next();
                System.out.print("Digite o valor que você quer depositar: \n");
                valor = ler.nextFloat();

                if(valor > 0){
                    banco.buscarCliente(cpf).conta.deposito(valor, banco.buscarCliente(cpf).conta);
                    System.out.println("Deposito realizado com sucesso");
                    System.out.println("Valor Depositado: R$" + valor);
                    System.out.println("Saldo total: R$" +  banco.buscarCliente(cpf).conta.retornarSaldo());
                    banco.buscarCliente(cpf).adicionarHistorico("Deposito: " + valor);
                }else{
                    System.out.println("Valor insuficiente");
                }
            break;
        case 6: // retornar saldo da conta
              System.out.print("Digite seu cpf:\n");
              cpf = ler.next();
              System.out.println("Saldo da conta: " + banco.buscarCliente(cpf).conta.retornarSaldo());
            break;
         
         
     }
     }while(op != 7);    

    }
}