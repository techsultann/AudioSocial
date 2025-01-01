package com.example.audiosocial.manager

import android.content.Context
import android.media.AudioRecord
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Build
import android.util.Log
import java.io.IOException

private const val LOG_TAG = "AudioRecordTest"
private const val REQUEST_RECORD_AUDIO_PERMISSION = 200

class AudioRecorderManager(
    private val context: Context
){

    private var fileName: String = ""
    private var player: MediaPlayer? = null
    private var recorder: MediaRecorder? = null

    private fun onRecord(start: Boolean) = if (start) {
        startRecording()
    } else {
        stopRecording()
    }

    private fun onPlay(start: Boolean) = if (start) {
        startPlaying()
    } else {
        stopPlaying()
    }

    private fun startPlaying() {
        player = MediaPlayer().apply {
            try {
                setDataSource(fileName)
                prepare()
                start()
            } catch (e: IOException) {
                Log.e(LOG_TAG, "prepare() failed")
            }
        }
    }

    private fun stopPlaying() {
        player?.release()
        player = null
    }

    private fun startRecording() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            recorder = MediaRecorder(context).apply {
                setAudioSource(MediaRecorder.AudioSource.MIC)
                setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
                setOutputFile(fileName)
                setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
                setMaxDuration(30000)

                try {
                    prepare()
                } catch (e: IOException) {
                    Log.e(LOG_TAG, "prepare() failed")
                }

                start()
            }
        }
    }

    private fun stopRecording() {
        recorder?.apply {
            stop()
            release()
        }
        recorder = null
    }

    private fun pauseRecording() {
        recorder?.apply {
            pause()
            release()
        }
        recorder = null
    }
}