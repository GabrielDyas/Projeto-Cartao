package Objetos;

import java.time.LocalDate;
import java.util.Scanner;

public class ControleDeTempo {

    // Variável para rastrear o tempo
    private LocalDate dia = LocalDate.now(); 

    // Função para passar 1 dia
    public void passarUmDia() {
        this.dia = this.dia.plusDays(1);
        System.out.println("Um dia se passou. Data atual: " + this.dia);
    }

    // Função de atalho (Debug) para passar X dias
    public void pularDias(int diasParaPular) {
        this.dia = this.dia.plusDays(diasParaPular);
        System.out.println("[DEBUG] Tempo avançado em " + diasParaPular + " dias. Nova data: " + this.dia);
    }

    // Método main: é por aqui que o Java vai rodar esse arquivo e ler seu teclado
    public static void main(String[] args) {
        ControleDeTempo controle = new ControleDeTempo();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Sistema de Tempo Iniciado ---");
        System.out.println("Data atual: " + controle.dia);
        System.out.println("Comandos: [p] Passar 1 dia | [pular X] Pular X dias | [sair] Fechar");
        
        // Loop infinito para ficar lendo o teclado até você digitar "sair"
        while (true) {
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("p")) {
                controle.passarUmDia();
                
            } else if (input.toLowerCase().startsWith("pular ")) {
                try {
                    // Pega o número que vem depois da palavra "pular "
                    int dias = Integer.parseInt(input.split(" ")[1]);
                    controle.pularDias(dias);
                } catch (Exception e) {
                    System.out.println("Erro. Digite no formato: pular 5");
                }
                
            } else if (input.equalsIgnoreCase("sair")) {
                System.out.println("Fechando debug de tempo...");
                break;
                
            } else {
                System.out.println("Comando não reconhecido.");
            }
        }
        
        scanner.close();
    }
}