package com.ex2.homluv.testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class Sample {

	
	
	@Test
	public void checking() {
//		List list1=[http://beta-stage.homluv.com/article/six-great-room-floor-plans-that-live-large, http://beta-stage.homluv.com/article/certificate-of-occupancy-what-is-it-and-why-is-it-important, http://beta-stage.homluv.com/article/the-hidden-heavyweight-of-your-closing-team, http://beta-stage.homluv.com/article/how-to-make-sure-your-home-is-ready-for-technology, http://beta-stage.homluv.com/article/how-to-pet-proof-your-new-home, http://beta-stage.homluv.com/article/how-to-pick-the-big-six-options, http://beta-stage.homluv.com/article/how-to-have-a-successful-walkthrough, http://beta-stage.homluv.com/article/how-to-prepare-for-the-big-move, http://beta-stage.homluv.com/article/how-to-evaluate-community-amenities, http://beta-stage.homluv.com/article/how-to-create-the-ultimate-home-theater, http://beta-stage.homluv.com/article/how-to-create-the-ultimate-green-roof, http://beta-stage.homluv.com/article/is-it-time-to-downsize-or-to-upsize, http://beta-stage.homluv.com/article/how-to-choose-window-treatments, http://beta-stage.homluv.com/article/meet-homluv-a-better-way-to-shop-new-homes, http://beta-stage.homluv.com/article/pool-safety-tips, http://beta-stage.homluv.com/article/how-to-choose-new-home-options-for-resale-value]
		
		List l1=new ArrayList();
		l1.add("Santosh");
		l1.add("Gupta");
		l1.add("Naam");
		l1.add("Hai");
		
		List l2=new ArrayList();
		l1.add("Santosh");
		l1.add("Gupta");
		l1.add("Naam");
		
		System.out.println(l1.equals(l2));
		
	}
	
	@Test
	public void checkingagain() {
		String a="By Santosh Gupta asfdas safa";
		String[] split = a.split("By ");
		System.out.println(split[1]);
	}
}
