package uk.co.rwapp.a11ybox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_live_region.*

class LiveRegionFrgament: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_live_region, container, false)
    }

    private var score1 = 0
    private var score2 = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Listing 5-4
        scoreText2.accessibilityLiveRegion = View.ACCESSIBILITY_LIVE_REGION_ASSERTIVE

        updateScoreButton1.setOnClickListener {
            ++score1

            scoreText1.text = "Score: $score1 points"
        }

        updateScoreButton2.setOnClickListener {
            ++score2

            scoreText2.text = "Score: $score2 points"
        }

        announceButton.setOnClickListener {

//            Listing 5-2
            view.announceForAccessibility("New message received.")
        }
    }
}