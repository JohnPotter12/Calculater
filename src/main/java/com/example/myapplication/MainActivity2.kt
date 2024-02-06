package com.example.myapplication

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.navigation.NavigationBarView
import kotlin.time.times

class MainActivity2 : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.title = "Конвектор"

        val receivedValue: String? = intent.getStringExtra("key")
        Log.i("qwe", "$receivedValue")

        val input: EditText = findViewById(R.id.inputTextView)
        val output: TextView = findViewById(R.id.outputTextView)

        val editableValue: Editable = Editable.Factory.getInstance().newEditable(receivedValue ?: "")
        input.text = editableValue

        editSpinner(input, output)

        val spinner: Spinner = findViewById(R.id.value1)
        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            this,
            R.array.spinner_items,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selectedItem = parent?.getItemAtPosition(position).toString()
        Log.i("id", "id: $id")
        Log.i("position", "position: $position")
        Log.i("view", "view: $view")
        Log.i("selectedItem", "selectedItem: $selectedItem")
        println("Вибрано: $selectedItem")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    fun editSpinner(input: EditText, output: TextView) {
        val data = listOf("Довжина", "Маса", "Температура")
        val spinner: Spinner = findViewById(R.id.spinner)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedValue = data[position]
                if (selectedValue == "Довжина") {
                    typeLength(input, output)
                } else if (selectedValue == "Маса") {
                    typeMass()
                } else if (selectedValue == "Температура") {
                    temperature()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    fun temperature() {
        val data1 = listOf("°C", "°F", "K")
        val value1: Spinner = findViewById(R.id.value1)
        val adapter1 =
            ArrayAdapter(this@MainActivity2, android.R.layout.simple_spinner_item, data1)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        value1.adapter = adapter1

        value1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedValue1 = data1[position]
                if (selectedValue1 == "°C") {

                    val data2 = listOf("°C", "°F", "K")

                    val value2: Spinner = findViewById(R.id.value2)

                    val adapter2 = ArrayAdapter(
                        this@MainActivity2,
                        android.R.layout.simple_spinner_item,
                        data2
                    )
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                    value2.adapter = adapter2


                    value2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                val selectedValue2 = data2[position]

                                Toast.makeText(
                                    this@MainActivity2,
                                    "Вибрано: $selectedValue2",
                                    Toast.LENGTH_SHORT
                                ).show()
                                if (selectedValue2 == "°C") {

                                    textChange(1)

                                } else if (selectedValue2 == "°F") {

                                    textChange(3, true)

                                } else if (selectedValue2 == "K") {

                                    textChange(0, true,273.15)

                                }
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                            }
                        }

                } else if (selectedValue1 == "°F") {

                    val data2 = listOf("°C", "°F", "K")

                    val value2: Spinner = findViewById(R.id.value2)

                    val adapter2 = ArrayAdapter(
                        this@MainActivity2,
                        android.R.layout.simple_spinner_item,
                        data2
                    )
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                    value2.adapter = adapter2


                    value2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                val selectedValue2 = data2[position]

                                Toast.makeText(
                                    this@MainActivity2,
                                    "Вибрано: $selectedValue2",
                                    Toast.LENGTH_SHORT
                                ).show()
                                if (selectedValue2 == "°C") {

                                    textChange(3, false)

                                } else if (selectedValue2 == "°F") {

                                    textChange(1)

                                } else if (selectedValue2 == "K") {

                                    textChange(4, true)

                                }
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                            }
                        }

                } else if (selectedValue1 == "K") {

                    val data2 = listOf("°C", "°F", "K")

                    val value2: Spinner = findViewById(R.id.value2)

                    val adapter2 = ArrayAdapter(
                        this@MainActivity2,
                        android.R.layout.simple_spinner_item,
                        data2
                    )
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                    value2.adapter = adapter2


                    value2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                val selectedValue2 = data2[position]

                                Toast.makeText(
                                    this@MainActivity2,
                                    "Вибрано: $selectedValue2",
                                    Toast.LENGTH_SHORT
                                ).show()
                                if (selectedValue2 == "°C") {

                                    textChange(0, false, 273.15)

                                } else if (selectedValue2 == "°F") {

                                    textChange(4, false)

                                } else if (selectedValue2 == "K") {

                                    textChange(1)

                                }
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                            }
                        }

                }  else
                    textChange(0, true,0.0)
                }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

    }

    fun typeMass() {
        val data1 = listOf("гр", "кг", "фунт", "тонна")
        val value1: Spinner = findViewById(R.id.value1)
        val adapter1 =
            ArrayAdapter(this@MainActivity2, android.R.layout.simple_spinner_item, data1)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        value1.adapter = adapter1

        value1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedValue1 = data1[position]
                if (selectedValue1 == "гр") {

                    val data2 = listOf("гр", "кг", "фунт", "тонна")

                    val value2: Spinner = findViewById(R.id.value2)

                    val adapter2 = ArrayAdapter(
                        this@MainActivity2,
                        android.R.layout.simple_spinner_item,
                        data2
                    )
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                    value2.adapter = adapter2


                    value2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                val selectedValue2 = data2[position]

                                Toast.makeText(
                                    this@MainActivity2,
                                    "Вибрано: $selectedValue2",
                                    Toast.LENGTH_SHORT
                                ).show()
                                if (selectedValue2 == "гр") {

                                    textChange(1)

                                } else if (selectedValue2 == "кг") {

                                    textChange(2, false,1000.0)

                                } else if (selectedValue2 == "фунт") {

                                    textChange(2, false,453.59237)

                                } else if (selectedValue2 == "тонна") {

                                    textChange(2, false,1000000.0)

                                }
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                            }
                        }

                } else if (selectedValue1 == "кг") {

                    val data2 = listOf("гр", "кг", "фунт", "тонна")

                    val value2: Spinner = findViewById(R.id.value2)

                    val adapter2 = ArrayAdapter(
                        this@MainActivity2,
                        android.R.layout.simple_spinner_item,
                        data2
                    )
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                    value2.adapter = adapter2


                    value2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                val selectedValue2 = data2[position]

                                Toast.makeText(
                                    this@MainActivity2,
                                    "Вибрано: $selectedValue2",
                                    Toast.LENGTH_SHORT
                                ).show()
                                if (selectedValue2 == "гр") {

                                    textChange(2, true,1000.0)

                                } else if (selectedValue2 == "кг") {

                                    textChange(1,)

                                } else if (selectedValue2 == "фунт") {

                                    textChange(2, false,0.45359237)

                                } else if (selectedValue2 == "тонна") {

                                    textChange(2, false,1000.0)

                                }
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                            }
                        }

                } else if (selectedValue1 == "фунт") {

                    val data2 = listOf("гр", "кг", "фунт", "тонна")

                    val value2: Spinner = findViewById(R.id.value2)

                    val adapter2 = ArrayAdapter(
                        this@MainActivity2,
                        android.R.layout.simple_spinner_item,
                        data2
                    )
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                    value2.adapter = adapter2


                    value2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                val selectedValue2 = data2[position]

                                Toast.makeText(
                                    this@MainActivity2,
                                    "Вибрано: $selectedValue2",
                                    Toast.LENGTH_SHORT
                                ).show()
                                if (selectedValue2 == "гр") {

                                    Log.i("selected", "кг")
                                    textChange(2, true,0.00220462262)

                                } else if (selectedValue2 == "кг") {

                                    Log.i("selected", "см")
                                    textChange(2, true,2.20462262)

                                } else if (selectedValue2 == "фунт") {

                                    Log.i("selected", "м")
                                    textChange(1,)

                                } else if (selectedValue2 == "тонна") {

                                    Log.i("selected", "kм")
                                    textChange(2, false,2204.62262)

                                }
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                            }
                        }

                }  else if (selectedValue1 == "тонна") {

                    val data2 = listOf("гр", "кг", "фунт", "тонна")

                    val value2: Spinner = findViewById(R.id.value2)

                    val adapter2 = ArrayAdapter(
                        this@MainActivity2,
                        android.R.layout.simple_spinner_item,
                        data2
                    )
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                    value2.adapter = adapter2


                    value2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                val selectedValue2 = data2[position]

                                Toast.makeText(
                                    this@MainActivity2,
                                    "Вибрано: $selectedValue2",
                                    Toast.LENGTH_SHORT
                                ).show()
                                if (selectedValue2 == "гр") {

                                    textChange(2, true,1000000.0)

                                } else if (selectedValue2 == "кг") {

                                    textChange(2, true,1000.0)

                                } else if (selectedValue2 == "фунт") {

                                    textChange(2, true,2204.62262)

                                } else if (selectedValue2 == "тонна") {

                                    textChange(1)

                                }
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                            }
                        }

                } else
                    textChange(0, true,0.0)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }


    fun typeLength(input: EditText, output: TextView) {
            val data1 = listOf("мм", "см", "м", "км")
            val value1: Spinner = findViewById(R.id.value1)
            val adapter1 =
                ArrayAdapter(this@MainActivity2, android.R.layout.simple_spinner_item, data1)
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            value1.adapter = adapter1

            value1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selectedValue1 = data1[position]
                    if (selectedValue1 == "мм") {

                        val data2 = listOf("мм", "см", "м", "км")

                        val value2: Spinner = findViewById(R.id.value2)

                        val adapter2 = ArrayAdapter(
                            this@MainActivity2,
                            android.R.layout.simple_spinner_item,
                            data2
                        )
                        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                        value2.adapter = adapter2


                        value2.onItemSelectedListener =
                            object : AdapterView.OnItemSelectedListener {
                                override fun onItemSelected(
                                    parent: AdapterView<*>?,
                                    view: View?,
                                    position: Int,
                                    id: Long
                                ) {
                                    val selectedValue2 = data2[position]

                                    Toast.makeText(
                                        this@MainActivity2,
                                        "Вибрано: $selectedValue2",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    if (selectedValue2 == "мм") {

                                        textChange(1)

                                    } else if (selectedValue2 == "см") {

                                        textChange(2, false,10.0)

                                    } else if (selectedValue2 == "м") {

                                        textChange(2, false,1000.0)

                                    } else if (selectedValue2 == "км") {

                                        textChange(2, false,1000000.0)

                                    }
                                }

                                override fun onNothingSelected(parent: AdapterView<*>?) {
                                }
                            }

                    } else if (selectedValue1 == "см") {

                        val data2 = listOf("мм", "см", "м", "км")

                        val value2: Spinner = findViewById(R.id.value2)

                        val adapter2 = ArrayAdapter(
                            this@MainActivity2,
                            android.R.layout.simple_spinner_item,
                            data2
                        )
                        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                        value2.adapter = adapter2


                        value2.onItemSelectedListener =
                            object : AdapterView.OnItemSelectedListener {
                                override fun onItemSelected(
                                    parent: AdapterView<*>?,
                                    view: View?,
                                    position: Int,
                                    id: Long
                                ) {
                                    val selectedValue2 = data2[position]

                                    Toast.makeText(
                                        this@MainActivity2,
                                        "Вибрано: $selectedValue2",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    if (selectedValue2 == "мм") {

                                        textChange(2, true,10.0)

                                    } else if (selectedValue2 == "см") {

                                        textChange(1,)

                                    } else if (selectedValue2 == "м") {

                                        textChange(2, false,100.0)

                                    } else if (selectedValue2 == "км") {

                                        textChange(2, false,100000.0)

                                    }
                                }

                                override fun onNothingSelected(parent: AdapterView<*>?) {
                                }
                            }

                    } else if (selectedValue1 == "м") {

                        val data2 = listOf("мм", "см", "м", "км")

                        val value2: Spinner = findViewById(R.id.value2)

                        val adapter2 = ArrayAdapter(
                            this@MainActivity2,
                            android.R.layout.simple_spinner_item,
                            data2
                        )
                        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                        value2.adapter = adapter2


                        value2.onItemSelectedListener =
                            object : AdapterView.OnItemSelectedListener {
                                override fun onItemSelected(
                                    parent: AdapterView<*>?,
                                    view: View?,
                                    position: Int,
                                    id: Long
                                ) {
                                    val selectedValue2 = data2[position]

                                    Toast.makeText(
                                        this@MainActivity2,
                                        "Вибрано: $selectedValue2",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    if (selectedValue2 == "мм") {

                                         textChange(2, true,1000.0)

                                    } else if (selectedValue2 == "см") {

                                        textChange(2, true,100.0)

                                    } else if (selectedValue2 == "м") {

                                        textChange(1,)

                                    } else if (selectedValue2 == "км") {

                                        textChange(2, false,1000.0)

                                    }
                                }

                                override fun onNothingSelected(parent: AdapterView<*>?) {
                                }
                            }

                    }  else if (selectedValue1 == "км") {

                        val data2 = listOf("мм", "см", "м", "км")

                        val value2: Spinner = findViewById(R.id.value2)

                        val adapter2 = ArrayAdapter(
                            this@MainActivity2,
                            android.R.layout.simple_spinner_item,
                            data2
                        )
                        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                        value2.adapter = adapter2


                        value2.onItemSelectedListener =
                            object : AdapterView.OnItemSelectedListener {
                                override fun onItemSelected(
                                    parent: AdapterView<*>?,
                                    view: View?,
                                    position: Int,
                                    id: Long
                                ) {
                                    val selectedValue2 = data2[position]

                                    Toast.makeText(
                                        this@MainActivity2,
                                        "Вибрано: $selectedValue2",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    if (selectedValue2 == "мм") {

                                        textChange(2, true,1000000.0)

                                    } else if (selectedValue2 == "см") {

                                        textChange(2, true,100000.0)

                                    } else if (selectedValue2 == "м") {

                                        textChange(2, true,1000.0)

                                    } else if (selectedValue2 == "км") {

                                        textChange(1)

                                    }
                                }

                                override fun onNothingSelected(parent: AdapterView<*>?) {
                                }
                            }

                    } else
                        textChange(0, true,0.0)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
        }

        fun isNumericWithDot(input: String): Boolean {
            return input.matches("[0-9]+(\\.[0-9]+)?".toRegex())
        }

        fun textChange(id: Int, oper: Boolean = true, b: Double = 1.0) {


            val input: EditText = findViewById(R.id.inputTextView)
            val output: TextView = findViewById(R.id.outputTextView)

            var previousEditTextValue: String = ""

            input.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    previousEditTextValue = s.toString()
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    val null0: Number = 0
                    when (id) {
                        0 -> {
                            if (oper){
                                try {
                                    val outputString: String = input.text.toString()
                                    val outputValue: Double = outputString.toDouble() + b
                                    output.text = outputValue.toString()
                                } catch (e: NumberFormatException) {
                                    e.printStackTrace()
                                }
                            } else {
                                try {
                                    val outputString: String = input.text.toString()
                                    val outputValue: Double = outputString.toDouble() - b
                                    output.text = outputValue.toString()
                                } catch (e: NumberFormatException) {
                                    e.printStackTrace()
                                }
                            }

                        }
                        1 -> {
                            output.text = input.text
                        }
                        2 -> {
                            try {
                                if (oper){
                                    try {
                                        val outputString: String = input.text.toString()
                                        Log.i("id: $id", "outputString: $outputString")
                                        val outputValue: Double = outputString.toDouble() * b
                                        Log.i("id: $id", "outputValue: $outputValue")
                                        output.text = outputValue.toString()
                                        if(outputValue is Double){
                                            val type = outputValue::class
                                            Log.i("id: $id", "double" )
                                            Log.i("id: $id",  "$type")
                                        }
                                    }catch (e: NumberFormatException) {
                                        println("Помилка перетворення: ${e.message}")
                                    }

                                }else {
                                    try {
                                        val outputString: String = input.text.toString()
                                        Log.i("id: $id", "outputString: $outputString")
                                        val outputValue: Double = outputString.toDouble() / b
                                        Log.i("id: $id", "outputValue: $outputValue")
                                        output.text = String.format("%.8f", outputValue).replace("0*$".toRegex(), "").replace(",*$".toRegex(), "")
                                        if(outputValue is Double){
                                            val type = outputValue::class
                                            Log.i("id: $id", "double" )
                                            Log.i("id: $id",  "$type")
                                        }
                                    } catch (e: NumberFormatException) {
                                        e.printStackTrace()
                                    }

                                }
                            } catch (e: NumberFormatException) {
                                e.printStackTrace()
                            }
                        }
                        3 -> {
                            try {
                                val outputString: String = input.text.toString()
                                if (outputString.isNotEmpty()){
                                    if (oper){
                                        try {
                                            val outputString: String = input.text.toString()
                                            val a: Double = 1.8
                                            val outputValue: Double = a * outputString.toDouble() + 32
                                            output.text = outputValue.toString()
                                        } catch (e: NumberFormatException) {
                                            e.printStackTrace()
                                        }
                                    } else {
                                        try {
                                            val outputString: String = input.text.toString()
                                            val outputValue: Double = (outputString.toDouble() - 32) * 5 / 9
                                            output.text = outputValue.toString()
                                        } catch (e: NumberFormatException) {
                                            e.printStackTrace()
                                        }

                                    }


                                }
                            } catch (e: NumberFormatException) {
                                e.printStackTrace()
                            }
                        }
                        4 -> {
                            try {
                                val outputString: String = input.text.toString()
                                if (outputString.isNotEmpty()){
                                    if (oper){
                                        try{
                                            val outputValue: Double = ((outputString.toDouble() - 32) * 5 / 9) + 273.15
                                            output.text = outputValue.toString()
                                        } catch (e: NumberFormatException) {
                                            e.printStackTrace()
                                        }

                                    } else {
                                        try {
                                            val a: Double = 1.8
                                            val outputValue: Double = a * ( outputString.toDouble() - 273.15) + 32
                                            output.text = outputValue.toString()
                                        } catch (e: NumberFormatException) {
                                            e.printStackTrace()
                                        }
                                    }

                                }
                            } catch (e: NumberFormatException) {
                                e.printStackTrace()
                            }


                        }
                    }

                }

                override fun afterTextChanged(s: Editable?) {
                    val enteredText = s.toString()
                }
            })

            when (id) {
                0 -> {
                    if (oper){
                        try {
                            val outputString: String = input.text.toString()
                            val outputValue: Double = outputString.toDouble() + b
                            output.text = outputValue.toString()
                        } catch (e: NumberFormatException) {
                            e.printStackTrace()
                        }
                    } else {
                        try {
                            val outputString: String = input.text.toString()
                            val outputValue: Double = outputString.toDouble() - b
                            output.text = outputValue.toString()
                        } catch (e: NumberFormatException) {
                            e.printStackTrace()
                        }
                    }

                }
                1 -> {
                    output.text = input.text
                }
                2 -> {
                    try {
                        if (oper){
                            try {
                                val outputString: String = input.text.toString()
                                val outputValue: Double = outputString.toDouble() * b
                                output.text = outputValue.toString()
                            }catch (e: NumberFormatException) {
                                println("Помилка перетворення: ${e.message}")
                            }

                        }else {
                            try {
                                val outputString: String = input.text.toString()
                                val outputValue: Double = outputString.toDouble() / b
                                output.text = String.format("%.8f", outputValue).replace("0*$".toRegex(), "").replace(",*$".toRegex(), "")
                            } catch (e: NumberFormatException) {
                                println("Помилка перетворення: ${e.message}")
                            }

                        }
                    } catch (e: NumberFormatException) {
                    }
                }
                3 -> {
                    try {
                        val outputString: String = input.text.toString()
                        if (outputString.isNotEmpty()){
                            if (oper){
                                try {
                                    val outputString: String = input.text.toString()
                                    val a: Double = 1.8
                                    val outputValue: Double = a * outputString.toDouble() + 32
                                    output.text = outputValue.toString()
                                } catch (e: NumberFormatException) {
                                    e.printStackTrace()
                                }
                            } else {
                                try {
                                    val outputString: String = input.text.toString()
                                    val a: Double = 1.8
                                    val outputValue: Double = a * (outputString.toDouble() - 32)
                                    output.text = outputValue.toString()
                                } catch (e: NumberFormatException) {
                                    e.printStackTrace()
                                }

                            }


                        }
                    } catch (e: NumberFormatException) {
                        e.printStackTrace()
                    }
                }
                4 -> {
                    try {
                        val outputString: String = input.text.toString()
                        if (outputString.isNotEmpty()){
                            if (oper){
                                try {
                                    val a: Double = 1.8
                                    val outputValue: Double = (a * outputString.toDouble() + 32) + 273.15
                                    output.text = outputValue.toString()
                                } catch (e: NumberFormatException) {
                                    e.printStackTrace()
                                }
                            } else {
                                try{
                                    val outputString: String = input.text.toString()
                                    val a: Double = 1.8
                                    val outputValue: Double = a * ((outputString.toDouble() - 273.15) - 32)
                                    output.text = outputValue.toString()
                                } catch (e: NumberFormatException) {
                                    e.printStackTrace()
                                }
                            }

                        }
                    } catch (e: NumberFormatException) {
                        e.printStackTrace()
                    }


                }
            }

        }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menu.add(0,0,0,"Конвертор")
        menu.add(0, 1, 1, "Калькулятор")
        menu.add(0, 2, 2, "Вихід")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == 0) {
            val intent = Intent(this, MainActivity2::class.java)
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