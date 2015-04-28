package movements;

import player.Enemy;
import player.Player;
import objects.Object;

public class Colision {
	
	public boolean checkColision(Player player, Object object){
		
		if(player.getPosX() + player.getRadio() < object.getPosX()) return false;
		if(object.getPosX() + object.getHeight() < player.getPosX() - player.getRadio()) return false;
		
		if(player.getPosY() + player.getRadio() < object.getPosY()) return false;
		if(object.getPosY() + object.getHeight() < player.getPosY() - player.getRadio()) return false;
		
		while((player.getPosX() + player.getRadio() < object.getPosX() + (object.getWidth()/2))&&(player.getPosX() + player.getRadio() > object.getPosX())) player.setPosX(player.getPosX() - 1);
		while((player.getPosX() - player.getRadio() > object.getPosX() + (object.getWidth()/2))&&(player.getPosX() - player.getRadio() < object.getPosX() + object.getWidth())) player.setPosX(player.getPosX() + 1);

		while((player.getPosY() + player.getRadio() < object.getPosY() + (object.getHeight()/2))&&(player.getPosY() + player.getRadio() > object.getPosY())) player.setPosY(player.getPosY() - 1);
		while((player.getPosY() - player.getRadio() > object.getPosY() + (object.getHeight()/2))&&(player.getPosY() - player.getRadio() < object.getPosY() + object.getHeight())) player.setPosY(player.getPosY() + 1);
		
		return true;
		
	}
	public int checkColision(Enemy enemy, Object object){
		
		return 0;
	}
	
}
