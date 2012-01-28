package org.globalgamejam.strat;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameRenderer implements ApplicationListener{

	private SpriteBatch batch;
	private Sprite[] bonus, avatars, lifeBar, blockBar;
	Texture texAvatar, texBonus, texLifeBar, texBlockBar;
	public static final int NB_JOUEURS = 1, NB_BONUS = 5, NB_SPRITE_LIFEBAR = 2, NB_SPRITE_BLOCKBAR = 0, SPRITE_BY_LINE = 3;
	public static final String PATH_IMG = "img/";
	
	public void create() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		
		texAvatar = new Texture(PATH_IMG + "avatar.png");
		texBonus = new Texture(PATH_IMG + "bonus.png");
		texLifeBar = new Texture(PATH_IMG + "lifebar.png");
		texBlockBar = new Texture(PATH_IMG + "blockbar.png");
		
		loadTextures();
	}
	
	public void render() {
		// TODO Auto-generated method stub
		int nbPa = 4;
		
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
			for(int i=0;i<nbPa-1;i++)
			{
				lifeBar[0].setPosition(i*(lifeBar[0].getWidth()), Gdx.graphics.getHeight()-lifeBar[0].getHeight());
				lifeBar[0].draw(batch);
			}
			lifeBar[1].setPosition((nbPa-1)*(lifeBar[1].getWidth()), Gdx.graphics.getHeight()-lifeBar[1].getHeight());
			lifeBar[1].draw(batch);
			
		batch.end();
		
	}
	
	private void loadTextures() {
		bonus= new Sprite[NB_BONUS];
		avatars = new Sprite[NB_JOUEURS];
		lifeBar = new Sprite[NB_SPRITE_LIFEBAR];
		blockBar = new Sprite[NB_SPRITE_BLOCKBAR];
		/*
		for(int i=0;i<NB_JOUEURS;i++)
			avatars[i] = new Sprite(new TextureRegion(tex, (i%SPRITE_BY_LINE)*(tex.getHeight()/2),
					(i/SPRITE_BY_LINE)*(tex.getHeight()/2), tex.getHeight()/2, tex.getHeight()/2));
		
		tex.dispose();
		tex = new Texture(PATH_IMG + "avatar" + (i+1) + ".png");
		
		for(int i=0;i<NB_BONUS;i++)
			bonus[i] = new Sprite(new TextureRegion(tex, (i%SPRITE_BY_LINE)*(tex.getHeight()/2),
					(i/SPRITE_BY_LINE)*(tex.getHeight()/2), tex.getHeight()/2, tex.getHeight()/2));
		
		for(int i=0;i<NB_SPRITE_LIFEBAR;i++)
			lifeBar[i] = new Sprite(new Texture(PATH_IMG + "lifebar" + (i+1) + ".png"));
		
		for(int i=0;i<NB_SPRITE_BLOCKBAR;i++)
			blockBar[i] = new Sprite(new Texture(PATH_IMG + "blockbar" + (i+1) + ".png"));*/
	}

	public void dispose() {}
	public void pause()  {}
	public void resize(int arg0, int arg1)  {}
	public void resume()  {}
}
