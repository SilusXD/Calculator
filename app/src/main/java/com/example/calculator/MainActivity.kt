package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.rangeTo
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main))
        { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun clearResult(view: View)
    {
        val txtViewResult: TextView = findViewById(R.id.txtViewResult)
        val txtViewExpression: TextView = findViewById(R.id.txtViewExpression)

        txtViewResult.text = "0"
        txtViewExpression.text = ""
    }

    fun eraseChar(view: View)
    {
        val txtViewResult: TextView = findViewById(R.id.txtViewResult);

        if(txtViewResult.text.length > 1)
        {
            txtViewResult.text = txtViewResult.text.dropLast(1)
        }
        else
        {
            txtViewResult.text = "0";
        }
    }

    fun setNumber(number: Int)
    {
        val txtViewResult: TextView = findViewById(R.id.txtViewResult)

        if(txtViewResult.text[0] == '0' && txtViewResult.length() == 1 )
        {
            txtViewResult.text = number.toString()
        }
        else
        {
            txtViewResult.text = txtViewResult.text.toString() + number.toString()
        }
    }

    fun addNumber1(view: View)
    {
        setNumber(1)
    }

    fun addNumber2(view: View)
    {
        setNumber(2)
    }

    fun addNumber3(view: View)
    {
        setNumber(3)
    }

    fun addNumber4(view: View)
    {
        setNumber(4)
    }

    fun addNumber5(view: View)
    {
        setNumber(5)
    }

    fun addNumber6(view: View)
    {
        setNumber(6)
    }

    fun addNumber7(view: View)
    {
        setNumber(7)
    }

    fun addNumber8(view: View)
    {
        setNumber(8)
    }

    fun addNumber9(view: View)
    {
        setNumber(9)
    }

    fun addNumber0(view: View)
    {
        val txtViewResult: TextView = findViewById(R.id.txtViewResult)

        if(txtViewResult.length() == 1 && txtViewResult.text[0] != '0')
        {
            txtViewResult.text = txtViewResult.text.toString() + '0'
        }
        else if (txtViewResult.length() != 1)
        {
            txtViewResult.text = txtViewResult.text.toString() + '0'
        }
    }

    fun addNumberPoint(view: View)
    {
        val txtViewResult: TextView = findViewById(R.id.txtViewResult)

        if("+-x/.".contains(txtViewResult.text.last()))
        {
            return
        }

        if(txtViewResult.text.contains('+') || txtViewResult.text.contains('-') ||
            txtViewResult.text.contains('x') || txtViewResult.text.contains('/'))
        {
            for (i in txtViewResult.length() - 1 downTo 0) {
                if ("+-x/".contains(txtViewResult.text[i])) {
                    val tempString: String = txtViewResult.text.substring(i+1)
                    if (tempString.contains('.')) {
                        return
                    }
                    break
                }
            }
        }
        else if (txtViewResult.text.contains('.'))
        {
            return
        }

        txtViewResult.text = txtViewResult.text.toString() + '.'
    }

    fun changeSign(view: View)
    {
        val txtViewResult: TextView = findViewById(R.id.txtViewResult)
        if(txtViewResult.text.contains('+') || txtViewResult.text.contains('x') ||
            txtViewResult.text.contains('/'))
        {
            return
        }


        val countOfMinus: Int = txtViewResult.text.count{ it == '-'}
        if(countOfMinus > 1 || countOfMinus > 0 && txtViewResult.text[0] != '-' )
        {
            return
        }

        txtViewResult.text = (txtViewResult.text.toString().toDouble() * -1).toString()
    }

    fun insertOperator(view: View)
    {
        val txtViewResult: TextView = findViewById(R.id.txtViewResult)
        val btnOperator: TextView = findViewById(view.id)

        if("/x+-.".contains(txtViewResult.text.last()))
        {
            txtViewResult.text = txtViewResult.text.substring(0,txtViewResult.length()-1) +
                    btnOperator.text
        }
        else
        {
            txtViewResult.text = txtViewResult.text.toString() + btnOperator.text
        }
    }

    fun insertDivOperator(view: View)
    {
        insertOperator(view)
    }

    fun insertMultOperator(view: View)
    {
        insertOperator(view)
    }

    fun insertPlusOperator(view: View)
    {
        insertOperator(view)
    }

    fun insertMinusOperator(view: View)
    {
        insertOperator(view)
    }

    fun calculateResult(view: View)
    {
        val txtViewResult: TextView = findViewById(R.id.txtViewResult)
        val txtViewExpression: TextView = findViewById(R.id.txtViewExpression)

        var result: Double = 0.0
        var tempNum1: StringBuilder = StringBuilder()
        var tempOperator: Char = ' '

        if(!("+-x/".contains(txtViewResult.text.last())))
        {
            txtViewResult.text = txtViewResult.text.toString() + '+'
        }

        for (i in 0..<txtViewResult.length())
        {
            if(i == 0 && txtViewResult.text[i] == '-')
            {
                tempNum1.append(txtViewResult.text[i])
            }
            else if("/x+-".contains(txtViewResult.text[i]))
            {
                val num: Double = tempNum1.toString().toDouble()

                if(tempOperator == '+' || tempOperator == ' ')
                {
                    result += num
                }
                else if(tempOperator == '-')
                {
                    result -= num
                }
                else if(tempOperator == 'x')
                {
                    result *= num
                }
                else if(tempOperator == '/')
                {
                    result /= num
                }
                tempOperator = txtViewResult.text[i]
                tempNum1.clear()
            }
            else
            {
                tempNum1.append(txtViewResult.text[i])
            }
        }


        txtViewExpression.text = txtViewResult.text.dropLast(1)
        txtViewResult.text = result.toString()
    }
}