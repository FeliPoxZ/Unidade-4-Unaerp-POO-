package clientes;

import java.util.ArrayList;
import java.util.Scanner;

public class Clientes {

    Scanner input = new Scanner(System.in); //Scaner responsavel por obtenção de informações

    //Atributos
    private String nome;
    private String email;
    private String senha;
    private CarrinhoDeCompras ListaDeProdutosComprados;
    //Fim dos atributos

    //Construtores
    public Clientes() {
        ListaDeProdutosComprados = new CarrinhoDeCompras();
    }

    public Clientes(String nome, String email, String senha, CarrinhoDeCompras listaDeProdutosComprados) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        ListaDeProdutosComprados = listaDeProdutosComprados;
    }
    //Fim dos construtores


    //Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public CarrinhoDeCompras getListaDeProdutosComprados() {
        return ListaDeProdutosComprados;
    }

    public void setListaDeProdutosComprados(CarrinhoDeCompras listaDeProdutosComprados) {
        ListaDeProdutosComprados = listaDeProdutosComprados;
    }
    //Fim dos getters e setters

    //Metodo responsavel por adicionar itens ao carrinho (encapsulando o metodo que reamente faz essa adição)
    public void adicionarCarrinho(){
        this.ListaDeProdutosComprados.AdicionarAoCarrinho();
    }

    //Metodo responsavel por mostrar os itens e o preço total do carrinho (encapsulando o metodo que reamente faz essa mostragem)
    public void mostrarCarrinho(){
        this.ListaDeProdutosComprados.mostrarCarrinho();
    }

    //Metodo responsavel por remover itens ao carrinho (encapsulando o metodo que reamente faz essa remover)
    public void removerCarrinho(){
        this.ListaDeProdutosComprados.removerCarrinho();
    }


    //Metodo responsavel por cadastrar o cliente (adicionar um cliente na lista de clientes cadastrados)
    public ArrayList<Clientes> cadastrarCliente (ArrayList<Clientes> clientesCadastrados){
        System.out.println("Insira seu nome completo");
        String nomeParaCadastro = input.next();
        System.out.println("Insira um email valido: ");
        input.reset();
        String emailDeCadastro = input.next();
        String senhaDeCadastro;

        System.out.println("Insira uma senha: ");
        senhaDeCadastro = input.next();

        Clientes cl = new Clientes();
        cl.setEmail(emailDeCadastro);
        cl.setNome(nomeParaCadastro);
        cl.setSenha(senhaDeCadastro);
        clientesCadastrados.add(cl);

        return clientesCadastrados;

    }

    //Metodo responsavel por validar se há algum cliente com o email e senha passados no menu principal
    public static boolean loginCliente (String senha, String email, ArrayList<Clientes> clientesCadastrados){
        if (clientesCadastrados.isEmpty()){
            return false;
        }
        for (Clientes cl : clientesCadastrados){
            if (cl.getEmail().equals(email) && cl.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }


    //ToString
    @Override
    public String toString() {
        return getNome();
    }
}
