package service;

import com.ltp.gradesubmission.Constants;
import com.ltp.gradesubmission.Grade;
import repository.GradeRepostory;

import java.util.List;

public class GradeService {

    GradeRepostory gradeRepostory = new GradeRepostory();
    public Grade getGrade(int index){
        return gradeRepostory.getGrade(index);
    }

    public void addGrade(Grade grade){
        gradeRepostory.addGrade(grade);
    }

    public void updateGrade(Grade grade, int index){
        gradeRepostory.updateGrade(grade, index);
    }

    public List<Grade> getGrades(){
        return gradeRepostory.getGrades();
    }

    public int getGradeIndex(String id){
        for (int i = 0; i < getGrades().size(); i++) {
            if (getGrades().get(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

    public Grade getGradeById(String id){
        int index = getGradeIndex(id);
        return index == Constants.NOT_FOUND ? new Grade() : getGrade(index);
    }

    public void submitGrade(Grade grade){
        int index = getGradeIndex(grade.getId());
        if (index == Constants.NOT_FOUND) {
            addGrade(grade);
        } else {
            updateGrade(grade, index);
        }
    }
}
