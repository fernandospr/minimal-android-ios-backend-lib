Demonstrates a minimal Kotlin library to share logic in Android, iOS and JVM Backend projects.

## minimal-android-ios-backend-lib
Contains the Kotlin code to share across platforms.

You'll find this simple class:
```kotlin
class Example {
  fun hello(who: String) = "Hello $who!"
}
```
### Compiling the library for Android/JVM/Backend apps
1. Execute the Gradle Task: `publishToMavenLocal` using `./gradlew publishToMavenLocal`.
This task will publish in your `/.m2/repository` folder.

2. Open the Android/JVM/Backend client project and make sure you have `mavenLocal()` in your repositories configuration.
3. Add the dependency: `implementation("{group}:{rootProject.name}:{version}")`. For this example, it's `implementation("com.github.fernandospr:minimal-android-ios-backend-lib:1.0.0")`.
4. Now in your Android app code you can import the library classes.
  
### Compiling the library for iOS apps
1. Execute the Gradle Task: `assemble{libName}XCFramework` using `./gradlew assemble{libName}XCFramework`. For this example, it's `./gradlew assembleMAIBLibXCFramework`. This task will generate the framework in `build/XCFrameworks` of the library project.
2. Copy the debug or release framework to your iOS client project.
3. Open your iOS client project using Xcode, go to the project properties, open `General` tab and add the framework in the `Frameworks, Libraries and Embedded Content` section.
4. Now in your iOS app code you can import the library classes.

Note: If you try to build & run your app in a simulator and get the following error `building for iOS Simulator-arm64 but attempting to link with file built for iOS Simulator-x86_64` go to `Build Settings`, `All` and filter by `Excluded Architectures`, add `Any iOS Simulator SDK` with `arm64` value.

## android-sample-app
Contains a sample Android App that uses the library.

To build this app you'll need to compile the library locally first, as explained above.

`MainActivity.kt` contains the following code that uses the `Example` class from the library:

```kotlin
import com.github.fernandospr.maiblib.Example

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    ...
    val example = Example()
    findViewById<TextView>(R.id.textView).text = example.hello("Fernando")
  }
}
```

### Screenshots
<img width="200" alt="android-maiblib-sample" src="https://user-images.githubusercontent.com/4404680/177391909-a2043ddd-54c1-4186-88f7-aa16f8185cea.png">


## ios-sample-app
Contains a sample iOS App that uses the library.

This app already contains the framework compiled and copied to the project folder so you can safely build the app.

`ViewController.swift` contains the following code that uses the `Example` class from the library:

```swift
import MAIBLib

class ViewController: UIViewController {
  ...
  override func viewDidLoad() {
    ...
    let example = Example()
    label.text = example.hello(who: "Fernando")
  }
}
```

### Screenshots
<img width="200" alt="ios-maiblib-sample" src="https://user-images.githubusercontent.com/4404680/177391856-ff00adae-6392-4164-8fd5-d5d5b5949eb2.png">

## backend-sample-app
Contains a sample Kotlin Backend App that uses the library.

To build this app you'll need to compile the library locally first, as explained above.

`Controller.kt` contains the following code that uses the `Example` class from the library:
```kotlin
import com.github.fernandospr.maiblib.Example

@RestController
@RequestMapping("/web")
class WebController {

  @GetMapping("/hello")
  fun hello(@PathParam("who") who: String) = Example().hello(who)
}

@RestController
@RequestMapping("/api")
class ApiController {

  @GetMapping("/hello")
  fun hello(@PathParam("who") who: String) = ApiResponse(Example().hello(who))
}
```

### Screenshots
Using the `Example` class in a Web server that returns a String:

<img width="512" alt="backend-web-maiblib-sample" src="https://user-images.githubusercontent.com/4404680/177391204-da62b53f-2bb2-4830-aefe-ddbd5bab12ed.png">

Using the `Example` class in an API that returns JSON:

<img width="500" alt="backend-api-maiblib-sample" src="https://user-images.githubusercontent.com/4404680/177391224-2c4572c6-9aaf-47d7-8a6b-4a1cceabd402.png">


