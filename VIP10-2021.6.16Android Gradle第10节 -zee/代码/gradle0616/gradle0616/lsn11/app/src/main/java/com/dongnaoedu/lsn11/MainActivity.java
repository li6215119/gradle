package com.dongnaoedu.lsn11;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bashellwang.libbsdiff.BsdiffUtils;

import java.io.File;
import java.io.InputStream;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String mOldPath;
    private String mNewVersionPath;
    private String mPatchPath;
    private String mNewPath;

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        initAssert();
        mHandler = new Handler(Looper.getMainLooper());

        Test test = new Test();
        test.test();
    }

    private void initAssert() {

        String fileDir = getFilesDir().getPath() + File.separator;

        // 拷贝old文件到私有目录
        mOldPath = fileDir + "old.apk";
        InputStream inputStream = FileUtil.openAssetInputStream(this, "old.apk");
        FileUtil.copyFile(inputStream, mOldPath);

        // 拷贝新版本文件到私有目录
        mNewVersionPath = fileDir + "new.apk";
        InputStream inputStream2 = FileUtil.openAssetInputStream(this, "new.apk");
        FileUtil.copyFile(inputStream2, mNewVersionPath);

        // 差分包的路径
        mPatchPath = fileDir + "patch";

        // 新合并的文件/包路径
        mNewPath = fileDir + "final.apk";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                if (!FileUtil.isFileExists(mOldPath) || !FileUtil.isFileExists(mNewVersionPath)) {
                    Toast.makeText(MainActivity.this, "对应文件不存在", Toast.LENGTH_SHORT).show();
                    return;
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final int diff = BsdiffUtils.diff(mOldPath, mNewVersionPath, mPatchPath);
                        String diffMd5 = FileUtil.getFileMD5ToString(mPatchPath);
                        Log.e("MainActivity", "差分结果：" + diff);
                        Log.e("MainActivity", "差分md5：" + diffMd5);
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (diff == 0) {
                                    Toast.makeText(MainActivity.this, "生成差分包成功", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "生成差分包失败:" + diff, Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }).start();
                break;
            case R.id.btn2:
                if (!FileUtil.isFileExists(mOldPath) || !FileUtil.isFileExists(mPatchPath)) {
                    Toast.makeText(MainActivity.this, "对应文件不存在", Toast.LENGTH_SHORT).show();
                    return;
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final int result = BsdiffUtils.patch(mOldPath, mPatchPath, mNewPath);
                        Log.e("MainActivity", "合并结果：" + result);
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (result == 0) {
                                    Toast.makeText(MainActivity.this, "合并成功", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "合并失败:" + result, Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }).start();
                break;
        }
    }
}