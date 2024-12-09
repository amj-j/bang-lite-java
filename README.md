# BANG Lite

This is a simplified version of card game "BANG" in the form of a console Java aplication.

## My motivation
This is the first assigment I was given in the "Object-Oriented Programming" course at my university. I coded this in March of 2023. This was, however, not my first experience with object oriented programming, as before starting the course, I completed four assignments from the same course (from previous years) as a self-directed challenge. My goal was to deepen my understanding of Java and object-oriented programming principles, as well as to prepare myself for the actual course. These projects can be found on my GitHub: [Duck hunt](https://github.com/amj-j/duck-hunt-java), [Monopoly lite](https://github.com/amj-j/monopoly-lite-java), [Reversi](https://github.com/amj-j/reversi-java), and [Rook in maze](https://github.com/amj-j/rook-in-maze-java).

The **Gameplay** section in this file is the original assignment.

### Goal
This assignment focuses on practicing the basic principles of object-oriented programming.

## Prerequisites
You need to have JDK 8 or higher installed on you computer to compile and run this app.

## Installation
1. Open your terminal and navigate to folder in which you wish to clone this repository.
2. Clone this repository using ```git clone https://github.com/amj-j/bang-lite-java.git```
3. In your terminal, navigate inside the new directory created by cloning the repository.
4. Execute this command to compile the source code: ```javac -d bin $(find src -name "*.java")``` (This command works on Linux, macOS, and Git Bash on Windows but not in Command Prompt or PowerShell. For Windows, use Git Bash terminal for compatibility, or list the source files manually.)
5. Execute this command to run the app: ```java -cp bin Bang```
6. The app will run in your terminal.

## Gameplay

### Introduction to the game

The players are in the wild west, and since this is a simplified version of the game, they all fight against each other. In this simplified version of the game, we have neither characters nor weapons and also we don't have many other cards from the original game.

### Goal of the game

Be the last one alive.

### Cards

In our version of the game, there are two types of cards, **Blue** and **Brown** cards.

#### Blue cards

After playing blue card, blue card lie in front of the player, and their effect is permanent until they are removed.

* 2x Barrel
* 1x Dynamite
* 3x Prison

#### Brown cards

Brown cards have an immediate effect and are immediately discarded into the discard pile after being played.

* 30x Bang
* 15x Missed
* 8x Beer
* 6x Cat Balou
* 4x Stagecoach
* 2x Indians

The effects of each card are described below.

### Game preparation

The game can be played by 2-4 players. Each player starts with 4 cards from the deck and starts with 4 lives. The upper number of lives is not limited.

### The course of the game

Players play sequentially in a row. Each player's turn is divided into 3 parts:
* 1. Drawing cards - at the beginning of their turn, the given player draws 2 cards from the deck. If they have blue cards (Prison, Dynamite) in front of them, their effect is excecuted first.
* 2. Playing cards - the player can play any number of cards during their turn, but he does not have to play any. During the move, however, the rule must be fulfilled that only one copy of each card can lie in front of the player (Example: If you already have a Barrel in front of you, you cannot place another one in front of you).
* 3. Discarding excess cards - a player can only have as many cards on their hand as they have lives at the end of their turn.

### Killing an opponent

If any of the players die, they return all the cards from their hand and from the table in front of them and put them in the discard pile.

### Explanation of individual cards

#### Bang and Missed

Bang cards are the main way to deal damage to your opponents. In this simplified version of the game, you can play an unlimited number of these cards during your turn.

If you are a target of a Bang card, you can immediately play a card Missed to discard the effect of the Bang card, if you don't have one, you lose a life. If you lose all lives, you are out of the game.

An example of a move: Player A plays a Bang card to Player B, Player B automatically checks if they have a card Missed on hand, if they do, the card is automatically played, if they do not, they lose a life.

#### Barrel

Barrel is a card that gives you a chance to hide from a BANG card attack. The chance of a Barrel is 1 in 4.

Example move: Some of the players shoot a BANG card at you, and you have a Barrel in front of you, you check its effect, and you may manage to avoid the shot. If you do, you don't need to play Missed and you don't lose a life.

#### Beer

The beer card allows the player to add one life. The effect of the card can only be applied to the currently playing player.

#### Stagecoach

Using the stagecoach card, the player can draw two cards from the deck.

#### Indians

By playing the Indians card, you cause an Indian attack on all players (except yourself). Each player must use a *Bang* card or lose one life.

#### Cat Balou

By playing this card, you can discard a card of your opponent, either from the table or from their hand.

Example of playing a card: Player A plays the Cat Balou card on Player B, the game offers them (A) whether they want to discard a card from Player B's hand or from the table. Then, randomly selected card is automatically discarded from Player B.

#### Prison

When you put this card in front of any other player, you send them to prison. If a player has a Prison card in front of them before the start of their turn, they must check its effect to see if they manage to escape from it or not. The chance of escaping from prison is 1 in 4. If they fail to escape from prison, they skip the turn. Else, they continue their turn. In both cases, the card is discarded into the deck after checking its effect.

#### Dynamite

You place this card in front of you when you play it. The effect of the Dynamite card is always checked at the beginning of the turn, if the dynamite explodes in front of you, you lose 3 life and the card is discarded into the deck. Unless your dynamite explodes, the card moves to the player who played before you (Dynamite moves in the opposite direction of the game). The dynamite has a 1 in 8 chance of exploding.

If the situation should arise that the player has both a Prison and Dynamite card in front of him at the beginning of the round, the effect of the Dynamite card is checked first.

[Rules of the original game](https://www.ultraboardgames.com/bang/game-rules.php)

### Controls
Since this is a console app, the last line in the console always gives instructions for the user about what to enter next. Every user input must be comitted by pressing ENTER. No mouse input is possible.
