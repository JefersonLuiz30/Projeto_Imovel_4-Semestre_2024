package app.model;



//class modelo de representação de um objeto
public class Imovel {

    // Propriedade é uma caracteristica
    // private bloqueia o acesso (protege o acesso a somente a classe desse objeto
    // tem acesso)
    // pulic abre acesso a todas as areas do sitema


    //Selecionar Gett and setter
    private int codigo;
    private String rua;
    private String numero;
    private double tamanho;
    private double valor;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    // metodo get ler informação
    public int getCodigo() {
        return codigo;
    }

    // metodo set para gravar informação
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    //Incapsulamento é conjunto de boas praticas ao objeto , melhora manutenção e organização.
    //imovel.codigo=10; ( vc insere o valor diretamente)
    //imovel.setCodigo(10); (Aqui vc pede para o set alterar o valor (Boa pratica))

}
