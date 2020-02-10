# OneMain Dad Jokes App
Simple, fast, secure. Shows dad jokes from [https://icanhazdadjoke.com](https://icanhazdadjoke.com) when launched.


# Project Setup
Build with gradle. Edit with Android Studio.

# Technical Assignment
The suggested time to complete the assignment is 1-2 hours **maximum**. 

Candidates are required to complete a minimum of:

- One task from the Roadmap section
- One task from the Tech Debt section
- One task from the Bugs section

After completing the required tasks, if there is leftover time, feel free to pick up additional tasks to help demonstrate your skillset.

Please be prepared to discuss your implementation in-depth.

# Roadmap
- Swipe to Refresh joke [Android Training - Add Swipe Interface](https://developer.android.com/training/swipe/add-swipe-interface)
- Show some sort of a loading spinner
- Show list of jokes as per [API Reference - Search](https://icanhazdadjoke.com/api#search-for-dad-jokes)
- Search for jokes [API Reference - Search](https://icanhazdadjoke.com/api#search-for-dad-jokes)
- Share a joke (looks like there is a way to generate a permalink)

# Tech Debt
- Communicate `User-Agent` as per [API Reference - Custom User Agent](https://icanhazdadjoke.com/api#custom-user-agent)
- Add Repository layer as recommended in [Android Developer Guide](https://developer.android.com/jetpack/docs/guide)
- Refactor existing codebase to leverage a mature dependency injection solution (Ex: [Koin](https://insert-koin.io)).
- Add unit tests and/or espresso tests. Tests should be executable via gradle CL.

# Bugs
- Screen rotation fetches a new joke. Rotating the screen should **NOT** cause the app to fetch a new joke.
