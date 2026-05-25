from turtle import Screen
from snake import Snake
from food import Food
from scoreboard import ScoreBoard
import time

screen = Screen()
screen.setup(600,600)
screen.bgcolor("black")
screen.title("my snake game")
screen.tracer(0)

snake = Snake()
food = Food()
score = ScoreBoard()

screen.listen()
screen.onkey(snake.up,"w")
screen.onkey(snake.down,"s")
screen.onkey(snake.left,"a")
screen.onkey(snake.right,"d")    
    
    

game_is_on = True
while game_is_on:
    screen.update()
    time.sleep(0.1)
    snake.move()
    
    if snake.head[0].distance(food) < 15:
        food.refresh()
        snake.extends()
        score.increase_score()
    
    if snake.head[0].xcor() > 280 or snake.head[0].xcor() <-280 or snake.head[0].ycor() >280  or snake.head[0].ycor() <-280:
        game_is_on = False
        score.game_over()
    
    for head in snake.head:
        if snake.head[0].distance(head)<10 and head != snake.head[0]:
            game_is_on = False
            score.game_over()



screen.exitonclick()
