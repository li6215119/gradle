package com.dongnaoedu.lsn11

//import android.os.Bundle
//import android.os.Handler
//import android.os.Looper
//import android.util.Log
//import android.view.View
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import java.io.File
//import java.io.InputStream
//
//class MainActivity : AppCompatActivity(), View.OnClickListener {
//
//    private var mOldPath: String? = null
//    private var mNewVersionPath: String? = null
//    private var mPatchPath: String? = null
//    private var mNewPath: String? = null
//
//    private var mHandler: Handler? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        findViewById<View>(R.id.btn1).setOnClickListener(this)
//        findViewById<View>(R.id.btn2).setOnClickListener(this)
//        initAssert()
//        mHandler = Handler(Looper.getMainLooper())
//    }
//
//    private fun initAssert() {
//        val fileDir = filesDir.path + File.separator
//
//        // 拷贝old文件到私有目录
//        mOldPath = fileDir + "hello.txt"
//        val inputStream: InputStream = FileUtil.openAssetInputStream(this, "hello.txt")
//        FileUtil.copyFile(inputStream, mOldPath)
//
//        // 拷贝新版本文件到私有目录
//        mNewVersionPath = fileDir + "hello_v2.txt"
//        val inputStream2: InputStream = FileUtil.openAssetInputStream(this, "hello_v2.txt")
//        FileUtil.copyFile(inputStream2, mNewVersionPath)
//
//        // 差分包的路径
//        mPatchPath = fileDir + "patch"
//
//        // 新合并的文件/包路径
//        mNewPath = fileDir + "hello_new.txt"
//    }
//
//    override fun onClick(v: View?) {
//        when (v?.id) {
//            R.id.btn1 ->
//                if (!FileUtil.isFileExists(mOldPath) || !FileUtil.isFileExists(mNewVersionPath)) {
//                    Toast.makeText(this@MainActivity, "对应文件不存在", Toast.LENGTH_SHORT).show()
//                } else {
//                    Thread() {
//                        val diff = BsdiffUtil.diff(mOldPath, mNewVersionPath, mPatchPath)
//                        val diffMd5 = FileUtil.getFileMD5ToString(mPatchPath)
//                        Log.e("MainActivity", "差分结果：$diff")
//                        Log.e("MainActivity", "差分md5：$diffMd5")
//                        mHandler!!.post {
//                            if (diff == 0) {
//                                Toast.makeText(this@MainActivity, "生成差分包成功", Toast.LENGTH_SHORT)
//                                    .show()
//                            } else {
//                                Toast.makeText(
//                                    this@MainActivity,
//                                    "生成差分包失败:$diff",
//                                    Toast.LENGTH_SHORT
//                                ).show()
//                            }
//                        }
//                    }.start()
//                }
//            R.id.btn2 ->
//                if (!FileUtil.isFileExists(mOldPath) || !FileUtil.isFileExists(mPatchPath)) {
//                    Toast.makeText(this@MainActivity, "对应文件不存在", Toast.LENGTH_SHORT).show()
//                } else {
//                    Thread() {
//                        val result = BsdiffUtil.patch(mOldPath, mPatchPath, mNewPath)
//                        Log.e("MainActivity", "合并结果：$result")
//                        mHandler!!.post {
//                            if (result == 0) {
//                                Toast.makeText(this@MainActivity, "合并成功", Toast.LENGTH_SHORT).show()
//                            } else {
//                                Toast.makeText(
//                                    this@MainActivity,
//                                    "合并失败:$result",
//                                    Toast.LENGTH_SHORT
//                                ).show()
//                            }
//                        }
//                    }.start()
//                }
//        }
//    }
//}