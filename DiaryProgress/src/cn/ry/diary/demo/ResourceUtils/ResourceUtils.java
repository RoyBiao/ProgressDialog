package cn.ry.diary.demo.ResourceUtils;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.TypedValue;
import cn.ry.diary.R;

public class ResourceUtils extends AndroidTestCase {
	private static TypedValue mTmpValue = new TypedValue();

	public static int getXmlDef(Context context, int id) {
		synchronized (mTmpValue) {
			TypedValue value = mTmpValue;
			context.getResources().getValue(id, value, true);
			return (int) TypedValue.complexToFloat(value.data);
		}
	}

	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	public void test() {
		int num = getXmlDef(getContext(), R.dimen.activity_horizontal_margin);
		float num2 = getContext().getResources().getDimension(
				R.dimen.activity_horizontal_margin);
		int num3=px2dip(getContext(),num2);
		System.out.println("num:" + num);
		System.out.println("num2:" + num2);
		System.out.println("num3:" + num3);
	}

}
