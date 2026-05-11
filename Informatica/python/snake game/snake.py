from turtle import Turtle 

class Snake:
    
    def __init__(self):
        self.segment = []
        x =0
        for i in range(3):
            tim = Turtle()
            tim.shape("square")
            tim.color("white")
            tim.penup()
            tim.goto(x,0)
            x-=20
            self.segment.append(tim)


    def move(self):
        for i in range(len(self.segment) -1,0,-1):
            new_x = self.segment[i -1].xcor
            new_y = self.segment[i-1].ycor
            self.segment[i].goto(new_x,new_y)
