package application.domain.FigureModels;
import application.domain.FigureModels.Movement;

public class Figure_Rook extends Figure implements Movement {



	public Figure_Rook(String name, String id, boolean alive, int x, int y, boolean white) {
		super(name, id, alive, x, y, white);
		this.firstMove = true;
	}
	private boolean firstMove;

	public boolean movementOption(int x, int y) {
		int thisX = this.getX();
		int thisY = this.getY();

		if(thisY == y && thisX != x) {
			return true;
		}
		else if(thisX == x && thisY != y) {
			return true;
		}
		else {
			return false;
		}
	}

	
	public boolean movementOption(int x, int y, boolean[][] occupation) {
		int thisX = this.getX();
		int thisY = this.getY();

		if(thisY == y && thisX != x) {
			if(thisX<x) {
				for(int i = thisX+1; i<=x; i++ ) {
					if(occupation[i][thisY]) {
						return false;
					}
				}
				return true;
			}
			else if(thisX>x){
				for(int i = thisX-1; i>=x; i-- ) {
					if(occupation[i][thisY]) {
						return false;
					}
				}
				return true;
			}
		}
		else if(thisY != y && thisX == x) {
			if(thisY<y) {
				for(int i = thisY+1; i<=y; i++ ) {
					if(occupation[thisX][i]) {
						return false;
					}
				}
				return true;
			}
			else if(thisY>y){
				for(int i = thisY-1; i>=y; i-- ) {
					if(occupation[thisX][i]) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
	
	public boolean canEat(Figure figure, boolean[][] occupation) {
		int thisY = this.getY();
		int thisX = this.getX();
		int figureX = figure.getX();
		int figureY = figure.getY();
		if(this.isWhite() != figure.isWhite()) {

			boolean[][] occup = occupation;
			occup[figureX][figureY] = false;
			if(movementOption(figureX,figureY,occup)) {
				return true;
			}
		}
		
		return false;
	}

	
	@Override
	public void move(int posX, int posY) {
		this.setX(posX);
		this.setY(posY);
		this.firstMove = false;
	}
	
}
