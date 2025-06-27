import java.util.Scanner;

public class Car {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarFunctions meuCarro = new CarFunctions();


        int opcao;
        int gearState;
        int selectDirection;

        do {
            System.out.println("====Escolha uma opção====");
            System.out.println("1 - Ligar o carro");
            System.out.println("2 - Desligar o carro");
            System.out.println("3 - Trocar de marcha");
            System.out.println("4 - Acelerar");
            System.out.println("5 - Diminuir velocidade");
            System.out.println("6 - Virar para a esquera/direita");
            System.out.println("7 - Verificar a velocidade");
            System.out.println("8 - Sair");

            try {
                opcao = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, selecione uma opção.");
                scanner.next();
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1:
                    meuCarro.startCar();
                    break;
                case 2:
                    meuCarro.offCar();
                    break;
                case 3:
                    System.out.print("Digite o número da marcha desejada (0 a 6): ");
                    gearState = scanner.nextInt();
                    scanner.nextLine();
                    meuCarro.gearSystem(gearState);
                    break;
                case 4:
                    meuCarro.accelerate();
                    break;
                case 5:
                    meuCarro.reduceVelocity();
                    break;
                case 6:
                    System.out.println("===Selecione sua direção===");
                    System.out.println("1 - Direita");
                    System.out.println("2 - Esquerda");
                    selectDirection = scanner.nextInt();
                    meuCarro.changeDirection(selectDirection);
                    break;
                case 7:
                    meuCarro.verifyVelocity();
                    break;
                case 8:
                    break;
            }

        } while (opcao != 0);
    }

}
