import java.util.Scanner;

public class CarFunctions {
    private int carVelocity;
    private int carGear;
    private boolean carOn;
    private boolean carOff;
    private String carDirection;

    Scanner scanner = new Scanner(System.in);

    public CarFunctions() {
        this.carVelocity = 0;
        this.carGear = 0;
        this.carOn = false;
        this.carOff = true;
        this.carDirection = "";
    }

    public void startCar() {

        boolean startCarValue = false;

        if (!this.carOn) {
            startCarValue = true;
            this.carOn = startCarValue;
            this.carOff = false;
            System.out.println("Carro ligado!");
        } else {
            System.out.println("Carro já está ligado!");
        }

    }

    public void offCar() {

        boolean offCarValue = false;

        if ((this.carOn) && (this.carGear == 0)) {
            offCarValue = true;
            this.carOn = false;
            this.carOff = offCarValue;
            System.out.println("Carro foi desligado!");
        } else if (!this.carOn) {
            System.out.println("Carro não está ligado!");
        } else  {
            System.out.println("Carro permanece ligado.");
            System.out.println("Não é possível desligar o carro em movimento, reduza para 0km/h e coloque em ponto neutro.");
        }

    }

    public void accelerate(){
        if (!this.carOn) {
            System.out.println("Erro: Não é possível acelerar com o carro desligado.");
            return;
        }
        if (this.carGear == 0) {
            System.out.println("Não é possível acelerar no ponto morto.");
            return;
        }

        int nextVelocity = this.carVelocity + 5;


        if (this.carGear == 1 && nextVelocity > 20) {
            System.out.println("Velocidade máxima para 1ª marcha (20km/h) excedida. Troque a marcha para acelerar mais.");
            return;
        }
        else if (this.carGear == 2 && nextVelocity > 40){
            System.out.println("Velocidade máxima para 2ª marcha (40km/h) excedida. Troque a marcha para acelerar mais.");
            return;
        }
        else if (this.carGear == 3 && nextVelocity > 60) {
            System.out.println("Velocidade máxima para 3ª marcha (60km/h) excedida. Troque a marcha para acelerar mais.");
            return;
        }
        else if (this.carGear == 4 && nextVelocity > 80) {
            System.out.println("Velocidade máxima para 4ª marcha (80km/h) excedida. Troque a marcha para acelerar mais.");
            return;
        }
        else if (this.carGear == 5 && nextVelocity > 100) {
            System.out.println("Velocidade máxima para 5ª marcha (100km/h) excedida. Troque a marcha para acelerar mais.");
            return;
        }
        else if (this.carGear == 6 && nextVelocity > 120) {
            System.out.println("Velocidade máxima para 6ª marcha (120km/h) atingida ou excedida.");
        }

        if (nextVelocity > 120) {
            this.carVelocity = 120;
        } else {
            this.carVelocity = nextVelocity;
        }
        System.out.println("Acelerando. Velocidade atual: " + this.carVelocity + " km/h (Marcha: " + this.carGear + ").");

    }

    public void reduceVelocity(){
        if (!this.carOn) {
            System.out.println("Erro: Não é possível reduzir com o carro desligado.");
            return;
        }
        if (this.carGear == 0) {
            System.out.println("Não é possível reduzir no ponto morto.");
            return;
        }

        this.carVelocity -= 5;


        if (this.carGear == 1 && this.carVelocity == 0) {
            System.out.println("Atenção: Velocidade (" + this.carVelocity + " km/h) abaixo da faixa ideal para 1ª marcha (0-20 km/h). Considere reduzir a marcha.");
            return;
        }
        else if (this.carGear == 2 && this.carVelocity < 21 && this.carVelocity > 0){
            System.out.println("Atenção: Velocidade (" + this.carVelocity + " km/h) abaixo da faixa ideal para 2ª marcha (21-40 km/h). Considere reduzir a marcha.");
            return;
        }
        else if (this.carGear == 3 && this.carVelocity < 41 && this.carVelocity > 0) {
            System.out.println("Atenção: Velocidade (" + this.carVelocity + " km/h) abaixo da faixa ideal para 3ª marcha (41-60 km/h). Considere reduzir a marcha.");
            return;
        }
        else if (this.carGear == 4 && this.carVelocity < 61 && this.carVelocity > 0) {
            System.out.println("Atenção: Velocidade (" + this.carVelocity + " km/h) abaixo da faixa ideal para 4ª marcha (61-80 km/h). Considere reduzir a marcha.");
            return;
        }
        else if (this.carGear == 5 && this.carVelocity < 81 && this.carVelocity > 0) {
            System.out.println("Atenção: Velocidade (" + this.carVelocity + " km/h) abaixo da faixa ideal para 5ª marcha (81-100 km/h). Considere reduzir a marcha.");
            return;
        }
        else if (this.carGear == 6 && this.carVelocity < 101 && this.carVelocity > 0) {
            System.out.println("Atenção: Velocidade (" + this.carVelocity + " km/h) abaixo da faixa ideal para 6ª marcha (101-120 km/h). Considere reduzir a marcha.");
        }

        if (this.carVelocity < 0) {
            this.carVelocity = 0;
            System.out.println("Reduzindo. Velocidade atual: " + this.carVelocity + " km/h (Marcha: " + this.carGear + ").");
        } else {
            System.out.println("Reduzindo. Velocidade atual: " + this.carVelocity + " km/h (Marcha: " + this.carGear + ").");
        }


    }


