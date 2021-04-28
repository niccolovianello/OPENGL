package org.lwjglb.engine.gameitems;

import org.lwjglb.engine.graph.Material;
import org.lwjglb.engine.graph.Mesh;
import org.lwjglb.engine.graph.OBJLoader;
import org.lwjglb.engine.graph.Texture;

public class ButtonItem extends GameItem {

    static final String models = "/models/button.obj";
    static final String[] skin = {"GomJump-main/textures/ButtonStart.png", "GomJump-main/textures/ButtonPlayer.png", "GomJump-main/textures/ButtonCoin.png",
            "GomJump-main/textures/ButtonHighScores.png", "GomJump-main/textures/ButtonExit.png"};
    static Mesh[] meshes = new Mesh[5];
    static Texture[] textures = new Texture[5];

    public static void init() throws Exception {
        for (int i = 0; i < textures.length; i++) {
            meshes[i] = OBJLoader.loadMesh(models);
            textures[i] = new Texture(skin[i]);
        }
    }

    public ButtonItem(int index){
        super(meshes[index]);
        Material mat = new Material();
        mat.setTexture(textures[index]);
        getMesh().setMaterial(mat);
        float[] position = {0.05f, 0, -0.05f, -0.1f, -0.15f};
        setPosition(0, position[index], -0.45f);
        setRotation(0, 90, 0);
        setScale(0.1f);
    }

    public static void clear(){
        for (int i = 0; i < textures.length; i++) {
            meshes[i] = null;
            textures[i] = null;
        }
    }
}
