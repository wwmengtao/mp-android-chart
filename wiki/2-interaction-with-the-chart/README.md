# 与图表的交互
该库允许你完全自定义与图表视图的可能触摸（和手势）交互，并通过回调方法对交互作出反应

# 启用/禁用交互
* `setTouchEnabled(boolean enabled)`：允许启用/禁用与图表的所有可能的触摸交互  
* `setDragEnabled(boolean enabled)`：启用/禁用拖动（平移）图表  
* `setScaleEnabled(boolean enabled)`：启用/禁用两个轴上图表的缩放比例  
* `setScaleXEnabled(boolean enabled)`：在 x 轴上启用/禁用缩放  
* `setScaleYEnabled(boolean enabled)`：在 y 轴上启用/禁用缩放  
* `setPinchZoom(boolean enabled)`：如果设置为 true，则启用缩放缩放。如果禁用，x 轴和 y 轴可以分开放大  
* `setDoubleTapToZoomEnabled(boolean enabled)`：将其设置为 false 以禁止通过双击缩放图表来缩放图表  

# 图表投掷/减速
* `setDragDecelerationEnabled(boolean enabled)`：如果设置为 true，则在修改后，图表会继续滚动。默认值：true。
* `setDragDecelerationFrictionCoef(float coef)`：减速摩擦系数区间为 [0, 1] ，较高的值表示速度将缓慢下降。例如，如果设置为0，则会立即停止。 1 是无效值，将自动转换为 0.9999

# 突出显示值
[突出显示](https://github.com/PhilJay/MPAndroidChart/wiki/Highlighting) 部分介绍如何通过轻触手势和编程方式突出显示条目

# 手势回调
OnChartGestureListener将允许你对图表上的手势做出反应：
```java
public interface OnChartGestureListener {

    /**
     * Callbacks when a touch-gesture has started on the chart (ACTION_DOWN)
     *
     * @param me
     * @param lastPerformedGesture
     */
    void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture);

    /**
     * Callbacks when a touch-gesture has ended on the chart (ACTION_UP, ACTION_CANCEL)
     *
     * @param me
     * @param lastPerformedGesture
     */
    void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture);

    /**
     * Callbacks when the chart is longpressed.
     *
     * @param me
     */
    public void onChartLongPressed(MotionEvent me);

    /**
     * Callbacks when the chart is double-tapped.
     *
     * @param me
     */
    public void onChartDoubleTapped(MotionEvent me);

    /**
     * Callbacks when the chart is single-tapped.
     *
     * @param me
     */
    public void onChartSingleTapped(MotionEvent me);

    /**
     * Callbacks then a fling gesture is made on the chart.
     *
     * @param me1
     * @param me2
     * @param velocityX
     * @param velocityY
     */
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY);

   /**
     * Callbacks when the chart is scaled / zoomed via pinch zoom gesture.
     *
     * @param me
     * @param scaleX scalefactor on the x-axis
     * @param scaleY scalefactor on the y-axis
     */
    public void onChartScale(MotionEvent me, float scaleX, float scaleY);

   /**
    * Callbacks when the chart is moved / translated via drag gesture.
    *
    * @param me
    * @param dX translation distance on the x-axis
    * @param dY translation distance on the y-axis
    */
    public void onChartTranslate(MotionEvent me, float dX, float dY);
}
```

简单地让你的应该接收回调的类实现此接口并将其设置为图表监听器：
```java
chart.setOnChartGestureListener(this);
```
