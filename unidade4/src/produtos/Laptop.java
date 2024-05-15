package produtos;

public class Laptop extends Produtos {

    //Atributos
    private String tela;
    private String processador;
    private String bateria;
    private String linguagemDoTeclado;
    private String SistemaOperacional;

    //fim dos atributos

    //Construtores
    public Laptop() {
       super();
    }

    public Laptop(String marca, String modelo, Double preco, String tela, String processador, String bateria, String linguagemDoTeclado, String sistemaOperacional) {
        super(marca, modelo, preco);
        this.tela = tela;
        this.processador = processador;
        this.bateria = bateria;
        this.linguagemDoTeclado = linguagemDoTeclado;
        SistemaOperacional = sistemaOperacional;
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

    public String getLinguagemDoTeclado() {
        return linguagemDoTeclado;
    }

    public void setLinguagemDoTeclado(String linguagemDoTeclado) {
        this.linguagemDoTeclado = linguagemDoTeclado;
    }

    public String getSistemaOperacional() {
        return SistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        SistemaOperacional = sistemaOperacional;
    }

    //Fim dos getters e setters

    //toString
    @Override
    public String toString() {
        return super.toString() + String.format("Tela: %s\n" +
                "Processador: %s\n" +
                "Bateria: %s\n" +
                "Layout do teclado: %s\n" +
                "Sistema Operacional: %s\n", getTela(), getProcessador(), getBateria(), getLinguagemDoTeclado(), getSistemaOperacional());
    }
}
