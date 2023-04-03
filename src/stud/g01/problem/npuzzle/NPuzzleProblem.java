package stud.g01.problem.npuzzle;

import core.problem.Action;
import core.problem.Problem;
import core.problem.State;
import core.solver.queue.Node;

import java.util.Deque;

public class NPuzzleProblem extends Problem {
    private int[][] storePuzzle;// 用来读入npuzzle
    public NPuzzleProblem(State initialState, State goal) {
        super(initialState, goal);
    }

    public NPuzzleProblem(State initialState, State goal, int size) {
        super(initialState, goal, size);
    }
    int[][] puzzle;

    @Override
    //如果8数码游戏输入状态中逆序对的数量是奇数，则无法解决问题实例。
    //https://www.geeksforgeeks.org/check-instance-8-puzzle-solvable/
    public boolean solvable() {
        //need an input array puzzle[i][j] which store the value of the npuzzle
        int linearPuzzle[];
        linearPuzzle = new int[9];
        int k = 0;

        // Converting 2-D puzzle to linear form

        for(int i = 0; i<3; i++)
            for(int j=0; j<3; j++)
                linearPuzzle[k++] = puzzle[i][j];

        // Count inversions in given 8 puzzle
        int invCount = 0;
        for (int i = 0; i < 9; i++)
            for (int j = i + 1; j < 9; j++)

                // Value 0 is used for empty space
                if (linearPuzzle[i] > 0 &&
                        linearPuzzle[j] > 0 && linearPuzzle[i] > linearPuzzle[j])
                    invCount++;
        // return true if inversion count is even.
        return (invCount % 2 == 0);
        //return false;
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
