package egor.android.navigations.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import egor.android.features.feed.FeedScreen
import egor.android.features.profile.ui.ProfileScreen
import egor.android.navigations.AppScreens
import egor.android.navigations.LocalNavHost
import egor.android.theme.RelaxTheme
import org.jetbrains.compose.resources.stringResource
import relax.composeapp.generated.resources.Res
import relax.composeapp.generated.resources.bottom_home
import relax.composeapp.generated.resources.bottom_inbox
import relax.composeapp.generated.resources.bottom_library
import relax.composeapp.generated.resources.bottom_post
import relax.composeapp.generated.resources.bottom_subscriptions

enum class MainScreens(val route: String) {
    Home("home"),
    Subscriptions("subscriptions"),
    Post("post"),
    Inbox("inbox"),
    Library("library")
}

@Composable
fun MainScreen() {
    val outerNavController = LocalNavHost.current
    val navHostController = rememberNavController()
    val items = MainScreens.entries.toTypedArray()
    val bottomNavigationHeight = 75.dp

    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navHostController,
            modifier = Modifier.padding(bottom = bottomNavigationHeight).fillMaxHeight(),
            startDestination = MainScreens.Home.route
        ) {
            composable(MainScreens.Home.route) {
                FeedScreen()
            }
            composable(MainScreens.Subscriptions.route) {
                ProfileScreen()
            }
            composable(MainScreens.Inbox.route) {
                Text("Hello, Inbox")
            }
            composable(MainScreens.Library.route) {
                Text("Hello, Library")
            }
        }
        BottomNavigation(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .height(bottomNavigationHeight),
            backgroundColor = RelaxTheme.colors.secondaryBackground
        ) {
            val navBackStackEntry by navHostController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            items.forEach { screen ->
                val isSelected =
                    currentDestination?.hierarchy?.any { it.route == screen.route } == true
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = when (screen) {
                                MainScreens.Home -> Icons.Filled.Home
                                MainScreens.Subscriptions -> Icons.Filled.Check
                                MainScreens.Post -> Icons.Filled.Add
                                MainScreens.Inbox -> Icons.Filled.MailOutline
                                MainScreens.Library -> Icons.Filled.AccountBox
                            },
                            contentDescription = screen.route,
                            tint = if (isSelected) RelaxTheme.colors.primaryText else RelaxTheme.colors.secondaryText
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(
                                when (screen) {
                                    MainScreens.Home -> Res.string.bottom_home
                                    MainScreens.Subscriptions -> Res.string.bottom_subscriptions
                                    MainScreens.Post -> Res.string.bottom_post
                                    MainScreens.Inbox -> Res.string.bottom_inbox
                                    MainScreens.Library -> Res.string.bottom_library
                                }
                            ),
                            color = if (isSelected) RelaxTheme.colors.primaryText else RelaxTheme.colors.secondaryText
                        )
                    },
                    selected = isSelected,
                    onClick = {
                        if (screen == MainScreens.Post) {
                            outerNavController.navigate(AppScreens.CreatePost.title)
                        } else {
                            navHostController.navigate(screen.route) {

                                popUpTo(navHostController.graph.findStartDestination().displayName) {
                                    saveState = true
                                }

                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    selectedContentColor = RelaxTheme.colors.tintColor,
                    unselectedContentColor = RelaxTheme.colors.secondaryText
                )
            }
        }
    }
}