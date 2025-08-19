import java.util.*;

class Question {
    private String text;
    private List<String> options;
    private int correctIndex;

    public Question(String text, List<String> options, int correctIndex) {
        this.text = text;
        this.options = options;
        this.correctIndex = correctIndex;
    }

    public void display() {
        System.out.println(text);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ") " + options.get(i));
        }
    }

    public boolean checkAnswer(int answer) {
        return (answer - 1) == correctIndex;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?",
                Arrays.asList("Berlin", "Madrid", "Paris", "Rome"), 2));
        questions.add(new Question("Which language runs on JVM?",
                Arrays.asList("C++", "Java", "Python", "Go"), 1));
        questions.add(new Question("Which collection allows unique elements only?",
                Arrays.asList("List", "Set", "Map", "Queue"), 1));

        int score = 0;

        System.out.println(" Welcome to the Quiz!");
        System.out.println("-----------------------");


        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ":");
            q.display();

            System.out.print("Your answer: ");
            int ans;
            try {
                ans = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                ans = -1; // invalid input
            }

            if (q.checkAnswer(ans)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong.");
            }
        }

        // Final result
        System.out.println("\n--- Quiz Finished ---");
        System.out.println("Your Score: " + score + "/" + questions.size());
    }
}
