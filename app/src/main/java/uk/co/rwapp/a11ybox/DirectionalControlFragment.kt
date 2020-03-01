package uk.co.rwapp.a11ybox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_directional_control.*

class DirectionalControlFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_directional_control, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Listing 4-15
        button14.nextFocusUpId = button11.id
        button14.nextFocusDownId = button17.id
        button14.nextFocusLeftId = button13.id
        button14.nextFocusRightId = button15.id
        button14.nextFocusForwardId = button15.id
    }
}