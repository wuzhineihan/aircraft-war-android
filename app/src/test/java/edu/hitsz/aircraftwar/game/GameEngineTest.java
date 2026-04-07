package edu.hitsz.aircraftwar.game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.hitsz.aircraftwar.game.model.EliteEnemy;
import edu.hitsz.aircraftwar.game.model.HeroAircraft;
import edu.hitsz.aircraftwar.game.model.PropBomb;

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

    @Test
    public void pickingBombAlongsideOtherPropDropsDoesNotCrash() {
        GameConfig config = new GameConfig(Difficulty.NORMAL, 512, 768);
        GameEngine engine = new GameEngine(config);
        HeroAircraft heroAircraft = engine.getHeroAircraft();

        engine.getProps().add(new PropBomb(
                heroAircraft.getLocationX(),
                heroAircraft.getLocationY(),
                0f,
                0f,
                config.getPropWidth(),
                config.getPropHeight()));

        engine.getEnemyAircrafts().add(new EliteEnemy(
                heroAircraft.getLocationX() + 160f,
                heroAircraft.getLocationY() - 220f,
                0f,
                config.getEliteEnemySpeedY(),
                config.getEliteEnemyHp(),
                config.getEliteEnemyWidth(),
                config.getEliteEnemyHeight()));

        engine.update(16L);

        assertFalse(engine.getProps().isEmpty());
        assertTrue(engine.getEnemyAircrafts().stream().allMatch(enemyAircraft -> enemyAircraft.notValid()));
    }
}
