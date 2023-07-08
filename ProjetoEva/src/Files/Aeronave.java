package Files;

/**
 * @author Gabriel Camargo
 * @author Leonardo Gomes da Silva
 */

public class Aeronave {
    
    protected String modelo;

    public Aeronave(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
}
