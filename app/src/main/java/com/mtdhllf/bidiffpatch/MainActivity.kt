package com.mtdhllf.bidiffpatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.Toast
import com.mtdhllf.tools.bidiffpatch.BinaryTool
import java.io.File

/**
 * 测试demo
 */
class MainActivity : AppCompatActivity() {

    //旧版本路径
    private var old = getSdPath() + "hello.apk"
    //新版本
    private var newp = getSdPath() + "hehehe.apk"
    //差分包
    private var patch = getSdPath() + "patch.patch"
    //旧版apk和差分包合并生成的新版apk
    private var tmp = getSdPath() + "new.apk"

    init {
        System.loadLibrary("bsdiff-lib")
    }

    fun click(view: View) {
        when (view.id) {
            R.id.bt_diff -> {
                val s = System.currentTimeMillis()
                BinaryTool.diff(old, newp, patch)
                val s1 = System.currentTimeMillis()
                Toast.makeText(this, "diff success" + (s1 - s), Toast.LENGTH_SHORT).show()
                Log.e("diff","diff success "+(s1 - s))
            }
            R.id.bt_patch -> {
                val s2 = System.currentTimeMillis()
                BinaryTool.patch(old, tmp, patch)
                val s3 = System.currentTimeMillis()
                Toast.makeText(this, "patch success" + (s3 - s2), Toast.LENGTH_SHORT).show()
                Log.e("patch","patch success "+(s3 - s2))

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun getSdPath(): String {
        return Environment.getExternalStorageDirectory().path + File.separator
    }

}
