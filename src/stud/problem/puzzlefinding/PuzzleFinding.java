package stud.problem.puzzlefinding;

import core.problem.Action;
import core.problem.Problem;
import core.problem.State;
import core.solver.queue.Node;

import java.util.Deque;

public class PuzzleFinding extends Problem {

    public PuzzleFinding(State initialState, State goal, int size) {
        super(initialState, goal, size);
    }

    @Override
    public boolean solvable() {

        return false;
    }

    @Override
    public int stepCost(State state, Action action) {
        return 0;
    }

    @Override
    public boolean applicable(State state, Action action) {
        return false;
    }

    @Override
    public void showSolution(Deque<Node> path) {

    }
}
