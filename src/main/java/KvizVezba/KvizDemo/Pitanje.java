package KvizVezba.KvizDemo;

public class Pitanje {
     String category;
     String type;
     String difficulty;
     String question;
     String correct_answer;
     String[] incorrect_answers;

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getCorrect_answer() {
        return correct_answer;
    }
    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }
    public String[] getIncorrect_answers() {
        return incorrect_answers;
    }
    public void setIncorrect_answers(String[] incorrect_answers) {
        this.incorrect_answers = incorrect_answers;
    }
}
