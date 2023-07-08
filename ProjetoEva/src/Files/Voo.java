package Files;

import javax.swing.JOptionPane;

/**
 * @author Gabriel Camargo
 * @author Leonardo Gomes da Silva
 */
public class Voo {

    private Aviao aeronave;
    private int nro;
    private String data, hora;

    public Voo(Aviao aeronave, int nro, String data, String hora) {
        this.aeronave = aeronave;
        this.nro = nro;
        this.data = data;
        this.hora = hora;
    }

    public int getNro() {
        return this.nro;
    }

    public String getData() {
        return this.data;
    }

    public String getHora() {
        return this.hora;
    }

    //apenas para teste, apagar no final
    public Aviao getAviao() {
        return this.aeronave;
    }

    @SuppressWarnings("finally")
	public int lugaresVagos() {
        int lugaresVagos = 0;
        boolean flagLugaresVagos = false;
        //conta os lugares vagos no voo selecionado
        try {
            for (int h = 0; h < aeronave.getFileiras(); h++) {
                for (int g = 0; g < aeronave.getPoltronas(); g++) {
                    if (aeronave.verificaLugarOcupado(h, g) == false) {
                        lugaresVagos += 1;
                    }
                }
            }
        } catch (RuntimeException e) {
        	flagLugaresVagos = true;

        } finally {
        	if(flagLugaresVagos == true) {
        		JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado");
                System.exit(1);
                return 0;
        	}else {
        		return lugaresVagos;
        	}
        }
    }
}
