import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

abstract class Question {
    protected String text;
    protected String correctAnswer;
    protected String studentAnswer;
    protected int points;

    public Question(String text, String correctAnswer, String studentAnswer, int points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.student_answer = student_answer;
        this.points = points;
    }

    protected String student_answer;

    public abstract double grade();
}

class MCQQuestion extends Question {
    public MCQQuestion(String text, String correctAnswer, String studentAnswer, int points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    @Override
    public double grade() {
        if (student_answer.trim().equalsIgnoreCase(correctAnswer.trim())) {
            return (double) points;
        }
        return 0.0;
    }
}

class TFQuestion extends Question {
    public TFQuestion(String text, String correctAnswer, String studentAnswer, int points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    @Override
    public double grade() {
        if (student_answer.trim().equalsIgnoreCase(correctAnswer.trim())) {
            return (double) points;
        }
        return 0.0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String text, String correctAnswer, String studentAnswer, int points) {
        super(text, correctAnswer, studentAnswer, points);
    }

    @Override
    public double grade() {
        List<String> keywords = Arrays.stream(correctAnswer.split(","))
                .map(kw -> kw.trim().toLowerCase())
                .collect(Collectors.toList());
        
        String studentTextLower = student_answer.toLowerCase();
        long matchedCount = keywords.stream().filter(studentTextLower::contains).count();

        if (matchedCount >= 2) {
            return points * 0.75;
        } else if (matchedCount == 1) {
            return points * 0.50;
        }
        return 0.0;
    }
}