package org.brokenopenapp.acratest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.webkit.WebView;

import org.acra.ACRA;

/**
 */
public class WebViewActivity extends ActionBarActivity {





	WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview);

		webView = (WebView)findViewById(R.id.webview);

		String html = "<html>\n" +
				"  <body>\n" +
				"    <script type=\"text/javascript\">\n" +
				"      window.onerror = function(message, url, lineNumber) {\n" +
				"        ACRA.reportError(message,url,lineNumber);\n" +
				"        return false;\n" +
				"      };\n" +
				"    </script>\n" +
				"    <a onclick=\"doesnotexist.call(); return false;\">Crash me now!</a>\n" +
				"  </body>\n" +
				"</html>";
		String mime = "text/html";
		String encoding = "utf-8";

		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadDataWithBaseURL(null, html, mime, encoding, null);

		webView.addJavascriptInterface(new WebViewInterface(), "ACRA");

	}


	public class WebViewInterface  {

		@android.webkit.JavascriptInterface
		public void reportError(String message, String url, Integer lineNumber) {
			ACRA.getErrorReporter().handleException(new RuntimeException(
					"Javascript Error" + message + " in " + url + " on line " + lineNumber
			));
		}

	}

}
