package uk.co.rwapp.a11ybox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_traversal_order.*

class TraversalOrderFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_traversal_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        traversal_order_6.accessibilityTraversalAfter = traversal_order_5.id
        traversal_order_5.accessibilityTraversalAfter = traversal_order_4.id

    }
}