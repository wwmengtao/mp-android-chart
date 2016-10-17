# MPAndroidChart 官方文档翻译和源码分析
官方指的是 [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart) 这个库，MPAndroidChart是一个非常强大的、容易使用的图表库。

这个仓库主要分为三个部分：
1. 官方文档翻译
2. 官方源码分析
3. MPAndroidChart-Samples

## 初衷
2015年发现和学习MPAndroidChart时，边学习边翻译了官方Wiki，后来毕业后很长时间都没有继续用到这个库。工作后因为业务需要的特殊性，即使接触到一些图表功能开发也没有使用这个库，大多数时候都是自定义View来实现业务需求的图表功能。这并不意味着MPAndroidChart的扩展性不好，而是因为历史原因，继续使用自定义view开发更加方便快捷。

随着业务的发展，发现在原有自定义View上做改动实现新功能是比较困难的。前人在自定义View时封装性做得不够好、可扩展性相对较差（因为无法预料到业务的发展，也无需做到很好的扩展性）。

如今自己要新写图表时，发现难以下手，于是想了解MPAndroidChart是如何设计的，所以就决定进行一次彻底的源码分析。

-- 记于2016年10月17日

## 微信公众号
![二维码](https://github.com/zhuanghongji/MPAndroidChart/blob/master/image/AndroidHub_qrcode.jpg?raw=true)

名称：AndroidHub<br/>
简介：A place for Android developers everywhere to meet, share and discuss the latest on Android development .
