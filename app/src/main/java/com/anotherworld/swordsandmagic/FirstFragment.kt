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
        Picasso.get().load(getterANDSetter.getImage()).placeholder(R.drawable.ic_baseline_account_box_24).error(R.drawable.ic_baseline_account_box_24).into(avatar_in_settings);
    }

    override fun onStart() {
        super.onStart()
        Picasso.get().load(getterANDSetter.getImage()).placeholder(R.drawable.ic_baseline_account_box_24).error(R.drawable.ic_baseline_account_box_24).into(avatar_in_settings);
    }

    override fun onResume() {
        super.onResume()
        Picasso.get().load(getterANDSetter.getImage()).placeholder(R.drawable.ic_baseline_account_box_24).error(R.drawable.ic_baseline_account_box_24).into(avatar_in_settings);
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v =  inflater.inflate(R.layout.fragment_first, container, false)
        change = v.findViewById(R.id.change_avatar)
        accept = v.findViewById(R.id.accept)
        input_nickname = v.findViewById(R.id.input_nickname)
        avatar_in_settings = v.findViewById(R.id.avatar_in_settings)
        change.setOnClickListener(this)
        accept.setOnClickListener(this)
        if (getterANDSetter.getSign()==1) {
                //Glide.with(this).load(getterANDSetter.getImage()).into(avatar_in_settings)
            Picasso.get().load(getterANDSetter.getImage()).placeholder(R.drawable.ic_baseline_account_box_24).error(R.drawable.ic_baseline_account_box_24).into(avatar_in_settings);
        }

//        count = object : CountDownTimer((sec * 1000).toLong(), 1000) {
//            override fun onTick(millisUntilFinished: Long) {
//                sec--
//                if (getterANDSetter.getSign()==1) {
//                    //Glide.with(this).load(getterANDSetter.getImage()).into(avatar_in_settings)
//                    Picasso.get().load(getterANDSetter.getImage()).placeholder(R.drawable.ic_baseline_account_box_24).error(R.drawable.ic_baseline_account_box_24).into(avatar_in_settings);
//                }
//            }
//
//            override fun onFinish() {
//                if (count != null) {
//                    sec = 1
//                    count!!.start()
//                }
//            }
//        }
//        if (count != null) {
//            sec = 1
//            count!!.start()
//        }
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
            R.id.accept -> {
                if (input_nickname.text.toString().isNotEmpty() && !input_nickname.text.toString().contains(";") && !input_nickname.text.toString().contains(" ")){
                    getterANDSetter.setName(input_nickname.text.toString())
                    input_nickname.text = null
                }
            }
        }
    }
}