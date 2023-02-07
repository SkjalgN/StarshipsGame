package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;



public class Task1 extends ApplicationAdapter {

	int posX = 0;
	int posY = 0;
	int velX = 4;
	int velY = 4;

	SpriteBatch batch;
	Texture img;
	Sprite sprite;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("heli1.png");
		sprite = new Sprite(img);
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
		if (posX >= 500 || posX <= 0){
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
		img.dispose();
	}

}