from turtle import Screen , Turtle

tim = Turtle()
screen = Screen()
screen.setup(600,600)
screen.bgcolor("black")
screen.title("my snake game")
screen.tracer(0)
segment = []

x =0
for i in range(3):
    tim = Turtle()
    tim.shape("square")
    tim.color("white")
    tim.penup()
    tim.goto(x,0)
    x-=20
    segment.append(tim)
    
    
    

game_is_on = True
while game_is_on:
    screen.update()
    for i in segment:
        i.forward(20)












screen.exitonclick()