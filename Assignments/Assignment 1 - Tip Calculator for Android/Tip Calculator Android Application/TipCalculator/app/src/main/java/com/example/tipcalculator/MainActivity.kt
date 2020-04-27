package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.math.RoundingMode
private const val FLAG = "MainActivity"
var m_base = 0.0
var m_tipPercentage = 15
var m_split = 1
var m_tipAmount = 0.0
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Base Edit Text */
        baseEditText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Log.i(FLAG, "$s")
                if (baseEditText.text.toString().isEmpty()) {
                    m_base = 0.0
                    m_tipAmount = 0.0
                    tipTextView.text = ""
                    amountTextView.text = ""
                    return
                }
                if (baseEditText.text.toString() == ".") {
                    baseEditText?.setText("0.")
                    val editBaseText = findViewById(R.id.baseEditText) as EditText
                    editBaseText.setSelection(editBaseText.text.length)
                }
                amountTextView.text = ""
                m_base = baseEditText.text.toString().toDouble()
                m_base = "%.2f".format(m_base).toDouble()

                m_tipAmount = (m_tipPercentage.toDouble()/100) * m_base
                m_tipAmount = "%.2f".format(m_tipAmount).toDouble()
                tipTextView.text = "$$m_tipAmount"

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })

        /* Split Edit Text */
        splitEditText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Log.i(FLAG, "$s")
                if (splitEditText.text.toString().isEmpty()) {
                    amountTextView.text = ""
                    m_split = 1
                    return
                }
                amountTextView.text = ""
                m_split = splitEditText.text.toString().toInt()
                if (m_split == 0) {
                    Toast.makeText(this@MainActivity, "Bill can't be splitted among 0.", Toast.LENGTH_SHORT).show()
                    m_split = 1
                    splitEditText?.setText("$m_split")
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })

        /* Seek Bar */
        tipSeekBar.progress = 15
        tipPerTextView.text = "15%"
        tipSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.i(FLAG, "$progress")
                tipPerTextView.text = "$progress%"
                if (baseEditText.text.toString().isEmpty()) {
                    amountTextView.text = ""
                    m_base = 0.0
                    m_tipAmount = 0.0
                    tipTextView.text = ""
                    return
                }
                amountTextView.text = ""
                m_tipPercentage = progress
                m_tipAmount = (m_tipPercentage.toDouble()/100) * m_base
                m_tipAmount = "%.2f".format(m_tipAmount).toDouble()
                tipTextView.text = "$$m_tipAmount"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        /* Calculate Total */

        val calculate_button = findViewById(R.id.calButton) as Button

        calculate_button.setOnClickListener {
            if (m_base == 0.0) {
                Toast.makeText(this@MainActivity, "Please enter the base amount.", Toast.LENGTH_SHORT).show()
                amountTextView.text = ""
            } else{
                var totalAmt = m_base + m_tipAmount
                if (splitEditText.text.toString().isEmpty()) {
                    amountTextView.text = ""
                    splitEditText?.setText("1")
                    m_split = 1
                }
                if (m_split > 1) {
                    totalAmt /= m_split
                    totalAmt = "%.2f".format(totalAmt).toDouble()
                    amountTextView.text = "$$totalAmt per head"
                } else {
                    totalAmt = "%.2f".format(totalAmt).toDouble()
                    amountTextView.text = "$$totalAmt"
                }
            }

        }
        /* Reset Button */
        val reset_button = findViewById(R.id.resetButton) as Button
        reset_button.setOnClickListener{
            m_base = 0.0
            m_tipPercentage = 15
            m_split = 1
            m_tipAmount = 0.0
            amountTextView.text = ""
            splitEditText?.setText("1")
            tipTextView.text = ""
            tipSeekBar.progress = 15
            tipPerTextView.text = "15%"
            baseEditText?.setText("")
        }

    }
}
