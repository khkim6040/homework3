package edu.postech.csed332.homework3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void testCellConstruction() {
        Cell cell = new Cell();
        for (int n = 1; n <= 9; n++)
            Assertions.assertTrue(cell.containsPossibility(n));
    }


    @Test
    void testAddPossibility() {
        Cell cell = new Cell();
        cell.removePossibility(1);
        Assertions.assertFalse(cell.containsPossibility(1));
        cell.addPossibility(1);
        Assertions.assertTrue(cell.containsPossibility(1));
    }


    @Test
    void testCellDisabled() {
        Cell cell = new Cell();
        for(int i = 1; i <= 8; i++)
            cell.removePossibility(i);
        assertFalse(cell.hasNoPossibility());

        var disabled = new AtomicBoolean(false);
        cell.addObserver((caller, arg) -> {
            if (arg instanceof ActivationEvent ae)
                disabled.set(!ae.activated());
        });
        cell.removePossibility(9);
        assertTrue(disabled.get());
        assertTrue(cell.hasNoPossibility());
    }

    @Test
    void testCellEnabled() {
        Cell cell = new Cell();
        for(int i = 1; i <= 9; i++)
            cell.removePossibility(i);
        assertTrue(cell.hasNoPossibility());

        var disabled = new AtomicBoolean(true);
        cell.addObserver((caller, arg) -> {
            if (arg instanceof ActivationEvent ae)
                disabled.set(!ae.activated());
        });
        cell.addPossibility(1);
        assertFalse(disabled.get());
        assertFalse(cell.hasNoPossibility());
    }

//    @Test
//    void testGameSetNumbers() {
//        var board = new Board(GameInstanceFactory.createGameInstance());
//        assertTrue(board.getCell(1,1).setNumber(5));
//        assertTrue(board.getCell(4,4).setNumber(1));
//        assertTrue(board.getCell(5,5).setNumber(9));
//        assertTrue(board.getCell(6,6).hasNoPossibility());
//        assertTrue(board.getCell(1,1).unsetNumber());
//        assertTrue(board.getCell(6,6).hasNoPossibility());
//        assertTrue(board.getCell(5,5).unsetNumber());
//        assertFalse(board.getCell(6,6).hasNoPossibility());
//    }

    @Test
    void testCellSetNumberShouldSetNumberWhenNumberIsUnsigned() {
        Cell cell = new Cell();
        assertTrue(cell.setNumber(5));
        assertTrue(cell.getNumber().isPresent());
        assertEquals(5, (int) cell.getNumber().get());
    }

    @Test
    void testCellSetNumberShouldNotSetNumberWhenNumberIsSigned() {
        Cell cell = new Cell();
        assertTrue(cell.setNumber(5));
        assertFalse(cell.setNumber(6));
    }

    @Test
    void testCellUnsetNumberShouldUnsetNumberWhenNumberIsSigned() {
        Cell cell = new Cell();
        assertTrue(cell.setNumber(5));
        assertTrue(cell.unsetNumber());
        assertFalse(cell.getNumber().isPresent());
    }

    @Test
    void testCellUnsetNumberShouldNotUnsetNumberWhenNumberIsUnsigned() {
        Cell cell = new Cell();
        assertFalse(cell.unsetNumber());
    }

    @Test
    void testCellAddGroup() {
        Cell cell = new Cell();
        Group group = new Group();
        cell.addGroup(group);
        assertTrue(cell.groups.contains(group));
    }

    @Test
    void testCellAddPossibilityShouldNotAddPossibilityWhenNumberIsSignedInAnotherGroup() {
        // TODO: implement this After implementing Group
    }
}
