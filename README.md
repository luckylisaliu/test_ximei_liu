Requirements and Implementation Specification:

1.    Support Android 4.0+ 

-> My code SDK Version:
· minSdkVersion 14

· targetSdkVersion 25


 

2.    Support portrait and landscape screen orientation

->Support both orientations

 

3.    Use the list of people fetched live from http://jsonplaceholder.typicode.com/users

->Use Retrofit Library to fetch JSon Array data

 

4.    Loading animation when fetching the list 

->Implemented loading animation and loading text when fetching the list. Since Retrofit fetch data is very fast, it may not be easy to observe the effect from emulator. However, if you disable the internet then run the emulator again you will see the effect clearly. The contact list is implemented via Android RecyclerView

 

5.     List can be sorted alphabetically (ascending & descending)

->Implemented both way