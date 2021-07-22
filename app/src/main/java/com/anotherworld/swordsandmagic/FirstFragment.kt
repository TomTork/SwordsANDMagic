package com.anotherworld.swordsandmagic

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
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
    lateinit var ultimate1: ImageButton
    lateinit var ultimate2: ImageButton
    lateinit var ultimate3: ImageButton
    lateinit var ultimate4: ImageButton
    lateinit var ultimate5: ImageButton
    lateinit var common1: ImageButton
    lateinit var common2: ImageButton
    lateinit var common3: ImageButton
    lateinit var common4: ImageButton
    lateinit var common5: ImageButton
    lateinit var common6: ImageButton
    lateinit var common7: ImageButton

    lateinit var active_common: ImageButton
    lateinit var active_ultimate: ImageButton
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
        try {
            Thread.sleep(350)
        }catch (e:Exception){
            e.printStackTrace()
        }
        loadCommon()
        loadUltimate()
        return v;
    }
    fun loadCommon(){
        when(getterANDSetter.getCommon()){
            1 -> active_common.setImageResource(R.mipmap.sword)
            2 -> active_common.setImageResource(R.mipmap.anchor)
            3 -> active_common.setImageResource(R.mipmap.helmet)
            4 -> active_common.setImageResource(R.mipmap.page)
            5 -> active_common.setImageResource(R.mipmap.count)
            6 -> active_common.setImageResource(R.mipmap.heal)
            else -> active_common.setImageResource(R.drawable.ic_baseline_check_box_outline_blank_24)
        }
    }
    fun loadUltimate(){
        when(getterANDSetter.getUltimate()){
            1 -> active_ultimate.setImageResource(R.mipmap.vampirism)
            2 -> active_ultimate.setImageResource(R.mipmap.fullheal)
            3 -> active_ultimate.setImageResource(R.mipmap.totem)
            4 -> active_ultimate.setImageResource(R.mipmap.book)
            5 -> active_ultimate.setImageResource(R.mipmap.molot)
            else -> active_ultimate.setImageResource(R.drawable.ic_baseline_check_box_outline_blank_24)
        }
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

    //common1 - sword
    //common2 - anchor
    //common3 - helmet
    //common4 - page
    //common5 - count
    //common6 - heal
    //common7 - trap
    //ultimate1 - vampirism
    //ultimate2 - fullheal
    //ultimate3 - totem
    //ultimate4 - book
    //ultimate5 - molot
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.change_avatar -> {
                getterANDSetter.setGallery(1)
            }
            R.id.ultimate1 ->{
                getterANDSetter.setUltimate(1)
                active_ultimate.setImageResource(R.mipmap.vampirism)
            }
            R.id.ultimate2 ->{
                getterANDSetter.setUltimate(2)
                active_ultimate.setImageResource(R.mipmap.fullheal)
            }
            R.id.ultimate3 ->{
                if (getterANDSetter.getMoney()>=30.0){
                    getterANDSetter.setMoney(getterANDSetter.getMoney()-30.0)
                    getterANDSetter.setUltimate(3)
                    active_ultimate.setImageResource(R.mipmap.totem)
                }
                else Toast.makeText(context,"Недостаточно средств",Toast.LENGTH_SHORT).show()
            }
            R.id.ultimate4 ->{
                if (getterANDSetter.getMoney()>=50.0){
                    getterANDSetter.setMoney(getterANDSetter.getMoney()-50.0)
                    getterANDSetter.setUltimate(4)
                    active_ultimate.setImageResource(R.mipmap.book)
                }
                else Toast.makeText(context,"Недостаточно средств",Toast.LENGTH_SHORT).show()
            }
            R.id.ultimate5 ->{
                if (getterANDSetter.getMoney()>=100.0){
                    getterANDSetter.setMoney(getterANDSetter.getMoney()-100.0)
                    getterANDSetter.setUltimate(5)
                    active_ultimate.setImageResource(R.mipmap.molot)
                }
                else Toast.makeText(context,"Недостаточно средств",Toast.LENGTH_SHORT).show()
            }
            R.id.common1 ->{
                getterANDSetter.setCommon(1)
                active_common.setImageResource(R.mipmap.sword)
            }
            R.id.common2 ->{
                getterANDSetter.setCommon(2)
                active_common.setImageResource(R.mipmap.anchor)
            }
            R.id.common3 ->{
                if (getterANDSetter.getMoney()>=30.0){
                    getterANDSetter.setMoney(getterANDSetter.getMoney()-30.0)
                    getterANDSetter.setCommon(3)
                    active_common.setImageResource(R.mipmap.helmet)
                }
                else Toast.makeText(context,"Недостаточно средств",Toast.LENGTH_SHORT).show()
            }
            R.id.common4 ->{
                if (getterANDSetter.getMoney()>=50.0){
                    getterANDSetter.setMoney(getterANDSetter.getMoney()-50.0)
                    getterANDSetter.setCommon(4)
                    active_common.setImageResource(R.mipmap.page)
                }
                else Toast.makeText(context,"Недостаточно средств",Toast.LENGTH_SHORT).show()
            }
            R.id.common5 ->{
                if (getterANDSetter.getMoney()>=100.0){
                    getterANDSetter.setMoney(getterANDSetter.getMoney()-100.0)
                    getterANDSetter.setCommon(5)
                    active_common.setImageResource(R.mipmap.count)
                }
                else Toast.makeText(context,"Недостаточно средств",Toast.LENGTH_SHORT).show()
            }
            R.id.common6 ->{
                if (getterANDSetter.getMoney()>=120.0){
                    getterANDSetter.setMoney(getterANDSetter.getMoney()-120.0)
                    getterANDSetter.setCommon(6)
                    active_common.setImageResource(R.mipmap.heal)
                }
                else Toast.makeText(context,"Недостаточно средств",Toast.LENGTH_SHORT).show()
            }
            R.id.common7 ->{
                if (getterANDSetter.getMoney()>=150.0){
                    getterANDSetter.setMoney(getterANDSetter.getMoney()-150.0)
                    getterANDSetter.setCommon(7)
                    active_common.setImageResource(R.mipmap.trap)
                }
                else Toast.makeText(context,"Недостаточно средств",Toast.LENGTH_SHORT).show()
            }
            R.id.active_common ->{
                getterANDSetter.setCommon(0)
                active_common.setImageResource(R.drawable.ic_baseline_check_box_outline_blank_24)
            }
            R.id.active_ultimate ->{
                getterANDSetter.setUltimate(0)
                active_ultimate.setImageResource(R.drawable.ic_baseline_check_box_outline_blank_24)
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