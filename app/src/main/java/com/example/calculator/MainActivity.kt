package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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

        txtViewResult.text = "0"
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

        if(!txtViewResult.text.contains('.'))
        {
            txtViewResult.text = txtViewResult.text.toString() + '.'
        }
    }

    fun changeSign(view: View)
    {
        val txtViewResult: TextView = findViewById(R.id.txtViewResult)

        val num: Any

        if(txtViewResult.text.contains('.'))
        {
            txtViewResult.text = (txtViewResult.text.toString().toDouble() * -1).toString()
        }
        else
        {
            txtViewResult.text = (txtViewResult.text.toString().toInt() * -1).toString()
        }
    }
}