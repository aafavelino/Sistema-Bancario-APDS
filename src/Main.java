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
             System.out.print("\nDigite seu cpf: ");
             cpf = ler.nextLine();
             System.out.println("Digite seu nome: ");
             nome = ler.nextLine();
             System.out.println("Digite o tipo de conta ( CC, CP, CA)");
             escolha = ler.nextLine();

             if(escolha.equals("CC")){
                c = new ContaCorrente(10.0f , 0.0f, 73, 132);
             }else if(escolha.equals("CP")){
                c = new ContaPopanca();
             }else if(escolha.equals("CA")){
                c = new ContaAcoes();
             }else{
                 System.out.println("Conta inválida");
                 break;
             }
             banco.cadastrarCliente(nome,cpf, c);
             break;
        case 2: // Sacar
                System.out.println("Digite seu cpf:");
                cpf = ler.nextLine();
                System.out.println("Digite o valor que você quer sacar:");
                valor = ler.nextFloat();
                    banco.buscarCliente(cpf).conta.saque(valor);
                    System.out.println("Saque realizado com sucesso");
                    System.out.println("Valor sacado: " +  valor);
              
             break;
        case 3: // Fazer tranferência
             
             System.out.println("Digite seu cpf:");
             cpf = ler.nextLine();
             System.out.println("Digite o cpf do cliente que deseja tranferir: ");
             cpf2 = ler.nextLine();
             System.out.println("Digite o valor que deseja transferir: ");
             valor = ler.nextFloat();

                 banco.buscarCliente(cpf).conta.transferencia(valor, banco.buscarCliente(cpf2));
                 System.out.println("Transferência realizada com sucesso");
                 System.out.println("Valor tranferido = " + valor);
            
             break;

        case 4: // Retirar extrato
              System.out.println("Digite seu cpf:");
              cpf = ler.nextLine();
              System.out.println("Historico  da conta: " + banco.buscarCliente(cpf).retornarHistorico());
            break;

        case 5: // Depositar
                System.out.println("Digite seu cpf:");
                cpf = ler.nextLine();
                System.out.println("Digite o valor que você quer depositar: ");
                valor = ler.nextFloat();
                if(valor > 0){
                    banco.buscarCliente(cpf).conta.deposito(valor);
                    System.out.println("Deposito realizado com sucesso");
                    System.out.println("Valor Depositado: R$" + valor);
                    System.out.println("Saldo total: R$" +  banco.buscaCliente(cpf).conta.retornarSaldo());
                }else{
                    System.out.println("Valor insuficiente");
                }
            break;
        case 6: // retornar saldo da conta
              System.out.println("Digite seu cpf:");
              cpf = ler.nextLine();
              System.out.println("Saldo da conta: " + banco.buscarCliente(cpf).conta.retornarSaldo());
            break;
         
         default:
            System.out.println("Opção inválida, digite novamente");
     }
     }while(op != 7);    

    }
}