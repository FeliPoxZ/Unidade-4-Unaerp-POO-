package clientes;

import produtos.Laptop;
import produtos.Produtos;
import produtos.Smartphone;
import produtos.TV;

import java.util.ArrayList;
import java.util.Scanner;

public class CarrinhoDeCompras {
    static Scanner input = new Scanner(System.in); //Scaner responsavel por obtenção de informações

    //Atributos
    private int quantidadeTvs;
    private int quantidadeSmartphones;
    private int quantidadeLapTops;
    private ArrayList<Produtos> produtosPresentesNoCarrinho;
    //fim dos atributos

    //Construtores
    public CarrinhoDeCompras() {
        this.produtosPresentesNoCarrinho = new ArrayList<>();
    }

    public CarrinhoDeCompras(int quantidadeTvs, int quantidadeSmartphones, int quantidadeLapTops, ArrayList<Produtos> produtosPresentesNoCarrinho) {
        this.quantidadeTvs = quantidadeTvs;
        this.quantidadeSmartphones = quantidadeSmartphones;
        this.quantidadeLapTops = quantidadeLapTops;
        this.produtosPresentesNoCarrinho = produtosPresentesNoCarrinho;
    }
    //Fim dos construtores

    //Getters e setters
    public int getQuantidadeTvs() {
        return quantidadeTvs;
    }

    public void setQuantidadeTvs(int quantidadeTvs) {
        this.quantidadeTvs = quantidadeTvs;
    }

    public int getQuantidadeSmartphones() {
        return quantidadeSmartphones;
    }

    public void setQuantidadeSmartphones(int quantidadeSmartphones) {
        this.quantidadeSmartphones = quantidadeSmartphones;
    }

    public int getQuantidadeLapTops() {
        return quantidadeLapTops;
    }

    public void setQuantidadeLapTops(int quantidadeLapTops) {
        this.quantidadeLapTops = quantidadeLapTops;
    }

    public ArrayList<Produtos> getProdutosPresentesNoCarrinho() {
        return produtosPresentesNoCarrinho;
    }

    public void setProdutosPresentesNoCarrinho(ArrayList<Produtos> produtosPresentesNoCarrinho) {
        this.produtosPresentesNoCarrinho = produtosPresentesNoCarrinho;
    }
    //Fim dos getters e setters

    //Metodo responsavel por adicionar itens no carrinho
    public  void AdicionarAoCarrinho(){
        String produtoAdicionado; //variavel responsavel por armazenar o item que ira ser adicionado ao carrinho
        boolean validation = true; //variavel de controle
        String temp; //variavel de controle para adicionar mais de um item ao carrinho
        int quantidadeRelativa = 0; //quantidade de itens que ele deseja adicionar

        while (validation){
            //obtenção de qual item vai ser adicionado
            System.out.println("Qual o produto que deseja comprar?\nTV, SmartPhone ou laptops");
            produtoAdicionado = input.next().toLowerCase();

            if (produtoAdicionado.equals("tv")){
                //Se for a TV:
                TV t = new TV("Roku", "rk2024", 4200.00,
                        "4k", "Amazon Prime", "Internet");
                System.out.println("Quantas TVs deseja?");
                quantidadeRelativa = input.nextInt();
                for (int i = 0; i < quantidadeRelativa; i++) {
                    this.produtosPresentesNoCarrinho.add(t);
                }
                this.quantidadeTvs += quantidadeRelativa; //adiciona a quantidade de tvs adicionada

            }else if (produtoAdicionado.equals("smartphone")){
                //Se for smartphone
                Smartphone sp = new Smartphone("OPPO", "RF01", 2500.00,
                        "full hd", "Dimensity 700", "5000 mAh");
                System.out.println("Quantos SmartPhones deseja?");
                quantidadeRelativa = input.nextInt();
                for (int i = 0; i < quantidadeRelativa; i++) {
                    this.produtosPresentesNoCarrinho.add(sp);
                }
                this.quantidadeSmartphones += quantidadeRelativa;//adiciona na quantidade de smartphones  adicionados
            }else if (produtoAdicionado.equals("laptop")){
                //Se for laptops
                Laptop lp = new Laptop("ASUS", "Vivobook2024", 5000.00, "2.5K", "Intel i5",
                        "12500 mAh", "pt-BR", "Linux Ubuntu");
                System.out.println("Quantos LapTops deseja?");
                quantidadeRelativa = input.nextInt();
                for (int i = 0; i < quantidadeRelativa; i++) {
                    this.produtosPresentesNoCarrinho.add(lp);
                }
                this.quantidadeLapTops += quantidadeRelativa; //adiciona na quantidade de laptops  adicionados
            }else {
                System.out.println("Produto invalido tente novamente");
                return;
            }

            //Caso queira comprar mais de item
            System.out.println("Deseja continuar comprando?");
            temp = input.next().toLowerCase();
            if (temp.equals("sim") || temp.equals("s")){
                validation = true;
            }else {
                validation = false;
            }
        }
    }

