package ttcn.dinhvinh.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var number1: Double = 0.0
    var number2: Double = 0.0
    var result: Double = 0.0
    var btnAdd=findViewById<Button>(R.id.btnAddition)
    var btnSub=findViewById<Button>(R.id.btnSubtraction)
    var btnMul=findViewById<Button>(R.id.btnMultiplication)
    var btnDiv=findViewById<Button>(R.id.btnDivision)
    var tvResult = findViewById<TextView>(R.id.tvResult)
    var etNumber1=findViewById<TextView>(R.id.etNumber1)
    var etNumber2=findViewById<TextView>(R.id.etNumber2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        events()

    }
    private fun events() {
        btnAdd.setOnClickListener {
            cal("+")
        }

        btnSub.setOnClickListener {
            cal("-")
        }

        btnMul.setOnClickListener {
            cal("*")
        }

        btnDiv.setOnClickListener {
            cal("/")
        }
    }

    private fun cal(type: String) {

         tvResult.text = "Kết quả: 0"
        if (etNumber1.text.isEmpty()) {
            etNumber1.requestFocus()
            Toast.makeText(this@MainActivity, "Vui lòng nhập số thứ nhất", Toast.LENGTH_SHORT).show()
            return
        }

        if (etNumber2.text.isEmpty()) {
            etNumber2.requestFocus()
            Toast.makeText(this, "Vui lòng nhập số thứ hai", Toast.LENGTH_SHORT).show()
            return
        }

        number1 = etNumber1.text.toString().toDouble()
        number2 = etNumber2.text.toString().toDouble()

        result = when (type) {
            "+" -> number1 + number2
            "-" -> number1 - number2
            "*" -> number1 * number2
            "/" -> number1 / number2
            else -> 0.0
        }

        tvResult.text = "Kết quả: ${result.toString()}"
    }

}

