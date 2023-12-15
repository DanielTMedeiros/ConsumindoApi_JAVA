package br.al.infnet;



import br.al.infnet.exception.ResourceNotFoundException;
import br.al.infnet.model.Advice;
import br.al.infnet.model.Slip;
import br.al.infnet.util.AdviceUtil;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AdviceUtil adviceUtil = new AdviceUtil();
        Scanner scanner = new Scanner(System.in);


        System.out.println( "=========  Consumindo API Advice =========" );
        System.out.println("::::::::::: Funcionalidades ::::::::::::::::");
        System.out.println("1 - Buscar advice pelo ID");
        System.out.println("2 - Buscar advice por ID aleatorio");
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::");

        System.out.print("Digite a opcao desejada: ");
        int opcaoUsuario = scanner.nextInt();

        switch(opcaoUsuario) {
            case 1:
                System.out.println("Opção 1 selecionada");
                System.out.println("Quantidade max de adivice = 65");
                System.out.print("Digite o Id: ");


                int personagemId = scanner.nextInt();
                try {
                    Advice advice = adviceUtil.getById(personagemId);
                    advice.getbyID();

                } catch (ResourceNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                try {
                    System.out.println("Opção 2 selecionada");
                    System.out.println("Selecionando um Id aleatório... ");
                    Advice advice = adviceUtil.getRandomAdvice();
                    advice.getbyID();
                }catch(ResourceNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        }







    }

