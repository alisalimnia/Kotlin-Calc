package com.example.salimnia_calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(),View.OnClickListener {


    lateinit var btn_0:Button
    lateinit var btn_1:Button
    lateinit var btn_2:Button
    lateinit var btn_3:Button
    lateinit var btn_4:Button
    lateinit var btn_5:Button
    lateinit var btn_6:Button
    lateinit var btn_7:Button
    lateinit var btn_8:Button
    lateinit var btn_9:Button
    lateinit var btn_Dot:Button
    lateinit var btn_Mul:Button
    lateinit var btn_Div:Button
    lateinit var btn_Minus:Button
    lateinit var btn_Sum:Button
    lateinit var btn_Equal:Button
    lateinit var btn_Clear:Button
    lateinit var btn_BackSpace:Button
    lateinit var btn_MiPl:Button
    //lateinit var txt_Op:TextView
    lateinit var txt_Result:TextView


    var calculator=CalcClass()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    fun init(){

        btn_0 =        findViewById(R.id.btn_0)
        btn_1 =        findViewById(R.id.btn_1)
        btn_2 =        findViewById(R.id.btn_2)
        btn_3 =        findViewById(R.id.btn_3)
        btn_4 =        findViewById(R.id.btn_4)
        btn_5 =        findViewById(R.id.btn_5)
        btn_6 =        findViewById(R.id.btn_6)
        btn_7 =        findViewById(R.id.btn_7)
        btn_8 =        findViewById(R.id.btn_8)
        btn_9 =        findViewById(R.id.btn_9)
        btn_Dot=       findViewById(R.id.btn_Dot)
        btn_Mul=       findViewById(R.id.btn_Mul)
        btn_Div=       findViewById(R.id.btn_Div)
        btn_Minus=     findViewById(R.id.btn_Minus)
        btn_Sum=       findViewById(R.id.btn_Sum)
        btn_Equal=     findViewById(R.id.btn_Equal)
        btn_Clear=     findViewById(R.id.btn_Clear)
        btn_BackSpace= findViewById(R.id.btn_BackSpace)
        btn_MiPl=      findViewById(R.id.btn_PlMi)
       // txt_Op=        findViewById(R.id.txt_Op)
        txt_Result=    findViewById(R.id.txt_Result)


        btn_0.setOnClickListener(this)
        btn_1.setOnClickListener(this)
        btn_2.setOnClickListener(this)
        btn_3.setOnClickListener(this)
        btn_4.setOnClickListener(this)
        btn_5.setOnClickListener(this)
        btn_6.setOnClickListener(this)
        btn_7.setOnClickListener(this)
        btn_8.setOnClickListener(this)
        btn_9.setOnClickListener(this)
        btn_Dot.setOnClickListener(this)
        btn_Mul.setOnClickListener(this)
        btn_Div.setOnClickListener(this)
        btn_Minus.setOnClickListener(this)
        btn_Sum.setOnClickListener(this)
        btn_Equal.setOnClickListener(this)
        btn_Clear.setOnClickListener(this)
        btn_BackSpace.setOnClickListener(this)
        btn_MiPl.setOnClickListener(this)
        //txt_Op.setOnClickListener(this)
        txt_Result.setOnClickListener(this)



        calculator.setResultView(txt_Result)


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_0  ->calculator.addNumber("0")
            R.id.btn_1  ->calculator.addNumber("1")
            R.id.btn_2  ->calculator.addNumber("2")
            R.id.btn_3  ->calculator.addNumber("3")
            R.id.btn_4  ->calculator.addNumber("4")
            R.id.btn_5  ->calculator.addNumber("5")
            R.id.btn_6  ->calculator.addNumber("6")
            R.id.btn_7  ->calculator.addNumber("7")
            R.id.btn_8  ->calculator.addNumber("8")
            R.id.btn_9  ->calculator.addNumber("9")
            R.id.btn_Dot ->calculator.addDot(".")
            R.id.btn_Sum ->calculator.setOperator("+")
            R.id.btn_Minus ->calculator.setOperator("-")
            R.id.btn_Mul ->calculator.setOperator("×")
            R.id.btn_Div ->calculator.setOperator("/")
            R.id.btn_Clear -> calculator.clear()
            R.id.btn_Equal ->calculator.calculate()
            R.id.btn_BackSpace-> calculator.backSpace()
            R.id.btn_PlMi -> calculator.plMi()

        }

    }
}