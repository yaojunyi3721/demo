package com.chinaitop.linxia.demo.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 压缩图片
 *
 * @author Administrator
 */
public class Bimp {
    public static int max = 0;
    public static boolean act_bool = true;
    public static List<Bitmap> bmp = new ArrayList<Bitmap>();

    // 图片sd地址 上传服务器时把图片调用下面方法压缩后 保存到临时文件夹 图片压缩后小于100KB，失真度不明显
    public static List<String> drr = new ArrayList<String>();

    // TelephonyManager tm = (TelephonyManager) this
    // .getSystemService(Context.TELEPHONY_SERVICE);

    public static Bitmap revitionImageSize(String path) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(
                new File(path)));

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        // Bitmap btBitmap=BitmapFactory.decodeFile(path);
        // System.out.println("原尺寸高度："+btBitmap.getHeight());
        // System.out.println("原尺寸宽度："+btBitmap.getWidth());
        BitmapFactory.decodeStream(in, null, options);
        in.close();
        int i = 0;
        Bitmap bitmap = null;
        while (true) {
            if ((options.outWidth >> i <= 800)
                    && (options.outHeight >> i <= 800)) {
                in = new BufferedInputStream(
                        new FileInputStream(new File(path)));
                options.inSampleSize = (int) Math.pow(2.0D, i);
                options.inJustDecodeBounds = false;
                bitmap = BitmapFactory.decodeStream(in, null, options);
                break;
            }
            i += 1;
        }
        // 当机型为三星时图片翻转
//		bitmap = Photo.photoAdapter(path, bitmap);
//		System.out.println("-----压缩后尺寸高度：" + bitmap.getHeight());
//		System.out.println("-----压缩后尺寸宽度度：" + bitmap.getWidth());
        return bitmap;
    }

    public static Bitmap getLoacalBitmap(String url) {
        try {
            FileInputStream fis = new FileInputStream(url);
            return BitmapFactory.decodeStream(fis); // /把流转化为Bitmap图片
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * @param x              图像的宽度
     * @param y              图像的高度
     * @param image          源图片
     * @param outerRadiusRat 圆角的大小
     * @return 圆角图片
     */
    public static Bitmap createFramedPhoto(int x, int y, Bitmap image, float outerRadiusRat) {
        // 根据源文件新建一个darwable对象
        Drawable imageDrawable = new BitmapDrawable(image);

        // 新建一个新的输出图片
        Bitmap output = Bitmap.createBitmap(x, y, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        // 新建一个矩形
        RectF outerRect = new RectF(0, 0, x, y);

        // 产生一个红色的圆角矩形
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        canvas.drawRoundRect(outerRect, outerRadiusRat, outerRadiusRat, paint);

        // 将源图片绘制到这个圆角矩形上
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        imageDrawable.setBounds(0, 0, x, y);
        canvas.saveLayer(outerRect, paint, Canvas.ALL_SAVE_FLAG);
        imageDrawable.draw(canvas);
        canvas.restore();

        return output;
    }

    public static Bitmap getimage(String pathName) {
        String srcPath = new File(pathName).getPath();
        Log.i("TAG", "compressImage: "+pathName+"------file:"+srcPath);
        BitmapFactory.Options newOpts = new BitmapFactory.Options();

//开始读入图片，此时把options.inJustDecodeBounds 设回true了

        newOpts.inJustDecodeBounds = true;

        Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOpts);//此时返回bm为空

        newOpts.inJustDecodeBounds = false;

        int w = newOpts.outWidth;

        int h = newOpts.outHeight;

//现在主流手机比较多是800*480分辨率，所以高和宽我们设置为

        float hh = 800f;//这里设置高度为800f

        float ww = 480f;//这里设置宽度为480f

//缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可

        int be = 1;//be=1表示不缩放

        if (w > h && w > ww) {//如果宽度大的话根据宽度固定大小缩放

            be = (int) (newOpts.outWidth / ww);

        } else if (w < h && h > hh) {//如果高度高的话根据宽度固定大小缩放

            be = (int) (newOpts.outHeight / hh);

        }

        if (be <= 0)

            be = 1;

        newOpts.inSampleSize = be;//设置缩放比例

//重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了

        bitmap = BitmapFactory.decodeFile(srcPath, newOpts);

        return compressImage(bitmap);//压缩好比例大小后再进行质量压缩
    }

    public static Bitmap comp(Bitmap image) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);

        if (baos.toByteArray().length / 1024 > 1024) {//判断如果图片大于1M,进行压缩避免在生成图片（BitmapFactory.decodeStream）时溢出

            baos.reset();//重置baos即清空baos

            image.compress(Bitmap.CompressFormat.JPEG, 50, baos);//这里压缩50%，把压缩后的数据存放到baos中

        }

        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());

        BitmapFactory.Options newOpts = new BitmapFactory.Options();

//开始读入图片，此时把options.inJustDecodeBounds 设回true了

        newOpts.inJustDecodeBounds = true;

        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);

        newOpts.inJustDecodeBounds = false;

        int w = newOpts.outWidth;

        int h = newOpts.outHeight;

//现在主流手机比较多是800*480分辨率，所以高和宽我们设置为

        float hh = 800f;//这里设置高度为800f

        float ww = 480f;//这里设置宽度为480f

//缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可

        int be = 1;//be=1表示不缩放

        if (w > h && w > ww) {//如果宽度大的话根据宽度固定大小缩放

            be = (int) (newOpts.outWidth / ww);

        } else if (w < h && h > hh) {//如果高度高的话根据宽度固定大小缩放

            be = (int) (newOpts.outHeight / hh);

        }

        if (be <= 0)

            be = 1;

        newOpts.inSampleSize = be;//设置缩放比例

        newOpts.inPreferredConfig = Bitmap.Config.RGB_565;//降低图片从ARGB888到RGB565

//重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了

        isBm = new ByteArrayInputStream(baos.toByteArray());

        bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);

        return compressImage(bitmap);//压缩好比例大小后再进行质量压缩
    }

    public static Bitmap compressImage(Bitmap image) {
        if (image != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中

            int options = 100;

            while (baos.toByteArray().length / 1024 > 100) {//循环判断如果压缩后图片是否大于100kb,大于继续压缩

                baos.reset();//重置baos即清空baos

                options -= 10;//每次都减少10

                image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中

            }

            ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中

            Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
            Log.i("TAG", "compressImage: 压缩成功");
            return bitmap;
        }
        Log.i("TAG", "compressImage: 压缩失败");
        return null;
    }

    public static Bitmap compressImage(String pathName) {
        String path = new File(pathName).getPath();
        Bitmap image = BitmapFactory.decodeFile(path);
        Log.i("TAG", "compressImage: "+pathName+"------file:"+path);
        if (image != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中

            int options = 100;

            while (baos.toByteArray().length / 1024 > 100) {//循环判断如果压缩后图片是否大于100kb,大于继续压缩

                baos.reset();//重置baos即清空baos

                options -= 10;//每次都减少10

                image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中

            }

            ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中

            Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片

            Log.i("TAG", "compressImage: 压缩成功");

            return bitmap;

        }
        Log.i("TAG", "compressImage: 压缩失败");
        return null;
    }

}
