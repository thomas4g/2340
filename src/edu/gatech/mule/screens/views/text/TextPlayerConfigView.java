package edu.gatech.mule.screens.views.text;

import java.util.ArrayList;
import java.util.Scanner;

import edu.gatech.mule.game.CharacterType;
import edu.gatech.mule.screens.presenters.PlayerConfigPresenter;
import edu.gatech.mule.screens.views.IPlayerConfigView;

public class TextPlayerConfigView implements IPlayerConfigView {

	private ArrayList<CharacterType> characters;
	private PlayerConfigPresenter presenter;
	
	public TextPlayerConfigView() {
		characters = new ArrayList<CharacterType>();
	}
	
	@Override
	public void display() {
		System.out.println("Welcome to the Player Selection & Configuration Screen!");
		System.out.println("Here are your player options: ");
		for(CharacterType type : characters) {
			System.out.print(characters.indexOf(type) + 1);
			System.out.print(". " + type.name);
			System.out.print(" - " + type.money);
			System.out.println("");
		}
		System.out.print("Enter the number corresponding to character: ");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt() - 1;
		presenter.complete(characters.get(choice));
	}

	@Override
	public void addCharacterOption(CharacterType type) {
		characters.add(type);
	}

	@Override
	public void setPresenter(PlayerConfigPresenter presenter) {
		this.presenter = presenter;
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		characters.clear();
	}

}
