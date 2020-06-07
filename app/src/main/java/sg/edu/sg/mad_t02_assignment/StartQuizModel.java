package sg.edu.sg.mad_t02_assignment;

public class StartQuizModel implements Comparable<StartQuizModel>{

    int score;
    String schoolname;

    public StartQuizModel(){

    }

    public StartQuizModel(int score, String schoolname) {
        this.score = score;
        this.schoolname = schoolname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    @Override
    public int compareTo(StartQuizModel school) {
        int compareScore=((StartQuizModel)school).getScore();

        return compareScore-this.score;

    }
}
