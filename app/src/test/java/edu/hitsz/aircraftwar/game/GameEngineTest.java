package edu.hitsz.aircraftwar.game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameEngineTest {

    @Test
    public void updateSpawnsEnemiesAndHeroBullets() {
        GameConfig config = new GameConfig(Difficulty.NORMAL, 512, 768);
        GameEngine engine = new GameEngine(config);

        engine.update(config.getCycleDurationMs());

        assertFalse(engine.getEnemyAircrafts().isEmpty());
        assertFalse(engine.getHeroBullets().isEmpty());
    }

    @Test
    public void bombClearsExistingEnemyBullets() {
        GameConfig config = new GameConfig(Difficulty.NORMAL, 512, 768);
        GameEngine engine = new GameEngine(config);

        engine.update(config.getCycleDurationMs());
        assertFalse(engine.getEnemyBullets().isEmpty());

        engine.triggerBomb();

        assertTrue(engine.getEnemyBullets().stream().allMatch(BaseBullet -> BaseBullet.notValid()));
    }
}
