package cn.ry.diary.demo3.crop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import cn.ry.diary.R;

public class CropActivity2 extends Activity {
	// String path =
	// Environment.getExternalStorageDirectory().getPath()+"/temp.jpg";
	private static final String IMAGE_FILE_LOCATION = "file:///sdcard/temp.jpg";// temp
	Uri imageUri = Uri.parse(IMAGE_FILE_LOCATION);// The Uri to store the big
	
	private String TAG = "CropActivity2";

	public static final int PHOTO_PICKED = 01;
	public static final int SELECT_PICKED = 02;
	public static final int TAKE_PICKED = 03;
	private ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crop);
		imageView = (ImageView) this.findViewById(R.id.imageView);
	}

	public void cropClick(View view) {
		Intent pickIntent = new Intent(Intent.ACTION_PICK, null);
		pickIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
				"image/*");
		startActivityForResult(pickIntent, SELECT_PICKED);
	}

	public void takeClick(View view) {
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// action is
																	// capture
		intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
		startActivityForResult(intent, TAKE_PICKED);// or TAKE_SMALL_PICTURE
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case SELECT_PICKED:
//			Uri uri = data.getData();
//			String[] proj = { MediaStore.Images.Media.DATA };
//			Cursor actualimagecursor = managedQuery(uri,proj,null,null,null);
//			int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//			actualimagecursor.moveToFirst();
//			String img_path = actualimagecursor.getString(actual_image_column_index);
//			File file = new File(img_path);
//			File copy = new File(IMAGE_FILE_LOCATION);
//			fileChannelCopy(file, copy);
//			imageUri = Uri.fromFile(copy);
			imageUri = data.getData();
			cropImageUri(data.getData(), 800, 800, PHOTO_PICKED);
			break;

		case TAKE_PICKED:
			imageUri = Uri.parse(IMAGE_FILE_LOCATION);
			cropImageUri(imageUri, 800, 800, PHOTO_PICKED);
			break;

		case PHOTO_PICKED:// from crop_big_picture
			Log.d(TAG, "CROP_BIG_PICTURE: data = " + data);// it seems to be
															// null
			if (imageUri != null) {
				Bitmap bitmap = decodeUriAsBitmap(imageUri);
				imageView.setImageBitmap(bitmap);
			}
			break;
		default:
			break;
		}
	}

	private void cropImageUri(Uri uri, int outputX, int outputY, int requestCode) {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		intent.putExtra("crop", "true");
		intent.putExtra("aspectX", outputX);
		intent.putExtra("aspectY", outputY);
		intent.putExtra("outputX", outputX);
		intent.putExtra("outputY", outputY);
		intent.putExtra("scale", true);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
		intent.putExtra("return-data", false);
		intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
		intent.putExtra("noFaceDetection", true); // no face detection
		startActivityForResult(intent, requestCode);
	}

	private Bitmap decodeUriAsBitmap(Uri uri) {
		Bitmap bitmap = null;
		try {
			Log.d(TAG, "decodeUriAsBitmap1");
			bitmap = BitmapFactory.decodeStream(getContentResolver()
					.openInputStream(uri));
			Log.d(TAG, "decodeUriAsBitmap2");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Log.d(TAG, "decodeUriAsBitmap3");
			return null;
		}
		return bitmap;
	}
	/**
	 * 使用文件通道的方式复制文件
	 * @param s
	 *            源文件
	 * @param t
	 *            复制到的新文件
	 */

	public static void fileChannelCopy(File s, File t) {

		FileInputStream fi = null;
		FileOutputStream fo = null;
		FileChannel in = null;
		FileChannel out = null;

		try {

			fi = new FileInputStream(s);
			fo = new FileOutputStream(t);
			in = fi.getChannel();// 得到对应的文件通道
			out = fo.getChannel();// 得到对应的文件通道
			in.transferTo(0, in.size(), out);// 连接两个通道，并且从in通道读取，然后写入out通道
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fi != null) {
					fi.close();
				}
				if (in != null) {
					in.close();
				}
				if (fo != null) {
					fo.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
