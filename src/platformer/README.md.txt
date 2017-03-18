Brian Lee, bhlee6@gmail.com

Under:Folder src/platformer
Game.png is UML class diagram of my project.
Design Document.txt is my Design Document

To Run (Through Eclipse)
Right click Properties for the "Java Project" -> go to "Java Build Path" -> "Add Class Folder" -> select the "res" folder
The source code is all in the above github.
To run the program, open the Game Class, and Run as Java application (Eclipse)

I set out to build a 2D platformer type game with an idea similar to Mario, where the player could move left and right,
jump, and attack (close up like with a sword).  There would be multiple levels, a game menu, and an environment that the player could walk along, with some hazards such as
 water or fire.  I also wanted to add multiple types of enemies that could do a variety of things (patrol,fly,shoot back).
 The goal would be to reach the end of the level without dying, and I wanted to give the player only one life, and if he died the game would be over,
 and he would restart at the beginning of the level or menu(was to be decided).  The game would have a camera that follows the player.

I ended up developing a 2D platformer type game where the player could move left and right, jump and attack with a laser/bullet weapon.
Alot of the credit and ideas come from RealTutsGML youtube channel that aided in creation of this game.
If the bullet hit an enemy the enemy would be removed from the game.
There are multiple levels, but I did not implement a menu.  There is an environment that the player can walk along (Blocks) and 
ground hazards such as pitfalls and Fire (Water can easily be added, would be very similar to fire).  I only implemented one type of 
enemy, but it was a flyer that patrolled back and forth.  If the player touched a hazard, fell through a hole, or touched an enemy,
he would essentially "die" and the game ends and closes the window.  The game has a camera that follows the player, and also there is
very basic animation.

There was a bug in detecting the collision(in Player class) and setting the player's y coordinate when jumping and hitting a block.
I believe I might have fixed the bug (I could not recreate the bug after I changed some code), but another bug seemed to show
where the player would get stuck on the top (comments in Player class,Collision method). I will have to make future adjustments to the collision bounds in order to fix this.
The keys have a bit of a "sticky" feel in that it is not fluid pressing left and right, jumping and attacking, and I believe it
 is in the implementation of KeyInput and movement.  I believe this can be fixed up to bring a smoother movement when combining key movements.
