package projeto;
import java.util.Scanner;

public class Projeto {
    
    // variáveis globais
    static Scanner dados = new Scanner(System.in);
    static boolean [] statusQuarto = new boolean[100];   
    static String[] hospedes = new String[100];
    static int [] n_reserva = new int[100];
    static int[][] consumoFrigobar = new int[100][4];
    static int[] totalFrigobar = new int[100];
    
    public static void mostrarF(int num_quarto){
        System.out.println("Consumo do quarto " + (num_quarto+1) + ":");
        System.out.println("         Água: " + consumoFrigobar[num_quarto][0]);
        System.out.println(" Refrigerante: " + consumoFrigobar[num_quarto][1]);
        System.out.println("         suco: " + consumoFrigobar[num_quarto][2]);
        System.out.println("    Chocolate: " + consumoFrigobar[num_quarto][3]);
        System.out.println("Total de produtos: " + (consumoFrigobar[num_quarto][0]+ consumoFrigobar[num_quarto][1]+ consumoFrigobar[num_quarto][2]+consumoFrigobar[num_quarto][3]));
        System.out.println("valor Total: R$" + totalFrigobar[num_quarto]+",00");   
    }
    
    public static void main(String[] args) {

        //Variaveis de controle
        int num_quarto;
        int r;

        boolean desligar = false;
        while (!desligar){
           System.out.println("======PROJETO POO 1 BIMESTRE======");
        System.out.println("\n1- Reservar Quarto \n2- Cancelar reserva\n3- Listar Reservas\n4- Consultar Hospede\n5- Editar Hospede\n6- Registrar Consumo Frigobar\n7- Check-out\n8- Encerrar programa");
        
        int opcao = 0;
        while(opcao <= 0 || opcao > 8){
            System.out.println("Selecione uma das opções:");
            opcao = dados.nextInt();
            switch(opcao){
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=                  
//Reservar quarto
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=                  
                case 1:
                    System.out.println("==================================");
                    num_quarto = 0;
                    while(num_quarto < 1 || num_quarto > 100){
                        do{
                            System.out.println("digite o número do quarto:");
                            num_quarto = dados.nextInt();
                            dados.nextLine();
                            if(statusQuarto[num_quarto-1]){
                                System.out.println("Quarto Já ocupado, tente novamente");
                            }
                        }while(statusQuarto[num_quarto-1]); 
                    }
                    
                    System.out.println("Digite o nome do hospede:");
                    String nome = dados.nextLine();
                    hospedes[num_quarto - 1] = nome;
                    statusQuarto[num_quarto - 1 ] = true;
                    
                    int num_reserva =  (int)Math.floor(Math.random() * 10000);
                    n_reserva[num_quarto - 1] = num_reserva;
                    System.out.println("\nHospede Resgistrado!\nReserva: " + num_reserva + "\nQuarto: " + num_quarto +"\nnome do hospede: " + hospedes[num_quarto - 1]+"\n");
                    
                    System.out.println("Digite qualquer tecla para continuar");
                    dados.next();
                    
                    break;
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=                      
//Cancelar Reserva 
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=                      
                case 2:
                    System.out.println("==================================");
                    System.out.println("\nReservas Registradas São:");
                    for(int reserva:n_reserva){
                        if(reserva != 0){
                            System.out.print(reserva + " | ");
                        }  
                    
                    }
                    
                    System.out.println("\nDigite a Reserva que quer Cancelar. 0 para cancelar a operação");
                    r = dados.nextInt();
                    
                    if(r == 0){
                        break;
                    }
                    
                    boolean achou = false;
                    for (int i =0; i < 100 ; i++){
                        if(n_reserva[i] == r){
                            achou = true;
                            if(totalFrigobar[i] != 0){
                                System.out.println("Não é possível cancelar a reserva: há itens consumidos no frigobar.");
                                break;
                            }
                            System.out.println("==================================");
                            System.out.println("nome: "+ hospedes[i] +"\nQuarto:"+ (i+1));
                            System.out.println("==================================");
                            int conf = 2;
                            
                            while(conf != 0 & conf != 1){
                                System.out.println("confirme o cancelamento. 1-confirmar 0-Cancelar");
                                conf = dados.nextInt();
                                if(conf != 0 & conf != 1) System.out.println("opção inválida");
                            }
                            
                            if(conf == 0){
                                System.out.println("operação cancelada!");
                                break;
                            }
                            
                            n_reserva[i] = 0;
                            hospedes[i] = "";
                            statusQuarto[i] = false;
                            for(int j = 0; j<4; j++){
                                consumoFrigobar[i][j] = 0;
                            }
                            System.out.println("Reserva cancelada!");
                        }
                    }
                    
                    if(!achou){
                        System.out.println("Reserva não encontrada!");
                    }
                    System.out.println("==================================");
                    System.out.println("Digite qualquer tecla para continuar");
                    dados.next();
                    break;
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=                      
//Listar Reserva
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=                      
                case 3:
                    System.out.println("\nAs Reservas Registradas São:\n");
                    for (int i = 0; i<100; i++){
                        if(statusQuarto[i]){
                            System.out.println("==================================");
                            System.out.println("Reserva: "+n_reserva[i]+"\nnome do hospede: " + hospedes[i] + "\nQuarto: " + (i+1));   
                        }
                    }
                    System.out.println("==================================");
                    System.out.println("Digite qualquer tecla para continuar");
                    dados.next();
                    break;
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=                      
//Consultar Hospede
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=                      
                case 4:
                    System.out.println("Por quarto ou reserva? 1-quarto 2-reserva");
                    int resp = dados.nextInt();
                switch (resp) {
                    case 1:
                        System.out.println("==================================");
                        System.out.println("Digite o Número do quarto. de 1 - 100");
                        num_quarto = dados.nextInt() - 1;
                        if(num_quarto >= 0 && num_quarto <= 100){
                            if(statusQuarto[num_quarto]){
                                System.out.println("==================================");
                                System.out.println("nome do Hospede: " + hospedes[num_quarto]);
                                System.out.println("Reserva: "+ n_reserva[num_quarto]);
                                if(totalFrigobar[num_quarto] != 0){
                                    System.out.println("==================================");
                                    mostrarF(num_quarto);
                                }else{
                                    System.out.println("Não possui consumos no Frigobar");
                                }

                            }else{
                                System.out.println("O quarto está vazio!");
                            }
                        }else{
                            System.out.println("quarto inválido!");
                        }
                        break;
                case 2:
                    System.out.println("==================================");
                    System.out.println("Digite o Número da Reserva:");
                    r = dados.nextInt();
                    achou = false;
                    for(int i = 0; i < 100; i++){
                        if(n_reserva[i] == r){
                            achou = true;
                            System.out.println("==================================");
                            System.out.println("nome do Hospede: " + hospedes[i]);
                            System.out.println("Nº do quarto: " + (i+1));
                        }
                    }
                    if(!achou){
                        System.out.println("Reserva não encontrada!");
                    }
                    break;
                default:
                    System.out.println("opção inválida");
                    break;
            }
                    System.out.println("==================================");
                    System.out.println("Digite qualquer tecla para continuar");
                    dados.next();
                    
                    break;
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=                    
//Editar Hospede    
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=                     
                case 5:
                    System.out.println("==================================");
                    System.out.println("Digite o Número da Reserva:");
                    r = dados.nextInt();
                    
                    achou = false;
                    
                    for(int i = 0; i < 100; i++){
                        if(n_reserva[i] == r){
                            achou = true;
                            System.out.println("==================================");
                            System.out.println("O que voce deseja alterar. 1- número do quarto 2- hospede:");
                            int opc = dados.nextInt();
                            if(opc == 1){
                                System.out.println("==================================");
                                System.out.println("Digite o número do novo quarto:");
                                num_quarto = dados.nextInt() - 1;
                                if(!statusQuarto[num_quarto]){
                                    hospedes[num_quarto] = hospedes[i];
                                    hospedes[i] = "";
                                    n_reserva[num_quarto] = n_reserva[i];
                                    n_reserva[i] = 0;
                                    statusQuarto[num_quarto]=true;
                                    statusQuarto[i] = false;
                                    for(int x = 0; x < 4; x++){
                                        consumoFrigobar[num_quarto][x]= consumoFrigobar[i][x];
                                        consumoFrigobar[i][x]= 0;
                                    }
                                    break;
                                } else{
                                    System.out.println("==================================");
                                    System.out.println("Quarto já ocupado!");
                                }
                            }
                            else if(opc == 2){
                                System.out.println("==================================");
                                System.out.println("Digite o nome do hospede:");
                                dados.nextLine();
                                nome = dados.nextLine();
                                hospedes[i] = nome;
                            }
                        }
                    }
                    if(!achou){
                        System.out.println("==================================");
                        System.out.println("Reserva não encontrada!");
                    }
                        
                    System.out.println("==================================");
                    System.out.println("Digite qualquer tecla para continuar");
                    dados.next();
                    break;
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=                      
//Consumo frigobar
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=                      
                case 6:
                    System.out.println("==================================");
                    System.out.println("Digite o número do Quarto:");
                    num_quarto = dados.nextInt() - 1;
                    
                    if(statusQuarto[num_quarto]){
                        
                        System.out.println("==================================");
                        mostrarF(num_quarto);
                        System.out.println("==================================");
                        
                        System.out.println("Adicioar produtos?\n1-Água R$1,00\n2-Refrigerante R$7,00\n3-suco R$3,00\n4-Chocolate R$2,00\noutros numeros - Cancelar\n");
                        int produto = dados.nextInt() - 1;
                        if(produto >= 0 & produto < 3){
                                System.out.println("Digite a Quantidade:");
                                int quant = dados.nextInt();
                                consumoFrigobar[num_quarto][produto] = quant;
                                totalFrigobar[num_quarto] = consumoFrigobar[num_quarto][0] + (consumoFrigobar[num_quarto][1] * 7) + (consumoFrigobar[num_quarto][2] * 3)+(consumoFrigobar[num_quarto][3]*2);
                        } else{
                            System.out.println("Cancelando!");
                        }
                    }else{
                        System.out.println("Quarto não ocupado!");
                    }
                    System.out.println("==================================");
                    System.out.println("Digite qualquer tecla para continuar");
                    dados.next();
                    break;
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=                      
//Check-out  
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=                      
                case 7:
                    System.out.println("==================================");
                    System.out.println("Digite o Número do Quarto:");
                    num_quarto = dados.nextInt()-1;
                    System.out.println("Digite o número de diárias:");
                    int d = dados.nextInt();
                    if(statusQuarto[num_quarto]){
                        System.out.println("==================================");
                        System.out.println("Número do Quarto: "+ (num_quarto+1));
                        System.out.println(" Nome do hospede: "+ hospedes[num_quarto]);
                        System.out.println("         Reserva: "+ n_reserva[num_quarto]);
                        System.out.println("  Valor Frigobar: R$"+totalFrigobar[num_quarto]+",00");
                        System.out.println("   Total Diárias: "+ d);
                        System.out.println("==================================");
                        
                        float valorD = d * 67.67f;
                        float valorTotal = valorD + totalFrigobar[num_quarto];
                        System.out.println("Valor total: R$" + valorTotal);
                        
                        System.out.println("\nConfirmar Check-out. 1-Sim 0-Cancelar");
                        int opc2 = dados.nextInt();
                        if(opc2 != 1){
                            System.out.println("==================================");
                            System.out.println("\nOperação Cancelada!");
                            break;
                        }else{
                            System.out.println("==================================");
                            hospedes[num_quarto] = "";
                            n_reserva[num_quarto] = 0;
                            totalFrigobar[num_quarto] = 0;
                            for(int i = 0;i<4;i++){
                                consumoFrigobar[num_quarto][i] = 0;
                            }
                            statusQuarto[num_quarto]=false;
                            System.out.println("Check-out encerrado!");
                        }
                        
                    }else{
                        System.out.println("==================================");
                        System.out.println("Quarto não ocupado!");
                    }
                    
                    System.out.println("==================================");
                    System.out.println("Digite qualquer tecla para continuar");
                    dados.next();
                    
                    break;
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=                      
//Cancelar
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=                      
                case 8:
                    System.out.println("Desligando X_X ...");
                    desligar = true;
                break;
                default:
                    System.out.println("opação inválida");
            }
          } 
        }
    } 
}


