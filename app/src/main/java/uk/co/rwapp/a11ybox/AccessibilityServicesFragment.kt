package uk.co.rwapp.a11ybox

import android.accessibilityservice.AccessibilityServiceInfo
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityManager
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_accessibility_services.*

class AccessibilityServicesFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_accessibility_services, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Listing 5-17
        val a11yManager = activity!!.getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager

//        Listing 5-18
        val installedServices = a11yManager.installedAccessibilityServiceList

//        Listing 5-19
        val isAccessibilityEnabled = a11yManager.isEnabled

//        Listing 5-20
        val screenReaders = a11yManager.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_SPOKEN)

//        Listing 5-1
        val isExploreByTouchEnabled = a11yManager.isTouchExplorationEnabled


        if (isAccessibilityEnabled) {
            accessibilityEnabledText.text = getString(R.string.accessibility_enabled)
        } else {
            accessibilityEnabledText.text = getString(R.string.accessibility_disabled)
        }

        if (isExploreByTouchEnabled) {
            exploreByTouchText.text = getString(R.string.explore_by_touch_enabled)
        } else {
            exploreByTouchText.text = getString(R.string.explore_by_touch_disabled)
        }

        if (screenReaders.isEmpty()) {
            screenReadersText.text = getString(R.string.none)
        } else {
            val screenReaderNames = screenReaders.joinToString(separator = "\n") { it.id }
            screenReadersText.text = screenReaderNames
        }

        if (installedServices.isEmpty()) {
            installedServicesText.text = getString(R.string.none)
        } else {
            val installedServicesNames = installedServices.joinToString(separator = "\n") { it.id }
            installedServicesText.text = installedServicesNames
        }

    }
}