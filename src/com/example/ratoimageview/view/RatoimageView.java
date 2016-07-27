package com.example.ratoimageview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/**
 * ����ָ���Č��߱� ��ӑB�O������ĸ߶�
 * @author Administrator
 *
 */
public class RatoimageView extends ImageView { 
	//���x ���߱�
	private  float ratio = 0f;
	public RatoimageView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	public RatoimageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		//�@ȡ�Զ��x���Ե�ֵ
		String namespace = "http://schemas.android.com/apk/res/com.example.ratoimageview";
		ratio = attrs.getAttributeFloatValue(namespace, "ratio", 0f);
	}

	public RatoimageView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	
	//�O�� ���߱�
	public void setRato(float ratio){
		this.ratio = ratio;
	}

	//  widthMeasureSpec  heightMeasureSpec��view ���҂�Ӌ��� �� ���o��view    
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		
		//ͨ�^�y�� Ҏ�t �@ȡ�DƬ�� ����
		int width = MeasureSpec.getSize(widthMeasureSpec);
		//ͨ�^ ���� �� ���߱� Ӌ���  �߶�
		if(ratio !=0){
			float height = width/ratio;
			//���߶��O�ýo imageview
			heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) height, MeasureSpec.EXACTLY);
		}
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
}
