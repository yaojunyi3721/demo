package com.chinaitop.linxia.demo.utils;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.os.Build;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class BitmapHelper {
    public BitmapHelper() {
    }

    public static Options calculateInSampleSize(Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            int heightRatio = Math.round((float) height / (float) reqHeight);
            int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        options.inSampleSize = inSampleSize;
        options.inJustDecodeBounds = false;
        return options;
    }

    /**
     * @param bitmap
     * @param maxSize 单位kb
     * @return
     */
    public static Bitmap imageZoom(Bitmap bitmap, double maxSize) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 70, baos);
        byte[] b = baos.toByteArray();
        double mid = (double) (b.length / 1024);
        double i = mid / maxSize;
        if (i > 1.0D) {
            bitmap = scaleWithWH(bitmap, (double) bitmap.getWidth() / Math.sqrt(i), (double) bitmap.getHeight() / Math.sqrt(i));
        }

        return bitmap;
    }

    /**
     * 读取图片的旋转的角度
     *
     * @param path 图片绝对路径
     * @return 图片的旋转角度
     */
    @TargetApi(Build.VERSION_CODES.ECLAIR)
    public static int getBitmapDegree(String path) throws IOException {
        int degree = 0;
        // 从指定路径下读取图片，并获取其EXIF信息
        ExifInterface exifInterface = new ExifInterface(path);
        // 获取图片的旋转信息
        int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_NORMAL);
        switch (orientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                degree = 90;
                break;
            case ExifInterface.ORIENTATION_ROTATE_180:
                degree = 180;
                break;
            case ExifInterface.ORIENTATION_ROTATE_270:
                degree = 270;
                break;
        }
        return degree;
    }

    public static int getExifOrientation(String filepath) {
        int degree = 0;
        ExifInterface exif = null;
        try {
            exif = new ExifInterface(filepath);
        } catch (IOException ex) {
//            FLogUtil.d("tag", "cannot read exif" + ex);
        }
        if (exif != null) {
            int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, -1);
            if (orientation != -1) {
                switch(orientation) {
                    case ExifInterface.ORIENTATION_ROTATE_90:
                        degree = 90;
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_180:
                        degree = 180;
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_270:
                        degree = 270;
                        break;
                }
            }
        }
        return degree;
    }

    /**
     * 旋转图片，使图片保持正确的方向。
     * @param bitmap 原始图片
     * @param degrees 原始图片的角度
     * @return Bitmap 旋转后的图片
     */
    public static Bitmap rotateBitmap(Bitmap bitmap, int degrees) {
        if (degrees == 0 || null == bitmap) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(degrees, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        Bitmap bmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (null != bitmap) {
            bitmap.recycle();
        }
        return bmp;
    }
    public static byte[] compressBitmap(byte[] var0, int var1) {
        boolean var2 = false;
        if (var0 != null && var0.length >= var1) {
            ByteArrayOutputStream var3 = new ByteArrayOutputStream();
            Bitmap var4 = BitmapFactory.decodeByteArray(var0, 0, var0.length);
            int var5 = 1;
            double var6 = 1.0D;
            int compressedSize = 0;
            while (!var2 && var5 <= 10) {
                var6 = Math.pow(0.8D, (double) var5);
                int var8 = (int) (100.0D * var6);
//                FLogUtil.e("BitmapUtils", "quality = " + var8);
                var4.compress(CompressFormat.JPEG, var8, var3);
                compressedSize = var3.toByteArray().length / 1024;
//                FLogUtil.e("BitmapUtils", "WeiXin Thumb Size = " + var3.toByteArray().length / 1024 + " KB");
                if (var3.size() < var1) {
                    var2 = true;
                } else {
                    var3.reset();
                    ++var5;
                }
            }
            byte[] var9 = var3.toByteArray();
            if (!var4.isRecycled()) {
                var4.recycle();
            }
            if (var9 != null && var9.length <= 0) {
//                FLogUtil.e("BitmapUtils", "### 您的原始图片太大,导致缩略图压缩过后还大于" + var1 + "KB,请将分享到微信的图片进行适当缩小.最后文件大小" + compressedSize + "KB");
            }
            return var9;
        }

        return var0;
    }

    public static Bitmap scaleWithWH(Bitmap src, double w, double h) {
        if (w != 0.0D && h != 0.0D && src != null) {
            int width = src.getWidth();
            int height = src.getHeight();
            Matrix matrix = new Matrix();
            float scaleWidth = (float) (w / (double) width);
            float scaleHeight = (float) (h / (double) height);
            matrix.postScale(scaleWidth, scaleHeight);
            return Bitmap.createBitmap(src, 0, 0, width, height, matrix, true);
        } else {
            return src;
        }
    }

    public static Bitmap scaleWithMatrix(Bitmap src, Matrix scaleMatrix) {
        return Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), scaleMatrix, true);
    }

    public static Bitmap scaleWithXY(Bitmap src, float scaleX, float scaleY) {
        Matrix matrix = new Matrix();
        matrix.postScale(scaleX, scaleY);
        return Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matrix, true);
    }

    public static Bitmap scaleWithXY(Bitmap src, float scaleXY) {
        return scaleWithXY(src, scaleXY, scaleXY);
    }

    public static void doRecycledIfNot(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }

    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(
                drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(),
                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                        : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }
}

