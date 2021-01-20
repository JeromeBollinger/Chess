package application.domain.FigureModels;

import application.domain.Board;

public class Figure_Pawn extends Figure implements Movement {






	public Figure_Pawn(String name, String id, boolean alive, int x, int y, boolean white) {
		super(name, id, alive, x, y, white);
	}

	public boolean movementOption(int x, int y) {
		int thisY = this.getY();
		int thisX = this.getX();

		if(this.isWhite()) {
			if(y-thisY == 1 && x == thisX) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if(thisY-y == 1  && x == thisX) {
				return true;
			}
			else {
				return false;
			}
		}

	}

	public boolean movementOption(int x, int y, boolean[][] occupation) {
		int thisY = this.getY();
		int thisX = this.getX();

		if(!occupation[x][y]) {
			if(this.isWhite()) {
				if(y-thisY == 1 && x == thisX) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				if(thisY-y == 1  && x == thisX) {
					return true;
				}
				else {
					return false;
				}
			}

		}
		else {
			return false;
		}
	}

	public boolean canEat(Figure figure, boolean[][] notNeeded) {
		int thisY = this.getY();
		int thisX = this.getX();
		int figureX = figure.getX();
		int figureY = figure.getY();
		if(this.isWhite() && !figure.isWhite()) {

			if((figureX == thisX+1 || figureX == thisX-1) && figureY == thisY+1) {
				return true;
			}
		}
		else if(!this.isWhite() && figure.isWhite()){
			if((figureX == thisX+1 || figureX == thisX-1) && figureY == thisY-1) {
				return true;
			}
		}
		return false;
	}
	
	
	
}