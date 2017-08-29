package com.example.yui.games;

import android.content.Context;
import android.media.MediaPlayer;

public class Audio {
	
	private MediaPlayer mPlayer;
	private String name;
	private boolean mPlaying = false;
	private boolean mLoop = false;

			
			public Audio(Context ctx, int resID){
			// clip name
			name = ctx.getResources().getResourceName(resID);
			
			// Create a media player
			mPlayer = MediaPlayer.create(ctx, resID);
			// Listen for completion events
			mPlayer.setOnCompletionListener(	
					new MediaPlayer.OnCompletionListener() {

						//@Override
						public void onCompletion(MediaPlayer mp) {
							mPlaying = false;
							if (mLoop) {
								mp.start();
							}
						}
					});
			}
		
			public synchronized void play() {
				if (mPlaying)
					return;
				if (mPlayer != null) {
					mPlaying = true;
					mPlayer.start();
				}
			}
		
		
			public synchronized void stop() {
			
				try {
					mLoop = false;
					if (mPlaying) {
						mPlaying = false;
						mPlayer.pause();
					}
				} catch (Exception e) {
					System.err.println("AduioClip::stop " + name + " "+ e.toString());
				}
			}
			
			public synchronized void loop() {			
				mLoop = true;
				mPlaying = true;
				mPlayer.start();
			}
			
			public void release() {
				if (mPlayer != null) {
					mPlayer.release();
					mPlayer = null;
				}
			}
}
