# 区块预生成 Chunky

- 官方源码：https://github.com/pop4959/Chunky
- 基准提交：`f979e9e370c14d590001e8194207ebded66cd44e`
- 对应官方发布版：`1.4.28`，支持 Paper 1.20.5–1.21.4
- 目标服务端：MyRPG Paper 1.21.4
- 授权协议：GPL-3.0，详见 `LICENSE`

此目录从官方 GitHub 源码归档建立，保留了全部平台模块和原始许可文件。源码归档不含 `.git` 历史；基准提交与官方 1.4.28 发布日的兼容性热修复一致。已完成简体中文本地化，并将 Paper 插件部署到 MyRPG 正式服 V2.0 的插件目录；部署时服务器处于停止状态，尚未启动验证。

## 本地构建适配

- `gradle.properties` 设置 `myrpgPatchVersion=28`，让无 Git 历史的源码归档生成正确的 `1.4.28` 版本号。
- `settings.gradle.kts` 增加 `-PmyrpgPaperOnly=true` 开关；使用时只配置 Bukkit 插件所需的 `nbt`、`common`、`paper`、`folia`、`bukkit` 模块。默认设置仍包含官方所有平台模块。
- 仅调整简体中文语言资源、语言默认值和插件描述，未改动区块生成逻辑。

使用 Java 21 和 Gradle 8.10.2 构建服务器插件：

```powershell
.\gradlew.bat :chunky-bukkit:build -PmyrpgPaperOnly=true
```

本机使用同版本 Gradle 执行该构建，结果为 `BUILD SUCCESSFUL`。插件包位于 `bukkit/build/libs/Chunky-Bukkit-1.4.28.jar`，其 `plugin.yml` 标识的版本也为 `1.4.28`。Bukkit 模块没有测试源码（Gradle 显示 :chunky-bukkit:test NO-SOURCE）。已将 JAR 复制到 E:\MYSQL\正式服V2.0\plugins\Chunky-Bukkit-1.4.28.jar；服务器当时未运行，插件将在下次启动时加载，尚未执行启动验证。
