package com.ng.ui.show

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.ng.ui.R
import com.ng.ui.show.frag.*
import com.ng.ui.show.main.AppUtils
import com.ng.ui.show.main.ItemInfo
import com.ng.ui.show.main.MyViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main_vp.*


/**
 * 描述: 新的主页
 * @author Jzn
 * @date 2020-04-11
 */
class MainActivity : AppCompatActivity() {

    private var itemInfoList = ArrayList<ItemInfo>()
    private var myViewPagerAdapter = MyViewPagerAdapter(supportFragmentManager, itemInfoList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentViewLayoutID())
        initViewsAndEvents()
    }

    private fun initViewsAndEvents() {
        initView()
        //start
        itemInfoList.add(ItemInfo("CentralTractionButton", CtbFragment()))
        itemInfoList.add(ItemInfo("EcgView", EcgFragment()))
        itemInfoList.add(ItemInfo("PolygonLoadView", PlFragment()))
        itemInfoList.add(ItemInfo("ArrowInteractionView", AiFragment()))
        itemInfoList.add(ItemInfo("PointLoadingView", PtlFragment()))
        itemInfoList.add(ItemInfo("CylinderView", CdFragment()))
        itemInfoList.add(ItemInfo("SoundView", SvFragment()))
        itemInfoList.add(ItemInfo("ToggleView", TgFragment()))

        //notify
        myViewPagerAdapter.notifyDataSetChanged()
        vp_maina.currentItem = itemInfoList.size - 1
    }

    private fun initView() {
        vp_maina.adapter = myViewPagerAdapter;
        vp_maina.setOnPageChangeListener(MyOnPageChangeListener())
        pts_main.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
        pts_main.setTextColor(Color.WHITE)
        pts_main.setTabIndicatorColorResource(R.color.colorAccent)
        pts_main.drawFullUnderline = false
        main_toolbar.title = AppUtils.getAppName(this)
        setSupportActionBar(main_toolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            //设置ActionBar左上角按钮
            actionBar.setHomeAsUpIndicator(R.drawable.ic_nav)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun getContentViewLayoutID(): Int {
        return R.layout.activity_main_vp

    }


    class MyOnPageChangeListener : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(position: Int) {
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

//    fun onCreateOptionsMenu(menu: Menu): Boolean {
//        val menuInflater = menuInflater
//        menuInflater.inflate(R.menu.main_menu, menu)
//        return super.onCreateOptionsMenu(menu)
//    }

//    fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.getItemId()) {
//            android.R.id.home -> if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//                drawerLayout.closeDrawers()
//            } else {
//                drawerLayout.openDrawer(GravityCompat.START)
//            }
//            R.id.menu_1 -> Toast.makeText(this@MainActivity, item.getTitle(), Toast.LENGTH_SHORT).show()
//        }
//        return super.onOptionsItemSelected(item)
//    }

}