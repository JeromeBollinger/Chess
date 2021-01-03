package application.domain;

public class Figure_Knight extends Figure implements Movement {

	public Figure_Knight(String name, String id, boolean alive, int[] position, boolean white) {
		super(name, id, alive, position, white);
		// TODO Auto-generated constructor stub
	}

	

	public boolean movementOption(int x, int y) {
		
		int thisX = this.getPosition()[0];
		int thisY = this.getPosition()[1];
		
		
		if(x - thisX == 2 || thisX - x == 2) {
			if(y-thisY == 1 || thisY -y == 1) {
				return true;
			}
			else {
				return false;
			}
		}
		else if(y-thisY == 2 || thisY -y == 2) {
			if(x - thisX == 1 || thisX - x == 1) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		
		
		
	}

}
