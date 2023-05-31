#  Behind the Scenes (Caching) - DevByte Viewer Project

<table style="width:100%">
  <tr>
    <th><img src=".\readme.resources\start.png" alt=" DevByte Viewer initial with the list of subjects"/></th>
    <th><img src=".\readme.resources\end.png" alt="You Tube playing one of the videos in the list"/></th>
  </tr>
</table>

### List of Subjects:
1. Network Caching (RETROFIT)
    * Cache results per query
    * Http Caching
    * Store network results on disk
2. Cache Invalidation (RETROFIT)
    * Predicting cache out of date
    * Easy for simple requests
    * Harder for complex data
3. Room
    * Store structured data
    * Use to build a cache
    * Save network data in database
4. SharedPreferences
    * Key/Value store
    * Writes to disk
    * For small data
    * No query support
5. Files
    * Store anything you want
    * Private to your app
    * Can make multiple files
    * Images or data files
6. Offline Cache with Room
    * Local database -> Single source of truth
    * Network -> local database -> screen
    * updates: update server -> update loca data
7. Data Transfer Objects
    * Parse network results
    * Prepare data for network
8. Domain Objects
    * App data
    * Used by UI
    * Separate from network
9. Database object
    * Interacting with database
10. Room: VideoDao
11. Room: VideosDatabase
12. Build a Repository
13. Use the Repository
14. Background work
     * Upload Logs
     * Process data
     * Upload metrics
     * Prefetch content
15. WorkManager for the background
     * Lightweight API
     * Schedule background work
     * MyWork: Worker()
     * Pre-fetch content
16. WorkManager Constraints
     * Charging
     * Device Idle
     * On Wifi
     * ...
17. Create a Worker
18. Schedule Background Work






### Reference Documentation:
* [Save simple data with SharedPreferences](https://developer.android.com/training/data-storage/shared-preferences)
* [Data and file storage overview](https://developer.android.com/training/data-storage)
* [Guide to app architecture](https://developer.android.com/topic/architecture)
* [Connect ViewModel and the Repository](https://developer.android.com/topic/architecture#connect-viewmodel-repository)
* [Introducing WorkManager](https://medium.com/androiddevelopers/introducing-workmanager-2083bcfc4712)
* [WorkManager Codelab](https://developer.android.com/codelabs/android-workmanager#0)
* [WorkManager Documentation](https://developer.android.com/topic/libraries/architecture/workmanager)
* [WorkManager Basics](https://developer.android.com/guide/background/persistent)
* [Worker](https://developer.android.com/reference/androidx/work/Worker)
* [Application](https://developer.android.com/reference/android/app/Application)