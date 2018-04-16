# Animal		属性动画完全解析。
1：逐帧动画 & 补间动画存在一定的缺点：
	a:只改变View的某个属性。
	b:只改变视觉效果。
	C:动画效果单一
2：属性动画的工作流程：
	1：设置动画的运行时长以及对应的初始值，结束值。
	2：设置属性从初始值到结束值得逻辑。
	3：根据逻辑不断改变值
	4：每改变一次就赋给对象属性值一次（监听里面修改）
	5：每次调用Invalid重新绘图。
	重复4  5 就好了。

3：属性动画都是依靠这两个类ValueAnimator，ObjectAnimator。
	
	A：ValueAnimator。

	他有三个重要的方法
	1：ValueAnimator.ofInt（int values）
	2：ValueAnimator.ofFloat（float values）
	3：ValueAnimator.ofObject（int values）
	ValueAnimator.oFloat（）采用默认的浮点型估值器 (FloatEvaluator)

	ValueAnimator.ofInt（）采用默认的整型估值器（IntEvaluator）
	在使用上完全没有区别

	通过继承TypeEvaluator来实现插值器PointEvaluator，ColorEvaluator
	通过这两个实例可以学会ValueAnimator.ofObject。
	他的思路是这样的，可以从一个int过渡到另一个int，可以从一个float过渡到另一个float
	从一个类过渡到另一个类需要重新写插值器来适配就好了。
	两种自定义属性动画的方式，一个view内置插值器，一种将数据抛出来。
	ObjectAnimator anim = ObjectAnimator.ofObject(myView2, "color", new ColorEvaluator(), "#0000FF", "#FF0000")
	注意color。


	B：ObjectAnimator

	继承自ValueAnimator类，即底层的动画实现机制是基于ValueAnimator类
	使用方式：
	ObjectAnimator animator = ObjectAnimator.ofFloat(mButton, "alpha", 1f, 0f, 1f);

	ObjectAnimator.ofFloat(Object object, String property, float ....values)的第二个参数传入值的作用是：
	让ObjectAnimator类根据传入的属性名 去寻找 该对象对应属性名的 set（） & get（）方法，从而进行对象属性值的赋值


	例子。Myview2就是很好的例子。这样就将属性动画与自定义动画完美结合。
	
4：组合动画（AnimatorSet 类）

	AnimatorSet.play(Animator anim)   ：播放当前动画
	
AnimatorSet.after(long delay)   ：将现有动画延迟x毫秒后执行
	
AnimatorSet.with(Animator anim)   ：将现有动画和传入的动画同时执行
	
AnimatorSet.after(Animator anim)   ：将现有动画插入到传入的动画之后执行
	
AnimatorSet.before(Animator anim) ： 将现有动画插入到传入的动画之前执行



5：动画的监听
	start，repeat，cancel ，end。添加适配器只写需要的。
































































