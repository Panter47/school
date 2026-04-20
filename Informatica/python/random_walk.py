import turtle as t
import random


screen = t.Screen()
screen.colormode(255)


tim = t.Turtle()


########### Challenge 4 - Random Walk ########


def random_color():
   r = random.randint(0, 255)
   g = random.randint(0, 255)
   b = random.randint(0, 255)
   thecolor = (r, g, b)
   return thecolor
  


tim.pensize(2)
tim.speed("fastest")


for i in range(200):
  
   tim.color(random_color())
   tim.circle(150)
   tim.setheading(i*5)


screen.exitonclick()





