# WikiMusic

WikiMusic is an android app that lets you get details about any song genre, album, artist as well as song track.

## Api 

last.fm api is used to fetch all the details regarding genre, song and artists.
You can get more information on https://www.last.fm/api

## Decision
To use the MVVM design Model in this android app.

## Library
- Retrofit
- Picasso
- de.hdodenhof:circleimageview:3.1.0

## File Organisation
App contains 6 package namely
 - genre
 - track
 - album
-  artist
- adapters
- api

Each package has subpackages - 
- repository - contains repository files to fetch data from api.
- models - contains models files
- viewmodels - contains viewmodels files intergrating UI and models
- ui - contains files related to UI
- api - api interface file and retrofitclient
                  
## Usage

Clone the project in Android Studio and simply install the app.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
