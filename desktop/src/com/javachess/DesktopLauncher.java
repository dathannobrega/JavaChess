package com.javachess;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.javachess.board.JavaChess;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("JavaChess");

		config.setWindowedMode(800,800); // define a janela como 800 x 800 pixel
		config.setResizable(false); // não permite alterar a resolução da tela

		config.setWindowIcon("icon.png");
		new Lwjgl3Application(new JavaChess(), config);
	}
}