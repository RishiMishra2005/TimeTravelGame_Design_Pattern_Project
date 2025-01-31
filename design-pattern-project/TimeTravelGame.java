import java.util.*;
import java.util.concurrent.TimeUnit; 
// Base interface for historical eras

class Print {
    public static void slowPrint(String text) {
        try {
            for (char c : text.toCharArray()) {
                System.out.print(c);
                TimeUnit.MILLISECONDS.sleep(20);
            }
        } catch (InterruptedException e) {
            System.out.print(text);
        }finally {
            System.out.println();
        }
    }
}
interface Era {
    void describeEra();
    List<String> getKeyEvents();
    List<Question> getQuizQuestions();
}

// Concrete classes for Indian historical eras
class IndusValleyCivilization implements Era {
    public void describeEra() {
        Print.slowPrint("\nWelcome to the Indus Valley Civilization!\nExperience the advanced urban planning and trade culture of ancient India.\n");
    }

    public List<String> getKeyEvents() {
        return Arrays.asList("Development of Harappa and Mohenjo-Daro", "Trade with Mesopotamia", "Innovative city planning and drainage systems");
    }

    public List<Question> getQuizQuestions() {
        return Arrays.asList(
            new Question("What was one of the major cities in the Indus Valley Civilization?", 
                         "Mohenjo-Daro", 
                         Arrays.asList("Harappa", "Mohenjo-Daro", "Delhi", "Agra")),
            new Question("Which modern-day countries did the Indus Valley span?", 
                         "India and Pakistan", 
                         Arrays.asList("India and Pakistan", "India and China", "Pakistan and Afghanistan", "Nepal and Bhutan")),
            new Question("What was a major innovation of this civilization?", 
                         "Urban Planning", 
                         Arrays.asList("Mathematics", "Urban Planning", "Astronomy", "Medicine"))
        );
    }
}

class GuptaEmpire implements Era {
    public void describeEra() {
        Print.slowPrint("\nWelcome to the Gupta Empire!\nKnown as the Golden Age of India, it was a time of cultural and scientific advancements.\n");
    }

    public List<String> getKeyEvents() {
        return Arrays.asList("Flourishing of classical Indian art and literature", "Mathematical advances by Aryabhata", "Establishment of Nalanda University");
    }

    public List<Question> getQuizQuestions() {
        return Arrays.asList(
            new Question("Who was the famous mathematician during the Gupta Empire?", 
                         "Aryabhata", 
                         Arrays.asList("Aryabhata", "Brahmagupta", "Bhaskara", "Charaka")),
            new Question("Which famous university was established during this time?", 
                         "Nalanda", 
                         Arrays.asList("Nalanda", "Takshashila", "Kashi", "Pataliputra")),
            new Question("What form of art flourished during the Gupta period?", 
                         "Classical Indian Art", 
                         Arrays.asList("Folk Art", "Classical Indian Art", "Modern Art", "Cave Paintings"))
        );
    }
}

class MughalEmpire implements Era {
    public void describeEra() {
        Print.slowPrint("\nWelcome to the Mughal Empire!\nA period marked by significant cultural and architectural advancements in India.\n");
    }

    public List<String> getKeyEvents() {
        return Arrays.asList("Construction of the Taj Mahal", "Establishment of a centralized administration", "Introduction of Persian culture and art");
    }

    public List<Question> getQuizQuestions() {
        return Arrays.asList(
            new Question("Who was the most famous Mughal emperor?", 
                         "Shah Jahan", 
                         Arrays.asList("Akbar", "Shah Jahan", "Aurangzeb", "Babur")),
            new Question("What is the architectural marvel built by Shah Jahan?", 
                         "Taj Mahal", 
                         Arrays.asList("Red Fort", "Hawa Mahal", "Taj Mahal", "Qutub Minar")),
            new Question("Which Mughal emperor is known for his religious tolerance?", 
                         "Akbar", 
                         Arrays.asList("Akbar", "Jahangir", "Shah Jahan", "Aurangzeb"))
        );
    }
}

