package produtos;

public class Smartphone extends Produtos{

    //Atributos
    private String tela;
    private String processador;
    private String bateria;

    //fim dos atributos


    //Construtores

    public Smartphone() {
        super();
    }

    public Smartphone(String marca, String modelo, Double preco, String tela, String processador, String bateria) {
        super(marca, modelo, preco);
        this.tela = tela;
        this.processador = processador;
        this.bateria = bateria;
    }

    //Fim dos construtores

    //Getters e setters

    public String getTela() {
        return tela;
    }

    public void setTela(String tela) {
        this.tela = tela;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getBateria() {
        return bateria;
    }

    public void setBateria(String bateria) {
        this.bateria = bateria;
    }

    //Fim do getters e setters

    //To string
    @Override
    public String toString() {
        return super.toString() + String.format("Tela: %s\n" +
                "Processador: %s\n" +
                "Bateria: %s\n", getTela(), getProcessador(), getBateria());
    }

}
