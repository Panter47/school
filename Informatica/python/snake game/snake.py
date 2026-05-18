from turtle import Turtle 

UP = 90 
DOWN = 270 
LEFT = 180 
RIGHT = 0

class Snake:
    
    def __init__(self):
        self.head = []
        x = 0
        for i in range(3):
            tim = Turtle()
            tim.shape("square")
            tim.color("white")
            tim.penup()
            tim.goto(x, 0)
            x -= 20
            self.head.append(tim)
        self.direction = self.head[0]

    def move(self):
        for i in range(len(self.head) - 1, 0, -1):
            new_x = self.head[i - 1].xcor()
            new_y = self.head[i - 1].ycor()
            self.head[i].goto(new_x, new_y)
        self.head[0].forward(20)              
        
        
    def up(self):
        if self.direction.heading() != DOWN:
            self.direction.setheading(UP)
    
    def down(self):
        if self.direction.heading() != UP:
            self.direction.setheading(DOWN)
    
    def left(self):
        if self.direction.heading() != RIGHT:
            self.direction.setheading(LEFT)
    
    def right(self):
        if self.direction.heading() != LEFT:
            self.direction.setheading(RIGHT)