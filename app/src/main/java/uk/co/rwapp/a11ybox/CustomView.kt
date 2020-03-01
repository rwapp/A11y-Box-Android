package uk.co.rwapp.a11ybox

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.view.accessibility.AccessibilityManager

class CustomView: View {
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var faceColor = Color.YELLOW
    private var eyesColor = Color.BLACK
    private var mouthColor = Color.BLACK
    private var borderColor = Color.BLACK
    private var borderWidth = 4.0f
    private var size = 320
    private val mouthPath = Path()

//    Listing 4-17
    override fun onInitializeAccessibilityNodeInfo(info:
                                              AccessibilityNodeInfo?) {
        super.onInitializeAccessibilityNodeInfo(info)
        val click =
            AccessibilityNodeInfo.AccessibilityAction(AccessibilityNodeInfo.ACTION_CLICK,
                "open")
        val longClick =
            AccessibilityNodeInfo.AccessibilityAction(AccessibilityNodeInfo.ACTION_LONG_CLICK,
                "show options")
        info?.addAction(click)
        info?.addAction(longClick)

        // Listing 4-20
        info?.isCheckable = true
    }

    // Listing 4-18
    override fun sendAccessibilityEvent(eventType: Int) {
        super.sendAccessibilityEvent(eventType)
        when (eventType) {
            AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED -> faceColor(Color.YELLOW)
            AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUSED -> faceColor(Color.GREEN)
        }
    }

    private fun faceColor(color: Int) {
        faceColor = color
        invalidate()
    }

    // Face drawing code from https://www.raywenderlich.com/142-android-custom-view-tutorial
    override fun onDraw(canvas: Canvas) {
        // call the super method to keep any drawing from the parent side.
        super.onDraw(canvas)

        drawFaceBackground(canvas)
        drawEyes(canvas)
        drawMouth(canvas)
    }

    private fun drawFaceBackground(canvas: Canvas) {
        paint.color = faceColor
        paint.style = Paint.Style.FILL

        val radius = size / 2f

        canvas.drawCircle(size / 2f, size / 2f, radius, paint)

        paint.color = borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth

        canvas.drawCircle(size / 2f, size / 2f, radius - borderWidth / 2f, paint)
    }

    private fun drawEyes(canvas: Canvas) {
        paint.color = eyesColor
        paint.style = Paint.Style.FILL

        val leftEyeRect = RectF(size * 0.32f, size * 0.23f, size * 0.43f, size * 0.50f)

        canvas.drawOval(leftEyeRect, paint)

        val rightEyeRect = RectF(size * 0.57f, size * 0.23f, size * 0.68f, size * 0.50f)

        canvas.drawOval(rightEyeRect, paint)
    }

    private fun drawMouth(canvas: Canvas) {
        mouthPath.moveTo(size * 0.22f, size * 0.7f)

        mouthPath.quadTo(size * 0.50f, size * 0.80f, size * 0.78f, size * 0.70f)

        mouthPath.quadTo(size * 0.50f, size * 0.90f, size * 0.22f, size * 0.70f)

        paint.color = mouthColor
        paint.style = Paint.Style.FILL

        canvas.drawPath(mouthPath, paint)
    }
}