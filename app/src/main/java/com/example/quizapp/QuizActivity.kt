package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import kotlin.math.log

class QuizActivity : AppCompatActivity(), View.OnClickListener {

    private var mcurposition: Int = 1
    private var mquestionlist: ArrayList<Question>? = null
    private var mSelectedOption: Int = 0
    private var mUsername: String?= null
    private var mcorrectanswer: Int = 0
    private var mtotalquestion: Int?= null



    private var tvQuestion: TextView? = null
    private var tvimage: ImageView? = null
    private var progressBar: ProgressBar? = null
    private var TVoutoff: TextView? = null
    private var option1: TextView? = null
    private var option2: TextView? = null
    private var option3: TextView? = null
    private var option4: TextView? = null
    private var SubButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_quiz)

        mUsername = intent.getStringExtra(Constant.entername)


        tvQuestion = findViewById(R.id.tv_question)
        tvimage = findViewById(R.id.tv_image)
        progressBar = findViewById(R.id.prgressbar)
        TVoutoff = findViewById(R.id.TVoutoff)
        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)
        SubButton = findViewById(R.id.Submit)
        mquestionlist = Constant.getQuestions()

        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        SubButton?.setOnClickListener(this)

        setQuestion()
    }

    private fun setQuestion() {

        optionDefault()

        val question: Question = mquestionlist!![mcurposition - 1]

        tvQuestion?.text = question.question
        tvimage?.setImageResource(question.image)
        progressBar?.progress = mcurposition
        TVoutoff?.text = "$mcurposition/${progressBar?.max}"
        option1?.text = question.option1
        option2?.text = question.option2
        option3?.text = question.option3
        option4?.text = question.option4
        mtotalquestion = mquestionlist!!.size

        if (mcurposition == (mquestionlist!!.size))
            SubButton?.text = "FINISH"
        else
            SubButton?.text = "SUBMIT"
    }

    private fun optionDefault() {
        val options = ArrayList<TextView>()

        option1?.let {
            options.add(0, it)
        }

        option2?.let {
            options.add(1, it)
        }

        option3?.let {
            options.add(2, it)
        }

        option4?.let {
            options.add(3, it)
        }

        for (option in options) {
            //option.setTextColor(Color.parseColor("#7A8089"))
            option.setTextColor(Color.parseColor("#000000"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.mystyle
            )
        }
    }

    private fun selectedoption(tv: TextView, selectedOpNum: Int) {

        optionDefault()

        mSelectedOption = selectedOpNum

        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selectedoption
        )

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.option1 -> {
                option1?.let {
                    selectedoption(it, 1)
                }
            }

            R.id.option2 -> {
                option2?.let {
                    selectedoption(it, 2)
                }
            }

            R.id.option3 -> {
                option3?.let {
                    selectedoption(it, 3)
                }
            }

            R.id.option4 -> {
                option4?.let {
                    selectedoption(it, 4)
                }
            }

            R.id.Submit -> {
                if (mSelectedOption == 0) {
                    mcurposition++
                    when {
                        mcurposition <= mquestionlist!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            intent = Intent(this,result::class.java)
                            intent.putExtra(Constant.entername, mUsername)
                            intent.putExtra(Constant.corranswer,mcorrectanswer)
                            intent.putExtra(Constant.totquestion,mtotalquestion)

                            startActivity(intent)
                            finish()
                            }
                    }
                } else {
                    val question = mquestionlist?.get(mcurposition - 1)

                    if (question?.correctans != mSelectedOption) {
                        answerView(mSelectedOption, R.drawable.wrongans)
                    }
                    else {
                        mcorrectanswer++
                    }

                    answerView(mcorrectanswer, R.drawable.correctans)

                    if (mcurposition == mquestionlist!!.size)
                        SubButton?.text = "FINISH"
                    else
                        SubButton?.text = "GO TO NEXT QUESTION"
                }
                mSelectedOption = 0
            }
        }
    }
        fun answerView(answer: Int, drawableView: Int)
        {
            when (answer) {
                1 -> {
                    option1?.background = ContextCompat.getDrawable(
                        this,
                        drawableView
                    )
                }

                2 -> {
                    option2?.background = ContextCompat.getDrawable(
                        this,
                        drawableView
                    )
                }

                3 -> {
                    option3?.background = ContextCompat.getDrawable(
                        this,
                        drawableView
                    )
                }

                4 -> {
                    option4?.background = ContextCompat.getDrawable(
                        this,
                        drawableView
                    )
                }
            }
        }
}