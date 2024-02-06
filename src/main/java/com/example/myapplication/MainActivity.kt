package com.example.myapplication

import android.app.ActionBar
import android.app.AlertDialog
import android.app.AppOpsManager.OnOpNotedCallback
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnCreateContextMenuListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.datepicker.OnSelectionChangedListener
import com.google.android.material.navigation.NavigationView
import net.objecthunter.exp4j.ExpressionBuilder
import java.math.BigDecimal

class MainActivity : AppCompatActivity(), OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayOptions(androidx.appcompat.app.ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setCustomView(R.layout.custom_actionbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.title = "Калькулятор"
        supportActionBar?.height ?: 0


        val btn: Button = findViewById(R.id.button0)
        val btn1: Button = findViewById(R.id.Button1)
        val btn2: Button = findViewById(R.id.button2)
        val btn3: Button = findViewById(R.id.button3)
        val btn4: Button = findViewById(R.id.button4)
        val btn5: Button = findViewById(R.id.Button5)
        val btn6: Button = findViewById(R.id.button6)
        val btn7: Button = findViewById(R.id.button7)
        val btn8: Button = findViewById(R.id.button8)
        val btn9: Button = findViewById(R.id.Button9)
        val input: TextView = findViewById(R.id.textView2)
        val btnAC: Button = findViewById(R.id.buttonAC)
        val add: Button = findViewById(R.id.add)
        val sub: Button = findViewById(R.id.sub)
        val multiplication: Button = findViewById(R.id.multiplication)
        val division: Button = findViewById(R.id.division)
        val point: Button = findViewById(R.id.point)
        val equal: Button = findViewById(R.id.equal)
        val buttonC: Button = findViewById(R.id.ButtonC)

        btn.setOnClickListener {
            Toast.makeText(this, "button 0", Toast.LENGTH_SHORT).show()
        }
        btn.setOnClickListener(this)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        add.setOnClickListener(this)
        sub.setOnClickListener(this)
        multiplication.setOnClickListener(this)
        division.setOnClickListener(this)
        point.setOnClickListener(this)
        equal.setOnClickListener(this)
        buttonC.setOnClickListener(this)


        btnAC.setOnClickListener {
            input.text = ""
        }

        val text: String = intent.getStringExtra("value").toString()
        if(isNumericWithDot(text)) {
            findViewById<TextView>(R.id.textView2).text = text
        } else {
            findViewById<TextView>(R.id.textView2).text = "0"
        }
    }

    fun hello(){
        Toast.makeText(this, "button 4", Toast.LENGTH_SHORT).show()
    }


    override fun onClick(p0: View) {
        val input: TextView = findViewById(R.id.textView2)
        when (p0.id) {
            R.id.Button1 -> {
                val click: String = input.text.toString() + "1"
                input.text = click
            }

            R.id.button2 -> {
                val click: String = input.text.toString() + "2"
                input.text = click
            }

            R.id.button3 -> {
                val click: String = input.text.toString() + "3"
                input.text = click
            }

            R.id.button4 -> {
                val click: String = input.text.toString() + "4"
                input.text = click
                val message: () -> Unit
                message = :: hello
                message()
                Toast.makeText(this, "button 4", Toast.LENGTH_SHORT).show()
            }

            R.id.Button5 -> {
                val click: String = input.text.toString() + "5"
                input.text = click

            }

            R.id.button6 -> {
                val click: String = input.text.toString() + "6"
                input.text = click
            }

            R.id.button7 -> {
                val click: String = input.text.toString() + "7"
                input.text = click
            }

            R.id.button8 -> {
                val click: String = input.text.toString() + "8"
                input.text = click
            }

            R.id.Button9 -> {
                val click: String = input.text.toString() + "9"
                input.text = click
            }

            R.id.button0 -> {
                val click: String = input.text.toString() + "0"
                input.text = click
            }

            R.id.add -> {
                val inp: String = input.text.toString()

                if (inp == "") {
                    Log.i("MyTag", "Значение переменной ровняеться нулю");
                } else {
                    if (inp[inp.length - 1].isDigit()) {
                        val click: String = input.text.toString() + "+"
                        input.text = click
                    }
                    Log.i("MyTag", "Значение переменной myVariable: " + inp);

                }
            }

            R.id.sub -> {
                try {
                    val inp: String = input.text.toString()
                    if (inp == "") {
                        val click: String = input.text.toString() + "-"
                        input.text = click
                    } else if (inp[inp.length - 1].isDigit()) {

                        val click: String = input.text.toString() + "-"
                        input.text = click
                    }

                    Log.i("MyTag", "Значение переменной myVariable: " + inp);
                } catch (e: Exception) {
                    e.printStackTrace()
                }


            }

            R.id.multiplication -> {
                val inp: String = input.text.toString()

                if (inp == "") {
                    Log.i("MyTag", "Значение переменной ровняеться нулю");
                } else {
                    if (inp[inp.length - 1].isDigit()) {
                        val click: String = input.text.toString() + "*"
                        input.text = click
                    }
                    Log.i("MyTag", "Значение переменной myVariable: " + inp);

                }

            }

            R.id.division -> {
                val inp: String = input.text.toString()

                if (inp == "") {
                    Log.i("MyTag", "Значение переменной ровняеться нулю");
                } else {
                    if (inp[inp.length - 1].isDigit()) {
                        val click: String = input.text.toString() + "/"
                        input.text = click
                    }
                    Log.i("MyTag", "Значение переменной myVariable: " + inp);

                }
            }

            R.id.point -> {
                val inp: String = input.text.toString()

                if (inp == "") {
                    Log.i("MyTag", "Значение переменной ровняеться нулю");
                    val click: String = input.text.toString() + "0."
                    input.text = click
                } else {
                    if (inp[inp.length - 1].isDigit()) {
                        val inputString = input.text
                        val allowedOperators = setOf('+', '-', '*', '/')

                        val result = inputString.filter { it in allowedOperators }
                        Log.i("My!!!!!!!!!!1", "Значение переменной myVariable: " + result);
                        val lastSymbol = result.lastOrNull()
                        if (lastSymbol != null) {
                            Log.i(
                                "My!!!!!!!!!!1",
                                "Значение переменной myVariable: " + "$lastSymbol"
                            );

                            val charToFind = lastSymbol.toChar()

                            val lastIndex = inputString.lastIndexOf(charToFind)
                            if (lastIndex != -1) {
                                val result1 = inputString.substring(lastIndex + 1)
                                Log.i(
                                    "My!!!!!!!!!!1",
                                    "Значение переменной myVariable: " + lastIndex
                                );
                                Log.i("My!!!!!1", "Значение переменной myVariable: " + result1);

                                if ((result1.toDouble() % 1) == 0.0) {
                                    Log.i("My!!!!!1", "целое число");
                                    val click: String = input.text.toString() + "."
                                    input.text = click
                                } else {
                                    Log.i("My!!!!!1", "Дробное число");
                                    val click: String = input.text.toString()
                                    input.text = click
                                }
                            }
                        } else if (((inp.toDouble() % 1) == 0.0)) {
                            val click: String = input.text.toString() + "."
                            input.text = click
                        } else {
                            val click: String = input.text.toString()
                            input.text = click
                        }
                    }

                }
            }

            R.id.equal -> {
                try {
                    val click: String = input.text.toString()
                    val expressionResult = ExpressionBuilder(click).build().evaluate()
                    val result =
                        BigDecimal.valueOf(expressionResult).stripTrailingZeros().toPlainString()
                    input.text = result
                } catch (e: ArithmeticException) {
                    input.text = "На нуль заборонено ділити"
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }

            R.id.ButtonC -> {
                try {
                    val click: String = input.text.toString()
                    val indexToRemove = click.length - 1
                    val updatedString = StringBuilder(click).deleteCharAt(indexToRemove).toString()

                    input.text = updatedString
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }


    }

    fun isNumericWithDot(input: String): Boolean {
        return input.matches("[0-9]+(\\.[0-9]+)?".toRegex())
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {

            menu.add(0,0,0,"Конвертор")
    //    menu.add(0, 1, 1, "Калькулятор")
        menu.add(0, 2, 2, "Вихід")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val input: TextView = findViewById(R.id.textView2)
        if (item.itemId == 0) {
            val intent = Intent(this, MainActivity2::class.java)
            val stringValue = input.text
            intent.putExtra("key", stringValue)
            startActivity(intent)
        } else if (item.itemId == 1) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else if (item.itemId == 2) {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("Попередження")
                .setMessage("Бажаєте вийти?")
                .setPositiveButton("Так") { dialog, which ->
                    finishAffinity()
                    System.exit(0)
                }
                .setNegativeButton("Ні") { dialog, which ->

                }
            val dialog = builder.create()
            dialog.show()
        }
        return super.onOptionsItemSelected(item)
    }

}