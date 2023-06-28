package com.javachess.board;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.javachess.action.ImpChessInputProcessor;
import com.javachess.dao.LogXadrezDAO;

import pieces.Piece;

public class JavaChess extends ApplicationAdapter {
	private static final int GRID_SIZE = 8;
	private static final float CELL_SIZE = 100f;
	private Texture squad;
	private OrthographicCamera camera;
	private SpriteBatch batch;
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
		Tabuleiro tabuleiro = Tabuleiro.getInstance();
		pieces = Tabuleiro.getPieces();
<<<<<<< HEAD

		// iniciando a instância do banco
		LogXadrezDAO.initialize();
=======
>>>>>>> e8387b2f569028a02d33e9aeac8a5011e1987dab

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
		LogXadrezDAO.close();
	}
}
