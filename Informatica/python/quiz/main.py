from question_model import Question
from data import question_data
from quiz_brain import QuizBrain

questionBank=[]
for i in question_data:
    questionBank.append(Question(i["question"], i["correct_answer"]))

quiz = QuizBrain(questionBank)


while quiz.stillHasQuestion():
    quiz.nextQuestion()
    
print("you've completed the quiz")
print(f"your final score was {quiz.score}/{quiz.questionNumber}")