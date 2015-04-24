package com.segRadiobutton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioGroup;

import com.segRadiobutton.R;
/**
 * 
 * @author 张超
 *
 * 2015年4月9日
 */
public class SegmentedRadioGroup extends RadioGroup {

	public SegmentedRadioGroup(Context context) {
		super(context);
	}

	public SegmentedRadioGroup(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		changeButtonsImages();
	}

	private void changeButtonsImages(){
		int count = super.getChildCount();

//		if(count > 1){
//			super.getChildAt(0).setBackgroundResource(R.drawable.segment_radio_left);
//			for(int i=1; i < count-1; i++){
//				super.getChildAt(i).setBackgroundResource(R.drawable.segment_radio_middle);
//			}
//			super.getChildAt(count-1).setBackgroundResource(R.drawable.segment_radio_right);
//		}else if (count == 1){
//			super.getChildAt(0).setBackgroundResource(R.drawable.segment_button);
//		}
		View view;
		if(count > 1){
			float scale = getContext().getResources().getDisplayMetrics().density;
			int baseGap =(int) (1 * scale + 0.5f);
			int nextGap = 0;
			view = super.getChildAt(0);
			view.setBackgroundResource(R.drawable.seg_radio_left);
			for(int i=1; i < count-1; i++){
				nextGap=baseGap*i;
				view = super.getChildAt(i);
				view.setX(view.getX()-nextGap);
				view.setBackgroundResource(R.drawable.seg_radio_middle);
			}
			nextGap=nextGap+baseGap;
			view = super.getChildAt(count-1);
			view.setX(view.getX()-nextGap);
			view.setBackgroundResource(R.drawable.seg_radio_right);
		}else if (count == 1){
			super.getChildAt(0).setBackgroundResource(R.drawable.seg_radio_default);
		}
	}
}