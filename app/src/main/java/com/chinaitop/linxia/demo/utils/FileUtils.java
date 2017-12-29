package com.chinaitop.linxia.demo.utils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;


import com.chinaitop.linxia.demo.MyApplication;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {

    public static final String SDPATH = Environment.getExternalStorageDirectory()
            + "/hplk/";

    public static String saveBitmap(Bitmap bm, String picName) {
        Log.i("TAG", "保存图片");
        try {
            if (!isFileExist("")) {
                File tempf = createSDDir("");
            }
            File f = new File(SDPATH, picName + ".jpeg");
            if (f.exists()) {
                f.delete();
            }
            FileOutputStream out = new FileOutputStream(f);
            bm.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
            Log.i("TAG", "已经保存");
            return SDPATH + picName + ".jpeg";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void saveImage(String filePath, String picName) {
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
        saveImage(bitmap, picName);
    }

    public static void saveImage(Bitmap bitmap, String picName) {
        File dir = null;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            dir = new File(SDPATH);
        } else {
            dir = new File(Environment.getDataDirectory().getPath()
                    + "/hplk/");
        }
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir, picName + ".png");
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, bos);     //用.JPEG压缩速度比较快......
            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (file.exists()) {
            ToastUtils.showShort(file.getParent() + "文件夹");
        }

        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);  //刷新图库
        Uri uri = Uri.fromFile(file);
        intent.setData(uri);
        MyApplication.instance.sendBroadcast(intent);
    }
    public static File createSDDir(String dirName) throws IOException {
        File dir = new File(SDPATH + dirName);
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {

            System.out.println("createSDDir:" + dir.getAbsolutePath());
            System.out.println("createSDDir:" + dir.mkdir());
        }
        return dir;
    }

    public static boolean isFileExist(String fileName) {
        File file = new File(SDPATH + fileName);
        file.isFile();
        return file.exists();
    }

    public static void delFile(String fileName) {
        File file = new File(SDPATH + fileName);
        if (file.isFile()) {
            file.delete();
        }
        file.exists();
    }

    public static void deleteDir(String path) {
        if (TextUtils.isEmpty(path)){
            return;
        }
        File dir = new File(path);
        if (!dir.exists() || !dir.isDirectory())
            return;

        for (File file : dir.listFiles()) {
            if (file.isFile())
                file.delete(); // 删除所有文件
            else if (file.isDirectory())
                deleteDir(path); // 递规的方式删除文件夹
        }
        dir.delete();// 删除目录本身
    }

    public static boolean fileIsExists(String path) {
        try {
            File f = new File(path);
            if (!f.exists()) {
                return false;
            }
        } catch (Exception e) {

            return false;
        }
        return true;
    }

}

