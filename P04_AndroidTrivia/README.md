#  Navigation - Android Trivia Project

<table style="width:100%">
  <tr>
    <th><img src=".\readme.resources\start.png" alt="Android Trivia initial page with Navigation Drawer"/></th>
    <th><img src=".\readme.resources\play.png" alt="Android Trivia play game"/></th>
    <th><img src=".\readme.resources\end.png" alt="Android Trivia congratulations"/></th>
  </tr>
</table>

### List of Subjects:
1. Navigation Terms: 
     * Action Bar: Appears at the top of the application screen.Contains application branding and navigation features such as the overflow menu and the application drawer button.
     * Up Button: Appears in the action bar and takes us back through previous screens the user has navigated to within the app.
     * Overflow Menu: A drop down list of items within the Action Bar that can contain navigation destinations.
     * Navigation Drawer: A menu with a header that slides out from the side of the app.
     * Navigation Graph: All of the destinations -- the screens that can be navigated to from a single activity are contained in this.
     * Back button (below the device display)
     * fragment
2. UI Fragments: Fragment Back Stack, Fragment Manager, Fragment Transaction
     * onCreateView(): In a Fragment, you don’t inflate the view in onCreate like in an activity, but instead in this method.
     * context: Use this property from within a Fragment to get access to string and image resources.
     * The Activity layout: UI Fragments contain a layout and occupy a place within. 
3. Navigation Principles
     * First Principle: There's Always a Starting Place
     * Second Principle: You Can Always Go Back (Navigation Stack)
     * Third Principle: Up goes Back (mostly)
4. Navigation Components
     * Navigation Graph
     * Navigation Host Fragment
     * Connecting Fragments with an Action
5. Conditional Navigation (gameFragment -> gameWon / gameOver)
6. Back Stack Manipulation
     * PopTo Not-Inclusive: Pops off everything on the back stack until it finds the referenced fragment transaction.
     * PopTo Inclusive: Pops off everything on the back stack, including the referenced fragment transaction.
7. Support for the Up Button
8. Adding a 3 dot Overflow Menu
9. Menu Attributes:
     * id: Used by navigation to determine where to navigate
     * title: String displayed in the menu
     * setHasOptionsMenu: Tells Android that Fragment has a menu
     * onCreateOptionsMenu: Where you inflate the menu
     * onOptionsItemSelected: Called when a menu item is selected
10. Safe Arguments
     * Navigation generates the action and the argument class from navigation graph
     * non-default arguments are required parameters in action.
11. Intents 
     * Explicit: Launch specific activity
     * Implicit: Specify WHAT you want done and system chooses activiy
     * Intent Action: The type of thing that the app wants to have done on its behalf. 
           ACTION_VIEW, ACTION_DIAL, ACTION_EDIT
     * Intent Category: Adds a subtype of the action
           CATEGORY_APP_MUSIC, CATEGORY_APP_GALLERY, CATEGORY_APP_MAPS, 
           CATEGORY_APP_CALCULATOR, CATEGORY_APP_EMAIL, CATEGORY_APP_CALENDAR
     * Intent Data Type (MIME Data Type): Allows activities to support specific data types. 
12. Sharing and Share Compact
     * Hide the icon if you can't share
13. [Navigation Drawer](https://developer.android.com/guide/navigation/navigation-ui)
14. Navigation Listeners
15. Animation with Navigation
     * Exit Transaction: Played for the destination to be navigated to when another destination replaces the current one.
     * Enter Transaction: Played for the destination to be navigated to when it is entered.
     * Pop Exit Transaction: Played when the current destination is popped off the back stack.
     * Pop Enter Transaction: Played when the destination is returned to view from the back stack.




