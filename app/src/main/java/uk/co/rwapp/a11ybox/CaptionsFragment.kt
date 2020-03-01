package uk.co.rwapp.a11ybox

import android.content.Context
import android.media.MediaFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.CaptioningManager
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_captions.*
import java.util.Locale.*

class CaptionsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_captions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        captionStatus()

//        Listing 5-13
        val captioningManager = activity!!.getSystemService(Context.CAPTIONING_SERVICE) as CaptioningManager
        val captionsListener = MyCaptionListener()
        captionsListener.captionsFragment = this
        captioningManager.addCaptioningChangeListener(captionsListener)

    }

    internal fun captionStatus() {

        //        Listing 5-11
        val subtitlesEN = resources.openRawResource(R.raw.subs_en_vtt)
        videoView.addSubtitleSource(subtitlesEN, MediaFormat.createSubtitleFormat("text/vtt", ENGLISH.language))

        // Listing 5-12
        val captioningManager = activity!!.getSystemService(Context.CAPTIONING_SERVICE) as CaptioningManager
        val captionsEnabled = captioningManager.isEnabled
        val captionStyle = captioningManager.userStyle
        val textScale = captioningManager.fontScale

        if (captionsEnabled) {
            captionsStatusText.text = getString(R.string.captions_enabled)
        } else {
            captionsStatusText.text = getString(R.string.captions_disabled)
        }

        captionsSizeText.text = "Caption Text Scale: $textScale"
    }
}

class MyCaptionListener : CaptioningManager.CaptioningChangeListener() {

    lateinit var captionsFragment: CaptionsFragment

    override fun onEnabledChanged(enabled: Boolean) {
        captionsFragment.captionStatus()
    }
}
