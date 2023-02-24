package my.edu.tarc.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Linking between UI and Code
        val imageViewBMI: ImageView=findViewById(R.id.imageViewBMI)
        val textViewBMI:TextView=findViewById(R.id.textViewBMI)
        val textViewStatus:TextView=findViewById(R.id.textViewStatus)
        val editTextWeight:EditText=findViewById(R.id.editTextWeight)
        val editTextHeight:EditText=findViewById(R.id.editTextHeight)
        val buttonCalculate:Button=findViewById(R.id.buttonCalculate)
        val buttonReset:Button=findViewById(R.id.buttonReset)

        buttonCalculate.setOnClickListener {

            if(editTextWeight.text.isEmpty()){
                editTextWeight.setError(getString(R.string.value_required))
                return@setOnClickListener //terminate program execution
                }

            if(editTextHeight.text.isEmpty()){
                editTextWeight.setError(getString(R.string.value_required))
                return@setOnClickListener //terminate program execution
            }

            var weight=editTextWeight.text.toString().toFloat()
            var height=editTextHeight.text.toString().toFloat()
            var bmi=weight/(height/100).pow(2)

            if(bmi<18.5){ //underweight
                imageViewBMI.setImageResource(R.drawable.under)

                //Body Mass Index:18.42
                textViewBMI.text= String.format("%s : %.2f",getString(R.string.bmi),bmi)
                textViewStatus.text= String.format("%s : %s",getString(R.string.status),getString(R.string.under))

            }

            if(bmi>=18.5 && bmi<25){ //normal
                imageViewBMI.setImageResource(R.drawable.normal)

                //Body Mass Index:18.42
                textViewBMI.text= String.format("%s : %.2f",getString(R.string.bmi),bmi)
                textViewStatus.text= String.format("%s : %s",getString(R.string.status),getString(R.string.normal))
            }

            if(bmi>=25){ //overweight
                imageViewBMI.setImageResource(R.drawable.over)

                //Body Mass Index:18.42
                textViewBMI.text= String.format("%s : %.2f",getString(R.string.bmi),bmi)
                textViewStatus.text= String.format("%s : %s",getString(R.string.status),getString(R.string.over))
            }
        }

        buttonReset.setOnClickListener {
            editTextWeight.text.clear()
            editTextHeight.text.clear()
            imageViewBMI.setImageResource(R.drawable.empty)
        }
    }

}

