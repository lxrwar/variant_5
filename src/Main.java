import java.util.Scanner;

public class Main {
    private static final String ADMIN_PASSWORD = "1111";

    private static final String[] QUESTIONS = {
            "1. Did you ___________ a good time at the party?\n" +
                    "a) had\n" +
                    "b) have\n" +
                    "c) has\n" +
                    "d) having",
            "2. She ___________ her bike to work yesterday.\n" +
                    "a) rode\n" +
                    "b) ride\n" +
                    "c) rides\n" +
                    "d) riding",
            // Додайте решту питань тут
    };

    private static final int[] ANSWER_KEYS = {1, 0, /* Додайте відповіді для решти питань */};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Past Simple Quiz!");

        boolean isAdmin = false;
        int questionIndex = 0;
        int correctAnswers = 0;
        int totalQuestions = QUESTIONS.length;

        while (questionIndex < totalQuestions) {
            String question = QUESTIONS[questionIndex];
            System.out.println("\n" + question);
            System.out.print("Your answer (a, b, c, d): ");
            String answer = scanner.nextLine().toLowerCase();

            if (answer.equals("q")) {
                break;
            } else if (answer.equals("1111")) {
                isAdmin = true;
                break;
            } else if (!answer.matches("[abcd]")) {
                System.out.println("Invalid option! Please choose a valid answer.");
                continue;
            }

            int userAnswerIndex = answer.charAt(0) - 'a';
            if (userAnswerIndex == ANSWER_KEYS[questionIndex]) {
                correctAnswers++;
            }

            questionIndex++;
        }

        if (isAdmin) {
            System.out.println("\nCorrect answers: " + String.join(", ", getCorrectAnswers()));
        } else {
            double score = (correctAnswers / (double) totalQuestions) * 100;
            System.out.println("\nQuiz Results:");
            System.out.println("Total Questions: " + totalQuestions);
            System.out.println("Correct Answers: " + correctAnswers);
            System.out.println("Score: " + score + "%");
        }

        System.out.println("Thank you for taking the Past Simple Quiz!");
    }

    private static String[] getCorrectAnswers() {
        String[] correctAnswers = new String[ANSWER_KEYS.length];
        for (int i = 0; i < ANSWER_KEYS.length; i++) {
            correctAnswers[i] = QUESTIONS[i] + "\nCorrect Answer: " + getOptionLetter(ANSWER_KEYS[i]);
        }
        return correctAnswers;
    }

    private static char getOptionLetter(int optionIndex) {
        return (char) ('a' + optionIndex);
    }
}