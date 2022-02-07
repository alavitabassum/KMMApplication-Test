# KMMApplication-Test- WHATS INSIDE THE PROJECT

Set up the environment

Download KMM Plugin

Created Sample Project using the KMM Plugin

Made changes to the shared folder. Android app ran smoothly without any error.

Implemented KTOR to pull JSON data from a sample API. *Ran into an issue with MainScope.  KTOR is built around coroutines, and it is assumed that coroutines are automatically added to dependencies when the KMM plugin is installed. BUT a new KMM project does not add coroutines dependencies to the project by default.  I had to add the kotlinx-coroutines-android dependency to androidApp build.gradle file.  Also added the kotlinx-coroutines-core dependency to shared build.gradle file.  That fixed the for me.

The android side of the app ran smoothly and fetched all the JSON data successfully

