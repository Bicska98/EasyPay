package com.example.easypay

import android.content.Intent
import android.nfc.NdefMessage
import android.nfc.NdefRecord
import android.nfc.NdefRecord.TNF_ABSOLUTE_URI
import android.nfc.NfcAdapter
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.nio.charset.Charset

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun onNewIntent(intent: Intent,view: android.view.View,savedInstanceState: Bundle?) {
        val nfca=NfcAdapter.getDefaultAdapter(this)
        val textv = view.findViewById<TextView>(R.id.textvalue)
        super.onNewIntent(intent)
        super.onResume()
        super.onCreate(savedInstanceState)
        val nfcactive = NfcAdapter.ACTION_PREFERRED_PAYMENT_CHANGED == intent.action
        if (nfcactive) {
            intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)?.also { rawMessages ->
                val options = Bundle();
                // Work around for some broken Nfc firmware implementations that poll the card too fast
                options.putInt(NfcAdapter.EXTRA_READER_PRESENCE_CHECK_DELAY, 250);

                // Enable ReaderMode for all types of card and disable platform sounds

                val messages: List<NdefMessage> = rawMessages.map { it as NdefMessage }
                // Process the messages array
            }
        }

        if (nfcactive) {
            textv.text = "Mukodik"
        } else {
            textv.text = "Semmi"
        }
    }




        /*val msg = NdefMessage(
            arrayOf(
            NdefRecord.createApplicationRecord("com.example.android.beam")
            )
        )

        val uriRecord=ByteArray(0).let{emptyByteArray ->
            NdefRecord(
                TNF_ABSOLUTE_URI,
                "https://developer.android.com/index.html".toByteArray(Charset.forName("US-ASCII")),
                emptyByteArray,
                emptyByteArray
            )
        }*/

}

