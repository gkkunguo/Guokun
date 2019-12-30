package com.example.helenkellercompute.guokun.webview;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.example.helenkellercompute.guokun.R;

import java.util.HashMap;
import java.util.Set;

public class MainActivity_Webview extends AppCompatActivity {
    private static final String TAG = "MainActivity_Webview";
    private WebView webView;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__webview);
        webView  = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.addJavascriptInterface(new JavaScriptInterface(this),"android");
        webView.loadUrl("file:///android_asset/Htmltest.html");

        addJavascriptInterfaceTest();
        shouldOverrideUrlLoadingTest();
        onJsPromptTest();

    }


    //Android调用JS代码的方法
    //方法一  通过WebView的loadUrl（）
    public void jsOnclick(View view) {
        webView.post(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl("javascript:callJS()");
            }
        });
    }
    //方法二   通过WebView的evaluateJavascript（）
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void jsOnclickevaluateJavascript(View view){
        webView.evaluateJavascript("javascript:callReturnString()", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                Button button = findViewById(R.id.jsOnclickevaluateJavascript);
                button.setText(value);
            }
        });
    }
    //    对于JS调用Android代码的方法有3种
//    方法一  通过WebView的addJavascriptInterface（）进行对象映射
    //需要在初始化时加入   webView.addJavascriptInterface(new JavaScriptInterface(this),"android");
    private void addJavascriptInterfaceTest(){
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity_Webview.this);
                b.setTitle("Alert");
                b.setMessage(message);
                b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        result.confirm();
                    }
                });
                b.setCancelable(false);
                b.create().show();
                return true;
            }

        });
    }
    public class JavaScriptInterface{
        Context context;
        public JavaScriptInterface(Context c){
            context = c;
        }
        //与js交互时用到的方法
        @JavascriptInterface
        public void showToast(String s){
            Toast.makeText(MainActivity_Webview.this,s,Toast.LENGTH_LONG).show();
        }
    }
    //方法二：通过 WebViewClient 的shouldOverrideUrlLoading ()方法回调拦截 url
    private void shouldOverrideUrlLoadingTest(){
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // 步骤2：根据协议的参数，判断是否是所需要的url
                // 一般根据scheme（协议格式） & authority（协议名）判断（前两个参数）
                //假定传入进来的 url = "js://webview?arg1=111&arg2=222"（同时也是约定好的需要拦截的）
                Uri uri = Uri.parse(url);
                if ( uri.getScheme().equals("js")) {
                    if (uri.getAuthority().equals("webview")) {
                        // 可以在协议上带有参数并传递到Android上
                        HashMap<String, String> params = new HashMap<>();
                        Set<String> collection = uri.getQueryParameterNames();
                        for(String s:collection){
                            Log.i(TAG, "shouldOverrideUrlLoading: "+s);
                        }
                    }
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }
    //方法三：通过 WebChromeClient 的onJsAlert()、onJsConfirm()、onJsPrompt（）方法回调拦截JS对话框alert()、confirm()、prompt（） 消息
    private void onJsPromptTest(){
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                Uri uri = Uri.parse(message);
                if ( uri.getScheme().equals("js")) {
                    if (uri.getAuthority().equals("demo")) {
                        HashMap<String, String> params = new HashMap<>();
                        Set<String> collection = uri.getQueryParameterNames();
                        result.confirm("js调用了Android的方法成功啦");
                    }
                    return true;
                }
                return super.onJsPrompt(view, url, message, defaultValue, result);
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                return super.onJsConfirm(view, url, message, result);
            }
        });
    }
}
