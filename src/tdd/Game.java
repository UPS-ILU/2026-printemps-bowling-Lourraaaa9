package tdd;

public class Game {
	int score=0;
	
	void roll(int nbQuilles) {
		score+=nbQuilles;
	}
	
	int score() {
		return this.score;
	}

}
