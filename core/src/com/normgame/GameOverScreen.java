package com.normgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.normgame.MainMenuScreen;
import com.normgame.RunnerGo;
import com.normgame.screens.GameScreen;
import com.normgame.stages.GameStage;

public class GameOverScreen implements Screen {
    final RunnerGo Game;
    public static Texture backgroundTexture1;
    private Stage stage;
    private Skin skin;
    private Image gameover;
    private TextButton retry, menu;


    public GameOverScreen(final RunnerGo gam2) {
        Game = gam2;
        backgroundTexture1 = new Texture("bg.png");
        stage=new Stage(new FillViewport(640, 360));
        skin=new Skin(Gdx.files.internal("skin/uiskin.json"));
        gameover = new Image(new Texture(Gdx.files.internal("gameover.png")));
        retry=new TextButton("Retry",skin);
        menu=new TextButton("Menu", skin);

        retry.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                Game.setScreen(new GameScreen(Game));
                GameStage.schot=0;
            }
        });

        menu.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Game.setScreen(new MainMenuScreen(Game));
                GameStage.schot=0;

            }
        });

        gameover.setPosition(520-gameover.getWidth(), 320- gameover.getHeight());
        retry.setSize(200,100);
        retry.setPosition(350,50);
        stage.addActor(retry);
        menu.setSize(200,100);
        menu.setPosition(100,50);
        stage.addActor(menu);
        stage.addActor(gameover);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Game.batch.begin();
        Game.batch.draw(backgroundTexture1, 0, 0, 2400, 1200);
        Game.batch.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        stage.dispose();
        Game.dispose();
    }
}
