from turtle import Turtle, Screen

tim = Turtle()
screen = Screen()

def move_forwards():
    tim.forward(10)

def move_backwards():
    tim.back(10)
    
def move_right():
    tim.right(10)

def move_left():
    tim.left(10)

def ripristino():
    tim.reset()
    

screen.listen()
screen.onkey(fun=move_forwards, key="w")
screen.onkey(move_backwards, "s")
screen.onkey(move_right, "d")
screen.onkey(move_left, "a")
screen.onkey(ripristino, "c")


screen.exitonclick()