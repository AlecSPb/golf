package kr.co.pointn.golfya;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**dc dddd
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    final AppCompatActivity activity = this;

    private ListView newsListView;
    private NewsListAdapter adapter;
    private List<News> newsList;

    private static Context context;
    private static  int networkYn = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        newsListView = findViewById(R.id.mainNewsListView);
        newsList = new ArrayList<News>();
        newsList.add(new News("뉴스입니다","쥬피터","2018-10-10"));
        newsList.add(new News("뉴스입니다","쥬피터","2018-10-10"));
        newsList.add(new News("뉴스입니다","쥬피터","2018-10-10"));
        newsList.add(new News("뉴스입니다","쥬피터","2018-10-10"));
        newsList.add(new News("뉴스입니다","쥬피터","2018-10-10"));

        adapter = new NewsListAdapter(getApplicationContext(), newsList);
        newsListView.setAdapter(adapter);



       // final Button newsButton = (Button) findViewById(R.id.newsButton);
        final Button driverButton = (Button) findViewById(R.id.driverButton);
        final Button woodButton = (Button) findViewById(R.id.woodButton);
        final Button ironButton = (Button) findViewById(R.id.ironButton);
        final Button wedgeButton = (Button) findViewById(R.id.wedgeButton);
        final Button putterButton = (Button) findViewById(R.id.putterButton);

        final LinearLayout main_news = (LinearLayout) findViewById(R.id.main_news) ;

/*
        newsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_news.setVisibility(View.GONE);
                newsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                driverButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                woodButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                ironButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                wedgeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                putterButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new NewsFragment());
                fragmentTransaction.commit();
                
            }
        });
*/

        driverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                main_news.setVisibility(View.GONE);
                //newsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                driverButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                woodButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                ironButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                wedgeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                putterButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));



                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new DriverFragment());
                fragmentTransaction.commit();
                AdsFull.getInstance(getApplicationContext()).setAdsFull();

               //setContentView(R.layout.driver);
            }
        });

        woodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_news.setVisibility(View.GONE);
              //  newsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                driverButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                woodButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                ironButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                wedgeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                putterButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new WoodFragment());
                fragmentTransaction.commit();
                AdsFull.getInstance(getApplicationContext()).setAdsFull();

            }
        });



        ironButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_news.setVisibility(View.GONE);
                //newsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                driverButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                woodButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                ironButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                wedgeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                putterButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new IronFragment());
                fragmentTransaction.commit();
                AdsFull.getInstance(getApplicationContext()).setAdsFull();

            }
        });


        wedgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_news.setVisibility(View.GONE);
              //  newsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                driverButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                woodButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                ironButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                wedgeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                putterButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new WedgeFragment());
                fragmentTransaction.commit();
                AdsFull.getInstance(getApplicationContext()).setAdsFull();

            }
        });

        putterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_news.setVisibility(View.GONE);
               // newsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                driverButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                woodButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                ironButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                wedgeButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                putterButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new PutterFragment());
                fragmentTransaction.commit();
                AdsFull.getInstance(getApplicationContext()).setAdsFull();

            }
        });


        String token = FirebaseInstanceId.getInstance().getToken();
        updateIconBadge(activity,  0);

        AdsFull.getInstance(getApplicationContext()).setAds1(this);
        AdsFull.getInstance(getApplicationContext()).setAds2(this);
        AdsFull.getInstance(getApplicationContext()).setAds3(this);




    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {


        Log.d(TAG, "페이지이동 ");

        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void onBackPressed() {


        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.MyAlertDialogStyle);

        builder.setIcon(R.drawable.golfya_icon);
        builder.setTitle(R.string.app_name);
        builder.setMessage(R.string.exitmsg);
        builder.setPositiveButton(R.string.exitmsgY, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                });
        builder.setNegativeButton(R.string.exitmsgN, null);
        AlertDialog dialog = builder.show();


    }
    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            Online();
            if(networkYn==2){

                NotOnline();
                return true;

            }else {

                Log.d("check URL", url);
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);


            }
        }
    }
    public static String getLauncherClassName(Context context) {
        PackageManager pm = context.getPackageManager();

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> resolveInfos = pm.queryIntentActivities(intent, 0);
        for (ResolveInfo resolveInfo : resolveInfos) {
            String pkgName = resolveInfo.activityInfo.applicationInfo.packageName;
            if (pkgName.equalsIgnoreCase(context.getPackageName())) {
                String className = resolveInfo.activityInfo.name;
                return className;
            }
        }
        return null;
    }

    public static void updateIconBadge(Context context, int notiCnt) {
        Intent badgeIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        badgeIntent.putExtra("badge_count", notiCnt);
        badgeIntent.putExtra("badge_count_package_name", context.getPackageName());
        badgeIntent.putExtra("badge_count_class_name", getLauncherClassName(context));
        context.sendBroadcast(badgeIntent);
    }
    public void NotOnline() {
        final String networkmsg = getString(R.string.networkmsg);

        //mWebView.loadUrl("javascript:alert('"+networkmsg+"')");



        new AlertDialog.Builder(this, R.style.MyAlertDialogStyle)
                .setIcon(R.drawable.golfya_icon)
                .setTitle(R.string.app_name)
                .setMessage(""+networkmsg+"")
                .setNegativeButton(R.string.exitmsgN, null)
                .setPositiveButton(R.string.exitmsgY,new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog,int whichButton)
                    {
                        finish();
                        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
                    }
                }).show();


       // startActivity(new Intent(getApplicationContext(), OfflineActivity.class));


    }

    public void Online() {
        ConnectivityManager manager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobile = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);


        // wifi 또는 모바일 네트워크 어느 하나라도 연결이 되어있다면,
        if (wifi.isConnected() || mobile.isConnected()) {

            Log.d("연결됨" , "연결이 되었습니다.");
            networkYn =1;


        } else {
            Log.d("연결 안 됨" , "연결이 다시 한번 확인해주세요");
            networkYn =2;

        }
    }

}



