# MyKnow 无人机资料库

查阅好盈 **H13MD** / **H15 Plus** / **H150A FOC**，思翼 **A8 mini / ZR10 / UniRC / MT11**，云卓 **G16 / G20 / H16 / H30**，**UM982** / **ZED-F9P**，以及 CUAV **X7** / **X7 Pro** / **Pixhawk V6X** 的参数、接线和现场要点。

最低系统：Android 8.0。

## 下载 APK（请用这个链接）

不要从仓库文件页点 `release/MyKnow.apk`。GitHub 源文件直链在手机 Chrome 里经常 **已经下完 17 MB 却一直停在「正在下载…」**。

请打开 **Releases**，再点 Assets 里的 `MyKnow.apk`：

**https://github.com/1314520alu/myknow/releases/download/v1.0.0/MyKnow.apk**

发布页：https://github.com/1314520alu/myknow/releases/tag/v1.0.0

文件约 17.04 MB。仓库是私有的，手机浏览器需要已登录 GitHub。

### Chrome 卡在 100% 时

1. 点「取消」，不要一直等。
2. 打开系统「文件」/「下载」，搜索 `MyKnow`。
3. 若看到 `MyKnow.apk.crdownload` 或 `MyKnow.bin`，把后缀改成 `.apk` 再点安装。
4. 仍没有文件：关掉页面后用 **Firefox**、手机自带浏览器，或 **长按链接 → 下载链接**。
5. 状态栏有 VPN 时，下完字节后可先断开 VPN，再让浏览器收尾；或换节点后重新下 Releases 链接。
6. 用电脑下载再传到手机（微信文件传输助手 / 数据线）。

安装时允许「未知来源」/「安装未知应用」。

## 不用 APK：网页版加到桌面

仓库是私有的，jsDelivr 等 CDN 打不开。登录 GitHub 后，用电脑把 `docs/index.html` 拷到手机，或把本仓库改为 **Public** 后再用：

https://cdn.jsdelivr.net/gh/1314520alu/myknow@v1.0.0/docs/index.html

打开后点浏览器 **⋮ → 安装应用 / 添加到主屏幕**。

## 打开工程

用 Android Studio 打开本仓库，同步 Gradle 后运行 `app`。
