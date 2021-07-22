package com.anotherworld.swordsandmagic

import android.R.attr
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.OnProgressListener
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import kotlinx.android.synthetic.main.activity_email_password.*
import java.util.*


class EmailPasswordActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var mAuth: FirebaseAuth
    private lateinit var entrance: Button

    var storage: FirebaseStorage = FirebaseStorage.getInstance()
    lateinit var storageReference: StorageReference
    private var filePath: Uri? = null
    private val PICK_IMAGE_REQUEST = 71


    private var mAuthListener: AuthStateListener? = null
    var s:String = ""
    var number:Int = 0
    var n:Int = 0
    val createFiles: CreateFiles = CreateFiles()
    val getterANDSetter: GetterANDSetter = GetterANDSetter()
    val REQUEST_CODE = 100
    var bitmap : Bitmap? = null

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
//            avatar.setImageURI(data?.data) // handle chosen image
//            Log.d("QQQQQ",(data?.data).toString())
//        }
        if (requestCode === PICK_IMAGE_REQUEST && resultCode === RESULT_OK && attr.data != null) {
            filePath = data?.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                avatar.setImageBitmap(bitmap)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_password)
        storage = FirebaseStorage.getInstance();
        storageReference = storage.reference;
        supportActionBar?.hide()
        mAuth = FirebaseAuth.getInstance()
        entrance = findViewById(R.id.entrance)
        load.setOnClickListener{
            //openGalleryForImage()
            chooseImage()
        }
        createFiles.create()
        number = getterANDSetter.getSign()
        mAuthListener = AuthStateListener { firebaseAuth ->
            val user = firebaseAuth.currentUser
            if (user != null) {
                s = nickname.text.toString()
                if (!s.contains(" ")) getterANDSetter.setName(s)
            }
        }
        entrance.setOnClickListener {
            try {
                s = nickname.text.toString()
                if (!s.contains(" ") && s.isNotEmpty() && !s.contains(";")) getterANDSetter.setName(s)
                signin(email.text.toString(), password.text.toString())
                number = 1
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }
    private fun chooseImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }
    private fun uploadImage() {
        if (filePath != null) {
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Uploading...")
            progressDialog.show()
            val ref = storageReference.child("images/" + FirebaseAuth.getInstance().currentUser!!.email.toString())
            ref.putFile(filePath!!)
                .addOnSuccessListener {
                    progressDialog.dismiss()
                    //makeText(this@EmailPasswordActivity, "Uploaded", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    progressDialog.dismiss()
                    //makeText(this@EmailPasswordActivity, "Failed " + e.message, Toast.LENGTH_SHORT).show()
                }
                .addOnProgressListener(object : OnProgressListener<UploadTask.TaskSnapshot?> {
                    override fun onProgress(taskSnapshot: UploadTask.TaskSnapshot) {
                        val progress = 100.0 * taskSnapshot.bytesTransferred / taskSnapshot
                            .totalByteCount
                        progressDialog.setMessage("Uploaded " + progress.toInt() + "%")
                    }
                })
        }
    }

//    private fun openGalleryForImage() {
//        val intent = Intent(Intent.ACTION_PICK)
//        intent.type = "image/*"
//        startActivityForResult(intent, REQUEST_CODE)
//        //bitmap = (avatar.drawable as BitmapDrawable).bitmap //error
//    }
    fun signin(email: String, password: String) {
        if (!email.contains("@") && !email.contains("."))makeText(applicationContext, "Неправильная почта", Toast.LENGTH_LONG).show()
        else{
            if (password.length<6)makeText(applicationContext, "Пароль от 6 символов", Toast.LENGTH_LONG).show()
            else{
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this,
                    OnCompleteListener<AuthResult?> { task ->
                        if (task.isSuccessful) {
                            n=1
                            val sd = CreateFiles()
                            sd.create()
                            s = nickname.text.toString()

                            if (!s.contains(" ") && s.isNotEmpty() && !s.contains(";")) getterANDSetter.setName(s) else makeText(applicationContext, "Неправильный никнейм", Toast.LENGTH_SHORT).show()
                            number = 1
                            if (!s.contains(" ") && s.isNotEmpty() && !s.contains(";")) {
                                getterANDSetter.setSign(1)
                                uploadImage()
                                startActivity(Intent(this@EmailPasswordActivity,MainActivity::class.java))
                            }
                            else makeText(applicationContext, "Неправильный никнейм", Toast.LENGTH_LONG).show()
                        }
                        else{
                            try {
                                registration(email, password)
                            }catch (e:Exception){
                                e.printStackTrace()
                            }
                            //makeText(applicationContext, "Aвторизация провалена", Toast.LENGTH_SHORT).show()
                        }
                    })
            }
        }

    }
    fun registration(email: String, password: String) { // Метод регистрации, используется Firebase
        if (!email.contains("@") && !email.contains("."))makeText(applicationContext, "Неправильная почта", Toast.LENGTH_LONG).show()
        else{
            if (password.length<6)makeText(applicationContext, "Пароль от 6 символов", Toast.LENGTH_LONG).show()
            else{
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener<AuthResult?> {task->
                    if (task.isSuccessful){
                        val sd = CreateFiles()
                        sd.create()
                        s = nickname.text.toString()
                        if (!s.contains(" ") && s.isNotEmpty() && !s.contains(";")) getterANDSetter.setName(s)
                        else makeText(applicationContext, "Неправильный никнейм", Toast.LENGTH_SHORT).show()
                        number = 1
                        if (!s.contains(" ") && s.isNotEmpty() && !s.contains(";")) {
                            getterANDSetter.setSign(1)
                            uploadImage()
                            startActivity(Intent(this@EmailPasswordActivity, MainActivity::class.java))
                        }
                        else makeText(applicationContext, "Неправильный никнейм", Toast.LENGTH_LONG).show()
                    }
                    else makeText(applicationContext, "Что-то пошло не так...", Toast.LENGTH_LONG).show()
                })
            }
        }
    }
}