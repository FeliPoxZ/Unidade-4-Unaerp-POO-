import clientes.Clientes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //scaner para obtenção de dados
        ArrayList<Clientes> listaDeClientesCadastrados = new ArrayList<>(); // lista de clientes Cadastrados
        String senhaTemp; //variavel responsavel por armazenar a senha do login
        String emailTemp; //variavel responsavel por armazenar o email do login
        int temp = 1; // variavel de controle
        int opcaoDoMenu; //variavel de controle do menu

        Clientes clienteDaSessao = null; //cliente ativo da sessao do sistema

        //laço reponsavel por sempre carregar a tela de login e o menu
        while (true){
            //if responsavel por alternar entre menu e tela de login
            if (temp == 1){
                //entrou na tela de login
                System.out.println("Tela de login ----------------------\n");
                System.out.println("Insira seu email: ");
                emailTemp = input.next();
                System.out.println("Insira sua senha: ");
                senhaTemp = input.next();

                //valida se existe aquele cliente na lista de clientes cadastrados
                boolean validacao = Clientes.loginCliente(senhaTemp, emailTemp, listaDeClientesCadastrados);

                //Se true
                //O cliente da sessão é resgatado
                //se false
                //Solicita o cadastro
                if (validacao){
                    temp = 2;
                    for (Clientes c : listaDeClientesCadastrados){
                        if (c.getEmail().equals(emailTemp) && c.getSenha().equals(senhaTemp)){
                            clienteDaSessao = c;
                        }
                    }
                }else {
                    System.out.println("Deseja cadastrar-se?");
                    String opcao = input.next().toLowerCase();
                    //Solicita o cadastro
                    //caso nao queira finaliza o app
                    if (opcao.equals("sim")||opcao.equals("s")){
                        Clientes cl = new Clientes();
                        listaDeClientesCadastrados = cl.cadastrarCliente(listaDeClientesCadastrados);
                    }else{
                        System.out.println("Até mais!");
                        return;
                    }

                }

            }else {
                //Menu principal
                System.out.println("\n\n\n\n\n\n\nEntrando no menu principal...");
                System.out.println("Para adicionar ao carrinho clique 1, para remover do carrinho clique 2, para mostrar o total da compra clique 3, para sair do programa clique 4:");
                opcaoDoMenu = input.nextInt();
                switch (opcaoDoMenu){
                    case 1:
                        clienteDaSessao.adicionarCarrinho();
                        break;
                    case 2:
                        clienteDaSessao.removerCarrinho();
                        break;
                    case 3:
                        clienteDaSessao.mostrarCarrinho();
                        break;
                    default:
                        System.out.println("Saindo do programa...");
                        temp = 1;
                }
            }

        }
    }
}