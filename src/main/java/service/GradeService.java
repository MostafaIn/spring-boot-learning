package service;

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
}
