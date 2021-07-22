package com.anotherworld.swordsandmagic

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.OnProgressListener
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_email_password.*
import kotlinx.android.synthetic.main.fragment_first.*

class Preview : AppCompatActivity() {
    val getterANDSetter: GetterANDSetter = GetterANDSetter()
    val createFiles: CreateFiles = CreateFiles()
    var sec: Int = 1
    lateinit var storageReference: StorageReference
    var sP: String = ""
    private var filePath: Uri? = null
    private val PICK_IMAGE_REQUEST = 70
    private lateinit var confirm: Button
    private lateinit var preview_img: ImageView
    var storage: FirebaseStorage = FirebaseStorage.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        supportActionBar?.hide()
        confirm = findViewById(R.id.confirm)
        preview_img = findViewById(R.id.preview_avatar)
        storageReference = storage.reference;
        chooseImage()
        confirm.setOnClickListener {
            uploadImage()
            startActivity(Intent(this@Preview,MainActivity::class.java))
        }
    }
    private fun chooseImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === PICK_IMAGE_REQUEST && resultCode === RESULT_OK && android.R.attr.data != null) {
            filePath = data?.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                preview_img.setImageBitmap(bitmap)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    fun uploadImage() {
        if (filePath != null) {
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Uploading...")
            progressDialog.show()
            val ref = storageReference.child("images/" + FirebaseAuth.getInstance().currentUser!!.email.toString())
            val urlTask = ref.putFile(filePath!!).continueWithTask { task ->
                if (!task.isSuccessful) {
                    task.exception?.let {
                        throw it
                    }
                }
                ref.downloadUrl
            }.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val downloadUri = task.result
                    sP = downloadUri.toString().replace(downloadUri.toString().substringAfterLast("token="),"<UNGUESSABLE_UUID>")
                    getterANDSetter.setImage(sP)
                } else {

                }
            }
            ref.putFile(filePath!!).addOnSuccessListener {
                progressDialog.dismiss()
            }
                .addOnFailureListener { e ->
                    progressDialog.dismiss()
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
}