class MauryaEmpire implements Era {
    public void describeEra() {
        Print.slowPrint("\nWelcome to the Maurya Empire!\nA period of great political unity and expansion in ancient India.\n");
    }

    public List<String> getKeyEvents() {
        return Arrays.asList("Chandragupta Maurya establishes the empire", "Ashoka the Great's reign and spread of Buddhism", "Edicts of Ashoka carved on pillars");
    }

    public List<Question> getQuizQuestions() {
        return Arrays.asList(
            new Question("Who was the founder of the Maurya Empire?", 
                         "Chandragupta Maurya", 
                         Arrays.asList("Chandragupta Maurya", "Ashoka", "Bindusara", "Samudragupta")),
            new Question("Which ruler spread Buddhism across India?", 
                         "Ashoka", 
                         Arrays.asList("Chandragupta", "Ashoka", "Kanishka", "Harsha")),
            new Question("What was significant about Ashoka's edicts?", 
                         "Promoted non-violence and Dharma", 
                         Arrays.asList("Promoted trade", "Promoted non-violence and Dharma", "Outlined military strategies", "Celebrated festivals"))
        );
    }
}

class MarathaEmpire implements Era {
    public void describeEra() {
        Print.slowPrint("\nWelcome to the Maratha Empire!\nA significant force in India known for its resistance against Mughal rule.\n");
    }

    public List<String> getKeyEvents() {
        return Arrays.asList("Establishment of the Maratha Empire by Shivaji", "Decline of Mughal power", "Expansion of Maratha influence in India");
    }

    public List<Question> getQuizQuestions() {
        return Arrays.asList(
            new Question("Who was the founder of the Maratha Empire?", 
                         "Shivaji Maharaj", 
                         Arrays.asList("Shivaji Maharaj", "Balaji Vishwanath", "Sambhaji", "Shivaji II")),
            new Question("Which battle marked a significant victory for the Marathas against the Mughals?", 
                         "Battle of Panipat", 
                         Arrays.asList("Battle of Plassey", "Battle of Panipat", "Battle of Haldighati", "Battle of Talikota")),
            new Question("What title did Shivaji Maharaj adopt?", 
                         "Chhatrapati", 
                         Arrays.asList("Maharaja", "Raja", "Chhatrapati", "Sardar"))
        );
    }
}

// Strategy pattern for quiz-taking mechanism
interface QuizStrategy {
    boolean administerQuiz(List<Question> questions);
}

class SimpleQuizStrategy implements QuizStrategy {
    private final Scanner scanner = new Scanner(System.in);

    public boolean administerQuiz(List<Question> questions) {
        int correctAnswers = 0;

        for (Question question : questions) {
            Print.slowPrint("\nQuestion: " + question.getQuestionText());
            List<String> options = question.getChoices();
            for (int i = 0; i < options.size(); i++) {
                Print.slowPrint((i + 1) + ". " + options.get(i));
            }
            System.out.print("Your answer (1-" + options.size() + "): ");
            int answerIndex = scanner.nextInt() - 1;

            if (answerIndex >= 0 && answerIndex < options.size() && 
                options.get(answerIndex).equals(question.getCorrectAnswer())) {
                Print.slowPrint("Correct!");
                correctAnswers++;
            } else {
                Print.slowPrint("Incorrect! The correct answer is: " + question.getCorrectAnswer());
            }
        }
        return correctAnswers == questions.size();
    }
}

// Command for handling time travel actions
class TravelCommand {
    private final Era era;
    private final TimeTraveler traveler;
    private final TimeTravelHistory history;

    public TravelCommand(Era era, TimeTraveler traveler, TimeTravelHistory history) {
        this.era = era;
        this.traveler = traveler;
        this.history = history;
    }

    public void execute() {
        traveler.setEra(era);
        era.describeEra();
        displayKeyEvents();
    }

    private void displayKeyEvents() {
        Print.slowPrint("\nKey Events:");
        for (String event : era.getKeyEvents()) {
            Print.slowPrint(" - " + event);
        }
    }
}

