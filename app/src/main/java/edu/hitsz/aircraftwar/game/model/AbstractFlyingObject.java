package edu.hitsz.aircraftwar.game.model;

import edu.hitsz.aircraftwar.game.GameConfig;
import edu.hitsz.aircraftwar.game.SpriteType;

public abstract class AbstractFlyingObject {

    protected float locationX;
    protected float locationY;
    protected float speedX;
    protected float speedY;
    protected final int width;
    protected final int height;
    protected final SpriteType spriteType;
    protected boolean valid = true;

    protected AbstractFlyingObject(
            float locationX,
            float locationY,
            float speedX,
            float speedY,
            int width,
            int height,
            SpriteType spriteType) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.speedX = speedX;
        this.speedY = speedY;
        this.width = width;
        this.height = height;
        this.spriteType = spriteType;
    }

    public void forward(GameConfig config) {
        locationX += speedX;
        locationY += speedY;
        if (locationX <= width * 0.5f || locationX >= config.getScreenWidth() - width * 0.5f) {
            speedX = -speedX;
        }
    }

    public boolean crash(AbstractFlyingObject target) {
        int factor = this instanceof AbstractAircraft ? 2 : 1;
        int targetFactor = target instanceof AbstractAircraft ? 2 : 1;
        return target.locationX + (target.width + width) * 0.5f > locationX
                && target.locationX - (target.width + width) * 0.5f < locationX
                && target.locationY + (target.height / (float) targetFactor + height / (float) factor) * 0.5f
                        > locationY
                && target.locationY - (target.height / (float) targetFactor + height / (float) factor) * 0.5f
                        < locationY;
    }

    public float getLocationX() {
        return locationX;
    }

    public float getLocationY() {
        return locationY;
    }

    public void setLocation(float locationX, float locationY) {
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public float getSpeedX() {
        return speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public SpriteType getSpriteType() {
        return spriteType;
    }

    public boolean isValid() {
        return valid;
    }

    public boolean notValid() {
        return !valid;
    }

    public void vanish() {
        valid = false;
    }
}
