package edu.hitsz.aircraftwar.game;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import edu.hitsz.aircraftwar.R;

public class SpriteStore {

    private final Resources resources;
    private final Map<SpriteType, Bitmap> originalBitmaps = new EnumMap<>(SpriteType.class);
    private final Map<String, Bitmap> scaledBitmaps = new HashMap<>();

    public SpriteStore(Resources resources) {
        this.resources = resources;
    }

    public Bitmap get(SpriteType spriteType, int width, int height) {
        String cacheKey = spriteType.name() + "_" + width + "x" + height;
        Bitmap cached = scaledBitmaps.get(cacheKey);
        if (cached != null) {
            return cached;
        }

        Bitmap original = originalBitmaps.get(spriteType);
        if (original == null) {
            original = BitmapFactory.decodeResource(resources, resolveDrawable(spriteType));
            originalBitmaps.put(spriteType, original);
        }

        Bitmap scaled = Bitmap.createScaledBitmap(original, Math.max(1, width), Math.max(1, height), true);
        scaledBitmaps.put(cacheKey, scaled);
        return scaled;
    }

    private int resolveDrawable(SpriteType spriteType) {
        switch (spriteType) {
            case BACKGROUND_EASY:
                return R.drawable.bg;
            case BACKGROUND_HARD:
                return R.drawable.bg3;
            case BACKGROUND_NORMAL:
                return R.drawable.bg2;
            case HERO:
                return R.drawable.hero;
            case HERO_BULLET:
                return R.drawable.bullet_hero;
            case ENEMY_BULLET:
                return R.drawable.bullet_enemy;
            case MOB_ENEMY:
                return R.drawable.mob;
            case ELITE_ENEMY:
                return R.drawable.elite;
            case ELITE_PLUS_ENEMY:
                return R.drawable.elite_plus;
            case BOSS_ENEMY:
                return R.drawable.boss;
            case PROP_BLOOD:
                return R.drawable.prop_blood;
            case PROP_BOMB:
                return R.drawable.prop_bomb;
            case PROP_BULLET:
                return R.drawable.prop_bullet;
            case PROP_BULLET_PLUS:
                return R.drawable.prop_bullet_plus;
            default:
                throw new IllegalArgumentException("Unsupported sprite type: " + spriteType);
        }
    }
}
