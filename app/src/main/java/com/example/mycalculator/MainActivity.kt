package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initClickListener()
    }

    var expression: String = ""

    private fun initClickListener() {
        one.setOnClickListener { addString(getString(R.string.one)) }
        two.setOnClickListener { addString(getString(R.string.two)) }
        three.setOnClickListener { addString(getString(R.string.three)) }
        four.setOnClickListener { addString(getString(R.string.four)) }
        five.setOnClickListener { addString(getString(R.string.five)) }
        six.setOnClickListener { addString(getString(R.string.six)) }
        seven.setOnClickListener { addString(getString(R.string.seven)) }
        eight.setOnClickListener { addString(getString(R.string.eight)) }
        nine.setOnClickListener { addString(getString(R.string.nine)) }
        zero.setOnClickListener { addString(getString(R.string.zero)) }
        equally.setOnClickListener { calculate() }
        AC.setOnClickListener { allClean() }
        delete.setOnClickListener { deleteLastChar() }
        percent.setOnClickListener { addOperation(getString(R.string.percent)) }
        division.setOnClickListener { addOperation(getString(R.string.division)) }
        plus.setOnClickListener { addOperation(getString(R.string.plus)) }
        minus.setOnClickListener { addOperation(getString(R.string.minus)) }
        multiplication.setOnClickListener { addOperation(getString(R.string.multiplication)) }
        dot.setOnClickListener { addString(getString(R.string.dot)) }
    }

    private fun allClean() {
        expression = ""
        tv_result.text = expression
    }

    private fun deleteLastChar() {
        expression = expression.dropLast(1)
        tv_result.text = expression
    }

    private fun addOperation(string: String) {
        expression += " $string "
        tv_result.text = expression
    }

    private fun addString(string: String) {
        expression += string
        tv_result.text = expression
    }

    private fun calculate() {
        val list: List<String> = expression.split(" ")
        val firstNum: Float = list[0].toFloat()
        val secondNum: Float = list[2].toFloat()
        val result = when (list[1]) {
            "+" -> firstNum + secondNum
            "-" -> firstNum - secondNum
            "*" -> firstNum * secondNum
            "%" -> firstNum / 100 * secondNum
            else -> firstNum / secondNum
        }
        tv_result.text = result.toString()
    }

}
