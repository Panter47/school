class QuizBrain:
    def __init__(self, questionList ):
        self.questionNumber = 0
        self.questionList = questionList
        self.score = 0
    
    def nextQuestion(self):
        currentQuestion = self.questionList[self.questionNumber]
        self.questionNumber += 1
        userAnswer = input(f"Q.{self.questionNumber}:{currentQuestion.text} (True/False): ")
        self.checkAnswer(userAnswer, currentQuestion.answer)
    def stillHasQuestion(self):
        return self.questionNumber < len(self.questionList)
    
    def checkAnswer(self, userAnswer, correctAnswer):
        if userAnswer == correctAnswer.lower():
            print("you got it right!")
            self.score += 1 
        else:
            print("that's wrong")
            print(f"the correct answer was : {correctAnswer}")
        print(f"your corrent score is: {self.score}/{self.questionNumber}")
        print("\n")