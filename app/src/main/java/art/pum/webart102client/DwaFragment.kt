package art.pum.webart102client

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import art.pum.webart102client.databinding.FragmentDwaBinding


class DwaFragment : Fragment() {

    private lateinit var dwaBinding : FragmentDwaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {

        dwaBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_dwa,
                                        container, false)

        setHasOptionsMenu(true)

        var args = DwaFragmentArgs.fromBundle(requireArguments())
        Toast.makeText(context, "Liczba:  ${args.liczba}", Toast.LENGTH_SHORT)
            .show()

        return dwaBinding.root
    }

}