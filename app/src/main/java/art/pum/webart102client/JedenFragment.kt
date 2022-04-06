package art.pum.webart102client

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.findNavController
import art.pum.webart102client.databinding.FragmentJedenBinding


class JedenFragment : Fragment() {

    private lateinit var jedenBinding : FragmentJedenBinding
    private lateinit var loadPageVMFactory: GetSourcePageVMFactory
    private lateinit var loadPageVM: GetPageSourceVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        jedenBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_jeden,
                                               container, false)
        loadPageVMFactory = GetSourcePageVMFactory(viewLifecycleOwner, requireContext())
        loadPageVM = ViewModelProvider(this, loadPageVMFactory).get(GetPageSourceVM::class.java)
        jedenBinding.lifecycleOwner = viewLifecycleOwner
        jedenBinding.getPageVMLayout = loadPageVM

        setHasOptionsMenu(true)

        jedenBinding.idDoDwa.setOnClickListener {
            //it.findNavController().navigate(R.id.action_jedenFragment_to_dwaFragment)
            it.findNavController().navigate(
                JedenFragmentDirections.actionJedenFragmentToDwaFragment()
                    .setLiczba(120)
            )
        }


//        jedenBinding.zaladujStrone.setOnClickListener {
//            loadPageVM.getStrone()
//        }


        return jedenBinding.root
    }


}