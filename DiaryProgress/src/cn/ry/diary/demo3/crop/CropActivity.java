package cn.ry.diary.demo3.crop;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import cn.ry.diary.R;

public class CropActivity extends Activity {
	public static final int PHOTO_PICKED = 01;
	public static final int SELECT_PICKED = 02;
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

	
	private Uri getTempUri() {
		return Uri.fromFile(getTempFile());
	}

	private File getTempFile() {
		if (isSDCARDMounted()) {
			File f = new File(Environment.getExternalStorageDirectory(),
					"crop001.png");
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				Toast.makeText(this, "no input", Toast.LENGTH_LONG)
						.show();
			}
			return f;
		} else {
			return null;
		}
	}

	private boolean isSDCARDMounted() {
		String status = Environment.getExternalStorageState();
		if (status.equals(Environment.MEDIA_MOUNTED))
			return true;
		return false;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case SELECT_PICKED:
			try {
				// Launch picker to choose photo for selected contact
				Intent intent = new Intent("com.android.camera.action.CROP");
				intent.setType("image/*");
				intent.putExtra("crop", "true");
				intent.putExtra("aspectX", 1);
				intent.putExtra("aspectY", 1);
				intent.putExtra("outputX", 500);
				intent.putExtra("outputY", 500);
				intent.putExtra("scale", true);
				intent.putExtra("return-data", false);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, getTempUri());
				intent.putExtra("outputFormat",
						Bitmap.CompressFormat.JPEG.toString());
				startActivityForResult(intent, PHOTO_PICKED);
			} catch (ActivityNotFoundException e) {
				Toast.makeText(this, "no crop", Toast.LENGTH_LONG).show();
			}
			break;
		case PHOTO_PICKED:
			if (resultCode == RESULT_OK) {
				if (data == null) {
					Toast t = Toast.makeText(this, "data == null",
							Toast.LENGTH_SHORT);
					t.show();
					return;
				}

				final Bundle extras = data.getExtras();
				if (extras != null) {
					File tempFile = getTempFile();
					// new logic to get the photo from a URI
					if (data.getAction() != null) {
						Bitmap bitmap = BitmapFactory.decodeFile(getTempFile().getAbsolutePath());
						imageView.setImageBitmap(bitmap);
					}
				}
			}
			break;
		}
	}
}