    //Metodo responsavel por remover itens no carrinho
    public void removerCarrinho(){
        String produtoAserRemovido; //variavel responsavel por armazenar o item que ira ser removido do carrinho
        int quantidadeAserRemovida; //quantidade de itens que ele deseja remover

        //obtenção de qual item vai ser removido
        System.out.println("Qual é o produto que deseja remover? TVs, SmartPhones, ou LapTops?\n");
        produtoAserRemovido = input.next().toLowerCase();

        switch (produtoAserRemovido){
            //Se for TV
            case "tv":
                System.out.println("Quantas TVs deseja remover? Total atual: " + getQuantidadeTvs() + "\n");
                quantidadeAserRemovida = input.nextInt();
                //Verifica se o usuario que remover mais do que tem no carrinho -> e interrompe se for true
                if (quantidadeAserRemovida > getQuantidadeTvs()){
                    System.out.println("Erro numero de TVs INVALIDO tente novamente\n");
                    return;
                }
                for (int i = 0; i < quantidadeAserRemovida; i++) {
                    for (Produtos p : this.produtosPresentesNoCarrinho){
                        if (p.getModelo().equals("rk2024")){
                            TV t = (TV) p;
                            this.produtosPresentesNoCarrinho.remove(t);
                            break;
                        }
                    }
                }
                //Remove do atributo quantidadeTvs a quantidade removida
                int quantidadeDeTvsAtualizada = getQuantidadeTvs();
                quantidadeDeTvsAtualizada -= quantidadeAserRemovida;
                setQuantidadeTvs(quantidadeDeTvsAtualizada);
                break;
            case "smartphone":
                //se for smartphones
                System.out.println("Quantas Smartphones deseja remover? Total atual: " + getQuantidadeSmartphones() + "\n");
                quantidadeAserRemovida = input.nextInt();
                //Verifica se o usuario que remover mais do que tem no carrinho -> e interrompe se for true
                if (quantidadeAserRemovida > getQuantidadeSmartphones()){
                    System.out.println("Erro numero de Smartphoness INVALIDO tente novamente\n");
                    return;
                }
                for (int i = 0; i < quantidadeAserRemovida; i++) {
                    for (Produtos p : this.produtosPresentesNoCarrinho){
                        if (p.getModelo().equals("RF01")){
                            Smartphone sp = (Smartphone) p;
                            this.produtosPresentesNoCarrinho.remove(sp);
                            break;
                        }
                    }
                }
                //Remove do atributo quantidadeSmartphones a quantidade removida
                this.quantidadeSmartphones -= quantidadeAserRemovida;
                break;
            case "laptop":
                //Se for laptop
                System.out.println("Quantas LapTops deseja remover? Total atual: " + getQuantidadeLapTops() + "\n");
                quantidadeAserRemovida = input.nextInt();
                //Verifica se o usuario que remover mais do que tem no carrinho -> e interrompe se for true
                if (quantidadeAserRemovida > getQuantidadeSmartphones()){
                    System.out.println("Erro numero de LapTops INVALIDO tente novamente\n");
                    return;
                }
                for (int i = 0; i < quantidadeAserRemovida; i++) {
                    for (Produtos p : this.produtosPresentesNoCarrinho){
                        if (p.getModelo().equals("Vivobook2024")){
                            Laptop lp = (Laptop) p;
                            this.produtosPresentesNoCarrinho.remove(lp);
                            break;
                        }
                    }
                }
                //Remove do atributo quantidadeLaptops a quantidade removida
                this.quantidadeLapTops -= quantidadeAserRemovida;
                break;
            default:
                System.out.println("Produto invalido! Tente novamente");
                break;
        }
    }

    //Metodo responsavel por mostrar os itens presente no carrinho, e o valor total da compra
    // (valor total do carrinho)
    public void mostrarCarrinho(){
        if (verificarCarrinho()){
            System.out.println("Carrinho vazio");
            return;
        }
        for (Produtos p : this.produtosPresentesNoCarrinho){
            System.out.println(p);
        }
        System.out.println("O total a pagar é: " + calcularPreco());
    }

    //Verifica se carrinho está vazio
    public boolean verificarCarrinho(){
        if (this.produtosPresentesNoCarrinho.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    //faz o calculo do preco total do carrinho para ser mostrado
    private double calcularPreco(){
        double precoDasTvs = getQuantidadeTvs() * 4200.00;
        double precoDosSmartPhones = getQuantidadeSmartphones() * 2500.00;
        double precoDosLaptops = getQuantidadeLapTops() * 5000.00;

        return (precoDosLaptops + precoDasTvs + precoDosSmartPhones);
    }
}
