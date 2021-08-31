# Scripts for Jetpack Compose


Components and scripts that can be used on Android Compose projects

## Jetpack Compose

### Components

<img src="/img/main-screen.png" alt="Main screen" width=400/>

* ImageComp: Show image stored in app data, if file is not found show a placeholder
* RowInfo: Multiple rows of text that contains bolded key and value, uses SingleRowInfo
* RowMultipleInfo: A row that contains multiple bolded keys and values

### Dialog
| List dialog | Loading dialog | Radio dialog | Text dialog |
|------------|-------------|-------------|-------------|
|![List dialog](/img/list-dialog.png)|![Loading dialog](/img/loading-dialog.png)|![Radio dialog](/img/radio-dialog.png)|![Text dialog](/img/text-dialog.png)|

* ListDialog: Shows lists of options which user select instantly, and return index of chosen element, -1 if dismissed
* LoadingDialog: Simple loading screen with customizable text
* RadioDialog: Shows lists of options in radio form with confirm button, and return index of chosen element, -1 if dismissed
* TextDialog: Shows title and any composable content, suitable to show temporary information for users

## Kotlin Scripts
* CleanString: Scripts that remove any whitespace or substring in a string
* ContextLauncher: A way for composable to access context inside onClick, also provide other contextual function such as showing toast and launching website
* IndexOfAll: Search for an element in a list and return a list of indexes of the element that's in the list
* RegexToList: Returns lists of string searched in the specified original string and search pattern
