# Super Mario Exercise
## Author: Carlo Tacchella

## Request
This exercise is based on the famous Super Mario Game.
Brief Game Rules
1. R1 Super Mario, is out hero, he springs around the world, takes all the Coins he meets.
2. R2 Super Mario has enemies. If an enemy kills Super Mario, a life is lost. When all lives have been lost, the game ends.
3. R3 Super Mario can get extra lives by jumping each enemy consecutively without touching the ground.
4. R4 Super Mario can earn 5 coins by defeating enemies with fireballs.
5. R5 When Mario reaches 1000 points, he gets an additional life.

## Example "A"
If you have: "ConsecutivelyJumpOnBanzai_Bill,FireballOnBanzaiBill, Coin,Coin,Coin,ConsecutivelyJumpOnBlargg,InvincibleBig_Boo"
you earn 200+50+10+10+10+1600 points, but you lose a life but... 1600 = 600 points+1 life so you earn 600+280 points without loosing a life.

## Scoring System
Coin: 10 Points
Consecutively jump on enemies:
- Banzai_Bill: 200 points
- Beach_Koopa: 400 points
- Big_Boo: 800 points
- Blargg: 1600 points

## About this Project
I choose to develop the project in Java 22.

## Assumptions
(where to put the input file)
- I will remove points to get a life every time points gained are over 1000.
- I will always assume that default points value is 2000 and life default value is 3

## Pattern design used

## About the testing

## Executing the jar

## Example of input
In file "SuperMario-seq.txt"
"ConsecutivelyJumpOnBanzai_Bill,FireballOnBanzai_Bill,Coin,Coin,Coin,Coin,Coin,InvincibleBig_Boo,FireballOnBanzai_Bill,InvincibleBlargg,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,FireballOnBanzai_Bill,ConsecutivelyJumpOnBeach_Koopa,ConsecutivelyJumpOnBig_Boo,InvincibleBeach_Koopa,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin,Coin"

## Type of inputs:

### ConsecutivelyJumpOn<Monster type>
Effects: 
Point increment based on "Scoring system", based on the monster type.
If points > 1000 Life count +1 and points-=1000 (from "Example A").
With the previous behaviour that means the score is never higher than initial value + 999.
Basing on R3 if we have previous action "ConsecutivelyJumpOn" we increment life by one assuming that other actions are actions that make Mario touching the ground.

### Invincible<Monster type>
Life count: -1
If Life count reach 0 end the game

### FireballOn<Monster type>
Effects: 5 points
If points > 1000 Life count +1 and points -=1000

### Coin
Effects: 10 points
If points > 1000 Life count +1 and points -=1000
