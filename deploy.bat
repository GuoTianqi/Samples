rem -buildfile javafxexample.xml clean all
copy out\artifacts\JavaFXApp\bundles\JavaFXApp\runtime\jre\bin\msvcr100.dll out\artifacts\JavaFXApp\bundles\JavaFXApp
iscc JavaFXAppInnoSetup.iss


