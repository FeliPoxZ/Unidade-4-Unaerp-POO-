package produtos;

public class TV extends Produtos{

    //Atributos
    private String tela;
    private String aplicativos;
    private String conectividade;
    //Fim dos atributos

    //Construtores
    public TV() {
        super();
    }


    public TV(String marca, String modelo, Double preco, String tela, String aplicativos, String conectividade) {
        super(marca, modelo, preco);
        this.tela = tela;
        this.aplicativos = aplicativos;
        this.conectividade = conectividade;
    }
    //Fim dos construtores


    //Getters e setters
    public String getTela() {
        return tela;
    }

    public void setTela(String tela) {
        this.tela = tela;
    }

    public String getAplicativos() {
        return aplicativos;
    }

    public void setAplicativos(String aplicativos) {
        this.aplicativos = aplicativos;
    }

    public String getConectividade() {
        return conectividade;
    }

    public void setConectividade(String conectividade) {
        this.conectividade = conectividade;
    }
    //Fim dos getters e setters


    //ToString
    @Override
    public String toString() {
        return super.toString() + String.format("Tela: %s\n" +
                "Aplicativos: %s\n" +
                "Conectividade: %s\n", getTela(), getAplicativos(), getConectividade());
    }
}
