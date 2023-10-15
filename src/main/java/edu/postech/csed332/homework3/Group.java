package edu.postech.csed332.homework3;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A group that observes a set of cells, and maintains the invariant: if one
 * of the member has a particular value, none of its other members can have
 * the value as a possibility.
 */
public class Group implements Observer {
    //TODO: add private member variables and methods as necessary

    /**
     * Creates an empty group.
     */
    Group() {
        //TODO: implement this
    }

    /**
     * Adds a cell to this group.
     *
     * @param cell a cell to be added
     */
    void addCell(@NotNull Cell cell) {
        //TODO: implement this
    }

    /**
     * Returns true if a given number is available in the group
     *
     * @param number a number
     * @return true if no cell in the group has a given number.
     */
    public boolean isAvailable(int number) {
        //TODO: implement this
        return false;
    }


    /**
     * Updates the possibility of each cell in this group, according to NumberEvent.
     * If one of the cells has a particular value, none of its other members can have
     * the value as a possibility.
     *
     * @param caller the subject
     * @param arg    an argument
     */
    @Override
    public void update(@NotNull Subject caller, @NotNull Event arg) {
        //TODO: implement this
    }
}
