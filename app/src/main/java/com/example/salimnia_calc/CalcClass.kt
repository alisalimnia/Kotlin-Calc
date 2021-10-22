package com.example.salimnia_calc

import android.annotation.SuppressLint
import android.util.Log
import android.widget.TextView
import java.lang.NumberFormatException

class CalcClass {
    private var firstNumber=""
    private var secondNumber=""
    private var operator=""


    private var calculated = false

    private lateinit var result:TextView


    fun addNumber(number:String)
    {

        if(operator=="")
        {
            if(calculated)
            {
                firstNumber=""
                result.text=""
                firstNumber+=number
                calculated=false
            }
            else
            {
                firstNumber+=number
            }
            calculated=false
            Log.e("Calc","Adding to FirstNumber $number")
        }
        else
        {
            secondNumber+=number
            Log.e("Calc","Adding toSecondNumber $number")
        }
        result.append(number)

    }

    fun addDot(dot:String)
    {
        if (!firstNumber.toString().contains('.'))
        {

            firstNumber+=dot
            result.append(dot)
            Log.e("Calc","Adding to FirstNumber $dot")

        }

        else if(firstNumber.isNotEmpty() && operator.isNotEmpty() && !secondNumber.toString().contains('.'))
        {
            secondNumber+=dot
            result.append(dot)
            Log.e("Calc","Adding to SecondNumber $dot")

        }

    }

    fun setOperator(op:String)
    {
        if(firstNumber=="")
        {
            Log.e("Calc","firstNumber is null")
            return
        }
        if(operator=="")
        {
            operator=op
            result.append(op)
            Log.e("Calc","oper is $op")

        }
        else
        {
            if(firstNumber.isNotEmpty() && operator.isNotEmpty() && secondNumber.isEmpty())
            {
                operator=op
                result.text = result.text.substring(0, result.text.length - 1);
                result.append(op)
                Log.e("Calc",operator)

            }
            return
        }
    }

    fun calculate()
    {
        Log.e("Calc","calculate")
        if(firstNumber=="" || secondNumber=="" ||operator=="")
        {
            Log.e("Calc","Not Enough data...")
            return
        }

        try {
            var a:Double=firstNumber.toDouble()
            var b:Double=secondNumber.toDouble()
////////////////
            var calculatedResult:Double =when(operator)
            {
                "+"->this.sum(a,b)
                "-"->this.minus(a,b)
                "/"->this.div(a,b)
                "×"->this.mul(a,b)
                else ->return// (0).toDouble()
            }
            /////////////////
            result.text=calculatedResult.toString()
            firstNumber=result.text.toString()
            operator=""
            secondNumber=""
        }
        catch (e:NumberFormatException)
        {
            Log.e("Calc","NumberFormatException")
        }

    }


    fun clear()
    {
        firstNumber=""
        secondNumber=""
        operator=""
        result.text=""

    }


    fun setResultView(result:TextView)
    {
        this.result=result
        Log.e("Calc","ResultView is Set")
    }


    fun sum(a:Double,b:Double)=a+b
    fun minus(a:Double,b:Double)=a-b
    fun mul(a:Double,b:Double)=a*b
    fun div(a:Double,b:Double):Double
    {
        if(b==0.0) return 0.0
        else return a/b
    }


    fun backSpace()
    {
        try {

                if(firstNumber.isNotEmpty() && operator.isNotEmpty() && secondNumber.isNotEmpty())
                {
                    result.text = result.text.substring(0, result.text.length - 1);
                    secondNumber=secondNumber.toString().substring(0,secondNumber.toString().length-1).toString()
                    Log.e("Cacl","in SecondNumber$secondNumber")
                }
           else if(firstNumber.isNotEmpty() && operator.isNotEmpty() && secondNumber.isEmpty())
            {
                result.text = result.text.substring(0, result.text.length - 1);
                Log.e("Cacl","in Operator$operator")
                operator=operator.toString().substring(0,operator.toString().length-1).toString()

            }
            else if(firstNumber.isNotEmpty() && operator.isEmpty() && secondNumber.isEmpty())
                {
                    Log.e("Cacl","in FirstNumber$firstNumber")
                    result.text = result.text.substring(0, result.text.length - 1);
                    firstNumber=firstNumber.toString().substring(0,firstNumber.toString().length-1).toString()

                }
            else
                return
        }
        catch (e:NumberFormatException)
        {
            Log.e("Calc","NumberFormatException")
        }

    }

    @SuppressLint("SetTextI18n")
    fun plMi()
    {
        try {
            if(firstNumber.isNotEmpty() && operator.isNotEmpty() && secondNumber.isNotEmpty())
            {


                secondNumber=(secondNumber.toString().toDouble()*-1).toString()
                result.text=firstNumber+operator+secondNumber.toString()
                Log.e("Cacl","in SecondNumber$secondNumber")
                if(operator=="-")
                {
                    result.text="$firstNumber$operator($secondNumber)"
                }
            }
            else if(firstNumber.isNotEmpty() && operator.isEmpty() && secondNumber.isEmpty())
            {
                firstNumber=(firstNumber.toString().toDouble()*-1).toString()
                result.text=firstNumber.toString()
                Log.e("Cacl","in FirstNumber$firstNumber")

            }
            else
                return

        }
        catch (e:NumberFormatException)
        {
            Log.e("Calc","NumberFormatException")
        }
    }
}