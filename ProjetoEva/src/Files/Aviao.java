package Files;

/**
 * @author Gabriel Camargo
 * @author Leonardo Gomes da Silva
 */
public class Aviao extends Aeronave {

    Passageiro lugares[][];//array de lugares
    int qtdFileiras, qtdPoltronas;

    public Aviao(String modelo, int qtdFileiras, int qtdPoltronas) {
        super(modelo);
        this.qtdFileiras = qtdFileiras;
        this.qtdPoltronas = qtdPoltronas;
        this.lugares = new Passageiro[qtdFileiras][qtdPoltronas];
    }
    
    public int getFileiras() {
    	return this.qtdFileiras;
    }
    
    public int getPoltronas() {
    	return this.qtdPoltronas;
    }

    public Passageiro getPassageiro(int fileira, int poltrona) {
    	return this.lugares[fileira][poltrona];
    }

    public void setPassageiro(int fileira, int poltrona, Passageiro passageiro) {
    	this.lugares[fileira][poltrona] = passageiro;
    }
    
    public boolean verificaLugarOcupado(int fileira, int poltrona) {
    	if (this.lugares[fileira][poltrona] == null) {
    		return false;
    	}
    	else{
    		return true;
    	}
    }
    
}
