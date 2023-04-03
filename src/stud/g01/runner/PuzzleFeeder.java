package stud.g01.runner;

import core.problem.Problem;
import core.runner.EngineFeeder;
import core.solver.algorithm.heuristic.HeuristicType;
import core.solver.algorithm.heuristic.Predictor;
import core.solver.queue.EvaluationType;
import core.solver.queue.Frontier;
import core.solver.queue.Node;
import stud.problem.puzzlefinding.Position;
import stud.problem.puzzlefinding.PuzzleFinding;
import stud.queue.ListFrontier;

import java.util.ArrayList;

public class PuzzleFeeder extends EngineFeeder {
    @Override
    public ArrayList<Problem> getProblems(ArrayList<String> problemLines) {
        //�����ģ, ����ĵ�һ��

        /* �����������
        ArrayList<Problem> problems = new ArrayList<>();
        int lineNo = 0;
        while (lineNo < 6){
            int size = Integer.parseInt(String.valueOf(problemLines.get(0).charAt(0)));
            //3,4
            //��������ʵ��
            PuzzleFinding problem = getPuzzleFinding(problemLines.get(lineNo), size);
            //��ӵ������б�
            problems.add(problem);
            lineNo++;
        } //�����������
            */

        return problems;

    }
    private PuzzleFinding getPuzzleFinding(String problemLine, int size)
    {
        return null;
    }

    @Override
    public Frontier getFrontier(EvaluationType type) {
        return new ListFrontier(Node.evaluator(type));
    }

    @Override
    public Predictor getPredictor(HeuristicType type) {return Position.predictor(type);}
}
