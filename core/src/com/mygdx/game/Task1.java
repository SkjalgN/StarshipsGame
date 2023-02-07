package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;



public class Task1 extends ApplicationAdapter {

	int posX = 0;
	int posY = 0;
	int velX = 4;
	int velY = 4;

	private SpriteBatch batch;
	private Texture heli;
	private Sprite sprite;
	private Vector2 heliPos;
	private OrthographicCamera camera;

	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		camera = new OrthographicCamera();
		camera.setToOrtho(false,w,h);
		batch = new SpriteBatch();
		heli = new Texture("heli1.png");
		heliPos = new Vector2(w/2,h/2);
		sprite = new Sprite(heli);
		sprite.flip(true,false);
	}

	@Override
	public void render () {
		ScreenUtils.clear(2f, 0, 2f, 1);
		batch.begin();
		batch.draw(sprite, posX, posY);
		batch.end();
		posY += velY;
		posX += velX;
		if (posX >= Gdx.graphics.getWidth()-heli.getWidth() || posX <= 0){
			velX = -velX;
			sprite.flip(true,false);
		}
		if (posY >= 400 || posY <= 0){
			velY = -velY;
		}
	}

	@Override
	public void dispose() {
		batch.dispose();
		heli.dispose();
	}

}