class LoadMovieTask extends AsyncTask<Void, Void, String> {


    private  Context mContext;
    private DriverMovieListAdapter driveradapter;
    private List<DriverMovie> driverMovieList;
    private ListView driverMovieListView;
    String target;


    public LoadMovieTask(Context context, List<DriverMovie> driverMovieList, ListView view, String target) {
        this.mContext = context;
        this.driverMovieList = driverMovieList;
        this.driverMovieListView = view;
        this.target = target;
    }


    @Override
    protected String doInBackground(Void... voids) {

        try {

            URL url = new URL(target);
            Log.e("주소 url", ""+url);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();

            //Log.e("inputStream", ""+inputStream);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            // Log.e("bufferedReader", ""+bufferedReader);
            String temp;
            StringBuilder stringBuilder = new StringBuilder();

            while ((temp = bufferedReader.readLine()) != null) {
                Log.e("temp", ""+temp);
                stringBuilder.append(temp + "\n");
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return stringBuilder.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
    protected void onPostExecute(String result) {


        Log.e("드라이버2", ""+result);
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = jsonObject.getJSONArray("list");
            int count = 0;
            Log.e("드라이버3", ""+jsonArray.length());

            String thum_pic, subjectText, viewCount, viewDate, viewCnt;


            while (count < jsonArray.length()) {
                JSONObject object = jsonArray.getJSONObject(count);


                thum_pic = object.getString("thumbnails");
                subjectText = object.getString("title");
                viewDate = object.getString("viewDate");
                viewCnt = object.getString("cnt");

                DriverMovie drivermovie = new DriverMovie(thum_pic, subjectText, viewDate, viewCnt);


                Log.e("thum_pic", ""+thum_pic);
                Log.e("subjectText", ""+subjectText);
                Log.e("viewDate", ""+viewDate);
                Log.e("viewCnt", ""+viewCnt);
                Log.e("드라이버4", "" + object);

                // Log.e("드라이버5", "" + driverMovieList);

                // driverMovieList.add(new DriverMovie("11", "비기너골퍼를", "2018", "0"));

                driverMovieList.add(drivermovie);


                count++;
            }

            Log.d("driverMovieListView2 ", ""+driverMovieListView);
            driveradapter = new DriverMovieListAdapter(mContext.getApplicationContext(), driverMovieList);
            driverMovieListView.setAdapter(driveradapter);


            Log.d("driverMovieList7", ""+driverMovieList);


        } catch (Exception e) {
            //e.printStackTrace();
            Log.e("Buffer Error", "Error converting result " + e.toString());

        }

    }


}
