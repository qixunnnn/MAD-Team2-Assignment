package sg.edu.sg.mad_t02_assignment;

public class CourseModel {

    private String CourseName;
    private String CourseMotto;
    private int CourseLogo;

    public CourseModel() {

    }

    public CourseModel(String name, String motto, int logo){
        this.CourseName = name;
        this.CourseMotto = motto;
        this.CourseLogo = logo;
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

    public int getCourseLogo() {
        return CourseLogo;
    }

    public void setCourseLogo(int courseLogo) {
        CourseLogo = courseLogo;
    }
}
