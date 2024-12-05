# Console Strategy Game  
This game was developed as project 3 of the object oriented programming course at the Instituto Tecnológico de Costa Rica (TEC)

Welcome to **Console Strategy Game**, a turn-based card game inspired by strategy and dueling games like Yu-Gi-Oh! 🎴  
Players create and battle with cards, each with random stats, aiming to eliminate opponents and emerge as the last player standing.  

---

## 🛠 Features  

- **Card Creation**:  
  - 15 distinct card types.  
  - Players create cards of their preferred type with randomized stats.  
- **Turn-Based Combat**:  
  - Players take turns attacking opponents’ cards.  
  - Each card deals its assigned damage to enemy cards.  
- **Winning Objective**:  
  - The last player with at least one card alive wins the game.  
- **Interactive Commands**:  
  - Execute all game actions via in-game console commands.  
- **Multiplayer Chat**:  
  - Broadcast and private messaging using sockets.  
- **Dynamic Gameplay**:  
  - Real-time interaction enabled with Java threads.  

---

## 🚀 Technologies Used  

- **Java Swing**: Provides the graphical interface.  
- **Sockets**:  
  - Used for player communication (chat and game moves).  
  - Handles broadcasting and private messages.  
- **Threads**: Ensures smooth gameplay and manages concurrent actions.  
- **Design Patterns**:  
  - **Factory**: For card creation based on selected types.  
  - **MVC**: Organizes code into Model-View-Controller architecture.  
  - **Command**: Implements in-game console commands.  
  - **Singleton**: Manages global resources like game state.  
  - **Strategy**: Defines unique behaviors for different card types.  
  - Adheres to **SOLID principles** for clean and maintainable code.  

---

## 🎮 How to Play  

1. **Start the Game**  
   - Launch the server to host the game.  
   - Players connect to the server via the client application.  

2. **Create Your Deck**  
   - Use commands to create cards of your chosen types.  
   - Each card will have random stats (e.g., attack, defense, health).  

3. **Gameplay**  
   - Players take turns using commands to attack opponents’ cards.  
   - Manage your deck strategically to outlast your opponents.  

4. **Chat and Interact**  
   - Communicate with other players through the chat system.  

5. **Winning**  
   - The last player with at least one card alive wins the match.  

---

## 💻 Running the Game  

### Prerequisites  
- Java Development Kit (JDK) 8 or higher.  
- A Java-compatible IDE (e.g., IntelliJ IDEA, Eclipse, or NetBeans).  

### Steps  

1. **Start the Server**  
   - Compile and run the server application:  
     ```bash
     javac console_game/src/main/java/Main/GameServer.java  
     java -cp console_game/src/main/java Main.GameServer 
     ```  
     or use a IDLE
2. **Run the Client**  
   - Compile and launch the client:  
     ```bash
     javac console_game/src/main/java/Main/GameClient.java 
     java -cp console_game/src/main/java Main.GameClient   
     ```  
      or use a IDLE
3. **Setup your username and deck**    
