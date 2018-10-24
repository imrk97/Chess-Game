package database_score;
/*
 * Created by Rohan Karmakar (imrk97)
 * */

public class Score {
	private String name;
	private int win;
	private int lose;
	private int draw;
	private int gamesPlayed;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	@Override
	public String toString() {
		return "  "+name+"\t"+ "\t  "+win+"\t"+ "\t  "+lose+"\t"+ "\t  "+draw+"\t"+ "\t          "+gamesPlayed+"\t\n";

	}

}
