package academy.mindswap;

/*
SUGESTÃO DE FEATURES
1. Quando ele chega a uma parede voltar para a outra;
2. Acrescentar o MaxScore (e ter username para esse score?);
3. A partir de x frutas (10?) o delay assumir metade do valor e aparecerem 2 frutas de cada vez;
4. No final do jogo poder-se clicar uma tecla para reiniciar?
Refactor;
 */

public class Main {

    public static void main(String[] args) {
       Game game = new Game(100, 25, 100);
        try {
            game.start();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}