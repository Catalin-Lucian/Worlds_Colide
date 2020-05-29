package Worlds_Collide.Maps;



import Worlds_Collide.RefLinks;
import Worlds_Collide.__Utils.DataBase;
import Worlds_Collide.__Utils.Settings;

import java.awt.Graphics;


public class MapManager {

    private Map map;
    private MapFactory mapFactory;
    private Level level=Level.level_1;
    private final DataBase dataBase;

    public MapManager(DataBase dataBase){
        RefLinks.setMapManager(this);
        this.dataBase=dataBase;
        if (RefLinks.getQuality()==Settings.HIGH) mapFactory=new ParallaxMapFactory();
        else mapFactory=new ParallaxMapFactory(); // needs to change to staticfactory

        buildMap();
    }

    public MapManager(DataBase dataBase,boolean load){
        RefLinks.setMapManager(this);
        this.dataBase=dataBase;
        if (RefLinks.getQuality()==Settings.HIGH) mapFactory=new ParallaxMapFactory();
        else mapFactory=new ParallaxMapFactory(); // needs to change to staticfactory

        loadMap();
        buildMap();
    }

    public void loadMap(){
        level=Level.getLvl(dataBase.getData("MAP","PLAYER"));
    }

    public void saveMap(){
        dataBase.updateMap(level.ordinal());
    }

    public void buildMap(){
        map=mapFactory.createMap(level);
        RefLinks.SetMap(map);
    }

    public int getLevel(){
        return level.ordinal();
    }

    public void update(){
//        if (check player){
//
//            //change map;;
//        }
    }

    public void drawMapBack(Graphics g){
        map.drawBack(g);
    }
    public void drawMapFront(Graphics g){
        map.drawFront(g);
    }

}