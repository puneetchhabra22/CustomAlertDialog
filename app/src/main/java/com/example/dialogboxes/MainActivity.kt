package com.example.dialogboxes

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AlertDialog
import com.example.dialogboxes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnExit.setOnClickListener {
            val builderExit = AlertDialog.Builder(this)
            builderExit.setTitle("Are you sure?")
            builderExit.setMessage("You want to close the app!")
            builderExit.setIcon(R.drawable.exit_icon)
            builderExit.setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i ->
                //Exit the app and other
                finish()
            })
            builderExit.setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builderExit.show()
        }

        binding.btnGender.setOnClickListener {
            val genderArray = arrayOf("Female", "Male")
            val builderGender = AlertDialog.Builder(this)
            builderGender.setTitle("Choose your gender")
            builderGender.setSingleChoiceItems(genderArray,0,DialogInterface.OnClickListener { dialogInterface, i ->
                //No action
            })
            builderGender.setPositiveButton("Done",DialogInterface.OnClickListener { dialogInterface, i ->  })
            builderGender.show()
        }

        binding.btnInterests.setOnClickListener {
            val interestsArray = arrayOf("Productivity","Lifestyle","Motivation","Health","Entertaintment")
            val builderInterests = AlertDialog.Builder(this)
            builderInterests.setTitle("Choose the topics of your interests")
            builderInterests.setMultiChoiceItems(interestsArray,null,DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, isSelected ->
                //Show toast
                if(isSelected){
                    Toast.makeText(this,"${interestsArray[i]}, Nice choice.",Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this,"${interestsArray[i]}, can be a good option.",Toast.LENGTH_SHORT).show()
                }
            })
            builderInterests.setPositiveButton("Done",DialogInterface.OnClickListener { dialogInterface, i ->
                //No Action
            })
            builderInterests.show()
        }

        binding.btnCustomised.setOnClickListener {
            //this button will take the user to new activity to show customised alert box
            val intent = Intent(this,CustomisedAlert::class.java)
            startActivity(intent)
        }
    }
}