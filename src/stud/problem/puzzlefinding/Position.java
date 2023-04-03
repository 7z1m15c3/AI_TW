package stud.problem.puzzlefinding;

import core.problem.Action;
import core.problem.State;
import core.solver.algorithm.heuristic.HeuristicType;
import core.solver.algorithm.heuristic.Predictor;
import stud.problem.puzzlefinding.Direction;
import stud.problem.puzzlefinding.Move;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;

import static core.solver.algorithm.heuristic.HeuristicType.MANHATTAN;
import static core.solver.algorithm.heuristic.HeuristicType.MISPLACED;

public class Position extends State {

    private final int[][] present;
    private final int x_0;
    private final int y_0;

    public Position(int[][] present,int x_0,int y_0) {
        this.present = present;
        this.x_0 = x_0;
        this.y_0 = y_0;
    }

    @Override
    public void draw() { System.out.println(this);}

    @Override
    public State next(Action action) {
        Direction dir = ((Move)action).getDirection();
        int[] offsets = Direction.offset(dir);

        //生成新状态所在的点
        int x_0 = getX_0() + offsets[1];
        // r is x/c is y todo
        int y_0 = getY_0() + offsets[0];
        int[][] present = getPresent();
        // todo
        // need to swap

        return new Position(present,x_0,y_0);
    }

    @Override
    public Iterable<? extends Action> actions() {
        Collection<Move> moves = new ArrayList<>();
        for (Direction d : Direction.DIRECTIONS)
            moves.add(new Move(d));
        return moves;
    }


    private static final EnumMap<HeuristicType, Predictor> predictors = new EnumMap<>(HeuristicType.class);
    static{
        predictors.put(MISPLACED,
                (state, goal) -> ((Position)state).misplaced());
        predictors.put(MANHATTAN,
                (state, goal) -> ((Position)state).manhattan());
    }
    public static Predictor predictor(HeuristicType type){
        return predictors.get(type);
    }

    private int misplaced() {
        int[][] present = this.present;
        int cnt=0;
        for (int i=0;i<3;++i){
            for (int j=0;j<3;++j){
                // if (present[i][j]==0) continue; // 0 don't require ? todo
                if(present[i][j]==0)
                {
                    cnt += (i==2&&j==2)?0:1;
                    continue;
                }
                int x = (present[i][j]-1)/3;
                int y = (present[i][j]-1)%3;
                cnt += (x==i&&y==j)?0:1;
            }
        }
        return cnt;
    }
    private int manhattan() {
        int[][] present = this.present;
        int res=0;
        for (int i=0;i<3;++i){
            for (int j=0;j<3;++j){
                // if (present[i][j]==0) continue; // 0 don't require ? todo
                if(present[i][j]==0)
                {
                    res += Math.abs(2-i)+Math.abs(2-j);
                    continue;
                }
                int x = (present[i][j]-1)/3;
                int y = (present[i][j]-1)%3;
                res += Math.abs(x-i)+Math.abs(y-j);
            }
        }
        return res;

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;

        if (obj instanceof Position) {
            Position another = (Position) obj;

            return (Arrays.equals(this.present,another.present));
        }
        return false;
    }
    public int[][] getPresent() {
        return present;
    }
    public int getX_0() {
        return x_0;
    }
    public int getY_0() {
        return y_0;
    }
}
