package ru.anb.numbers

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class NewPostConract : ActivityResultContract<Numbers, Numbers?>() {
    override fun createIntent(context: Context, input: Numbers): Intent =
        Intent(context, ThedActivity::class.java)
            .apply { putExtra(Intent.EXTRA_TEXT, input) }

    override fun parseResult(resultCode: Int, intent: Intent?): Numbers? =
        if (resultCode == Activity.RESULT_OK) {
            intent?.getParcelableExtra(Intent.EXTRA_TEXT)
        } else {
            null
        }

}