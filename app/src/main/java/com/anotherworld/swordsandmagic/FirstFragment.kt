package com.anotherworld.swordsandmagic

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var v : View
    lateinit var change: Button
    lateinit var accept: Button
    lateinit var ultimate1: Button
    lateinit var ultimate2: Button
    lateinit var ultimate3: Button
    lateinit var ultimate4: Button
    lateinit var ultimate5: Button
    lateinit var common1: Button
    lateinit var common2: Button
    lateinit var common3: Button
    lateinit var common4: Button
    lateinit var common5: Button
    lateinit var common6: Button
    lateinit var common7: Button
    lateinit var active_common: Button
    lateinit var active_ultimate: Button
    lateinit var input_nickname: EditText
    lateinit var avatar_in_settings: ImageView
    val getterANDSetter: GetterANDSetter = GetterANDSetter()
    var sec: Int = 1
    private val PICK_IMAGE_REQUEST = 71
    var sP: String = ""
    var count:CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        try {
            Picasso.get().load(getterANDSetter.getImage()).placeholder(R.drawable.ic_baseline_account_box_24).error(R.drawable.ic_baseline_account_box_24).into(avatar_in_settings);

        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    override fun onStart() {
        super.onStart()
        try {
            Picasso.get().load(getterANDSetter.getImage()).placeholder(R.drawable.ic_baseline_account_box_24).error(R.drawable.ic_baseline_account_box_24).into(avatar_in_settings);

        }catch (e:Exception){
            e.printStackTrace()
        }    }

    override fun onResume() {
        super.onResume()
        try {
            Picasso.get().load(getterANDSetter.getImage()).placeholder(R.drawable.ic_baseline_account_box_24).error(R.drawable.ic_baseline_account_box_24).into(avatar_in_settings);

        }catch (e:Exception){
            e.printStackTrace()
        }    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v =  inflater.inflate(R.layout.fragment_first, container, false)
        change = v.findViewById(R.id.change_avatar)
        accept = v.findViewById(R.id.accept)
        active_common = v.findViewById(R.id.active_common)
        active_ultimate = v.findViewById(R.id.active_ultimate)
        common1 = v.findViewById(R.id.common1)
        common2 = v.findViewById(R.id.common2)
        common3 = v.findViewById(R.id.common3)
        common4 = v.findViewById(R.id.common4)
        common5 = v.findViewById(R.id.common5)
        common6 = v.findViewById(R.id.common6)
        common7 = v.findViewById(R.id.common7)
        ultimate1 = v.findViewById(R.id.ultimate1)
        ultimate2 = v.findViewById(R.id.ultimate2)
        ultimate3 = v.findViewById(R.id.ultimate3)
        ultimate4 = v.findViewById(R.id.ultimate4)
        ultimate5 = v.findViewById(R.id.ultimate5)
        input_nickname = v.findViewById(R.id.input_nickname)
        avatar_in_settings = v.findViewById(R.id.avatar_in_settings)
        change.setOnClickListener(this)
        accept.setOnClickListener(this)
        try {
            if (getterANDSetter.getSign()==1) {
                //Glide.with(this).load(getterANDSetter.getImage()).into(avatar_in_settings)
                Picasso.get().load(getterANDSetter.getImage()).placeholder(R.drawable.ic_baseline_account_box_24).error(R.drawable.ic_baseline_account_box_24).into(avatar_in_settings);
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
        return v;
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.change_avatar -> {
                getterANDSetter.setGallery(1)
            }
            R.id.ultimate1 ->{
                getterANDSetter.setUltimate(1)
            }
            R.id.ultimate2 ->{
                getterANDSetter.setUltimate(2)
            }
            R.id.ultimate3 ->{
                getterANDSetter.setUltimate(3)
            }
            R.id.ultimate4 ->{
                getterANDSetter.setUltimate(4)
            }
            R.id.ultimate5 ->{
                getterANDSetter.setUltimate(5)
            }
            R.id.common1 ->{
                getterANDSetter.setCommon(1)
            }
            R.id.common2 ->{
                getterANDSetter.setCommon(2)
            }
            R.id.common3 ->{
                getterANDSetter.setCommon(3)
            }
            R.id.common4 ->{
                getterANDSetter.setCommon(4)
            }
            R.id.common5 ->{
                getterANDSetter.setCommon(5)
            }
            R.id.common6 ->{
                getterANDSetter.setCommon(6)
            }
            R.id.common7 ->{
                getterANDSetter.setCommon(7)
            }
            R.id.active_common ->{
                getterANDSetter.setCommon(0)
            }
            R.id.active_ultimate ->{
                getterANDSetter.setUltimate(0)
            }
            R.id.accept -> {
                if (input_nickname.text.toString().isNotEmpty() && !input_nickname.text.toString().contains(";") && !input_nickname.text.toString().contains(" ")){
                    getterANDSetter.setName(input_nickname.text.toString())
                    input_nickname.text = null
                }
            }

        }
    }
}