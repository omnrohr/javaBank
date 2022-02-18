package com.company1.quidditchGame.src.test;

import com.company1.quidditchGame.src.main.models.Team;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TeamTest {

    @Test
    public void hasNullTest() {
        String[] chasers = new String[] {null, "Ginny", "Katie"};
        assertTrue(Team.hasNull(chasers));
    }

    @Test
    public void hasBlankTest() {
        String[] chasers = new String[] {"    ", "Ginny", "Katie"};
        assertTrue(Team.hasBlank(chasers));
    }

}
