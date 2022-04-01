package art.pum.webart102client

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import art.pum.webart102client.databinding.FragmentJedenBinding


class JedenFragment : Fragment() {

    private lateinit var jedenBinding : FragmentJedenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        jedenBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_jeden,
                                               container, false)

        setHasOptionsMenu(true)

        jedenBinding.idDoDwa.setOnClickListener {
            //it.findNavController().navigate(R.id.action_jedenFragment_to_dwaFragment)
            it.findNavController().navigate(JedenFragmentDirections.actionJedenFragmentToDwaFragment()
                .setLiczba(120))
        }

        return jedenBinding.root
    }


}