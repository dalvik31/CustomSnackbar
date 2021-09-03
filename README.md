# CustomSnackbar
Custom Snackbar

>Step 1. Add the JitPack repository to your build file

```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  
  > Step 2. Add the dependency
  
  ```	dependencies {
	        implementation 'com.github.dalvik31:CustomSnackbar:Tag'
	}
  ```

>Step 3. Use

```
 CustomSnackbar.showErrorToast(binding.container/*Constrainlayout*/,"message")
 ```
