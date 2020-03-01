package uk.co.rwapp.a11ybox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        content_description_button.setOnClickListener(Navigation.createNavigateOnClickListener(
            R.id.contentDescriptionFragment, null))

        important_for_accessibility_button.setOnClickListener(Navigation.createNavigateOnClickListener(
            R.id.importantForAccessibilityFragment, null))

        hint_button.setOnClickListener(Navigation.createNavigateOnClickListener(
            R.id.hintFragment, null))

        heading_button.setOnClickListener(Navigation.createNavigateOnClickListener(
            R.id.headingFragment, null))

        minimum_size_button.setOnClickListener(Navigation.createNavigateOnClickListener(
            R.id.minimumSizeFragment, null))

        label_for_button.setOnClickListener(Navigation.createNavigateOnClickListener(
            R.id.labelForFragment, null))

        traversal_order_button.setOnClickListener(Navigation.createNavigateOnClickListener(
            R.id.traversalOrderFragment, null))

        keyboard_focus_button.setOnClickListener(Navigation.createNavigateOnClickListener(
            R.id.keyboardFocusOrderFragment, null))

    }
}