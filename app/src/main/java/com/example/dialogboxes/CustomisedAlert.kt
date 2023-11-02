package com.example.dialogboxes

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dialogboxes.databinding.ActivityCustomisedAlertBinding
import com.example.dialogboxes.databinding.CustomAlertBinding

//Separate activity is created for customised alert, so as to keep the code for it clean

class CustomisedAlert : AppCompatActivity() {
    private lateinit var dialog : Dialog
    private lateinit var binding: ActivityCustomisedAlertBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomisedAlertBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dialogBinding = CustomAlertBinding.inflate(layoutInflater)
        dialog = Dialog(this)
        dialog.setContentView(dialogBinding.root)
        dialog.window?.setBackgroundDrawableResource(R.drawable.customalert_bg)

        dialogBinding.btnContact.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:8368941438")
            startActivity(intent)
        }
        dialogBinding.btnDecline.setOnClickListener {
            dialog.dismiss()
        }
        binding.btnClick.setOnClickListener {
            dialog.show()
        }

    }
}