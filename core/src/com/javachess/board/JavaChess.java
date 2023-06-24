package com.javachess.board;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.javachess.action.ImpChessInputProcessor;
import com.javachess.logScreen.LogScreen;
import pieces.Piece;

public class JavaChess extends ApplicationAdapter {
	private static final int GRID_SIZE = 8;
	private static final float CELL_SIZE = 100f;
	private Texture squad;
//	private LogScreen logScreen; // criar uma tela extra onde vai ficar o log
	private OrthographicCamera camera;
	private SpriteBatch batch;
	LogScreen logScreen;
	private Piece [][]pieces;


	@Override
	public void create() {
		//sobre a tela do jogo
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		//criação do tabuleiro em si
		squad = new Texture("squad.png");
		camera = new OrthographicCamera(screenWidth, screenHeight);
		camera.setToOrtho(false); // FAZER DOCUMENTAÇÂO
		//criação das piecas
		CreatePieces create = new CreatePieces();
		pieces = create.createPiece();

		//Tela de log tela a direita.
		logScreen = new LogScreen();
		//onde eu instancio as ações do mouse
		Gdx.input.setInputProcessor(new ImpChessInputProcessor(camera,pieces));

		batch = new SpriteBatch();
	}

	@Override
	public void render() {

		ScreenUtils.clear(0, 0, 0.2f, 1);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		camera.update();

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Lógica de renderização do jogo de xadrez

		logScreen.render(Gdx.graphics.getDeltaTime());

		for (int row = 0; row < GRID_SIZE; row++) {
			for (int col = 0; col < GRID_SIZE; col++) {
				float x = col * CELL_SIZE;
				float y = row * CELL_SIZE;

				if ((row + col) % 2 == 0) {
					batch.setColor(0.8f, 0.8f, 0.8f, 1f);
				} else {
					batch.setColor(0.2f, 0.2f, 0.2f, 1f);
				}

				batch.draw(
						squad,
						x, y,
						CELL_SIZE, CELL_SIZE
				);
				// As peças são desenhadas depois que o tabuleiro é desenhado
				for (int i = 0; i < 8; i++)
					for (int j = 0; j < 8; j++) {
						if(pieces[i][j] != null){
							batch.draw(pieces[i][j].getFigure(),pieces[i][j].getPosX(),pieces[i][j].getPosY()); //pega a posição de cada peça e desenha o objeto
						}
					}
			}
		}
		batch.end();

	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}