// Memento pattern for saving state
class TimeTravelerMemento {
    private final Era era;

    public TimeTravelerMemento(Era era) {
        this.era = era;
    }

    public Era getSavedEra() {
        return era;
    }
}

class TimeTraveler {
    private Era currentEra;

    public void setEra(Era era) {
        this.currentEra = era;
    }

    public Era getEra() {
        return currentEra;
    }

    public TimeTravelerMemento saveState() {
        return new TimeTravelerMemento(currentEra);
    }

    public void restoreState(TimeTravelerMemento memento) {
        currentEra = memento.getSavedEra();
    }
}

// Caretaker for managing time travel history
class TimeTravelHistory {
    private final List<TimeTravelerMemento> history = new ArrayList<>();

    public void save(TimeTraveler timeTraveler) {
        history.add(timeTraveler.saveState());
    }

    public void undo(TimeTraveler timeTraveler) {
        if (!history.isEmpty()) {
            timeTraveler.restoreState(history.remove(history.size() - 1));
        } else {
            Print.slowPrint("No previous state to restore.");
        }
    }
}

// Question class
class Question {
    private final String questionText;
    private final String correctAnswer;
    private final List<String> choices;

    public Question(String questionText, String correctAnswer, List<String> choices) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.choices = choices;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getChoices() {
        return choices;
    }
}

// Main game loop
public class TimeTravelGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       Print.slowPrint("\n✨🌟 Welcome to the Time Travel Simulator! 🌟✨");
       Print.slowPrint("\nEver wondered what it would be like to step back in time and witness the grandeur of ancient civilizations?");
       Print.slowPrint("In this immersive journey, you'll get the chance to explore some of India's most fascinating historical eras.");
       Print.slowPrint("From the bustling cities of the Indus Valley to the golden age of the Gupta Empire, and the mighty rule of the Mughals and Marathas...");
       Print.slowPrint("Each era has its own unique story, culture, and challenges. But beware! Only those who can pass the tests of knowledge can move forward.");
       Print.slowPrint("\nAre you ready to embark on a thrilling adventure through time?");
       Print.slowPrint("Prepare yourself to learn, explore, and prove your knowledge as you navigate the rich history of India.\n");
       System.out.print("Do you want to begin your journey? (yes/no): ");
        String playResponse = scanner.nextLine().trim().toLowerCase();

        if (!playResponse.equals("yes")) {
            Print.slowPrint("Maybe next time. Goodbye!");
            return;
        }


        TimeTraveler traveler = new TimeTraveler();
        TimeTravelHistory history = new TimeTravelHistory();
        QuizStrategy quizStrategy = new SimpleQuizStrategy();

        // Initialize eras
        List<Era> eras = Arrays.asList(
            new IndusValleyCivilization(), 
            new GuptaEmpire(), 
            new MughalEmpire(), 
            new MauryaEmpire(), 
            new MarathaEmpire()
        );
        
        int currentEraIndex = 0; // Start at the first era

        while (currentEraIndex < eras.size()) {
            Era era = eras.get(currentEraIndex);
            TravelCommand travelCommand = new TravelCommand(era, traveler, history);
            travelCommand.execute();

            // Save the current state before taking the quiz
            history.save(traveler);

            // Administer quiz
            boolean passed = quizStrategy.administerQuiz(era.getQuizQuestions());
            if (passed) {
                Print.slowPrint("\nLevel Completed! Advancing to the next era...");
                currentEraIndex++; // Move to the next era
            } else {
                Print.slowPrint("\nIncorrect! Returning to the previous era...");
                history.undo(traveler); // Undo the last state
                if (currentEraIndex > 0) {
                    currentEraIndex--; // Move back to the previous era
                } else {
                    Print.slowPrint("You are at the first era, can't go back further.");
                }
            }
        }

        Print.slowPrint("\nCongratulations! You've completed the journey through all historical eras!");
    }
}