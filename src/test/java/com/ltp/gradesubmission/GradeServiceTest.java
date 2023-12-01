package com.ltp.gradesubmission;

import com.ltp.gradesubmission.pojo.Grade;
import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.service.GradeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {

    @Mock
    private GradeRepository gradeRepository;

    @InjectMocks
    private GradeService gradeService;

    @Test
    public void getGradesFromTepoTest(){
        // ARRANGE
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(
                new Grade("Mosy","Spring-boot","C-"),
                new Grade("Rohy","Radio Chemistry","A+")
        ));

        //ACT
        List<Grade> result = gradeService.getGrades();

        //ASSERT
        assertEquals("Mosy", result.get(0).getName());
        assertEquals("Radio Chemistry", result.get(1).getSubject());
    }

    @Test
    public void gradeIndexTest(){
        Grade grade = new Grade("Mosy","Spring-boot","A");
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade));
        when(gradeRepository.getGrade(0)).thenReturn(grade);

        int valid = gradeService.getGradeIndex(grade.getId());
        int notFound = gradeService.getGradeIndex("123");

        assertEquals(0, valid);
        assertEquals(Constants.NOT_FOUND, notFound);
    }

    @Test
    public void returnGradeByIdTest(){
        Grade grade = new Grade("Mosy","Spring-boot","A");
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade));
        when(gradeRepository.getGrade(0)).thenReturn(grade);

        String id = grade.getId();
        Grade result = gradeService.getGradeById(id);
        assertEquals(grade, result);
    }

    @Test
    public void addGradeTest(){
        Grade grade = new Grade("Mosy","Spring-boot","A");
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade));
        when(gradeRepository.getGrade(0)).thenReturn(grade);

        Grade newGrade = new Grade ("Rohy","Radio Chemistry","A+");
        gradeService.submitGrade(newGrade);

        verify(gradeRepository, times(1)).addGrade(newGrade);
    }

    @Test
    public void updateGradeTest(){
        Grade grade = new Grade("Mosy","Spring-boot","A");
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(grade));
        when(gradeRepository.getGrade(0)).thenReturn(grade);

        grade.setScore("B-");
        gradeService.submitGrade(grade);
        verify(gradeRepository, times(1)).updateGrade(grade, 0);
    }
}
