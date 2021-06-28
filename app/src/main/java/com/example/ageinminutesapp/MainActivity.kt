package com.example.ageinminutesapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    var selectedDate: String? = null


    lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button= findViewById<Button>(R.id.btnDatePicker)

           button.setOnClickListener{
               clickDatePicker()

   }
    }



  fun clickDatePicker(){

      val myCalendar= Calendar.getInstance()
      val year=myCalendar.get(Calendar.YEAR)
      val month=myCalendar.get(Calendar.MONTH)
      val day= myCalendar.get(Calendar.DAY_OF_MONTH)



     val dpd= DatePickerDialog(this , DatePickerDialog.OnDateSetListener { _, year, month, day ->
       Toast.makeText(this, "$day ${month+1} $year", Toast.LENGTH_SHORT).show()

        selectedDate = "$day/${month+1}/$year"
         Log.i("awdawdawdawdawdawd", "$day/${month+1}/$year")

         var date=findViewById<TextView>(R.id.dateOfBirth)
         date.text = selectedDate



      val sdf=SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)

      val theDate = sdf.parse(selectedDate)

      val selectedDateInMinutes = theDate!!.time/60000

      val currentDate= sdf.parse(sdf.format(System.currentTimeMillis()))

      Log.i("wwwwww", currentDate.toString())

      val currentTimeInMinutes = currentDate!!.time/60000
         Log.i("qwerty", currentTimeInMinutes.toString())
      val difference = currentTimeInMinutes - selectedDateInMinutes

      val dateInMinutes=findViewById<TextView>(R.id.calculatedAgeInMinutes)
      dateInMinutes.text = difference.toString()

     },year,month,day)


      dpd.datePicker.maxDate = Date().time-86400000
      dpd.show()

  }
}

