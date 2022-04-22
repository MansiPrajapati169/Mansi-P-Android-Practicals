package com.example.practicals.android_permission_model

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.practicals.R
import com.example.practicals.databinding.ActivityPermissionBinding
import com.example.practicals.utils.Constants


class PermissionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPermissionBinding
    private lateinit var resultLauncher : ActivityResultLauncher<Intent>
    private lateinit var picture: ActivityResultLauncher<Intent>
    private lateinit var cameraLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
    }

    private fun setData() {

        picture = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            result.data?.let {
                val image = it.data
                binding.ivImage.setImageURI(image)
            }
        }

        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val path = data?.data
                binding.tvPath.text = path?.path.toString()
            }
        }

        cameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val currentIntent = result.data
                val bitmap = currentIntent?.extras?.get(getString(R.string.txt_data)) as Bitmap
                binding.ivImage.setImageBitmap(bitmap)
            }
        }

        binding.btnGallery.setOnClickListener {
            if(setupPermissions(Manifest.permission.READ_EXTERNAL_STORAGE,Constants.ONE)) {
               setIntent(Constants.IMAGE_INTENT_TYPE,Intent.ACTION_PICK,picture)
            }
        }

        binding.btnPickFile.setOnClickListener {
            if (setupPermissions(Manifest.permission.READ_EXTERNAL_STORAGE,Constants.ZERO)) {
                setIntent(Constants.PDF_INTENT_TYPE,Intent.ACTION_GET_CONTENT,resultLauncher)
            }
        }

        binding.btnCamera.setOnClickListener {
            if (setupPermissions(Manifest.permission.CAMERA,Constants.TWO)) {
                setIntent(null,MediaStore.ACTION_IMAGE_CAPTURE,cameraLauncher)
            }
        }
    }

    private fun setupPermissions(permission: String,requestCode: Int) : Boolean {
        val permissions = ContextCompat.checkSelfPermission(this,
            permission)

        return if (permissions != PackageManager.PERMISSION_GRANTED) {
            makeRequest(permission,requestCode)
            false
        }
        else {
            true
        }
    }

    private fun makeRequest(permission: String, requestCode: Int) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
    }

    private fun setIntent(type: String? = null,intentName: String,launcher: ActivityResultLauncher<Intent>) {
        val intent = Intent(intentName)

        if(type != null) {
            intent.type = type
        }
        launcher.launch(intent)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                Toast.makeText(this, permissions[0] +" "+ getString(R.string.txt_denied),Toast.LENGTH_SHORT).show()
            }
            else {
                val builder = AlertDialog.Builder(this)
                builder.apply {
                    setTitle(getString(R.string.txt_setting))
                    setMessage(getString(R.string.txt_alert_message))
                    setIcon(android.R.drawable.ic_dialog_alert)
                    setPositiveButton(getString(R.string.txt_setting)) { _, _ ->
                        val dialogIntent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                        val uri: Uri = Uri.fromParts(getString(R.string.txt_package), packageName, null)
                        dialogIntent.data = uri
                        startActivity(dialogIntent)
                    }
                }
                val alertDialog: AlertDialog = builder.create()
                alertDialog.setCancelable(false)
                alertDialog.show()
            }
        }
        else {
            when (requestCode) {
                Constants.ZERO -> {
                        if (permissions[0] == Manifest.permission.READ_EXTERNAL_STORAGE) {
                            setIntent(Constants.PDF_INTENT_TYPE,Intent.ACTION_GET_CONTENT,resultLauncher)
                        }
                }
                Constants.ONE -> {
                        if (permissions[0] == Manifest.permission.READ_EXTERNAL_STORAGE) {
                            setIntent(Constants.IMAGE_INTENT_TYPE,Intent.ACTION_PICK,picture)
                        }
                }
                Constants.TWO-> {
                        if (permissions[0] == Manifest.permission.CAMERA) {
                            setIntent(null,MediaStore.ACTION_IMAGE_CAPTURE,cameraLauncher)
                        }
                }
            }
        }
    }
}