    public void gearSystem(int newGearState){

        if (!this.carOn) {
            System.out.println("Erro: Não é possível trocar de marcha com o carro desligado.");
            return;
        }
        if (newGearState < -1 || newGearState > 6) {
            System.out.println("Erro: Marcha inválida. Use valores entre 0 (Neutra) e 6.");
            return;
        }

        boolean readyToPass = true;
        String notReadyToPass = "";

        if (newGearState == -0) {
            if (this.carVelocity != 0) {
                readyToPass = false;
                notReadyToPass = "Não é possível engatar o ponto morto com o carro em movimento.";
            }
        } else if (newGearState == 1) { // 1 marcha - 1 a 20
            if (this.carVelocity < 0 || this.carVelocity > 20) {
                readyToPass = false;
                notReadyToPass = "Velocidade (" + this.carVelocity + " km/h) incompatível com 1ª Marcha (0-20 km/h).";
            }
        } else if (newGearState == 2) { // 2 marcha - 21 a 40
            if (this.carVelocity < 20 || this.carVelocity > 40) {
                readyToPass = false;
                notReadyToPass = "Velocidade (" + this.carVelocity + " km/h) incompatível com 2ª Marcha (21-40 km/h).";
            }
        } else if (newGearState == 3) { // 3 marcha - 41 a 60
            if (this.carVelocity < 40 || this.carVelocity > 60) {
                readyToPass = false;
                notReadyToPass = "Velocidade (" + this.carVelocity + " km/h) incompatível com 3ª Marcha (41-60 km/h).";
            }
        } else if (newGearState == 4) { // 4 marcha - 61 a 80
            if (this.carVelocity < 60 || this.carVelocity > 80) {
                readyToPass = false;
                notReadyToPass = "Velocidade (" + this.carVelocity + " km/h) incompatível com 4ª Marcha (61-80 km/h).";
            }
        } else if (newGearState == 5) { // 5 marcha - 81 a 100
            if (this.carVelocity < 80 || this.carVelocity > 100) {
                readyToPass = false;
                notReadyToPass = "Velocidade (" + this.carVelocity + " km/h) incompatível com 5ª Marcha (81-100 km/h).";
            }
        }  else if (newGearState == 6) { // 6 marcha - 101 a 120
            if (this.carVelocity < 100 || this.carVelocity > 120) {
                readyToPass = false;
                notReadyToPass = "Velocidade (" + this.carVelocity + " km/h) incompatível com 6ª Marcha (101-120 km/h).";
            }
        }

        if (readyToPass) {
            this.carGear = newGearState;
            System.out.println("Marcha alterada para: " + this.carGear);
            System.out.println("Você está a: " + this.carVelocity + "km/h");
        } else {
            System.out.println("Não foi possível trocar a marcha: " + notReadyToPass);
        }
    }

    public void verifyVelocity() {
        System.out.println("Sua velocidade atual é de: " + this.carVelocity + "km/h.");
        System.out.println("Você está na " + this.carGear + "ª marcha.");
    }

    public void changeDirection(int selectDirection) {
        if (!this.carOn) {
            System.out.println("Erro: Não é possível mudar de direção com o carro desligado.");
            return;
        }
        if (this.carGear == 0) {
            System.out.println("Não é possível mudar de direção no ponto morto.");
            return;
        }

        if (selectDirection == 1 && this.carVelocity > 0 && this.carVelocity <= 40) {
            System.out.println("Você virou para a direita.");
        } else if (selectDirection == 1 && this.carVelocity > 40) {
            System.out.println("Reduza a velocidade para realizar mudanças de direções.");
        }
        if (selectDirection == 2 && this.carVelocity > 0 && this.carVelocity <= 40) {
            System.out.println("Você virou para a esquerda.");
        } else if (selectDirection == 2 && this.carVelocity > 40){
            System.out.println("Reduza a velocidade para realizar mudanças de direções.");
        }
    }
}




