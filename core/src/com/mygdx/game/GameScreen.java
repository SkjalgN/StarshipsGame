package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {

    //screen
    private Camera camera;
    private Viewport viewport;

    //graphics
    private SpriteBatch batch;
//    private Texture background;
    private Texture[] backgrounds;

    //timing
//    private int backgroundOffset;
    private float[] backgroundOffsetts = {0,0,0,0};
    private float backgroundMaxScrollingSpeed;

    //World Parameters
    private final int WorldWidth = 72;
    private final int WorldHeight = 128;

    GameScreen(){

        camera = new OrthographicCamera();
        viewport = new StretchViewport(WorldWidth,WorldHeight,camera);

//        background = new Texture("darkPurpleStarscape.png");
//        backgroundOffset = 0;

        backgrounds = new Texture[4];

        backgrounds[0] = new Texture("Starscape00.png");
        backgrounds[1] = new Texture("Starscape01.png");
        backgrounds[2] = new Texture("Starscape02.png");
        backgrounds[3] = new Texture("Starscape03.png");

        backgroundMaxScrollingSpeed = (float)(WorldHeight)/4;

        batch = new SpriteBatch();

    }

    @Override
    public void render(float deltaTime) {
        batch.begin();

        //Scrolling background
        renderBackground(deltaTime);


        batch.end();
    }

    private void renderBackground(float deltaTime){

        backgroundOffsetts[0] += deltaTime *backgroundMaxScrollingSpeed/8;
        backgroundOffsetts[1] += deltaTime *backgroundMaxScrollingSpeed/4;
        backgroundOffsetts[2] += deltaTime *backgroundMaxScrollingSpeed/2;
        backgroundOffsetts[3] += deltaTime *backgroundMaxScrollingSpeed;

        for (int layer = 0; layer < backgroundOffsetts.length; layer++){
            if (backgroundOffsetts[layer] > WorldHeight){
                backgroundOffsetts[layer] = 0;
            }
            batch.draw(backgrounds[layer],0,0-backgroundOffsetts[layer],WorldWidth,WorldHeight);
            batch.draw(backgrounds[layer],0,WorldHeight-backgroundOffsetts[layer],WorldWidth,WorldHeight);
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height,true);
        batch.setProjectionMatrix(camera.combined);
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
    public void show() {

    }

    @Override
    public void dispose() {

    }
}
