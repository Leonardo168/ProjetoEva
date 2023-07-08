package Files;

/**
 * @author Gabriel Camargo
 * @author Leonardo Gomes da Silva
 */
public class Passageiro {
    
    final String nome, cpf;
    
    public Passageiro(String nome, String cpf){
       
        this.nome = nome;
        this.cpf = cpf;
       
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
   
}
