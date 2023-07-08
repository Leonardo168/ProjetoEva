package Files;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 * @author Gabriel Camargo
 * @author Leonardo Gomes da Silva
 */
public class ProjetoEva {

    @SuppressWarnings("unused")
	public static void main(String[] args) {
    	
        Voo voo[] = new Voo[10];
        Aeronave aeronave[] = new Aeronave[10];
        int i = 0, j = 0, switchPrincipal;
        boolean flagPrincipal;

        do {
        	switchPrincipal = 0;
        	flagPrincipal = false;

            try {
                switchPrincipal = Integer.parseInt(JOptionPane.showInputDialog("Menu Principal\n 1.Parâmetros do Sistema\n 2.Reserva de Passagens\n 3.Sair"));

            } catch (NumberFormatException nfe) {
                flagPrincipal = true;

            } finally {
                if (flagPrincipal == true) {
                    switchPrincipal = 5;
                }
            }

            switch (switchPrincipal) {
            
                case 1: //Parâmetros do Sistema
                	
                    int switchParametros = 0;
                    boolean cadastrado, flagParametros;
                    
                    do {
                    	flagParametros = false;
                        try {
                            switchParametros = Integer.parseInt(JOptionPane.showInputDialog("Parâmetros do Sistema\n 1.Cadastrar Aeronave \n 2.Cadastrar Voo \n 3.Voltar"));

                        } catch (NumberFormatException nfe) {
                            flagParametros = true;

                        } finally {
                            if (flagParametros == true) {
                                switchParametros = 5;
                            }
                        }

                        switch (switchParametros) {
                        
                            case 1: //Cadastrar Aeronave
                            	
                                if (j < 10) {

                                	flagParametros = false;
                                    cadastrado = false;
                                    aeronave[j] = new Aeronave(JOptionPane.showInputDialog("Digite o modelo da aeronave"));

                                    try {
                                        for (int h = 0; h < j; h++) {
                                            if (aeronave[h].getModelo().equals(aeronave[j].getModelo())) {
                                                cadastrado = true;
                                            }
                                        }
                                    } catch (RuntimeException e) {
                                    	flagParametros = true;


                                    } finally{
                                    	if(flagParametros == true) {
                                    		JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado");
                                            System.exit(1);
                                    	}
                                    }
                                    if(cadastrado == true) {
                                		JOptionPane.showMessageDialog(null, "Este modelo de aeronave já foi cadastrado anteriormente");
                                	}

                                    j++;
                                } else {
                                    JOptionPane.showMessageDialog(null, "número máximo de naves cadastradas atingido");
                                }
                                break;

                            case 2: //Cadastrar Voo
                            	
                            	//verifica se já foram cadastradas aeronaves
                                if (j < 1) {
                                    JOptionPane.showMessageDialog(null, "Nenhuma aeronave foi cadastrada");
                                    
                                } else {
                                    if (i < 10) {
                                        int NRO = 0;
                                        boolean teste = false;

                                        do {
                                        	flagParametros = false;
                                            String temp = JOptionPane.showInputDialog("Digite o modelo da aeronave");

                                            try {
                                            	for (int h = 0; h < j; h++) {
                                                    if (aeronave[h].getModelo().equals(temp)) {
                                                        teste = true;
                                                    }
                                                }
                                            }
                                            catch (RuntimeException e){
                                            	flagParametros = true;
                                            }
                                            finally {
                                            	if(flagParametros == true) {
                                            		JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado");
                                                    System.exit(1);
                                            	}
                                            }

                                            if (teste == true) {
                                                int poltronas = 0, fileiras = 0;
                                                Aviao aviao = new Aviao(temp, 0, 0);

                                                do {
                                                	flagParametros = false;

                                                    try {

                                                        fileiras = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de fileiras da aeronave"));
                                                        poltronas = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de poltronas por fileira"));
                                                        
                                                    } catch (NumberFormatException nfe) {
                                                    	flagParametros = true;

                                                    } finally {
                                                    	if(flagParametros == true) {
                                                    		JOptionPane.showMessageDialog(null, "Digite quantidades de fileiras e poltronas válidas");
                                                    		
                                                    	}else if((fileiras<1)||(poltronas<1)) {
                                                    		flagParametros = true;
                                                    		JOptionPane.showMessageDialog(null, "Digite quantidades de fileiras e poltronas válidas");
                                                    		
                                                    	} else{
                                                    		aviao = new Aviao(temp, fileiras, poltronas);
                                                    	}
                                                    }
                                                } while (flagParametros == true);

                                                do {
                                                    cadastrado = false;
                                                    
                                                    do {
                                                    	flagParametros = false;
                                                    	
                                                    	try {
                                                            NRO = Integer.parseInt(JOptionPane.showInputDialog("Digite o NRO do voo"));

                                                        } catch (NumberFormatException nfe) {
                                                            flagParametros = true;

                                                        } finally {
                                                            if (flagParametros == true) {
                                                                JOptionPane.showMessageDialog(null, "Digite um NRO válido");
                                                            }
                                                        }
                                                    }while(flagParametros == true);

                                                    try {
                                                        for (int h = 0; h < i; h++) {
                                                            if (voo[h].getNro() == NRO) {
                                                                cadastrado = true;
                                                                flagParametros = false;
                                                            }
                                                        }
                                                    } catch (RuntimeException e) {
                                                    	flagParametros = true;

                                                    } finally {
                                                    	if(flagParametros == true) {
                                                    		JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado");
                                                            System.exit(1);
                                                    	}
                                                    	if(cadastrado == true) {
                                                    		JOptionPane.showMessageDialog(null, "Um voo com este NRO já foi cadastrado anteriormente");
                                                    	}
                                                    }
                                                } while (cadastrado == true);
                                                
                                                String data = null, hora = null;
                                                voo[i] = new Voo(aviao, NRO, data, hora);
                                                SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
                                                SimpleDateFormat horaFormatter = new SimpleDateFormat("HH:mm");
                                                
                                                do {
                                                	flagParametros = false;
                                                	try {
                                                        data = JOptionPane.showInputDialog("Digite a data do voo no formato dd/mm/aaaa");
                                                        hora = JOptionPane.showInputDialog("Digite a hora do voo no formato HH:mm");
														Date date = dateFormatter.parse(data);
														Date horario = horaFormatter.parse(hora);
                                                        
                                                    } catch (ParseException e) {
                                                    	flagParametros = true;
                                                        
                                                    } finally {
                                                    	if(flagParametros == true) {
                                                    		JOptionPane.showMessageDialog(null, "Informe data e hora no formato dd/mm/aaaa hh:mm");
                                                    	}
                                                    	voo[i]= new Voo(aviao, NRO, data, hora);
                                                    }
                                                }while(flagParametros==true);
                                                
                                                i++;
                                                
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Modelo inválido");
                                            }
                                        } while (teste == false);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "número máximo de voos cadastrados atingido");
                                    }
                                }
                                break;

                            case 3: //Voltar
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida");
                        }
                    } while (switchParametros != 3);
                    break;

                case 2: //Reserva de Passagens
                	
                    int switchReserva,
                    NRO = 0, lugaresVagos;
                    String aux;
                    boolean flagReserva, testeNRO;

                    //testa se já foram cadastrados voos
                    
                    if (i < 1) {
                        JOptionPane.showMessageDialog(null, "Não há voos cadastrados");
                    } else {

                        do {
                        	testeNRO = false;
                        	flagReserva = false;
                            aux = "Reserva de Passagens\nSelecione o NRO de um dos voos cadastrados:";

                            try {
                                for (int h = 0; h < i; h++) {
                                    aux += "\n Voo NRO: " + voo[h].getNro();
                                }
                                
                            } catch (RuntimeException e) {
                                flagReserva = true;

                            } finally {
                                if (flagReserva == true) {
                                	JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado");
                                    System.exit(1);
                                }
                            }
                            do {
                            	flagReserva = false;
                            	
                                try {
                                    NRO = Integer.parseInt(JOptionPane.showInputDialog(aux));

                                } catch (NumberFormatException nfe) {
                                    flagReserva = true;

                                } finally {

                                    if (flagReserva == true) {
                                        JOptionPane.showMessageDialog(null, "Digite um dos NROs informados");
                                    }
                                }
                            } while (flagReserva == true);
                            
                            
                            try {
                                for (int h = 0; h < i; h++) {
                                    if (voo[h].getNro() == NRO) {
                                        NRO = h;
                                        testeNRO = true;
                                        flagReserva = false;
                                        break;
                                    }
                                }
                            } catch (RuntimeException e) {
                                flagReserva = true;
                                
                            } finally {
                            	if (flagReserva == true) {
                            		JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado");
                                    System.exit(1);
                                } else if(testeNRO == false) {
                                	JOptionPane.showMessageDialog(null, "Digite um dos NROs informados");
                                	 flagReserva = true;
                                }
                            }
                        } while (flagReserva == true);

                        do {
                        	switchReserva = 0;
                        	flagReserva = false;
                            try {

                                switchReserva = Integer.parseInt(JOptionPane.showInputDialog("Reserva de Passagens (voo NRO:" + voo[NRO].getNro() + " data:" + voo[NRO].getData() + " hora:" + voo[NRO].getHora() + ")\n 1.Fazer reserva\n 2.Consultar lugares vazios\n 3.Consultar reservas realizadas\n 4.Voltar"));

                            } catch (NumberFormatException nfe) {
                                flagReserva = true;

                            } finally {
                                if (flagReserva == true) {
                                    switchParametros = 5;
                                }
                            }

                            lugaresVagos = voo[NRO].lugaresVagos();

                            switch (switchReserva) {
                                case 1:
                                    boolean reserva = false;
                                    int fileira = 0,
                                     poltrona = 0;

                                    //caso tenha lugares vagos, realiza a reserva
                                    if (lugaresVagos > 0) {

                                        String nome = null, cpf = null;
                                        Passageiro passageiro = new Passageiro(nome, cpf);

                                        do {
                                        	flagReserva = false;

                                            try {

                                                nome = JOptionPane.showInputDialog("Digite o nome do passageiro");
                                                Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
                                                Matcher matcher = pattern.matcher(nome); // Your String should come here
                                                if (!matcher.find()) { // If string contains any number/symbols etc...
                                                    throw new Exception("nome inválido");
                                                }

                                            } catch (Exception e) {
                                                System.out.println(e.toString());
                                                flagReserva = true;

                                            } finally {

                                                if (flagReserva == true) {
                                                    JOptionPane.showMessageDialog(null, "Informe um nome válido");

                                                } else {
                                                    passageiro = new Passageiro(nome, cpf);
                                                }

                                            }
                                        } while (flagReserva == true);

                                        do {
                                        	flagReserva = false;
                                            try {

                                                cpf = JOptionPane.showInputDialog("Digite o CPF do passageiro");
                                                long cpfAux = Long.parseLong(cpf);

                                            } catch (NumberFormatException nfe) {

                                                flagReserva = true;

                                            } finally {

                                                if (flagReserva == true) {

                                                    JOptionPane.showMessageDialog(null, "Informe um CPF válido");

                                                }

                                            }
                                        } while (flagReserva == true);

                                        do {

                                            do {
                                            	flagReserva = false;

                                                try {
                                                    fileira = Integer.parseInt(JOptionPane.showInputDialog("Digite a fileira desejada")) - 1;
                                                    poltrona = Integer.parseInt(JOptionPane.showInputDialog("Digite a poltrona desejada")) - 1;

                                                } catch (NumberFormatException nfe) {
                                                    flagReserva = true;

                                                } finally {
                                                    if (flagReserva == true) {
                                                        JOptionPane.showMessageDialog(null, "Informe fileira e poltrona válidos");
                                                    
                                                    } else if((fileira<0)||(fileira>voo[NRO].getAviao().getFileiras()-1)||(poltrona<0)||(poltrona>voo[NRO].getAviao().getPoltronas()-1)) {
                                                    	flagReserva = true;
                                                		JOptionPane.showMessageDialog(null, "Digite quantidades de fileiras e poltronas válidas");
                                                	}
                                                }
                                            } while (flagReserva == true);

                                            if (voo[NRO].getAviao().verificaLugarOcupado(fileira, poltrona) == false) {
                                                voo[NRO].getAviao().setPassageiro(fileira, poltrona, passageiro);
                                                reserva = true;
                                            } else {
                                                JOptionPane.showMessageDialog(null, "O lugar selecionado está ocupado");
                                            }

                                        } while (reserva == false);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Este voo não tem lugares vagos");
                                    }

                                    break;

                                case 2:
                                    JOptionPane.showMessageDialog(null, "Voo NRO: " + voo[NRO].getNro() + "\n lugares disponíveis: " + lugaresVagos);
                                    break;

                                case 3:

                                    String matriz = "";

                                    try {

                                        for (int h = 0; h < voo[NRO].getAviao().getFileiras(); h++) {
                                            for (int g = 0; g < voo[NRO].getAviao().getPoltronas(); g++) {
                                                if (voo[NRO].getAviao().verificaLugarOcupado(h, g) == false) {
                                                    matriz += " O";
                                                } else {
                                                    matriz += " X";
                                                }
                                            }
                                            matriz += "\n";
                                        }

                                    } catch (ArrayIndexOutOfBoundsException e) {
                                        System.out.println("Array fora do índice: " + e.getMessage());

                                    } finally {
                                        JOptionPane.showMessageDialog(null, matriz);

                                    }

                                    break;

                                case 4:
                                    break;

                                default:
                                    JOptionPane.showMessageDialog(null, "Opção inválida");
                            }
                        } while (switchReserva != 4);
                    }

                    break;

                case 3: //Sair
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        } while (switchPrincipal != 3);
    }
}
