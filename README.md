# Debounce-Click
Easier to prevents duplicate clicks for Android View.

[![License](https://img.shields.io/github/license/Wenlong-Guo/Debounce-Click)](https://github.com/Wenlong-Guo/Dimens-Generating/blob/master/LICENSE)
![Release](https://img.shields.io/github/v/release/Wenlong-Guo/Debounce-Click?include_prereleases)

## Getting started

In your module `build.gradle`:

```groovy
dependencies {
    implementation 'io.github.wenlong-guo:debounce-click:1.0.1'
}
```

## Usage

#### For example:

```kotlin
findViewById(R.id.button).setDebounceClickListener {
    //something to click event
}
```

#### Optional , for example:

```kotlin
setDebounceDefaultTriggerTimeMillis(1000)
```
License
-------

    Copyright 2022 Wenlong Guo

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


