package uk.co.rwapp.a11ybox

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat.getColor
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_semantic_view.*

class SemanticViewFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_semantic_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Listing 4-23
        semanticLayout.focusable = View.FOCUSABLE

//        Listing 5-9
        val color = ContextCompat.getColor(context!!, R.color.colorPrimary)
        parentLayout.setBackgroundColor(color)
    }

}