package stud.problem.puzzlefinding;

import java.util.EnumMap;
import java.util.List;

public enum Direction {
    N,
    E,
    S,
    W;
    public static final List<Direction> DIRECTIONS = List.of(Direction.N, Direction.E, Direction.S, Direction.W);
    private static final EnumMap<Direction, int[]> DIRECTION_OFFSET = new EnumMap<>(Direction.class);
    static{
        //�кţ�������꣩���������кţ��������꣩������
        DIRECTION_OFFSET.put(N, new int[]{0, -1});

        DIRECTION_OFFSET.put(E, new int[]{1, 0});

        DIRECTION_OFFSET.put(S, new int[]{0, 1});

        DIRECTION_OFFSET.put(W, new int[]{-1, 0});

    }
    public static int cost(Direction dir){
        return 1;
    }
    // ����һ�λ���1


    public static int[] offset(Direction dir){
        return DIRECTION_OFFSET.get(dir);
    }
}
