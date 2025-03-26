package model;

public class Card {

	private int x;
    private int y;
    private int imgNum;
    boolean correct;
	
	public Card(int _x, int _y, int _imgNum, boolean _correct) {
        this.x = _x;
        this.y = _y;
        this.imgNum = _imgNum;
        this.correct = _correct;
	}

	public int getImgNum() {
		return imgNum;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
			
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public boolean isCorrect() {
		return correct;
	}
	
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	

}
