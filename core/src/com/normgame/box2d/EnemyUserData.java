package com.normgame.box2d;

import com.badlogic.gdx.math.Vector2;
import com.normgame.enums.UserDataType;
import com.normgame.stages.GameStage;
import com.normgame.utils.Constants;

public class EnemyUserData extends UserData {

    private Vector2 linearVelocity;
    private String[] textureRegions;

    public EnemyUserData(float width, float height, String[] textureRegions) {
        super(width, height);
        userDataType = UserDataType.ENEMY;
        if (GameStage.stadya == 1) {


            linearVelocity = Constants.ENEMY_LINEAR_VELOCITY2;
        } else {
            linearVelocity = Constants.ENEMY_LINEAR_VELOCITY;
        }
        this.textureRegions = textureRegions;
    }

    public void setLinearVelocity(Vector2 linearVelocity) {
        this.linearVelocity = linearVelocity;
    }

    public Vector2 getLinearVelocity() {
        return linearVelocity;
    }

    public String[] getTextureRegions() {
        return textureRegions;
    }
}