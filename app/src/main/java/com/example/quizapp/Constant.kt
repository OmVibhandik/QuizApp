package com.example.quizapp

object Constant {

    const val entername : String = "Uermane"
    const val totquestion : String = "total question"
    const val corranswer : String = "correct answer"




    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val ques1 = Question(
            1,
            "On our first date, which animal would signify me?",
             R.drawable.animals,
            "Cute and cuddly like a kitten",
            "Like a turtle,always afraid to make the first move",
            "Like a tiger,brave and courageous",
            "Like an octopus... need I say more?",
            1,
        )
        questionList.add(ques1)

        val ques2 = Question(
            2,
            "What celebrity couple would best describes our relationship?",
            R.drawable.celebritycouple,
            "Brad Pitt and Angelina, sexy and passionate",
            "Tom cruise and Katie Holmes, crazy and unusual",
            "Ashton Kutcher and Demy Moore, opposites attract",
            "Brittney Spears and Kevin Federline, dysfunctional",
            2,

            )
        questionList.add(ques2)

        val ques3 = Question(
            3,
            "If our relationship would be an ice cream, what flavor would it be?",
            R.drawable.icecream,
            "Vanilla, classic and elegant, but kind of normal",
            "French chocolate, creamy, passionate, and sexy",
            "Rocky road, the name says it all",
            "Mint chocolate chip, mild, with a good taste",
            2,

            )
        questionList.add(ques3)

        val ques4 = Question(
            4,
            "If you and me were at a club, what would I be doing?",
            R.drawable.party,
            "Dancing with you",
            "Sitting in the corner",
            "With someone else",
            "In the middle of the dance floor",
            4,

            )
        questionList.add(ques4)

        val ques5 = Question(
            5,
            "What would our dream vacation be?",
            R.drawable.vacation,
            "An action packed adventure, kayaking, backpacking, and hiking",
            "A day at the beach, relaxing in the sun",
            "A day of pampering at a spa",
            "A day in the city",
            1,

            )
        questionList.add(ques5)

        val ques6 = Question(
            6,
            "What sport would our relationship be?",
            R.drawable.sports,
            "Baseball, the American pass time but kind of boring",
            "Football, ruff, rowdy, but a great show",
            "Soccer, a bunch of running around trying to score",
            "Frolf (frisbee golf), a fun game with no point",
            2,

            )
        questionList.add(ques6)

        val ques7 = Question(
            7,
            "What kind of weather forecast would our relationship be?",
            R.drawable.wheather,
            "Always sunny",
            "Partly cloudy",
            "Rash and unpredictable",
            "Like a tornado",
            1,

            )
        questionList.add(ques7)


        return questionList
    }
}