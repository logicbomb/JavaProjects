import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PageLoad extends WebViewClient {


    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }
}
