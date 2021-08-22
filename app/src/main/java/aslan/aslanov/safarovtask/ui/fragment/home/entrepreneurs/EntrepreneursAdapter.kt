package aslan.aslanov.safarovtask.ui.fragment.home.entrepreneurs

import android.annotation.SuppressLint
import aslan.aslanov.safarovtask.R
import aslan.aslanov.safarovtask.model.EntrepreneursItem
import aslan.aslanov.safarovtask.util.GenericListAdapter

@SuppressLint("ResourceType")
class EntrepreneursAdapter(private val onClickEntrepreneursItem: (EntrepreneursItem) -> Unit) :
    GenericListAdapter<EntrepreneursItem>(R.layout.layout_entrepreneurs_item, onClickListener = {
        onClickEntrepreneursItem(it)
    })
