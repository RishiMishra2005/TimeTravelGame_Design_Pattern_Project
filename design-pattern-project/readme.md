
# Time Travel Game

## Workflow

### 1. Introduction
- The **Time Travel Game** allows players to explore significant historical eras in India by answering quiz questions related to each period. The journey progresses through five distinct eras: the Indus Valley Civilization, Gupta Empire, Mughal Empire, Maurya Empire, and Maratha Empire.

### 2. Game Start
- When the game starts, the player is introduced to the first era, the **Indus Valley Civilization**. A brief description of the era is presented, highlighting its cultural and historical significance.

### 3. Era Description
- Each era is described with key information about its notable characteristics, including:
  - Urban planning and trade culture (Indus Valley Civilization)
  - Cultural advancements and scientific achievements (Gupta Empire)
  - Architectural marvels and influential leaders (Mughal Empire)
  - Political unity and expansion (Maurya Empire)
  - Resistance against Mughal rule (Maratha Empire)

### 4. Key Events
- Players are presented with a list of key events that took place during the era, providing contextual knowledge and enhancing the learning experience.

### 5. Quiz Administration
- After the description, players participate in a **multiple-choice quiz** based on the era’s history. The quiz consists of questions that test their knowledge and understanding.
- For each question:
  - Players are shown the question and multiple answer choices.
  - They select an answer by entering the corresponding number.

### 6. Scoring and Progression
- After answering all questions:
  - If the player answers all questions correctly, they successfully complete the level and advance to the next era.
  - If the player answers incorrectly, they must return to the previous era, losing their progress in the current level.

### 7. State Management
- The game utilizes the **Memento Design Pattern** to save the player's progress before each quiz. This allows the game to track the player's current state and revert to it if needed.
- The **Command Design Pattern** is employed to encapsulate actions related to time travel and quiz-taking, centralizing the command logic for better maintainability and extendability.

### 8. Completion
- The game continues until the player successfully navigates through all five historical eras.
- Upon completion, a congratulatory message is displayed, marking the player's journey through India's rich history.

---


---

# Design Patterns Used in the Time Travel Game

## 1. Memento Pattern
### Purpose:
The Memento Pattern is used to capture and store the internal state of an object without exposing its implementation details. This is especially useful for saving the progress of the player, allowing them to revert to a previous state if they fail a quiz.

### Implementation:
- **Memento Class**: This class stores the state of the `TimeTraveler`, specifically the current era they are in.
- **Originator Class**: The `TimeTraveler` class acts as the originator, where the `saveState()` method creates a new `TimeTravelerMemento` object to save the current era.
- **Caretaker Class**: The `TimeTravelHistory` class manages a list of `TimeTravelerMemento` objects, providing methods to save the current state and undo the last action by restoring the previous state.

## 2. Command Pattern
### Purpose:
The Command Pattern encapsulates a request as an object, thereby allowing for parameterization of clients with queues, requests, and operations. It centralizes the logic for executing actions, making it easier to extend functionality, such as adding new commands without modifying existing code.

### Implementation:
- **Command Interface**: An interface could be created (if needed in future expansions) to define the structure for command objects, allowing actions like "travel to an era" or "take a quiz" to be represented as command objects.
- **Concrete Command Classes**: Each action (e.g., traveling to an era or taking a quiz) can be encapsulated in separate classes implementing the command interface. This provides a clean way to execute actions through a unified interface.
- **Invoker**: In the context of the game, the `TimeTraveler` class could serve as the invoker, calling the command objects to perform actions like saving or restoring states.

## 3. Composite Pattern
### Purpose:
The Composite Pattern allows clients to treat individual objects and compositions of objects uniformly. It is useful for handling hierarchical structures, making it easier to manage groups of objects.

### Implementation:
- **Leaf Class**: The `HistoricalEvent` class represents individual events as leaf nodes in the composite structure.
- **Composite Class**: The `EventGroup` class acts as a composite that can contain multiple `HistoricalEvent` objects, allowing for grouped operations (e.g., displaying all events in an era).
- **Display Logic**: By calling `displayEvents()` on an `EventGroup`, all historical events can be displayed in a unified manner, simplifying the UI logic.

## 4. Strategy Pattern (Optional)
### Purpose:
The Strategy Pattern allows you to define a family of algorithms and make them interchangeable. In this game, it could be used for different quiz types or question formats (multiple-choice, true/false, etc.).

### Implementation:
- **Strategy Interface**: Define a common interface for different quiz strategies.
- **Concrete Strategy Classes**: Create classes for each quiz type, implementing the quiz logic specific to that format.
- **Context Class**: The `TimeTraveler` or quiz administration logic can choose which strategy to use at runtime based on the current era or player preferences.

---
