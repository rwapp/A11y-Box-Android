package uk.co.rwapp.a11ybox

import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_remove_animations.*

class RemoveAnimationsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_remove_animations, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (areSystemAnimationsEnabled()) {
            removeAnimationsText.text = getString(R.string.animations_enabled)
        } else {
            removeAnimationsText.text = getString(R.string.animations_disabled)
        }

    }

    private fun areSystemAnimationsEnabled(): Boolean {
        val animationDuration = try {
            Settings.Global.getFloat(context!!.contentResolver, Settings.Global.ANIMATOR_DURATION_SCALE)
        } catch (e: Settings.SettingNotFoundException) {
            0f
        }
        return animationDuration != 0f
    }
}