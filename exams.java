import java.util.ArrayList;
import java.util.List;

public class exams{

    List<exams> exams = new ArrayList<>();

    public void remover(exams umExame){
        exams.remove(umExame);
    }

    @Override
    public void editar(exams umExame) {
        if(umExame == null){
            throw new IllegalArgumentException("valores inválidos");
        }
        int index = exams.indexOf(umExame);
        if(index > -1){
            exams.add(index, umExame);
        }
    }
}