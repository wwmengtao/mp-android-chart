# 开始
本章介绍使用此库的基本设置

# 添加依赖关系
作为第一步，将该库的依赖项添加到您的项目中。如何做到这一点在这个仓库的 [使用](https://github.com/PhilJay/MPAndroidChart#usage) 部分中有描述。 *Gradle* 是使用这个库作为依赖的推荐方式

# 创建视图
要使用 `LineChart`，`BarChart`，`ScatterChart`，`CandleStickChart`，`PieChart`，`BubbleChart` 或 `RadarChart`，请在 .xml 中定义它：  
```xml
<com.github.mikephil.charting.charts.LineChart
    android:id="@+id/chart"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```

然后从你的 `Activity`，`Fragment` 或其他东西中检索它：
```java
// in this example, a LineChart is initialized from xml
LineChart chart = (LineChart) findViewById(R.id.chart);
```

或者在代码中创建它（然后将其添加到布局）：
```java
// programmatically create a LineChart
LineChart chart = new LineChart(Context);

// get a layout defined in xml
RelativeLayout rl = (RelativeLayout) findViewById(R.id.relativeLayout);
rl.add(chart); // add the programmatically created chart
```

# 添加数据
获得图表实例后，可以创建数据并将其添加到图表。此示例使用 `LineChart`，`Entry` 类使用 x 和 y 坐标表示图表中的单个条目。其他图表类型（例如 `BarChart`）使用其他类（例如 `BarEntry` ）用于此目的

要将数据添加到图表，请将每个数据对象包装到一个 `Entry` 对象中，如下所示：
```java
YourData[] dataObjects = ...;

List<Entry> entries = new ArrayList<Entry>();

for (YourData data : dataObjects) {

    // turn your data into Entry objects
    entries.add(new Entry(data.getValueX(), data.getValueY()));
}
```

下一步，需要将你创建的 `List<Entry>` 添加到 `LineDataSet` 对象。 `DataSet` 对象保存属于一起的数据，并允许单独设置该数据的样式。如果启用，下面使用的“标签”仅具有描述性目的，并显示在图例（`Legend`）中。
```java
LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entries to dataset
dataSet.setColor(...);
dataSet.setValueTextColor(...); // styling, ...
```

作为最后一步，需要将你创建的 `LineDataSet` 对象（或多个对象）添加到 `LineData` 对象。该对象包含由 `Chart` 实例表示的所有数据，并允许进一步设置样式。创建数据对象后，可以将其设置为图表并刷新它：
```java
LineData lineData = new LineData(dataSet);
chart.setData(lineData);
chart.invalidate(); // refresh
```

请考虑上面的场景，非常基本的设置。有关更详细的解释，请参阅 [设置数据](https://github.com/PhilJay/MPAndroidChart/wiki/Setting-Data) 部分，其中介绍了如何根据示例向各种图表类型添加数据

# 样式
有关图表表面和数据的设置和样式的信息，请访问 [常规设置和样式](https://github.com/PhilJay/MPAndroidChart/wiki/General-Chart-Settings-&-Styling) 部分。 关于各种图表类型的更具体的样式和设置，请查看 [具体设置和样式](https://github.com/PhilJay/MPAndroidChart/wiki/Specific-chart-settings) wiki 页面
