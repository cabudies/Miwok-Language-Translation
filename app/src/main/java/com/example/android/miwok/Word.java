package com.example.android.miwok;

/**
 * Created by gurjas on 30-05-2017.
 */

public class Word {

    public String mDefaultTranslation;
    public String mMiwokTranslation;
    private int imageResourceID;
    private int audioResourceID;

    public Word(String defaultTranslation, String miwokTranslation)
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageID, int musicID)
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        imageResourceID = imageID;
        audioResourceID = musicID;
    }

    public Word(String defaultTranslation, String miwokTranslation, int musicID)
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        audioResourceID = musicID;
    }

    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation()
    {
        return mMiwokTranslation;
    }

    public int getImageResourceID(){ return imageResourceID; }

    public int getAudioResourceID()
    {
        return audioResourceID;
    }
}
