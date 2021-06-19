
# InstaImageDownloader-Library

An easy to use library for extraction of images from instagram posts.





## Implementation

Step 1. Add the JitPack repository to your build file.

Add it in your root build.gradle at the end of repositories:

```bash 
 allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency

```bash
dependencies {
	        implementation 'com.github.Abhay-cloud:InstaImageDownloader-Library:0.1.0'
	}
```
    
## Usage
```java
ImagesDownloader.getImageUrl(Context, Post URL)
```
It'll return extracted image url. So you can use that to download and other purpose.


You are free to contribute here. This is first version. I'll add more awesome updates in near future.

### Made with ❤️ by Abhay

  
