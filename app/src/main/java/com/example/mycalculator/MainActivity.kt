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

    private fun render() {
        tv_result.text = expression
    }

    private fun initClickListener() {
        btn_one.setOnClickListener { addString(getString(R.string.one)) }
        btn_two.setOnClickListener { addString(getString(R.string.two)) }
        btn_three.setOnClickListener { addString(getString(R.string.three)) }
        btn_four.setOnClickListener { addString(getString(R.string.four)) }
        btn_five.setOnClickListener { addString(getString(R.string.five)) }
        btn_six.setOnClickListener { addString(getString(R.string.six)) }
        btn_seven.setOnClickListener { addString(getString(R.string.seven)) }
        btn_eight.setOnClickListener { addString(getString(R.string.eight)) }
        btn_nine.setOnClickListener { addString(getString(R.string.nine)) }
        btn_zero.setOnClickListener { addString(getString(R.string.zero)) }
        btn_equally.setOnClickListener { calculate() }
        btn_all_clean.setOnClickListener { allClean() }
        btn_delete.setOnClickListener { dropLastNumber() }
        btn_percent.setOnClickListener { addOperation(getString(R.string.percent)) }
        btn_division.setOnClickListener { addOperation(getString(R.string.division)) }
        btn_plus.setOnClickListener { addOperation(getString(R.string.plus)) }
        btn_minus.setOnClickListener { addOperation(getString(R.string.minus)) }
        btn_multiplication.setOnClickListener { addOperation(getString(R.string.multiplication)) }
        btn_dot.setOnClickListener { addString(getString(R.string.dot)) }
    }

    private fun allClean() {
        expression = ""
        render()
    }

    private fun dropLastNumber() {
        expression = expression.dropLast(1)
        render()
    }

    private fun addOperation(string: String) {
        expression += " $string "
        render()
    }

    private fun addString(string: String) {
        expression += string
        render()
    }

    private fun calculate() {
        val list: List<String> = expression.split(" ")
        if (list.size == 1 || list[2] == "") return
        val firstNum: Float = list[0].toFloat()
        val secondNum: Float = list[2].toFloat()
        val result = when (list[1]) {
            "+" -> firstNum + secondNum
            "-" -> firstNum - secondNum
            "*" -> firstNum * secondNum
            "%" -> firstNum / 100 * secondNum
            else -> firstNum / secondNum
        }
        expression = result.toString()
        if (expression[expression.length - 2].toString() == ".") {
            expression = expression.dropLast(2)
        }
        render()
    }
}
