package edu.gatech.mule.screens.views.text;

import java.util.ArrayList;
import java.util.Scanner;

import edu.gatech.mule.core.GameEngine.DIFFICULTY;
import edu.gatech.mule.screen.ScreenPresenter;
import edu.gatech.mule.screens.presenters.MenuPresenter;
import edu.gatech.mule.screens.views.IMenuView;

public class TextMenuView implements IMenuView {

	private ArrayList<DIFFICULTY> difficultyOptions;
	private MenuPresenter presenter;
	
	public TextMenuView() {
		this.difficultyOptions = new ArrayList<DIFFICULTY>();
	}
	
	@Override
	public void display() {
		System.out.println("Welcome to the menu!");
		System.out.println("Here are your difficulty options:");
		for(int i=0;i<difficultyOptions.size();i++) {
			System.out.println(i + ".  " + difficultyOptions.get(i).name());
		}
		System.out.print("Enter the number corresponding to difficulty: ");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		System.out.print("\nHow many players would you like?");
		int players = in.nextInt();
		presenter.complete(difficultyOptions.get(choice), players);
		
	}

	@Override
	public void addDifficulty(DIFFICULTY diff) {
		difficultyOptions.add(diff);
	}

	@Override
	public void setPresenter(MenuPresenter presenter) {
		this.presenter = presenter;	
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		difficultyOptions.clear();
	}

}
