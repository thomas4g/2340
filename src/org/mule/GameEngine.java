package org.mule;

public class GameEngine {

	private Screen screen;
	//We should have some sort of input type
	//Input input;
	
	public void recieveScene(Screen screen){
		this.screen=screen;
	}
	
	public void recieveInput(/*Input input*/){
		//this.input=input;
	}
	
	public Screen getScreen(){
		return screen;
	}
	
	public void updateEntities(){
		//do game logic here
	}

}
