#  Activity & Fragment Lifecycle - Dessert Pusher Project

<table style="width:100%">
  <tr>
    <th><img src=".\readme.resources\start.png" alt="Android Trivia initial page with Navigation Drawer"/></th>
    <th><img src=".\readme.resources\end.png" alt="Android Trivia congratulations"/></th>
  </tr>
</table>

### List of Subjects:
1.  [Activity Lifecycle Diagram](https://medium.com/androiddevelopers/the-android-lifecycle-cheat-sheet-part-i-single-activities-e49fd3d202ab):
     * OnCreate / *onRestart -> onStart  -> onResume 
     * onPause -> onStop -> onDestroy
2.  [Fragment Lifecycle Diagram](https://medium.com/androiddevelopers/the-android-lifecycle-cheat-sheet-part-iii-fragments-afc87d4f37fd):
     * onCreate -> onAttach -> onCreateView ->  OnActivityCreated -> onStart ->onResume
     * onPause -> onStop -> onDestroyView -> onDestroy -> onDetach
3.  [Logging](https://developer.android.com/studio/debug/am-logcat)
     * Verbose: Show all log messages (the default).
     * Debug: Show debug log messages that are useful during development only, as well as the message levels lower in this list.
     * Info: Show expected log messages for regular usage, as well as the message levels lower in this list.
     * Warn: Show possible issues that are not yet errors, as well as the message levels lower in this list.
     * Error: Show issues that have caused errors, as well as the message level lower in this list.
     * Assert: Show issues that the developer expects should never happen.
4. [Logging library Timber](https://github.com/JakeWharton/timber)
     * Generates Tags
     * Avoid logs in released app apk
     * Easy integration with crash reporting
5. Application Class
     * A base class that contains global application state for your entire app 
6. [Lifecycle-Aware Components](https://developer.android.com/topic/libraries/architecture/lifecycle)
7. Process Shutdown
     * "adb shell am kill com.tech.baptista.dessertpusher"
8. onSaveInstanceState
     * Android P (API 28+) : onStop -> OnSaveInstantceState -> onDestroy
     * API 27- : OnSaveInstantceState -> onStop -> onDestroy
     * Just for little information
9. Configuration Changes:
     * User change device language
     * User plugs in physical keyboard
     * User rotates device


