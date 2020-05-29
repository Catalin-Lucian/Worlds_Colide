package Worlds_Collide.Items.Characters.Enemys;

import Worlds_Collide.Animating.Animation;
import Worlds_Collide.Graphics.Assets;
import Worlds_Collide.Graphics.Camera;
import Worlds_Collide.Items.Characters.Enemy;
import Worlds_Collide.__Utils.Vector2D;

import java.awt.*;

public class Mushroom extends Enemy {

    public Mushroom(float x,float y,float size){
        super(new Vector2D(x,y), (int)(Assets.black_ball.getW()*size),(int)(Assets.black_ball.getH()*size));


        bounds=new Rectangle((int)GetX()+20,(int)GetY()+30,width-40,height-60);
        attackBounds=new Rectangle((int)GetX()+50,(int)GetY()+50,width-100,height-100);
        pSprite=Assets.mushroom;


        animation=new Animation(pSprite.getSpriteArray(state));

        damage=2;
        range=350;
        speed=DEFAULT_SPEED-4;


        state=idle;
    }


    @Override
    public void Update() {
        if(position.isONCamera()){
            getState();
            manageState();
            Move();
            animation.update();
        }
    }

    @Override
    public void Draw(Graphics g) {

        if(position.isONCamera())
        {
            if (animation.hasPlayedOnce()) inAction =false;

            g.drawImage(animation.getImage(),(int)(GetX()- Camera.getX_edge_left()),(int)GetY(),width,height,null);
            g.setColor(Color.red);
            g.drawRect((int)(bounds.x-Camera.getX_edge_left()),bounds.y,bounds.width,bounds.height);
            g.drawRect((int)(attackBounds.x-Camera.getX_edge_left()),attackBounds.y,attackBounds.width,attackBounds.height);
        }

    }

}