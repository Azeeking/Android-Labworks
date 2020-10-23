package com.example.newcalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_one.*

class FragmentTwo : Fragment() {

    var isNewOp = true
    var oldNum = ""
    var op = "+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    fun numberEvent(view : View){
        if(isNewOp)
            operation.setText("")
        isNewOp = false
        var btnClick:String= operation.text.toString()
        var btnSelect = view as Button
        when(btnSelect.id){
            button13.id ->{ btnClick += "1"}
            button14.id ->{ btnClick += "2"}
            button15.id ->{ btnClick += "3"}
            button9.id ->{ btnClick += "4"}
            button10.id ->{ btnClick += "5"}
            button11.id ->{ btnClick += "6"}
            button5.id ->{ btnClick += "7"}
            button6.id ->{ btnClick += "8"}
            button7.id ->{ btnClick += "9"}
            button18.id ->{ btnClick += "."}
            button2.id ->{ btnClick = "-$btnClick"}
        }
        operation.setText(btnClick)
    }

    fun operatorEvent(view : View){
        isNewOp = true
        oldNum = operation.text.toString()
        var btnSelect = view as Button
        when(btnSelect.id){
            button8.id -> { op = "*" }
            button4.id -> { op = "/" }
            button16.id -> { op = "+" }
            button12.id -> { op = "-" }
        }
    }

    fun resultEvent(view: View){
        var newNum = operation.text.toString()
        var result = 0.0
        when(op){
            "+" -> { result = oldNum.toDouble() + newNum.toDouble()}
            "-" -> { result = oldNum.toDouble() - newNum.toDouble()}
            "*" -> { result = oldNum.toDouble() * newNum.toDouble()}
            "/" -> { result = oldNum.toDouble() / newNum.toDouble()}
        }
        operation.setText(result.toString())
    }

    fun acEvent(view: View){
        operation.setText("0")
        isNewOp = true
    }

    fun precentEvent(view: View){
        var prc = operation.text.toString().toDouble()/100
        operation.setText(prc.toString())
        isNewOp = true
    }


}