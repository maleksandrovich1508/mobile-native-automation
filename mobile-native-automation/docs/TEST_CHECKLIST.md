Repository test analysis and next steps

What exists (mobile-relevant):
- src/test/java/com/solvd/carina/demo/MobileDragAndDropTest.java (Android drag & drop)
- src/test/java/com/solvd/carina/demo/IOSPreferencesTest.java (iOS native preferences example)
- src/test/java/com/solvd/carina/demo/IOSSafariTest.java
- Several other demo/regression tests under src/test/java/com/solvd/carina/demo and regression subpackages
- APK present: src/test/resources/apps/Android-MyDemoAppRN.apk
- TestNG suite files: android.xml, android-dragAndDrop.xml, ios.xml, ios-preferences.xml, etc.

Gaps vs. your Task list:
1) Environment setup: repo contains test code but local environment required (Appium server, emulators/simulators, adb, Xcode) — not installed by repo.
2) Test parity (iOS + Android): some features have only one-platform tests (e.g., drag-and-drop present for Android; verify iOS counterpart coverage).
3) Image-based testing: no tests or dependencies implementing find-by-image / OpenCV-based verification.
4) TestNG suites referenced non-existent class MobileSampleTest — fixed (android.xml → MobileDragAndDropTest, ios.xml → IOSPreferencesTest).

Suggested checklist (high priority)
- [ ] Install Appium and Appium Inspector locally
- [ ] Start Appium server (default http://127.0.0.1:4723) and verify connection
- [ ] Ensure Android emulator (or real device) and an iOS simulator are available and accessible
- [ ] Run mvn -Dsuite=android-dragAndDrop test and mvn -Dsuite=ios test (after emulators + Appium running)
- [ ] Create/enable image-based tests: add test resource images, install Appium images plugin, and either use Java client MobileBy.image(base64) or an OpenCV-based comparator
- [ ] Create at least 10 Test Cases in Zebrunner TCM and map each to implemented tests; ensure each has both iOS and Android variants where applicable
- [ ] Add CI job or script to start Appium/emulator and run suites (optional)

How to add image-based test support (short):
1. Install Appium images plugin on Appium server: appium plugin install --source=npm appium-images-plugin
2. Install OpenCV for local image processing (optional): for Node use opencv4nodejs (npm), for Java consider org.openpnp:opencv (native bindings may be required).
3. Prepare expected image(s) under src/test/resources/images/ (e.g., expected_draw.png).
4. In Java tests you can use io.appium.java_client.MobileBy.image(base64) to search by image - Appium server must have images plugin enabled to accept image locator.

How to run tests locally (quick):
- Start Appium: appium
- Start Android emulator: (Android Studio AVD manager) or: emulator -avd <name>
- Run: mvn -Dsuite=android-dragAndDrop test

If you want, I can:
- Add a template image-based test and a placeholder image resource (you can replace with a real image),
- Add a script to start Appium + emulator for CI, or
- Create the 10 Zebrunner test case descriptions mapped to repo tests.

Notes:
- I updated testng suites android.xml and ios.xml to use existing test classes so mvn runs don't fail due to missing class references.
- Local Appium/emulator required to actually execute mobile tests; build runs will fail with Connectionrefused otherwise.
