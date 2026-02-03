import turtle as diego
import random

colors = ["red", "orange", "yellow", "green", "blue", "purple"]


window = diego.Screen()
window.setup(width=500, height=400)
user_bet = window.textinput(title="Scegli tartaruga", prompt="Quale vincerà la gara? Scegli un colore: ")

y = -150
x = -230
turtles = []


for color in colors:
    turtle = diego.Turtle(shape="turtle")
    turtle.color(color)
    turtle.penup()
    turtle.goto(x, y)
    y += 50
    turtles.append(turtle)

win = False


while not win:
    for turtle in turtles:
        turtle.forward(random.randint(0, 10))
        if turtle.xcor() >= 230:
            win = True
            winner = turtle.pencolor()
            if winner == user_bet:
                print("Hai vinto! La tartaruga", winner, "ha vinto!")
                window.title("Hai vinto!")
            else:
                print("Hai perso! Ha vinto la tartaruga", winner)
                window.title("Hai perso!")
            break

window.exitonclick()
