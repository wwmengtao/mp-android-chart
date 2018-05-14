# 突出显示值
本节重点介绍突出显示图表中的条目的主题，无论是通过点击手势还是基于发布 [v3.0.0](https://github.com/PhilJay/MPAndroidChart/releases) 的编程方式

# 启用/禁用突出显示
* `setHighlightPerDragEnabled(boolean enabled)`：在图表上将其设置为true，以允许在完全缩小时拖动图表曲面时突出显示。默认值：true
* `setHighlightPerTapEnabled(boolean enabled)`：在图表上将其设置为false，以防止点击手势突出显示值。 值仍然可以通过拖动或以编程方式突出显示。默认值：true
* `setMaxHighlightDistance(float distanceDp)`：设置dp中的最大高光距离。 点击图表远离该条目的距离不会引起突出显示。默认值：500dp

除此之外，可以为各个 `DataSet` 对象配置突出显示：
```java
dataSet.setHighlightEnabled(true); // allow highlighting for DataSet

// set this to false to disable the drawing of highlight indicator (lines)
dataSet.setDrawHighlightIndicators(true);
dataSet.setHighlightColor(Color.BLACK); // color for highlight indicator
// and more...
```

# 以编程方式突出显示
* `highlightValue(float x，int dataSetIndex，boolean callListener)`：突出显示给定 DataSet 中给定 x 位置的值。提供 -1 作为 dataSetIndex 以撤消所有突出显示。boolean 标志决定选择监听器是否应该被调用
* `highlightValue(Highlight high，boolean callListener)`：突出显示由提供的 Highlight 对象表示的值。提供 null 以撤销所有突出显示。boolean 标志决定选择监听器是否应该被调用
* `highlightValues(Highlight [] highs)`：突出显示由给定的 Highlight[] 数组表示的值。提供 null 或一个空数组以撤消所有突出显示
* `getHighlighted()`：返回一个 Highlight[] 数组，其中包含有关所有突出显示的条目，它们的 x 索引和数据集索引的信息

# 选择回调
这个库为交互时的回调提供了许多监听器。其中之一是 `OnChartValueSelectedListener`，当通过触摸突出显示值时用于回调：
```java
public interface OnChartValueSelectedListener {
    /**
    * Called when a value has been selected inside the chart.
    *
    * @param e The selected Entry.
    * @param h The corresponding highlight object that contains information
    * about the highlighted position
    */
    public void onValueSelected(Entry e, Highlight h);
    /**
    * Called when nothing has been selected or an "un-select" has been made.
    */
    public void onNothingSelected();
}
```

简单地让你应该接收回调的类实现此接口，并将其设置为图表的监听器：
```java
chart.setOnChartValueSelectedListener(this);
```

# Highlight 类
`Highlight` 类表示与高亮条目相关的所有数据，例如高亮的 `Entry` 对象本身，它所属的 `DataSet`，它在绘图表面上的位置等等。它可用于获取有关已突出显示的 `Entry` 的信息，或用于向 `Chart` 提供要突出显示的 `Entry` 的信息。 关于这个目的，`Highlight` 类提供了两个构造函数：
```java
/** constructor for standard highlight */
public Highlight(float x, int dataSetIndex) { ... }

/** constructor for stacked BarEntry highlight */
public Highlight(float x, int dataSetIndex, int stackIndex) { ... }
```

这些构造函数可用于创建一个 `Highlight` 对象，该对象允许以编程方式执行突出显示：
```java
// highlight the entry and x-position 50 in the first (0) DataSet
Highlight highlight = new Highlight(50f, 0);

chart.highlightValue(highlight, false); // highlight this value, don't call listener
```

# 自定义高亮(highligher)
以高亮手势形式的所有用户输入均由默认的 `ChartHighlighter` 类内部处理。 使用下面的方法可以用一个自定义的实现来替换默认的 highligher：

* `setHighlighter(ChartHighlighter highlighter)`：为处理(handles)/处理(processes)在图表视图上执行的所有高亮触摸事件的图表设置自定义高级对象。你的自定义的 highligher 对象需要扩展自 `ChartHighlighter` 类
