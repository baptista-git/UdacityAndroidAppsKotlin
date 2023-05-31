#  App Architecture (UI Layer) - Guess the Word Project

<table style="width:100%">
  <tr>
    <th><img src=".\readme.resources\start.png" alt="Guess the Word playing page"/></th>
  </tr>
</table>

### List of Subjects:
1. Application Arquitecture
     * [Documentation - Guide to App Architecture](https://developer.android.com/topic/architecture)
     * [Blog Post - Android and Architecture](https://android-developers.googleblog.com/2017/05/android-and-architecture.html)
     * [Blog Post - Android Architecture Patterns Part 2: Model-View-Presenter](https://medium.com/upday-devs/android-architecture-patterns-part-2-model-view-presenter-8a6faaae14a5)
     * [Talk - Droidcon NYC 2016 - A Journey Through MV Wonderland](https://www.youtube.com/watch?v=QrbhPcbZv0I)
     * [Code Sample - Android Architecture Blueprints](https://github.com/android/architecture-samples)
     * [Code Sample - Blueprint Architecture Samples at a Glance Comparison](https://github.com/android/architecture-samples/wiki/Samples-at-a-glance)
2. [App Architecture](https://developer.android.com/topic/architecture):
     * Design Principle - Separation of Concerns: Code in classes, each with separate, well-defined responsibilities.
     * Ui controler: Display data and capture OS and user events
     * View Model: Hols all of the data needed for the UI and prepare it for display
     * LiveData: Crucial for communicating information  for the ViewModel to the UI Controller
3. ViewModel
     * [Documentation - ViewModel documentation](https://developer.android.com/topic/libraries/architecture/viewmodel)
     * [Documentation - ViewModel reference documentation](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel)
     * [Blog Post - ViewModels: A Simple Example](https://medium.com/androiddevelopers/viewmodels-a-simple-example-ed5ac416317e)
4.  ViewModel vs. UI Controller:
     * ViewModel holds data for UI
     * UI Controller only displays and gets user/OS events
     * UI Controller does NOT make decisions
     * ViewModel never references fragments, activities or views
5. Power and Limits of the ViewModel
     * [Documentation - Saving states](https://developer.android.com/topic/libraries/architecture/saving-states)
     * [Blog post - ViewModels: Persistence, onSaveInstanceState(), Restoring UI State and Loaders](https://medium.com/androiddevelopers/viewmodels-persistence-onsaveinstancestate-restoring-ui-state-and-loaders-fc7cc4a6c090)
6. LiveData
     * [Documentation - Observe LiveData objects](https://developer.android.com/topic/libraries/architecture/livedata?#observe_livedata_objects)
     * [Documentation - LiveData Overview](https://developer.android.com/topic/libraries/architecture/livedata)
     * [Documentation - LiveData reference documentation](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData)
7. LiveData Encapsulation
     * [Documentation - Backing properties](https://kotlinlang.org/docs/properties.html#backing-properties)
     * [Documentation - Backing properties in Android Style Guide](https://developer.android.com/kotlin/style-guide?hl=pt-br#backing-properties)
8. Event vs. State
9. [CountDownTimer](https://developer.android.com/reference/kotlin/android/os/CountDownTimer)
10. ViewModelFactory
      * [Documentation - ViewModelProvider.Factory](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModelProvider.Factory)
      * [Wikipedia - Factory pattern](https://en.wikipedia.org/wiki/Factory_(object-oriented_programming))
11. Add ViewModel to Data Binding
      * [Documentation - Use ViewModel to manage UI-related data](https://developer.android.com/topic/libraries/data-binding/architecture)
12. Add LiveData Data Binding
      * [Documentation - Use LiveData to notify the UI about data changes](https://developer.android.com/topic/libraries/data-binding/architecture#livedata)
      * [Documentation - Formatting strings](https://developer.android.com/guide/topics/resources/string-resource#formatting-strings)
      * [Documentation - Using resources with data binding](https://developer.android.com/topic/libraries/data-binding/expressions#resources)
13. [LiveData Map Transformation](https://developer.android.com/reference/android/arch/lifecycle/Transformations)
14. Adding the Buzzer
      * [Permissions on Android](https://developer.android.com/guide/topics/permissions/overview)
      * [Vibration on Android](https://developer.android.com/reference/android/os/Vibrator)



 


