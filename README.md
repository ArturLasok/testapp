# testapp
Testing playground: UI Compose testing

Simply Activity and Composable test

@ActivityTest

@get:Rule
val rule = createAndroidComposeRule<MainActivity>()

## is light/dark mode is changed after button click

@Test
fun textDarkModeChange() {

        rule.onNodeWithText("change light/dark").performClick()

        rule.onNodeWithText("Now Dark is: false").assertIsDisplayed()

        rule.onNodeWithText("change light/dark").performClick()

        rule.onNodeWithText("Now Dark is: true").assertIsDisplayed()


    }

@ComposabeTest

@get:Rule
val rulec = createComposeRule()

## is in StartScreen() Composable text is displayed

@Test
fun StartScreenTextIsVisible() {


        rulec.setContent { StartScreen(navigateTo = { route ->  }, isDarkModeOn = false) }

        rulec.onNodeWithText("START SCREEN").assertIsDisplayed()

    }




