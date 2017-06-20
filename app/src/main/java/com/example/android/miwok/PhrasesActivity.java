package com.example.android.miwok;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.UserDictionary;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static android.content.Context.AUDIO_SERVICE;

public class PhrasesActivity extends Fragment {

    /*private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    private String TAG = "Audio Manager";
    private AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener(){
        @Override
        public void onAudioFocusChange(int switchFocus) {
            switch (switchFocus)
            {
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                    Log.d(TAG, "Audio Focus Loss Transient");
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    Log.d(TAG, "Audio Focus Loss Transient Can Duck");
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                    break;
                case AudioManager.AUDIOFOCUS_GAIN:
                    Log.d(TAG, "Audio focus gain");
                    mediaPlayer.start();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:
                    Log.d(TAG, "Audio Focus Loss");
                    releaseMediaPlayer();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        final ArrayList<Word> phrases = new ArrayList<Word>();
        phrases.add(new Word("Where are you going?","minto wuksus", R.raw.phrase_where_are_you_going));
        phrases.add(new Word("What is your name?","tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        phrases.add(new Word("My name is...","oyaaset...", R.raw.phrase_my_name_is));
        phrases.add(new Word("How are you feeling?","michәksәs?", R.raw.phrase_how_are_you_feeling));
        phrases.add(new Word("I’m feeling good.","kuchi achit", R.raw.phrase_im_feeling_good));
        phrases.add(new Word("Are you coming?","әәnәs'aa?", R.raw.phrase_are_you_coming));
        phrases.add(new Word("Yes, I’m coming.","hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        phrases.add(new Word("I’m coming.","әәnәm", R.raw.phrase_im_coming));
        phrases.add(new Word("Let’s go.","yoowutis", R.raw.phrase_lets_go));
        phrases.add(new Word("Come here.","әnni'nem", R.raw.phrase_come_here));

        WordAdapter wordAdapter = new WordAdapter(this, phrases, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list_phrases);
        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                releaseMediaPlayer();
                Word wordObject = phrases.get(position);
                int result = audioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mediaPlayer = MediaPlayer.create(PhrasesActivity.this, wordObject.getAudioResourceID());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            releaseMediaPlayer();
                        }
                    });
                }
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    *//**
     * Clean up the media player by releasing its resources.
     *//*
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;

            audioManager.abandonAudioFocus(afChangeListener);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }*/

    //************************************ For Fragment View  *******************************///

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    private String TAG = "Audio Manager";
    private AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener(){
        @Override
        public void onAudioFocusChange(int switchFocus) {
            switch (switchFocus)
            {
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                    Log.d(TAG, "Audio Focus Loss Transient");
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    Log.d(TAG, "Audio Focus Loss Transient Can Duck");
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                    break;
                case AudioManager.AUDIOFOCUS_GAIN:
                    Log.d(TAG, "Audio focus gain");
                    mediaPlayer.start();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:
                    Log.d(TAG, "Audio Focus Loss");
                    releaseMediaPlayer();
                    break;
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_phrases, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        audioManager = (AudioManager) getActivity().getSystemService(AUDIO_SERVICE);

        //Create array variable to store the numbers in string
        final ArrayList<Word> phrases = new ArrayList<Word>();
        phrases.add(new Word("Where are you going?","minto wuksus", R.raw.phrase_where_are_you_going));
        phrases.add(new Word("What is your name?","tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        phrases.add(new Word("My name is...","oyaaset...", R.raw.phrase_my_name_is));
        phrases.add(new Word("How are you feeling?","michәksәs?", R.raw.phrase_how_are_you_feeling));
        phrases.add(new Word("I’m feeling good.","kuchi achit", R.raw.phrase_im_feeling_good));
        phrases.add(new Word("Are you coming?","әәnәs'aa?", R.raw.phrase_are_you_coming));
        phrases.add(new Word("Yes, I’m coming.","hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        phrases.add(new Word("I’m coming.","әәnәm", R.raw.phrase_im_coming));
        phrases.add(new Word("Let’s go.","yoowutis", R.raw.phrase_lets_go));
        phrases.add(new Word("Come here.","әnni'nem", R.raw.phrase_come_here));

        WordAdapter wordAdapter = new WordAdapter(getActivity(), phrases, R.color.category_phrases);
        ListView listView = (ListView) getView().findViewById(R.id.list_phrases);
        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                releaseMediaPlayer();
                Word wordObject = phrases.get(position);
                int result = audioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mediaPlayer = MediaPlayer.create(getActivity(), wordObject.getAudioResourceID());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            releaseMediaPlayer();
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();

        releaseMediaPlayer();
    }

    /**
     *Clean up the media player by releasing its resources.
     *//**/
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;

            audioManager.abandonAudioFocus(afChangeListener);
        }
    }
}
