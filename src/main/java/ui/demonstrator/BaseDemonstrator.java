package ui.demonstrator;

import ui.api.IDemonstrator;

public abstract class  BaseDemonstrator implements IDemonstrator{
	public static void showErrorCommand(){
		System.out.println("Error command");
	}
	
	public static void showNotFound() {
		System.out.println("NOTFOUND");
	}
}
