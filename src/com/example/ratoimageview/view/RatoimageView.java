package com.example.ratoimageview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/**
 * 根據指定的寬高比 來動態設置自身的高度
 * @author Administrator
 *
 */
public class RatoimageView extends ImageView { 
	//定義 寬高比
	private  float ratio = 0f;
	public RatoimageView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	public RatoimageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		//獲取自定義屬性的值
		String namespace = "http://schemas.android.com/apk/res/com.example.ratoimageview";
		ratio = attrs.getAttributeFloatValue(namespace, "ratio", 0f);
	}

	public RatoimageView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	
	//設置 寬高比
	public void setRato(float ratio){
		this.ratio = ratio;
	}

	//  widthMeasureSpec  heightMeasureSpec父view 幫我們計算好 并 傳給子view    
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		
		//通過測量 規則 獲取圖片的 寬度
		int width = MeasureSpec.getSize(widthMeasureSpec);
		//通過 寬度 和 寬高比 計算出  高度
		if(ratio !=0){
			float height = width/ratio;
			//將高度設置給 imageview
			heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) height, MeasureSpec.EXACTLY);
		}
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
}
