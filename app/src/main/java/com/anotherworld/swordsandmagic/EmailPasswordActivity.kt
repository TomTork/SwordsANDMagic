package com.anotherworld.swordsandmagic

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_email_password.*


class EmailPasswordActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var entrance: Button
    val createFiles: CreateFiles = CreateFiles()
    val getterANDSetter: GetterANDSetter = GetterANDSetter()
    //var bitmap: Bitmap = null

//    override fun onActivityResult(requestCode: Int, resultCode: Int, imageReturnedIntent: Intent?) {
//        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
//        when (requestCode) {
//            GALLERY_REQUEST -> {
//
//            }
//
//        }
//        switch(requestCode) {
//            case GALLERY_REQUEST :
//            if (resultCode == RESULT_OK) {
//                Uri selectedImage = imageReturnedIntent . getData ();
//                try {
//                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                avatar.setImageBitmap(bitmap);
//            }
//        }
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_password)
//        load.setOnClickListener{
//            val photoPickerIntent = Intent(Intent.ACTION_PICK)
//            photoPickerIntent.type = "image/*"
//            startActivityForResult(photoPickerIntent, GALLERY_REQUEST)
//        }

        auth = Firebase.auth
        entrance.setOnClickListener{
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            if (email.text.toString().isNullOrEmpty() || password.text.toString()
                    .isNullOrEmpty())
                    Snackbar.make(View(this@EmailPasswordActivity),"Поля не могут быть пустыми",Snackbar.LENGTH_SHORT)
            else {
                if (!nickname.text.toString().isNullOrEmpty() && !nickname.text.toString().contains(";") && !nickname.text.toString().contains(" ")){
                    auth.createUserWithEmailAndPassword(
                        email.text.toString(),
                        password.text.toString())
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                val user = auth.currentUser
                                updateUI(user)
                                createFiles.create()
                                getterANDSetter.setSign(1)
                                startActivity(Intent(this@EmailPasswordActivity,MainActivity::class.java))
                            } else {
                                Snackbar.make(View(this@EmailPasswordActivity),"Вход/Регистрация провалена",Snackbar.LENGTH_SHORT)
                                updateUI(null)
                            }
                        }
                }
                else Snackbar.make(View(this@EmailPasswordActivity),"Некорректный ввод имени",Snackbar.LENGTH_SHORT)
            }
        }
    }
    private fun updateUI(currentUser: FirebaseUser?) {

    }

}