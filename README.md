# Bowling Kata

Bowling score app developed in kotlin by following TDD approach

# Bowling Rules

The game consists of 10 frames. In each frame the player has two rolls to knock down 10 pins. The score for the frame is the total number of pins knocked down, plus bonuses for strikes and spares.

A spare is when the player knocks down all 10 pins in two rolls. The bonus for that frame is the number of pins knocked down by the next roll.

A strike is when the player knocks down all 10 pins on his first roll. The frame is then completed with a single roll. The bonus for that frame is the value of the next two rolls.

In the tenth frame a player who rolls a spare or strike is allowed to roll the extra balls to complete the frame. However no more than three balls can be rolled in tenth frame.

# Setup

Clone the project using below command

```bash
https://github.com/rajesh-udhayan/bowling-kata.git
```

Here are some useful Gradle/adb commands for executing this project:

 * `./gradlew runApp` - Builds and install the debug apk on the current connected device.
 * `./gradlew compileApp` - Builds the debug apk.
 * `./gradlew runUnitTests` - Execute unit tests (both unit and integration).
 * `./gradlew connectedAndroidTest` - Execute UI tests.
 
 # Dependencies used
 
 - Jetpack Compose
 
 - Android Hilt
 
 - Retrofit
 
 - Google Truth 
 
 - Mockk
 
 # Approaches followed 
 
 - Test Driven Development (TDD)

- UI Tests & Unit Tests

- MVVM architecture

- Dependency Injection
