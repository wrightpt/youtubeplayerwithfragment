package com.example.c.myapplication;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

import com.google.android.youtube.player.*;
import android.support.v4.app.FragmentManager;

/**
 * Created by Flavien Laurent (flavienlaurent.com) on 23/08/13.
 */
public class YoutubeActivity extends Activity {

    YouTubePlayerFragment youtubeFragment;
    private static final String YOUTUBE_API_KEY = "AIzaSyC1rMU-mkhoyTvBIdTnYU0dss0tU9vtK48";
    private static final String VIDEO_KEY = "gsjtg7m1MMM";
    private YouTubePlayer youtubePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

     //   final View fragmentYoutubeView = inflater.inflate(R.layout.fragment_youtube_empty, container, false);
    //    mYouTubePlayerFragment = new YouTubePlayerSupportFragment();
     //   mYouTubePlayerFragment.initialize(YoutubeConnector.KEY,  this);

        YoutubeFragment fragment = new YoutubeFragment();
       // YoutubeFragment ytfragment = YoutubeFragment.newInstance();
        android.app.FragmentManager manager = getFragmentManager();
       manager.beginTransaction()
               .replace(R.id.youtube_layout, fragment,"hey")
               // .addToBackStack(null)
                .commit();

       // youtubeFragment = (YouTubePlayerFragment)getFragmentManager().findFragmentById(R.id.youtubeplayerfragment);
     //   youtubeFragment.initialize(YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {

        //    @Override public void onInitializationSuccess(YouTubePlayer.Provider provider,
        //                                                  YouTubePlayer player, boolean wasRestored) {
        //        if (!wasRestored) {
        //            youtubePlayer = player;
         //           youtubePlayer.loadVideo(VIDEO_KEY);
         //           youtubePlayer.setShowFullscreenButton(true);
          //      }
         //   }

        //    @Override public void onInitializationFailure(YouTubePlayer.Provider provider,
      //                                                    YouTubeInitializationResult error) {
        //    }
      //  });
       //     final Fragment header = (Fragment) findViewById(R.id.youtubeplayerfragment);
      // final TextView viewHeader = (TextView) findViewById(R.id.header);
        final FrameLayout frameLayout = (FrameLayout)findViewById(R.id.youtube_layout);
        final YoutubeLayout youtubeLayout = (YoutubeLayout) findViewById(R.id.dragLayout);
        final ListView listView = (ListView) findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            //  viewHeader.setText(listView.getAdapter().getItem(i).toString());
                youtubeLayout.setVisibility(View.VISIBLE);
                youtubeLayout.maximize();
            }
        });

        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 50;
            }

            @Override
            public String getItem(int i) {
                return "object" + i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View rView, ViewGroup viewGroup) {
                View view = rView;
                if (view == null) {
                    view = getLayoutInflater().inflate(android.R.layout.simple_list_item_1, viewGroup, false);
                }
                ((TextView) view.findViewById(android.R.id.text1)).setText(getItem(i));
                return view;
            }
        });
    }
}
