package tdd;

public class Game {
	private int[] lancers = new int[21];
	private int lancer = 0;

	public void roll(int nbQuilles) {
		lancers[lancer++] = nbQuilles;
	}

	public int score() {
		int score = 0;
		int indexlancer = 0;
		for (int frame = 0; frame < 10; frame++) {
			if (isStrike(indexlancer)) {
				score += 10 + strikeBonus(indexlancer);
				indexlancer++;
			} else if (isSpare(indexlancer)) {
				score += 10 + spareBonus(indexlancer);
				indexlancer += 2;
			} else {
				score += sumOfPinsInFrame(indexlancer);
				indexlancer += 2;
			}
		}
		return score;
	}

	private boolean isStrike(int indexlancer) {
		return lancers[indexlancer] == 10;
	}

	private boolean isSpare(int indexlancer) {
		return lancers[indexlancer] + lancers[indexlancer + 1] == 10;
	}

	private int strikeBonus(int indexlancer) {
		return lancers[indexlancer + 1] + lancers[indexlancer + 2];
	}

	private int spareBonus(int indexlancer) {
		return lancers[indexlancer + 2];
	}

	private int sumOfPinsInFrame(int indexlancer) {
		return lancers[indexlancer] + lancers[indexlancer + 1];
	}
}