package com.example.android.miwok;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.content.Context.AUDIO_SERVICE;

public class FamilyActivity extends Fragment {

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
        setContentView(R.layout.activity_family);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        final ArrayList<Word> familyMembers = new ArrayList<Word>();
        familyMembers.add(new Word("father", "әpә", R.drawable.family_father, R.raw.family_father));
        familyMembers.add(new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        familyMembers.add(new Word("son", "angsi", R.drawable.family_son, R.raw.family_son));
        familyMembers.add(new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        familyMembers.add(new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        familyMembers.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        familyMembers.add(new Word("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        familyMembers.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        familyMembers.add(new Word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        familyMembers.add(new Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter wordAdapter = new WordAdapter(this, familyMembers, R.color.category_family);
        ListView listItemView = (ListView) findViewById(R.id.list_family);
        listItemView.setAdapter(wordAdapter);
        listItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                releaseMediaPlayer();
                Word wordObject = familyMembers.get(position);
                int result = audioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mediaPlayer = MediaPlayer.create(FamilyActivity.this, wordObject.getAudioResourceID());
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
        return inflater.inflate(R.layout.activity_family, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        audioManager = (AudioManager) getActivity().getSystemService(AUDIO_SERVICE);

        //Create array variable to store the numbers in string
        final ArrayList<Word> familyMembers = new ArrayList<Word>();
        familyMembers.add(new Word("father", "әpә", R.drawable.family_father, R.raw.family_father));
        familyMembers.add(new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        familyMembers.add(new Word("son", "angsi", R.drawable.family_son, R.raw.family_son));
        familyMembers.add(new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        familyMembers.add(new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        familyMembers.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        familyMembers.add(new Word("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        familyMembers.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        familyMembers.add(new Word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        familyMembers.add(new Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter wordAdapter = new WordAdapter(getActivity(), familyMembers, R.color.category_family);
        ListView listItemView = (ListView) getView().findViewById(R.id.list_family);
        listItemView.setAdapter(wordAdapter);
        listItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                releaseMediaPlayer();
                Word wordObject = familyMembers.get(position);
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
