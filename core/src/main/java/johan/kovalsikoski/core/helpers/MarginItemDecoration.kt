package johan.kovalsikoski.core.helpers

import android.content.Context
import android.graphics.Rect
import android.util.DisplayMetrics
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration(private val context: Context, private val marginRect: Rect? = null) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        if (marginRect != null) {
            with(outRect) {
                left = convertDpToPixel(marginRect.left)
                right = convertDpToPixel(marginRect.right)
                top = convertDpToPixel(marginRect.top)
                bottom = convertDpToPixel(marginRect.bottom)
            }
        }

        val itemPosition =
            (view.layoutParams as RecyclerView.LayoutParams).viewLayoutPosition

        val itemCount = state.itemCount

        if (itemPosition == itemCount - 1) {
            outRect.setEmpty()
        }

    }

    private fun convertDpToPixel(dp: Int): Int {
        return dp * (context.resources
            .displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT).toInt()
    }

}