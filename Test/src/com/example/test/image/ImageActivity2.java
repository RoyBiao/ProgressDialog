package com.example.test.image;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.example.R;

public class ImageActivity2 extends Activity {
	/**
	 * 显示图片的ImageView.
	 */
	private ImageView mImageView;
	/**
	 * 打开本地相册的requestcode.
	 */
	public static final int OPEN_PHOTO_REQUESTCODE = 0x1;
	/** 
     * 图片的target大小. 
     */  
    private static final int target = 400;  
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image2);

		mImageView = (ImageView) this.findViewById(R.id.imageView);

	}

	public void showImage(View view) {
		Intent intent = new Intent(Intent.ACTION_PICK, null);
		intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
				"image/*");

		startActivityForResult(intent, OPEN_PHOTO_REQUESTCODE);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case OPEN_PHOTO_REQUESTCODE:
//			Bitmap bm = ImageCacheUtil.getResizedBitmap( ImageActivity2.this,null, null,   
//                    data.getData(), target, false); 
			Bitmap bm = ImageCacheUtil.decode(ImageActivity2.this,null, null, data.getData(), null);   
//			Bitmap bm2 = ImageUtil.getImageWithSizeLimit(bm, 100, 100);
			mImageView.setImageBitmap(bm);
			break;
		default:
			break;
		}
		
		super.onActivityResult(requestCode, resultCode, data);
	}
}
