package sg.edu.sg.mad_t02_assignment;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class CourseModel {

    private String CourseName;
    private String CourseMotto;
    private String CourseURL;
    private String CourseID;

    public CourseModel() {

    }

    public CourseModel(String name, String motto/*, int logo */, String CourseURL, String CourseID){
        this.CourseName = name;
        this.CourseMotto = motto;
        //this.CourseLogo = logo;
        this.CourseURL = CourseURL;
        this.CourseID = CourseID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getCourseMotto() {
        return CourseMotto;
    }

    public void setCourseMotto(String courseMotto) {
        CourseMotto = courseMotto;
    }

/*    public int getCourseLogo() {
        return CourseLogo;
    }

    public void setCourseLogo(int courseLogo) {
        CourseLogo = courseLogo;
    }*/

    public String getCourseURL() {
        return CourseURL;
    }

    public void setCourseURL(String courseURL) {
        CourseURL = courseURL;
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String courseID) {
        CourseID = courseID;
    }
}
