package com.javachess.logScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LogScreen implements Screen {
    private SpriteBatch spriteBatch;
    private BitmapFont font;
    private CharSequence logText;
    private float elapsedTime;
    private float countdownTime = 600; // Tempo total do cronômetro em segundos (10 minutos)

    public LogScreen() {
        spriteBatch = new SpriteBatch();
        font = new BitmapFont(); // Pode personalizar a fonte conforme suas preferências
        logText = "Início do jogo de xadrez";
    }

    @Override
    public void show() {
        // Configurações iniciais da tela de log
    }

    @Override
    public void render(float delta) {
        elapsedTime += delta;
        float remainingTime = countdownTime - elapsedTime;
        if (remainingTime <= 0) {
            // O tempo acabou, você pode adicionar a lógica desejada aqui
        }

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        font.draw(spriteBatch, logText, 10, 10); // Renderiza o texto do log
        font.draw(spriteBatch, formatTime(remainingTime), 10, 40); // Renderiza o cronômetro
        spriteBatch.end();
    }

    private String formatTime(float time) {
        int minutes = (int) (time / 60);
        int seconds = (int) (time % 60);
        return String.format("%02d:%02d", minutes, seconds);
    }

    @Override
    public void resize(int width, int height) {
        // Ajuste das dimensões da tela quando a janela é redimensionada
    }

    @Override
    public void pause() {
        // Lógica de pausa da tela de log (se necessário)
    }

    @Override
    public void resume() {
        // Lógica de retomada da tela de log (se necessário)
    }

    @Override
    public void hide() {
        // Lógica de ocultação da tela de log (se necessário)
    }

    @Override
    public void dispose() {
        // Liberação de recursos da tela de log
        spriteBatch.dispose();
        font.dispose();
    }
}
