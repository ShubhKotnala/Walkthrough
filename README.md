# Walkthrough
[![Platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=plastic)](https://android-arsenal.com/api?level=21)
[![](https://jitpack.io/v/ShubhKotnala/Walkthrough.svg)](https://jitpack.io/#ShubhKotnala/Walkthrough)

Walkthrough is an Android library that helps developers create beautiful Walkthrough/Intro Screens for their app easily.
## Screenshot
## Usage
### Step 1:
#### Add gradle dependecies
#### In the root level build.gradle
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
#### In the app level build.gradle
```
dependencies {
    implementation 'com.github.ShubhKotnala:Walkthrough:{latest-release}'
}
```
### Step 2:
#### Create an activity which extends WalkthroughActivity
```java
public class Walkthrough extends WalkthroughActivity
```
### Step 3:
#### Add activity theme to the manifest.xml
```xml
        <activity
            android:name=".Walkthrough"
            android:theme="@style/WalkthroughTheme" />
```
### Step 4:
#### Customize the Walkthrough Activity to your needs
```java
public class WalkthroughDemo extends WalkthroughActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPageTitle("Walkthrough");
        addWalkthroughItem(new WalkthroughItem(R.drawable._follow, "#7BC8C0","Walkthrough","Description Text"));
        addWalkthroughItem(new WalkthroughItem(R.drawable.lorem, "#967ADC","Supports Long Description",getResources().getString(R.string.lorem).toString()));
        addWalkthroughItem(new WalkthroughItem(R.drawable.github_octocat, "#000000","Download","Download this project on Github\nhttp://github.com/ShubhKotnala"));
        addWalkthroughItem(new WalkthroughItem(R.drawable.success, "#4CAF50","You're all set!","Slide more to get this finished or press the button at the bottom of this card to finish the Walkthrough and enter your amazing app."));

        startWalkthrough();
    }

    @Override
    public void onFinish() {
        super.onFinish();
       //TODO: manage the state when the last page is scrolled
    }
}
```

### Step 5 [optional]
#### If you want to load the images of the slides in the WalkthoughActivity, add the internet permission in the manifest.
This is completely optional, and you can skip it if you want to load the local images.
```xml
<uses-permission android:name="android.permission.INTERNET" />
```
#### Functional Explanation:

  - ```setPageTitle()``` &#8702;  Sets the given String to the page title.
  ```java
  setPageTitle("Walkthrough");
  ```
  - ```WalkthoughItem``` &#8702; Class which accepts a drawable(or a string url), hex color string, title string and a description string.
  ```java
  WalkthoughItem walkthroughItem = new WalkthoughItem(R.drawable.logo, "#967ADC", "Title", "Description");
  ```
  - ```addWalkthroughItem()``` &#8702; Accepts a WalkthoughItem model
   ```java
  addWalkthroughItem(walkthroughItem);
  ```
  - ```startWalkthrough()``` &#8702; starts the walkthrough activity. Call after the completing the above steps.
  ```java
  startWalkthrough();
  ```
  - ```onFinish()``` &#8702; Override the onFinish() function to handle the app flow when the WalkthroughActivity has finished
  ```java
  @Override
  public void onFinish() {
        super.onFinish();
       //TODO: manage the state when the last page is scrolled
    }
  ```

## Getting Help

To report a specific problem or feature request, [open a new issue on Github](https://github.com/ShubhKotnala/Walkthrough/issues/new).

## Contribution
Want to contribute to this library? Feel free to fork this repository and make a pull request.