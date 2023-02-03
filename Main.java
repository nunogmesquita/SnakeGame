package academy.mindswap;

/*
1. Não anda para o sentido inverso - TIAGO
2. Collide com ele próprio termina o jogo- NUNO
EXTRA:
3. Acrescentar score;
4. Quando ele chega a uma parede voltar para a outra
5. ENDGAME maricas;
FINAL:
REFACTOR!!!!!!
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
