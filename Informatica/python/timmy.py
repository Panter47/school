from turtle import Turtle, Screen

window=Screen()

timmy=Turtle()
timmy.shape("turtle")
timmy.color("darkorange")

timmy.penup()
timmy.left(90)
timmy.forward(300)
timmy.right(90)
timmy.pendown()
timmy.speed("fastest")
lati=3

while lati!=44:
    angolo=360/lati
    for _ in range(lati):
        timmy.forward(50)
        timmy.right(angolo)
        
    lati+=1

window.exitonclick()
